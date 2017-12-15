(ns advent2017.solvers.day5
  (:require [clojure.string :as s]
            [advent2017.utils :as u]))


(defn parse [input]
  (let [lines (s/split-lines input)]
    (vec (map u/parse-int lines))))

(defn gen-maze-solver [update-fun [maze pos] steps]
  (let [cmd (maze pos)
        cmd' (update-fun cmd)
        maze' (assoc maze pos cmd')
        pos' (+ pos cmd)]
    (if (>= pos' (count maze))
      (reduced steps)
      [maze' pos'])))

(defn solve [update-fun maze]
  (let [maze-solver (partial gen-maze-solver update-fun)]
    (reduce maze-solver [maze 0] (map inc (range)))))


(defn puzzle1 [input]
    (solve inc (parse input)))

(defn custom-updater [offset]
  (if (>= offset 3)
    (dec offset)
    (inc offset)))

(defn puzzle2 [input]
    (solve custom-updater (parse input)))


