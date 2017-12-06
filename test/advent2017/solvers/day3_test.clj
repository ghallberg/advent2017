(ns advent2017.solvers.day3-test
  (:require [clojure.test :refer :all]
            [advent2017.solvers.day3 :refer :all]))

(deftest power-test
  (testing "some two-powers"
    (is (= (nth two-powers 0) 1))
    (is (= (nth two-powers 1) 2))
    (is (= (nth two-powers 2) 4))))

(deftest haystack-test
  (testing "gets correct haystack"
    (is (= (first (haystack 1)) 8))
    (is (= (first (haystack 2)) 4))))

(comment (deftest solve-test
  (testing "correct num steps"
    (is (= (solve 1) 0))
    (is (= (solve 4) 1))
    (is (= (solve 3) 2))
    (is (= (solve 12) 3))
    (is (= (solve 23) 2))
    (is (= (solve 1024) 31)))))
