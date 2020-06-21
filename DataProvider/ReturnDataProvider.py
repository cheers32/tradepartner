
def getDateText(dateList):
    resDatesList = []
    for d in dateList:
        if '12:00:00' in d:
            resDatesList.append(d.split(' ')[0])
        else:
            resDatesList.append(d.split(' ')[1])
    res = "dates@:" + ",".join(resDatesList)
    return res


def getPctReturn(priceList):
    res = []
    prevPrice = None
    for price in priceList:
        if prevPrice is None:
            res.append("0")
        else:
            pctReturn = (float(price) / float(prevPrice) - 1) * 100
            res.append(str(round(pctReturn, 2)))
        prevPrice = price
    return "pctReturns@"+",".join(res)
