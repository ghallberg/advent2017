(ns dev
  (:require
    [clojure.tools.namespace.repl :refer [refresh refresh-all clear]]
    [clojure.repl :only (doc)]
    [advent2017.core :as core]
    [advent2017.utils :as u]
    [clojure.string :as s]
    [advent2017.solvers.day1 :as day1]
    [advent2017.solvers.day2 :as day2]
    [advent2017.solvers.day3 :as day3]
    [advent2017.solvers.day4 :as day4]
    [advent2017.solvers.day5 :as day5]
    [advent2017.solvers.day6 :as day6]
    [advent2017.solvers.day7 :as day7]
    [advent2017.solvers.day8 :as day8]
    [advent2017.solvers.day9 :as day9]))

(clojure.tools.namespace.repl/set-refresh-dirs "dev" "src" "test")

(defn run [& args]
  (apply core/-main args))
