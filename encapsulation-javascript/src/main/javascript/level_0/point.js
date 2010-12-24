var x1 = 10;
var y1 = 20;
var x2 = 20;
var y2 = 30;

var distanceBetween = function(x1, y1, x2, y2) {
    var b = x2 - x1;
    var c = y2 - y1;

    return Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2));
}

console.log("The distance between the two points is " + distanceBetween(x1, y1, x2, y2));
