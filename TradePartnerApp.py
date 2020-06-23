from flask import Flask, jsonify, request

from DataProvider.HighLowProvider import getLows, getHighs, getSwingLines
from DataProvider.MovingAverageProvider import getSimpleMovingAverage, getStdv
from DataProvider.ReturnDataProvider import getDateText, getPctReturn
from DataProvider.RsiProvider import getRsi

app = Flask(__name__)


def start():
    app.run(host="0.0.0.0", port=5030, debug=False)


@app.route("/trade", methods=["POST"], strict_slashes=False)
def indexGet():
    open = request.form['open'] if 'open' in request.form else ""
    low = request.form['low'] if 'low' in request.form else ""
    high = request.form['high'] if 'high' in request.form else ""
    close = request.form['close'] if 'close' in request.form else ""
    date = request.form['date'] if 'date' in request.form else ""
    openList = open.split(',')
    highList = high.split(',')
    lowList = low.split(',')
    closeList = close.split(',')
    dateList = date.split(',')
    highLowPeriod = 10

    calcRes = [
        getDateText(dateList),
        getPctReturn(closeList),
        getSimpleMovingAverage(closeList, 20), getSimpleMovingAverage(closeList, 50), getSimpleMovingAverage(closeList, 125), getSimpleMovingAverage(closeList, 200),
        getStdv(closeList, 20),
        getRsi(closeList, 2), getRsi(closeList, 4),
        getLows(lowList, highLowPeriod), getHighs(highList, highLowPeriod), getSwingLines(lowList, highList, dateList, closeList[len(closeList)-1], highLowPeriod)
    ]

    res = '|'.join(calcRes)
    return jsonify(res)


@app.route("/trade", methods=["GET"], strict_slashes=False)
def indexPost():
    return jsonify("nihao GET ")


if __name__ == "__main__":
    start()
