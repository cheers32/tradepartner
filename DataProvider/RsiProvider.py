import statistics
from queue import Queue
from collections import deque
import numpy as np
import pandas as pd


def getRsi(priceList, n):
    data = pd.Series((float(v) for v in priceList))
    chg = data.diff(1)
    gain = chg.mask(chg < 0, 0)
    loss = chg.mask(chg > 0, 0)

    avg_gain = gain.ewm(com=n-1).mean()
    avg_loss = loss.ewm(com=n-1).mean()
    rs = abs(avg_gain / avg_loss)
    rsi = 100 - (100 / (1 + rs))

    res = ",".join([str(x) for x in rsi])
    return "rsi" + str(n) + "@" + res


def testRsi():
    res = getRsi([283.46,280.69,285.48,294.08,293.90,299.92,301.15,284.45,294.09,302.77,301.97,306.85,305.02,301.06,
                  291.97,284.18,286.48,284.54,276.82,284.49,275.01,279.07,277.85,278.85,283.76,291.72,284.73,291.82,296.74,291.13],14)
    print(res)


#testRsi()
