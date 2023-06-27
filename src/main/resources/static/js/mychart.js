var chartDataStr = decodeHtml(chartData);
var ChartJsonArray = JSON.parse(chartDataStr);

var arrayLength = ChartJsonArray.length;
var numericData = [];
var labelData = [];

for (var i = 0; i < arrayLength; i++) {
    numericData[i] = ChartJsonArray[i].val;
    labelData[i] = ChartJsonArray[i].label;
}
//for a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First Dataset',
            data: numericData,
            backgroundColor: [
                '#3e95cd',
                '#8e5ea2',
                '#3cba9f'
            ],
            hoverOffset: 4
        }]
    },
    options: {
        title: {
            display: true,
            text: "project Statuses"
        }
    }
});


// [{"value":1,"label" : "Completed/incomplete"},{"value":2,"label" : "Completed/incomplete"}]  --> output format
function decodeHtml(html) {
    var txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}