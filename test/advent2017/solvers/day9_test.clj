(ns advent2017.solvers.day9-test
  (:require [clojure.test :refer :all]
            [clojure.string :as s]
            [advent2017.solvers.day9 :refer :all]))

(deftest test-garbage-consume
  (testing "!"
    (is (= (garbage-consume ["!" "<" "a"] 1 4) [:garbage ["a"] 1 4])))

  (testing ">"
    (is (= (garbage-consume [">" "{"] 1 4) [:group ["{"] 1 4])))

  (testing "a"
    (is (= (garbage-consume ["a" ">"] 1 4) [:garbage [">"] 1 4]))))

(deftest test-normal-consume
  (testing "<"
    (is (= (normal-consume ["<" "<" "a"] 1 4) [:garbage ["<" "a"] 1 4])))

  (testing "} on level 3"
    (is (= (normal-consume ["}" "{"] 3 5) [:group ["{"] 2 8])))

  (testing "} on level 2"
    (is (= (normal-consume ["}" "{"] 2 4) [:group ["{"] 1 6])))

  (testing "} on level 1"
    (is (= (normal-consume ["}" "{"] 1 2) [:group ["{"] 0 3])))

  (testing "{"
    (is (= (normal-consume ["{" "{"] 1 4) [:group ["{"] 2 4]))))

(deftest test-puzzle1
  (testing "{}"
    (is (= (puzzle1 "{}") 1)))

  (testing "{{{}}}"
    (is (= (puzzle1 "{{{}}}") 6)))

  (testing "{{},{}}"
    (is (= (puzzle1 "{{},{}}") 5)))

  (testing "{{{},{},{{}}}}"
    (is (= (puzzle1 "{{{},{},{{}}}}") 16)))

  (testing "{{<!!>},{<!!>},{<!!>},{<!!>}}"
    (is (= (puzzle1 "{{<!!>},{<!!>},{<!!>},{<!!>}}") 9)))

  (testing "{{<a!>},{<a!>},{<a!>},{<ab>}}"
    (is (= (puzzle1 "{{<a!>},{<a!>},{<a!>},{<ab>}}") 3))))

(def lol3 "
    {<a>,<a>,<a>,<a>}, score of 1.
    {{<ab>},{<ab>},{<ab>},{<ab>}}, score of 1 + 2 + 2 + 2 + 2 = 9.
    {{<!!>},{<!!>},{<!!>},{<!!>}}, score of 1 + 2 + 2 + 2 + 2 = 9.
    {{<a!>},{<a!>},{<a!>},{<ab>}}, score of 1 + 2 = 3.
")
