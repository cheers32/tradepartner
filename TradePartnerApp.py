from flask import Flask, jsonify, request

from DataProvider.MovingAverageProvider import getSimpleMovingAverage, getStdv
from DataProvider.ReturnDataProvider import getDateText, getPctReturn
from DataProvider.RsiProvider import getRsi

app = Flask(__name__)


def start():
    app.run(host="0.0.0.0", port=5030, debug=False)


@app.route("/trade", methods=["POST"], strict_slashes=False)
def indexGet():
    close = request.form['close'] if 'close' in request.form else ""
    date = request.form['date'] if 'date' in request.form else ""
    closeList = close.split(',')
    dateList = date.split(',')

    calcRes = [
        getDateText(dateList),
        getPctReturn(closeList),
        getSimpleMovingAverage(closeList, 20), getSimpleMovingAverage(closeList, 50), getSimpleMovingAverage(closeList, 125), getSimpleMovingAverage(closeList, 200),
        getStdv(closeList, 20),
        getRsi(closeList, 2), getRsi(closeList, 4)
    ]

    res = '|'.join(calcRes)
    return jsonify(res)


@app.route("/trade", methods=["GET"], strict_slashes=False)
def indexPost():
    return jsonify("nihao GET ")


if __name__ == "__main__":
    start()
