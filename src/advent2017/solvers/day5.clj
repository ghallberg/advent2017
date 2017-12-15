(ns advent2017.solvers.day5
  (:require [clojure.string :as s]
            [advent2017.utils :as u]))


(defn parse [input]
  (let [lines (s/split-lines input)]
    (map u/parse-int lines)))
