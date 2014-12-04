import math

def getData():
    with open("data.csv") as f:
        data = [[], [], [], [], [], [], [], [], [], [], [], []]
        for line in f:
            l       = line.split(",")
            debit   = float(l[5]) if l[5] != '' else 0
            credit  = float(l[6]) if l[6] != '' else 0
            balance = float(l[7])
            month   = int(l[9]) - 1
            data[month].append([debit, credit, balance])
        return data

def flatten(data):
    return [item for months in data for item in months]

def getMean(data, col):
    return reduce((lambda s, e: s + e[col]), data, 0.0) / len(data)

def getVariance(data, col, mean):
    return reduce((lambda s, e: s + pow(e[col] - mean, 2)), data, 0.0) / len(data)

def getNumMonths(data):
    return reduce((lambda num, entries: num + 1 if len(entries) > 0 else num), data, 0.0)

def getMonthlyMean(data, col):
    return reduce((lambda s, e: s + reduce((lambda s_, e_: s_ + e_[col]), e, 0.0)), data, 0.0) / getNumMonths(data)

def getMonthlyVariance(data, col, mean):
    return reduce((lambda s, e: s + pow(reduce((lambda s_, e_: s_ + e_[col]), e, 0.0), 2)), data, 0.0) / getNumMonths(data)

data         = getData()
flattened    = flatten(data)

debMean      = getMean(flattened, 0)
debVariance  = getVariance(flattened, 0, debMean)
credMean     = getMean(flattened, 1)
credVariance = getVariance(flattened, 1, credMean)

debMeanM      = getMonthlyMean(data, 0)
debVarianceM  = getMonthlyVariance(data, 0, debMeanM)
credMeanM     = getMonthlyMean(data, 1)
credVarianceM = getMonthlyVariance(data, 1, credMeanM)

print "debit mean: ", debMean, ", variance: ", debVariance
print "credit mean:", credMean, ", variance: ", credVariance

print "monthly debit mean: ", debMeanM, ", variance: ", debVarianceM
print "monthly credit mean:", credMeanM, ", variance: ", credVarianceM

