(defproject advent2017 "0.1.0-SNAPSHOT"
  :description "Advent of code 2017 solutions by Gustah Hallberg"
  :url "https://github.com/ghallberg/advent2017"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/math.numeric-tower "0.0.4"]]
  :main ^:skip-aot advent2017.core
  :target-path "target/%s"
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]]
                   :source-paths ["dev"]
                   :repl-options {:init-ns dev}}
             :uberjar {:aot :all}})
