(ns advent2017.utils
  (:require [clojure.string :as s]))

(defn parse-int [s]
  (let [clean-s (s/trim s)]
    (Integer/parseInt clean-s)))

(defn tokenize [s]
  (s/split s #"\s"))
