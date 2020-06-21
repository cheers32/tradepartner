import datetime
from enum import Enum
from alpha_vantage.timeseries import TimeSeries

API_URL = "https://www.alphavantage.co/query?"
API_KEY = "4BYXFB9D3TYUYNN5"


class ApiFunc(Enum):
    daily = 1
    dailyAdjusted = 2
    intraday = 3


def getStock(symbol, apiFunc, outputSize="compact"):
    ts = TimeSeries(key=API_KEY, output_format="pandas")
    data = None
    if apiFunc == ApiFunc.daily:
        data, meta_data = ts.get_daily(symbol, outputsize=outputSize)
    elif apiFunc == ApiFunc.intraday:
        data, meta_data = ts.get_intraday(symbol, outputsize=outputSize)
    data.columns = ["open", "high", "low", "close", "volume"]
    data["date"] = data.index
    return data

res = getStock("QQQ",ApiFunc.daily)
print(res)