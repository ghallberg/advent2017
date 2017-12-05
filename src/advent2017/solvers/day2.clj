(ns advent2017.solvers.day2
  (:require [clojure.string :as s]
            [advent2017.utils :as u]))

(defn parse [input]
  (let [lines (s/split-lines input)
        tokens (map u/tokenize lines)]
    (map (partial map u/parse-int) tokens)))

(defn sub-checksum [num-vec]
  (- (apply max num-vec) (apply min num-vec)))

(defn divisible-pair? [[x y]]
  (= (mod x y) 0))

(defn x [[old-pairs tail] head]
  (let [new-pairs (map vector tail (repeat head))
        pairs (concat old-pairs new-pairs)
        new-tail  (rest tail)]
    (if (= (count new-tail) 0)
      (reduced (map (partial sort >) pairs))
      [pairs new-tail])))

(defn permutations [nums]
  (let [tail (rest nums)]
    (reduce x [[] tail] nums)))

(defn divisibles [nums]
  (let [pairs (permutations nums)]
    (first (filter divisible-pair? pairs))))

(defn div-checksum [num-vec]
  (let [pair (divisibles num-vec)]
    (apply / pair)))

(defn solve [num-vecs checksummer]
  (reduce + (map checksummer num-vecs)))

(defn puzzle1 [input]
  (solve (parse input) sub-checksum))

(defn puzzle2 [input]
  (solve (parse input) div-checksum))




