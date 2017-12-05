(ns advent2017.utils
  (:require [clojure.string :as s]))

(defn parse-int [s]
  (Integer/parseInt s))

(defn tokenize [s]
  (s/split s #"\s"))
