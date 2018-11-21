(ns advent2017.solvers.day9
  (:require [clojure.string :as s]
            [clojure.pprint :refer [pprint]]
            [advent2017.utils :as u]))

(defn garbage-consume [[next-char & remainder] level points gar-count]
  (case next-char
    "!" [:garbage (rest remainder) level points gar-count]
    ">" [:group remainder level points gar-count]
    [:garbage remainder level points (inc gar-count)]))

(defn normal-consume [[next-char & remainder] level points gar-count]
  (case next-char
    "{" [:group remainder (inc level) points gar-count]
    "}" [:group remainder (dec level) (+ points level) gar-count]
    "<" [:garbage remainder level points gar-count]
    [:group remainder level points gar-count]))

(defn count-points [state input level points gar-count]
  (let [[new-state remainder new-level new-points new-gar-count] (if (= state :garbage)
                                                     (garbage-consume input level points gar-count)
                                                     (normal-consume input level points gar-count))]

    (if (empty? remainder)
      [new-points new-gar-count]
      (recur new-state remainder new-level new-points new-gar-count))))


(defn puzzle1 [input]
  (let [str-input (map str input)]
    (count-points :init str-input 0 0 0)))


