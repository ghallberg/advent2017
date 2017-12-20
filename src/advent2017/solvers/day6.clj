(ns advent2017.solvers.day6
  (:require [clojure.string :as s]
            [advent2017.utils :as u]))

(defn parse [input]
  (vec (map u/parse-int (u/tokenize input))))

(defn next-slot [config slot]
  (let [size (count config)]
    (if (>= (inc slot) size)
      0
      (inc slot))))

(defn redistribute [config prev-slot remainder]
  (let [slot (next-slot config prev-slot)
        value (config slot)
        value' (inc value)
        config' (assoc config slot value')
        remainder' (dec remainder) ]
    (if (= remainder' 0)
      config'
      (recur config' slot remainder'))))

(defn rebalance [config]
  (let [amount (apply max config)
        max-slot (.indexOf config amount)
        config' (assoc config max-slot 0)]
    (redistribute config' max-slot amount)))

(defn find-loop [configs]
  (let [config (last configs)
        config' (rebalance config)
        configs' (conj configs config')]
    (if (apply distinct? configs')
      (recur configs')
      configs')))

(defn puzzle1 [input]
  (dec (count (find-loop [(parse input)]))))

(defn count-loop-steps [looping-v]
  (let [loop-result (last looping-v)
        first-occ (.indexOf looping-v loop-result)
        length (dec (count looping-v))]
    (- length first-occ)))

(defn puzzle2 [input]
  (count-loop-steps (find-loop [(parse input)])))

