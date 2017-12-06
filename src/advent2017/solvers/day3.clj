(ns advent2017.solvers.day3
  (:require [clojure.math.numeric-tower :as math]
            [advent2017.utils :as u]))
(defn log2 [n]
  (/ (Math/log n) (Math/log 2)))

(def odds  (drop 1 (filter odd? (range))))
(def evens (drop 1 (filter even? (range))))
(def two-powers (map (partial math/expt 2) (range)))

(defn haystack [num]
  (if (even? num)
    (map (partial nth two-powers) evens)
    (map (partial nth two-powers) odds)))

(defn search-haystack [[sum num] cur-hay])

(defn x [num]
  (filter (partial < num) (haystack num)))

(defn solve [input])

(defn parse [input]
  (u/parse-int input))

(defn puzzle1 [input]
  (solve (parse input)))

