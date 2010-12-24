eval(loadFile("src/main/javascript/level_0/point.js"));


testCases(test,


    function canCalculateFightingStrength() {
        var distance = distanceBetween(x1, y1, x1, y2);

        assert.that(distance, eq(3));


        assert.that(galleon_black_card_points, eq(1));
        assert.that(galleon_red_card_points, eq(4));
    },

    function reportsFailure() {
        assert.that(3, eq(4));
    }


);
