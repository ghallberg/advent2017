(ns advent2017.solvers.day7-test
  (:require [clojure.test :refer :all]
            [clojure.string :as s]
            [advent2017.solvers.day7 :refer :all]))

(def string-nodes ["hej (12)" "blubb (15)" "bla (123) -> hej, blubb"])

(def branch1 {:name "blubb"
             :weight 15
             :tree-weight 15
             :branches #{}})

(def branch2 {:name "hej"
             :weight 12
             :tree-weight 12
             :branches #{}})

(def root-node {:name "bla"
                :weight 123
                :branch-names #{"hej" "blubb"}})

(def parsed-nodes #{branch1
                    branch2
                    root-node})

(def tree {:name "bla"
           :weight 123
           :tree-weight 150
           :branches #{branch1 branch2}})

(def test-input "pbga (66)
xhth (57)
ebii (61)
havc (66)
ktlj (57)
fwft (72) -> ktlj, cntj, xhth
qoyq (66)
padx (45) -> pbga, havc, qoyq
tknk (41) -> ugml, padx, fwft
jptl (61)
ugml (68) -> gyxo, ebii, jptl
gyxo (61)
cntj (57)")

(def test-tree (parse test-input))

(deftest parse-test
  (testing "parses numbers nicely"
    (let [output (parse (s/join "\r\n" string-nodes))]
      (is (map? output))
      (is (= output tree)))))

(deftest find-root-test
  (testing "finds the root"
    (is (= (find-root parsed-nodes) root-node))))

(deftest build-tree-test
  (testing "correct tree structure"
           (is (= (build-tree parsed-nodes root-node) ))))

(deftest puzzle1-test
  (testing "stuff"
    (is (= (puzzle1 test-input) "tknk"))))

(deftest puzzle2-test
  (testing "stuff"
    (is (= (puzzle2 test-input) ["ugml" 60]))))
