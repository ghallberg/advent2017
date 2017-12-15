(ns advent2017.solvers.day5-test
  (:require [clojure.test :refer :all]
            [advent2017.solvers.day5 :refer :all]))

(deftest parse-test
  (testing "parsing some numbers"
    (is (= (parse "1") [1]))
    (is (= (parse "2\r\n1") [2 1]))
    (is (= (parse "-2\r\n1\r\n123\r\n0") [-2 1 123 0]))))
(deftest solve-test
  (testing "finds it's way correctly"
    (is (= (solve custom-updater [0 3 0 1 -3]) 10))
    (is (= (solve inc [0 3 0 1 -3]) 5))))
