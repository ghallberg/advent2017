(ns advent2017.solvers.day3
  (:require [clojure.math.numeric-tower :as math]
            [advent2017.utils :as u]))

(defn parse [input]
  (u/parse-int input))

(def odds  (filter odd? (range)))
(def rotation-ends (map math/expt odds (repeat 2)))
(def rotation-pairs (map vector (range) rotation-ends))

(defn side-length [rot-no]
  (nth odds rot-no))

(defn corner-distance [s-len]
  (math/floor (/ s-len 2)))

(defn rotation-finder [num]
  (fn [pair] (<= num (last pair))))

(defn rotation-pair [num]
  (first (filter (rotation-finder num) rotation-pairs)))

(defn step-oscilator [s-len]
  (let [corner-dist (corner-distance s-len)]
    (fn [dist] (math/abs (- (mod (+ dist corner-dist) s-len) corner-dist)))))

(defn solve [num]
  (let [[rot-no rot-end] (rotation-pair num)
        end-steps (* 2 rot-no)
        rotation-steps (- rot-end num)
        period (max 1 (- (side-length rot-no) 1))
        step-diff ((step-oscilator period) rotation-steps)]
    (- end-steps step-diff)))

(defn puzzle1 [input]
  (solve (parse input)))

(defn turning-points [rot]
  (let [neg-rot (* -1 rot)]
    (set [[rot rot]
          [neg-rot rot]
          [neg-rot neg-rot]
          [rot neg-rot] ])))

(defn turning-point? [rot point]
  (let [tps (turning-points rot)]
    (tps point)))

(defn rotation [[x y]]
  (let [x-dist (math/abs x)
        y-dist (math/abs y)
        s-len (side-length x-dist)
        same-rot-lim (corner-distance s-len)]
    (+ x-dist (max 0 (- y-dist same-rot-lim)))))

(defn normal-dir [point]
  (let [rot (rotation point)
        s-len (side-length rot)
        cd (corner-distance s-len)
        [x y] point]
    (if (= (math/abs x) cd)
      (if (> x 0)
        :up
        :down)
      (if (> y 0)
        :left
        :right))))

(defn turning-dir [[x y]]
  (if (> x 0)
    (if (> y 0)
      :left
      :right)
    (if (<= y 0)
      :right
      :down)))

(defn next-dir [point]
  (let [rot (rotation point)]
    (if (turning-point? rot point)
      (turning-dir point)
      (normal-dir point))))

(defn move [[x y] dir]
  (case dir
    :right [(+ x 1) y]
    :left  [(- x 1) y]
    :up    [x (+ y 1)]
    :down  [x (- y 1)]))

(defn next-point [point]
  (move point (next-dir point)))

(defn path-walker [cur-point]
  (next-point cur-point))

(def path (iterate path-walker [[0 0] :down]))

(def points [[0 0][0 1][0 2]])
(def slot-values [[1 2 3 4][5 6 7 8][9 10 11 12]])

(defn get-value [[x y]]
  ((slot-values x) y))

(defn neighbours [[x y]]
  (let [x+ (+ x 1)
        x- (- x 1)
        y+ (+ y 1)
        y- (- y 1)]
    [[x+ y+]
     [x+ y]
     [x+ y-]
     [x y+]
     [x y-]
     [x- y+]
     [x- y]
     [x- y-]]))

(defn neighbour-sum [point]
  (reduce + (map get-value (neighbours point))))

(def neighbour-sums (map neighbour-sum points))

(defn puzzle2 [input]
  (first filter (partial < (parse input)) neighbour-sums))

