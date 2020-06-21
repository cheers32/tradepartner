import statistics
from queue import Queue
from collections import deque
import numpy as np


def getSimpleMovingAverage(priceList, n):
    res = []
    queue = deque()
    curSum = 0
    for price in priceList:
        if len(queue) >= n:
            curSum -= queue.popleft()
        queue.append(float(price))
        curSum += float(price)
        res.append(str(round(curSum/len(queue), 2)))
    return "sma" + str(n) + "@" + ",".join(res)


def getStdv(priceList, n):
    res = []
    queue = deque()
    for price in priceList:
        if len(queue) >= n:
            queue.popleft()
        queue.append(float(price))
        res.append(str(np.std(queue)))
    return "stdv" + str(n) + "@" + ",".join(res)


def testStd():
    input = [9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4]
    v = np.std(input)
    res = getStdv(input, len(input))
    print(res)


def testMa():
    res = getSimpleMovingAverage([2,3,1,2,4,6,2,3],3)
    print(res)


#testMa()
