(ns jimbarritt.encapsulation.level_0.no-encapsulation-tests)

(use 'clojure.contrib.test-is)
(use 'jimbarritt.encapsulation.level_0.galleon)

(deftest calculates-fighting-strength
  (println "We can refer to the global variables even though they are defined in a different namespace to us:")
  (println (format "Number of red points %d" galleon-total-points-red-cards))
  (println (format "Number of black points %d" galleon-total-points-black-cards))

  (is (= galleon-total-points-red-cards 4))
  (is (= galleon-total-points-black-cards 1))

  (def fighting-strength (- galleon-total-points-red-cards galleon-total-points-black-cards))

  (is (= fighting-strength 3))
)

(deftest cannot-refer-to-local-variable
  (println "The variable 'fighting-strength should be undefined")
  (is (thrown? IllegalStateException (
    (. System/out (println (format "Fighting Strength %d" fighting-strength)))
  )))  
)

(run-tests)
