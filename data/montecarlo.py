import math
from random import gauss
import matplotlib.pyplot as plt

# calculated parameters
debMean =  42.6938848921
debVariance = 17676.1175842
credMean = 42.7485251799
credVariance = 26867.1585896

fakeDM = 45.0
fakeDV = 100.0
fakeCM = 42.0
fakeCV = 150.0

def genFlow(mean, variance, N):
    dataPoint = lambda: gauss(mean, math.sqrt(variance))
    nonNeg = lambda x: 0.0 if x < 0 else x
    return [nonNeg(dataPoint()) for i in range(N)]

def monteCarlo(mean, variance, Nsim, Ndays):
    return [genFlow(mean, variance, Ndays) for i in range(Nsim)]

def getMaxFlow(simulation):
    getMax = lambda (best, m), f: (sum(f), f) if (sum(f) > best) else (best, m)
    return reduce(getMax, simulation, (-1, []))[1]

def getMinFlow(simulation):
    getMin = lambda (best, m), f: (sum(f), f) if (sum(f) < best) else (best, m)
    return reduce(getMin, simulation, (1 << 15, []))[1]

def getAvgFlow(simulation):
    N = len(simulation)
    if N == 0:
        return []
    avg = lambda l, j: reduce((lambda s, e: s + e[j]), l, 0.0) / N
    return [avg(simulation, j) for j in range(len(simulation[0]))]

def calcBalance(init, debit, credit):
    balance = [init]
    for i in range(len(debit)):
        init += credit[i] - debit[i]
        balance.append(init)
    return balance

debit = monteCarlo(fakeDM, fakeDV, 100, 30)
credit = monteCarlo(fakeCM, fakeCV, 100, 30)
#debit = monteCarlo(debMean, debVariance, 100, 30)
#credit = monteCarlo(credMean, credVariance, 100, 30)

print 'simulation done'

minDebit = getMinFlow(debit)
maxDebit = getMaxFlow(debit)
avgDebit = getAvgFlow(debit)

minCredit = getMinFlow(credit)
maxCredit = getMaxFlow(credit)
avgCredit = getAvgFlow(credit)

initBalance = 500.0
minBalance = calcBalance(initBalance, maxDebit, minCredit)
maxBalance = calcBalance(initBalance, minDebit, maxCredit)
avgBalance = calcBalance(initBalance, avgDebit, avgCredit)

# draw graphs
plt.xkcd()
xs = range(1, 31)

# debit
plt.title('Debit')
plt.xlabel('days')
plt.ylabel('pounds')
plt.plot(xs, minDebit)
plt.plot(xs, maxDebit)
plt.plot(xs, avgDebit)
plt.show()

# credit
plt.title('Credit')
plt.plot(xs, minCredit)
plt.plot(xs, maxCredit)
plt.plot(xs, avgCredit)
plt.show()

# balance
plt.title('Balance')
plt.plot([0] + xs, minBalance)
plt.plot([0] + xs, maxBalance)
plt.plot([0] + xs, avgBalance)
plt.show()

