

// Load the Visualization API and the piechart package.
google.load('visualization', '1.0', {'packages':['corechart']});

//-----------------------------------------------------------
// Monte Carlo
//-----------------------------------------------------------
// A function to get normal distribution 
// using Box-Muller transform
function gauss(mean, sd) {
    var U1 = Math.random();
    var U2 = Math.random();
    var Z = Math.sqrt((-2) * Math.log(U1)) * Math.cos(2 * Math.PI * U2);
    return mean + sd * Z;
}

// a function to sum up values in the array
function sum(arr) {
    return arr.reduce(function(acc, x) { return acc + x; }, 0);
}

// return a flow of money
function genFlow(mean, variance, N) {
    var dataPoint = function() {
        var p = gauss(mean, Math.sqrt(variance), N);
        return (p < 0) ? 0 : p;
    }

    var flow = [];
    for (var i = 0; i < N; ++i) { flow.push(dataPoint()); }
    return flow;
}

// run a Monte Carlo simulation
function monteCarlo(mean, variance, Nsim, Ndays) {
    var sims = [];
    for (var i = 0; i < Nsim; i++) {
        sims.push(genFlow(mean, variance, Ndays));
    }
    return sims;
}

// get minimum flow from the simulation
function getMinFlow(simulation) {
    return simulation.reduce(function(best, curr) {
        currSum = sum(curr);
        return (currSum > best[0]) ? [currSum, curr] : best;
    }, [-1, []])[1];
}

// get maximum flow from the simulation
function getMaxFlow(simulation) {
    return simulation.reduce(function(best, curr) {
        currSum = sum(curr);
        return (currSum < best[0]) ? [currSum, curr] : best;
    }, [1 << 15, []])[1];
}

// get average flow from the simulation
function getAvgFlow(simulation) {
    var avg = [];
    for (var j = 0; j < simulation[0].length; ++j) {
        avg.push(simulation.reduce(function(acc, x) {
            return acc + x[j];
        }, 0) / simulation.length);
    }
    return avg;
}

// calculate balance
function calcBalance(init, debit, credit) {
    return credit.map(function(x, i) {
            init += x - debit[i];
            return init;
    });
}

// a function to add data in chart format
function transposeTo(dest, arr) {
    if (dest.length == 0) {
        for (var i = 0; i < arr.length; ++i) { dest.push([]); }
    }
    for (var i = 0; i < arr.length; ++i) {
        dest[i].push(arr[i]);
    }
    return dest;
}

//-----------------------------------------------------------
// parse get parameters
//-----------------------------------------------------------
function getHistory() {
    var extractHistory = function() {
        return $_GET['history'].split(',').map(function(x) {
            return parseFloat(x);
        });
    }
    return !!$_GET['history'] ? extractHistory() : undefined;
}

function getFloat(key) {
    return !!$_GET[key] ? parseFloat($_GET[key]) : undefined;
}

function getInt(key) {
    return !!$_GET[key] ? parseInt($_GET[key], 10) : undefined;
}

function getDebMean() { return getFloat('debMean'); }
function getDebVariance() { return getFloat('debVariance'); }
function getCredMean() { return getFloat('credMean'); }
function getCredVariance() { return getFloat('credVariance'); }
function getNSim() { return getInt('sims'); }
function getNDays() { return getInt('days'); }

//-----------------------------------------------------------
// display thingies
//-----------------------------------------------------------
// function to actually draw the chart
function drawChart() {
    console.log($_GET);
    
    var chartName = 'Balance Projections';
    var balance = 502.52;
    var history = getHistory() || [310.2, 305.7, 550.7, 545.2, 520.3, 510.2, 502.52];
    var debMean = getDebMean() || 45.0;
    var debVariance = getDebVariance() || 100.0;
    var credMean = getCredMean() || 42.0;
    var credVariance = getCredVariance() || 130.0;

    var Nsim  = getNSim() || 100;
    var Ndays = getNDays() || 30;
    
    // actual debit and credit
    var debit = monteCarlo(debMean, debVariance, Nsim, Ndays);
    var credit = monteCarlo(credMean, credVariance, Nsim, Ndays);

    // extracting specfics
    var minDebit = getMinFlow(debit);
    var maxDebit = getMaxFlow(debit);
    var avgDebit = getAvgFlow(debit);

    var minCredit = getMinFlow(credit);
    var maxCredit = getMaxFlow(credit);
    var avgCredit = getAvgFlow(credit);

    var initBalance = history[history.length - 1];
    var minBalance = calcBalance(initBalance, maxDebit, minCredit);
    var maxBalance = calcBalance(initBalance, minDebit, maxCredit);
    var avgBalance = calcBalance(initBalance, avgDebit, avgCredit);

    // concat with previous values
    minBalance = history.concat(minBalance);
    maxBalance = history.concat(maxBalance);
    avgBalance = history.concat(avgBalance);

    // forming data series
    var days = [];
    var currTime = new Date().getTime();
    for (var i = (1 - history.length); i <= Ndays; ++i) {
        days.push(new Date(currTime + i * 60 * 60 * 24 * 1000));
    }
    var series = transposeTo([], days);
    series = transposeTo(series, minBalance);
    series = transposeTo(series, maxBalance);
    series = transposeTo(series, avgBalance);
    
    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('date', 'days');
    data.addColumn('number', 'Max Balance');
    data.addColumn('number', 'Min Balance');
    data.addColumn('number', 'Predicted Balance');
    data.addRows(series);

    // Set chart options
    var options = {'title'  : chartName,
                   'legend' : 'bottom',
                   'series' : {
                        1: { 'color': '#01afef' },
                        2: { 'color': '#007eb6' },
                        3: { 'color': '#00395d' },
                   },
                   'lineWidth': 3,
                   'vAxis'  : { 'title': 'Balance, GBP' },
                   'width'  : 720,
                   'height' : 500};

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.LineChart(document.getElementById('chart-div'));
    chart.draw(data, options);
}

// get query arguments
var $_GET = {},
    args = location.search.substr(1).split(/&/);
function parseGET() {
    for (var i=0; i<args.length; ++i) {
        var tmp = args[i].split(/=/);
        if (tmp[0] != "") {
            $_GET[decodeURIComponent(tmp[0])] = decodeURIComponent(tmp.slice(1).join("").replace("+", " "));
        }
    }
}

// running everything
$(document).ready(function() {
    parseGET();
    drawChart();
});
