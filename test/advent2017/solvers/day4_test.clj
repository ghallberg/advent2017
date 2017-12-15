(ns advent2017.solvers.day4-test
  (:require [clojure.test :refer :all]
            [clojure.string :as s]
            [advent2017.solvers.day4 :refer :all]))

(def correct1 "aa bb cc dd ee")
(def correct1parsed ["aa" "bb" "cc" "dd" "ee"])
(def correct2 "aa bb cc dd aaa")
(def correct2parsed ["aa" "bb" "cc" "dd" "aaa"])
(def incorrect1 "aa bb cc dd aa")
(def incorrect1parsed ["aa" "bb" "cc" "dd" "aa"])

(def input (s/join "\n" (list correct1 correct2 incorrect1)))
(def parsedinput (list correct1parsed correct2parsed incorrect1parsed))

(deftest parse-test
  (testing "parses input into words"
    (is (= (parse correct1) (list correct1parsed)))
    (is (= (parse correct2) (list correct2parsed)))
    (is (= (parse incorrect1) (list incorrect1parsed)))
    (is (= (parse input) parsedinput))))


