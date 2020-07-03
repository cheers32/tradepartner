import statistics
from queue import Queue
from collections import deque
import numpy as np
import pandas as pd


def getLows(lowsList, n):
    data = pd.Series((float(v) for v in lowsList))
    lows = data.rolling(window=n).min()
    res = ",".join([str(x) for x in lows])
    return "low" + str(n) + "@" + res


def getHighs(highsList, n):
    data = pd.Series((float(v) for v in highsList))
    highs = data.rolling(window=n).max()
    res = ",".join([str(x) for x in highs])
    return "high" + str(n) + "@" + res


def getSwingLines(lowsList, highsList, datesList, lastClose, n):
    data = pd.Series((float(v) for v in lowsList))
    lows = data.rolling(window=n).min()
    data = pd.Series((float(v) for v in highsList))
    highs = data.rolling(window=n).max()

    prevLow = lows[n - 1]
    prevHigh = highs[n - 1]
    swings = [(-1, 0, prevLow), (1, 0, prevHigh)]
    idx = n
    while idx < len(lowsList):
        # if lows[idx] == prevLow and highs[idx] == prevHigh:
        #     idx += 1
        #     continue
        if lows[idx] == float(lowsList[idx]):
            curLow = (-1, idx, lows[idx])
            if swings[len(swings) - 1][0] == -1:
                swings[len(swings) - 1] = curLow
            else:
                swings.append(curLow)
            prevLow = lows[idx]
        elif highs[idx] == float(highsList[idx]):
            curHigh = (1, idx, highs[idx])
            if swings[len(swings) - 1][0] == 1:
                swings[len(swings) - 1] = curHigh
            else:
                swings.append(curHigh)
            prevHigh = highs[idx]
        idx += 1
    swings.append((-swings[len(swings)-1][0], len(lowsList)-1, float(lastClose)))

    swingText = []
    idx = 1
    while idx < len(swings):
        start = swings[idx - 1]
        end = swings[idx]
        pivotDate = datesList[end[1]].split(' ')[0] if '12:00:00' in datesList[end[1]] else datesList[end[1]].split(' ')[1]
        if start[2] == 0:
            idx += 1
            continue
        swingText.append(str(start[1]) + ";" + str(start[2]) + ";" + str(end[1]) + ";" + str(end[2])
                         + ";" + str(round(100 * (end[2] / start[2] - 1), 2)) + ";" + str(end[1] - start[1] + 1)
                         + ";" + pivotDate)
        idx += 1
    res = "swing" + str(n) + "@" + ",".join(swingText)
    return res


def testLows():
    res = getLows(
        [283.46, 280.69, 285.48, 294.08, 293.90, 299.92, 301.15, 284.45, 294.09, 302.77, 301.97, 306.85, 305.02, 301.06,
         291.97, 284.18, 286.48, 284.54, 276.82, 284.49, 275.01, 279.07, 277.85, 278.85, 283.76, 291.72, 284.73, 291.82,
         296.74, 291.13], 3
    )
    print(res)
