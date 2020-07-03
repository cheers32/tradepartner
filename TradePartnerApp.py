from flask import Flask, jsonify, request

from DataProvider.HighLowProvider import getLows, getHighs, getSwingLines
from DataProvider.LevelDataProvider import getLevels
from DataProvider.MovingAverageProvider import getSimpleMovingAverage, getStdv
from DataProvider.ReturnDataProvider import getDateText, getPctReturn
from DataProvider.RsiProvider import getRsi

app = Flask(__name__)


def start():
    app.run(host="0.0.0.0", port=5030, debug=False)

from datetime import datetime

@app.route("/trade", methods=["POST"], strict_slashes=False)
def indexGet():
    print("*****"+str(datetime.now()))
    open = request.form['open'] if 'open' in request.form else ""
    low = request.form['low'] if 'low' in request.form else ""
    high = request.form['high'] if 'high' in request.form else ""
    close = request.form['close'] if 'close' in request.form else ""
    volume = request.form['volume'] if 'volume' in request.form else ""
    date = request.form['date'] if 'date' in request.form else ""
    symbol = request.form['symbol'] if 'symbol' in request.form else ""
    dataScale = request.form['dataScale'] if 'dataScale' in request.form else ""
    isIntraDay = request.form['isIntraDay'] if 'isIntraDay' in request.form else ""
    securityName = request.form['securityName'] if 'securityName' in request.form else ""
    print(symbol + ", " + dataScale + ", " + securityName)

    openList = open.split(',')
    highList = high.split(',')
    lowList = low.split(',')
    closeList = close.split(',')
    volumeList = volume.split(',')
    dateList = date.split(',')
    highLowPeriod = 10

    calcRes = [
        getDateText(dateList),
        getPctReturn(closeList, volumeList),
        getSimpleMovingAverage(closeList, 20), getSimpleMovingAverage(closeList, 50), getSimpleMovingAverage(closeList, 125), getSimpleMovingAverage(closeList, 200),
        getStdv(closeList, 20),
        getRsi(closeList, 2), getRsi(closeList, 4),
        getLows(lowList, highLowPeriod), getHighs(highList, highLowPeriod), getSwingLines(lowList, highList, dateList, closeList[len(closeList)-1], highLowPeriod),
        getLevels(openList, highList, lowList, closeList, 20)
    ]

    res = '|'.join(calcRes)
    print("-----" + str(datetime.now()))
    return jsonify(res)


@app.route("/trade", methods=["GET"], strict_slashes=False)
def indexPost():
    return jsonify("nihao GET ")


if __name__ == "__main__":
    start()
