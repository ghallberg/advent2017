(ns advent2017.solvers.day1
  (:require [advent2017.utils :as u]))

(defn shift-pairer [input steps]
  (let [tail (subvec input steps)
        head (vec (take steps input))
        shifted (concat tail head)]
    (map vector input shifted)))

(defn next-pairer [input]
  (shift-pairer input 1))

(defn half-pairer [input]
  (let [half-count (/ (count input) 2)]
    (shift-pairer input half-count)))

(defn parse [input pairing-fun]
  (let [chars (map str input)
        ints  (vec (map u/parse-int chars))
        pairs (pairing-fun ints)]
    pairs))

(defn add-if-equal [sum [num1 num2]]
  (if (= num1 num2)
    (+ sum num1)
    sum))

(defn solve [pairs]
    (reduce add-if-equal 0 pairs))

(defn puzzle1 [input]
  (let [data (parse input next-pairer)]
    (solve data)))

(defn puzzle2 [input]
  (let [data (parse input half-pairer)]
    (solve data)))

