(ns advent2017.solvers.day7
  (:require [clojure.string :as s]
            [advent2017.utils :as u]))

(defn node-by-name [nodes name]
  (first (filter (fn [x] (= (:name x) name)) nodes)))

(defn find-root [nodes]
  (let [children (set (apply concat (map :child-names nodes)))]
    (first (filter (fn [x] (not (children (:name x)))) nodes))))

(defn clean-token [token]
  (s/replace token #"[\(\),]" ""))

(defn parse-node [line]
  (let [tokens (u/tokenize line)
        node {:name (first tokens)
              :weight (u/parse-int (clean-token (second tokens)))}]
    (if (> (count tokens) 2)
      (assoc node :child-names (set (map clean-token (subvec tokens 3))))
      node)))

(defn build-tree [nodes root]
  (if (:child-names root)
    (let [children (map (partial node-by-name nodes) (:child-names root))
          sub-trees (set (map (partial build-tree nodes) children))]
      (assoc (dissoc root :child-names) :children sub-trees))
    root))

(defn parse [input]
  (let [lines (s/split-lines input)
        nodes (map parse-node lines)
        root (find-root nodes)]
    (build-tree nodes root)))

(defn puzzle1 [input]
  (:name (parse input)))

(defn tree-weight [node]
  (apply (partial + (:weight node)) (map tree-weight (:children node))))

(defn bad-child [children]
  (let [child1 (first children)
        child2 (second children)
        child3 (last children)]
  (if (= (tree-weight child1) (tree-weight child2))
    child3
    (if (= (tree-weight child1) (tree-weight child3))
      child2
      child1))))

(defn find-bad-node [tree]
  (let [children (:children tree)]
    (println "TREENAME" (:name tree))
    (println "CHILD" (bad-child children))
    (if (apply = (map tree-weight children))
      [(:name tree) (:weight tree)]
      (recur (bad-child children)))))

(defn puzzle2 [input]
  (let [tree (parse input)]
    (find-bad-node tree)))
