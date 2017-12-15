(ns advent2017.solvers.day4
  (:require [clojure.string :as s]
            [advent2017.utils :as u]))

(defn parse [input]
  (let [lines (s/split-lines input)]
    (map u/tokenize lines)))

(defn count-all-distinct [input]
  (count (filter (partial apply distinct?) input)))

(defn puzzle1 [input]
  (count-all-distinct (parse input)))

(defn map-sort [input]
  (map sort input))

(defn puzzle2 [input]
  (count-all-distinct (map map-sort (parse input))))
