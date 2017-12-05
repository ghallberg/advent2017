(ns advent2017.core
  (:require [clojure.java.io :as io])
  (:gen-class))

(defn read-input [no]
  (slurp (io/resource (str "day" no ".txt"))))

(defn solver-name [no puz]
  (str "advent2017.solvers.day" no "/puzzle" puz))

(defn day-solver [no puz]
  (let [string-name (solver-name no puz)]
    (resolve (symbol string-name))))

(defn -main
  "Run problem no:sub"
  [& [no puz]]
  (let [input  (read-input no)
        solver (day-solver no puz)]
    (solver input)))
