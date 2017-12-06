(ns advent2017.solvers.day3
  (:require [clojure.math.numeric-tower :as math]
            [advent2017.utils :as u]))

(def odds  (filter odd? (range)))
(def rotation-ends (map math/expt odds (repeat 2)))
(def rotation-pairs (map vector (range) rotation-ends))

(defn rotation-finder [num]
  (fn [pair] (<= num (last pair))))

(defn rotation-pair [num]
  (first (filter (rotation-finder num) rotation-pairs)))

(defn step-oscilator [period]
  (let [half-period (math/floor (/ period 2))]
    (fn [dist] (math/abs (- (mod (+ dist half-period) period) half-period)))))

(defn solve [num]
  (let [pair (rotation-pair num)
        end-steps (* 2 (first pair))
        rotation-end (last pair)
        side-length (math/sqrt rotation-end)
        rotation-steps (- rotation-end num)
        period (max 1 (- side-length 1))
        step-diff ((step-oscilator period) rotation-steps)]
    (- end-steps step-diff)))

(defn parse [input]
  (u/parse-int input))

(defn puzzle1 [input]
  (solve (parse input)))

