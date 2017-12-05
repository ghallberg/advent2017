(ns advent2017.solvers.day1-test
  (:require [clojure.test :refer :all]
            [advent2017.solvers.day1 :refer :all]))

(def input-output-pairs-1 [["91212129" 9]
                         ["1122" 3]
                         ["1111" 4]
                         ["1234" 0]])

(defn check-input-1 [pair]
  (= (puzzle1 (first pair)) (last pair)))

(deftest puzzle1-test
  (testing "given test inputs get expected reponses"
      (is (every? check-input-1 input-output-pairs-1))))

(def input-output-pairs-2 [["1212" 6]
                           ["1221" 0]
                           ["123425" 4]
                           ["12131415" 4]
                           ["123123" 12]])

(defn check-input-2 [pair]
  (= (puzzle2 (first pair)) (last pair)))

(deftest puzzle2-test
  (testing "given test inputs get expected reponses"
      (is (every? check-input-2 input-output-pairs-2))))
