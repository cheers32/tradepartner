from collections import deque


def getLevels(openList, highList, lowList, closeList, n):
    openQueue = deque()
    highQueue = deque()
    lowQueue = deque()
    closeQueue = deque()
    priceMap = {}
    size = len(openList)
    idx = 0
    resList = []
    while idx < size:
        if len(openQueue) >= n:
            priceMap[openQueue.popleft()].popleft()
            priceMap[highQueue.popleft()].popleft()
            priceMap[lowQueue.popleft()].popleft()
            priceMap[closeQueue.popleft()].popleft()
        open = round(float(openList[idx]),1)
        high = round(float(highList[idx]),1)
        low = round(float(lowList[idx]),1)
        close = round(float(closeList[idx]),1)
        openQueue.append(open)
        highQueue.append(high)
        lowQueue.append(low)
        closeQueue.append(close)
        if open not in priceMap:
            priceMap[open] = deque()
        if high not in priceMap:
            priceMap[high] = deque()
        if low not in priceMap:
            priceMap[low] = deque()
        if close not in priceMap:
            priceMap[close] = deque()
        priceMap[open].append(idx)
        priceMap[high].append(idx)
        priceMap[low].append(idx)
        priceMap[close].append(idx)
        for key in priceMap:
            if len(priceMap[key])>5:
                startIdx = priceMap[key][0]
                endIdx = priceMap[key][len(priceMap[key])-1]
                resList.append(str(startIdx)+";"+str(endIdx)+";"+str(key))
        idx += 1
    res = "level"+str(n)+"@"+",".join(resList)
    return res
