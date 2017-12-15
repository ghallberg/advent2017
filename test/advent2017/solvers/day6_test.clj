(ns advent2017.solvers.day6-test
  (:require [clojure.test :refer :all]
            [advent2017.solvers.day6 :refer :all]))

(deftest parse-test
  (testing "parses numbers nicely"
    (let [output (parse "1\t2\t123\t5")]
      (is (vector? output)
      (is (= output [1 2 123 5]))))))


