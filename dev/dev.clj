(ns dev
  (:require
    [clojure.tools.namespace.repl :refer [refresh refresh-all clear]]
    [advent2017.core :as core]
    [advent2017.solvers.day1 :as day1]
    [advent2017.solvers.day2 :as day2]))

(clojure.tools.namespace.repl/set-refresh-dirs "dev" "src" "test")

(defn run [& args]
  (apply core/-main args))

(def input "1 2 3 4 5 66
123 4 5 644
2133 3 3 3")

