(ns advent2017.core-test
  (:require [clojure.test :refer :all]
            [advent2017.core :refer :all]))

(deftest day-solver-test
  (testing "gets correct function"
    (is (= (day-solver 2 1) #'advent2017.solvers.day2/puzzle1))))
