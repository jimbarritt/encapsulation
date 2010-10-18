eval(loadFile("src/main/javascript/level_0/galleon.js"));


testCases(test,


    function canCalculateFightingStrength() {
        
        var fightingStrength = galleon_red_card_points - galleon_black_card_points;

        assert.that(galleon_black_card_points, eq(1));
        assert.that(galleon_red_card_points, eq(4));
        assert.that(fightingStrength, eq(3));
    },

    function reportsFailure() {
        assert.that(3, eq(4));
    }


);
