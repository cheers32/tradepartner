import numpy as np

def getDateText(dateList):
    resDatesList = []
    for d in dateList:
        if '12:00:00' in d:
            resDatesList.append(d.split(' ')[0])
        else:
            resDatesList.append(d.split(' ')[1])
    res = "dates@:" + ",".join(resDatesList)
    print(dateList[len(dateList) - 1])
    return res


def getPctReturn(priceList, volumeList):
    res = []
    prevPrice = None
    for price in priceList:
        if prevPrice is None or prevPrice is "0":
            res.append("0")
        else:
            pctReturn = (float(price) / float(prevPrice) - 1) * 100
            res.append(str(round(pctReturn, 2)))
        prevPrice = price
    print(priceList[len(priceList)-1])
    valVolume = float(volumeList[len(volumeList) - 1])
    avgVolume = np.mean([float(x) for x in volumeList])
    print(str(valVolume/1000)+"K" + " (avg="+str(int(avgVolume/1000))+"K)" + " ("+str(round(100*valVolume/avgVolume,2))+"%)")
    return "pctReturns@"+",".join(res)
