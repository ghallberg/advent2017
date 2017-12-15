(ns advent2017.solvers.day6
  (:require [clojure.string :as s]
            [advent2017.utils :as u]))

(defn parse [input]
  (vec (map u/parse-int (u/tokenize input))))


(defn rebalance [config]
  config)

(defn rebalance-and-check [configs]
  (let [config (last configs)
        config' (rebalance config)
        configs' (conj configs config')]
    (if (distinct? configs')
      configs'
      (reduced (count configs')))))

