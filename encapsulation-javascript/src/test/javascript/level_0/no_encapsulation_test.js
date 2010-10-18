eval(loadFile("src/main/javascript/level_0/galleon.js"));


testCases(test,

    function setUp() {
        var test = 4;
    },

    function canMakeAnAssertion() {
        assert.that("foo", eq("bar"));
    }

);
