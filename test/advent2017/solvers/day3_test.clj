(ns advent2017.solvers.day3-test
  (:require [clojure.test :refer :all]
            [advent2017.solvers.day3 :refer :all]))

(deftest length-test
  (testing "some rotations"
    (is (= (nth rotation-ends 0) 1))
    (is (= (nth rotation-ends 1) 9))
    (is (= (nth rotation-ends 2) 25))
    (is (= (nth rotation-ends 3) 49))))

(deftest oscilator-test
  (testing "oscilators"
    (is (= ((step-oscilator 2) 0) 0))
    (is (= ((step-oscilator 2) 1) 1))
    (is (= ((step-oscilator 2) 2) 0))

    (is (= ((step-oscilator 4) 0) 0))
    (is (= ((step-oscilator 4) 1) 1))
    (is (= ((step-oscilator 4) 2) 2))
    (is (= ((step-oscilator 4) 3) 1))
    (is (= ((step-oscilator 4) 4) 0))

    (is (= ((step-oscilator 6) 0) 0))
    (is (= ((step-oscilator 6) 1) 1))
    (is (= ((step-oscilator 6) 2) 2))
    (is (= ((step-oscilator 6) 3) 3))
    (is (= ((step-oscilator 6) 4) 2))
    (is (= ((step-oscilator 6) 5) 1))
    (is (= ((step-oscilator 6) 6) 0))
    (is (= ((step-oscilator 6) 7) 1))
    (is (= ((step-oscilator 6) 8) 2))))

(comment (deftest solve-test
  (testing "correct num steps"
    (is (= (solve 1) 0))
    (is (= (solve 4) 1))
    (is (= (solve 9) 2))
    (is (= (solve 12) 3))
    (is (= (solve 23) 2))
    (is (= (solve 1024) 31)))))

(deftest rotation-test
  (testing "finds correct rotation"
    (is (= (rotation [0 0]) 0))
    (is (= (rotation [0 1]) 1))
    (is (= (rotation [1 0]) 1))
    (is (= (rotation [2 2]) 2))
    (is (= (rotation [-2 2]) 2))
    (is (= (rotation [3 -2]) 3))))

(deftest turning-points-test
  (testing "finds correct points"
    (is (= (turning-points 0) #{[0 0]}))
    (is (= (turning-points 1) #{[1 1][-1 1][-1 -1][1 -1]}))
    (is (= (turning-points 2) #{[2 2][-2 2][-2 -2][2 -2]}))))

(deftest side-test
  (testing "sides"
    (is (= (side-length 0) 1))
    (is (= (side-length 1) 3))))

(deftest corner-dist-test
  (testing "stuff"
    (is (= (corner-distance 1) 0))
    (is (= (corner-distance 3) 1))))

(deftest next-point-test
  (testing "next-point??!?!?"
    (is (= (next-point [0 0]) [1 0])))
    (is (= (next-point [1 0]) [1 1]))
    (is (= (next-point [0 1]) [-1 1]))
    (is (= (next-point [1 -1]) [2 -1]))
    (is (= (next-point [2 -1]) [2 0]))
    (is (= (next-point [2 -2]) [3 -2]))
    (is (= (next-point [-2 2]) [-2 1])))
