(ns advent2017.solvers.day2-test
  (:require [clojure.test :refer :all]
            [advent2017.solvers.day2 :refer :all]))

(deftest test-div-checksum
  (testing "div-checksum works"
    (is (= (div-checksum [5 9 2 8]) 4))
    (is (= (div-checksum [9 4 7 3]) 3))
    (is (= (div-checksum [3 8 6 5]) 2))))

(deftest test-sub-checksum
  (testing "sub-checksum works"
    (is (= (sub-checksum [1 1]) 0))
    (is (= (sub-checksum [5 1 9 5]) 8))
    (is (= (sub-checksum [110 123 1]) 122))
    (is (= (sub-checksum [7 5 3]) 4))
    (is (= (sub-checksum [2 4 6 8]) 6))))

(def num-vecs [[5 1 9 5]
               [1 1]
               [110 123 1]
               [7 5 3]
               [2 4 6 8]])


(deftest test-solve
  (testing "solver works"
    (is (= (solve num-vecs sub-checksum) 140))))

(def input-string "5 1 9 5
1 1
110 123 1
7 5 3
2 4 6 8")


(deftest test-puzzle1
  (testing "puzzle1 works"
    (is (= (puzzle1 input-string) 140))))
