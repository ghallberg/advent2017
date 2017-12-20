(ns advent2017.solvers.day6-test
  (:require [clojure.test :refer :all]
            [advent2017.solvers.day6 :refer :all]))

(deftest parse-test
  (testing "parses numbers nicely"
    (let [output (parse "1\t2\t123\t5")]
      (is (vector? output)
      (is (= output [1 2 123 5]))))))

(deftest rebalance-test
  (testing "rebalances a stack nicely"
    (let [output (rebalance [0 2 7 0])]
      (is (vector? output))
      (is (= output [2 4 1 2])))
    (let [output (rebalance [2 4 1 2])]
      (is (vector? output))
      (is (= output [3 1 2 3])))
    (let [output (rebalance [3 1 2 3])]
      (is (vector? output))
      (is (= output [0 2 3 4])))
    (let [output (rebalance [0 2 3 4])]
      (is (vector? output))
      (is (= output [1 3 4 1])))
    (let [output (rebalance [1 3 4 1])]
      (is (vector? output))
      (is (= output [2 4 1 2])))))

(deftest multi-rebalance-test
  (testing "gets correct number of iterations"
    (is (= (puzzle1  "0\t2\t7\t0") 5))))

(deftest loop-steps-test
  (testing "counts steps"
    (is (= (count-loop-steps (find-loop [[0 2 7 0]])) 4))
    (is (= (count-loop-steps [1 2 3 4 2]) 3))))
