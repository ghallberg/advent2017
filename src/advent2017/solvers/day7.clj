(ns advent2017.solvers.day7
  (:require [clojure.string :as s]
            [advent2017.utils :as u]))

(defn node-by-name [nodes name]
  (first (filter (fn [x] (= (:name x) name)) nodes)))

(defn find-root [nodes]
  (let [branches (set (apply concat (map :branch-names nodes)))]
    (first (filter (fn [x] (not (branches (:name x)))) nodes))))

(defn clean-token [token]
  (s/replace token #"[\(\),]" ""))

(defn parse-node [line]
  (let [tokens (u/tokenize line)
        node {:name (first tokens)
              :weight (u/parse-int (clean-token (second tokens)))}]
    (if (> (count tokens) 2)
      (assoc node :branch-names (set (map clean-token (subvec tokens 3))))
      node)))

(defn build-tree [nodes root]
  (let [branches (map (partial node-by-name nodes) (:branch-names root))
        root (dissoc root :branch-names)
        branches (set (map (partial build-tree nodes) branches))
        root-tree-weight (apply + (:weight root) (map :tree-weight branches))]
    (assoc root :branches branches :tree-weight root-tree-weight)))

(defn parse [input]
  (let [lines (s/split-lines input)
        nodes (map parse-node lines)
        root (find-root nodes)]
    (build-tree nodes root)))

(defn puzzle1 [input]
  (:name (parse input)))

(defn find-bad-branch [branches]
  (let [groups (vals (group-by :tree-weight branches))
        bad-group (first (filter (fn [x] (= (count x) 1)) groups))]
    (first bad-group)))

(defn find-bad-node [root]
  (if (apply = (seq (map :tree-weight (:branches root))))
    root
    (recur (find-bad-branch (:branches root)))))

(defn puzzle2 [input]
  (let [tree (parse input)
        bad-node (find-bad-node tree)
        branch-weights (map :tree-weight (:branches tree))
        diff (- (apply max branch-weights) (apply min branch-weights))]
    [(:name bad-node) (- (:weight bad-node) diff)]))
