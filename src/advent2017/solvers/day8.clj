(ns advent2017.solvers.day8
  (:require [clojure.string :as s]
            [clojure.pprint :refer [pprint]]
            [advent2017.utils :as u]))

(def field-names [:affected-reg :direction :amount :if :check-reg :check :check-value])

(def test-input "b inc 5 if a > 1
a inc 1 if b < 5
c dec -10 if a >= 1
c inc -20 if c == 10")

(def fun-map {">" >
              "<" <
              "==" =
              "!=" not=
              ">=" >=
              "<=" <=
              "dec" -
              "inc" +})

(defn get-fun [string-fun]
  (fun-map string-fun))

(defn parse-instruction [line]
  (let [tokens (u/tokenize line)
        instruction (zipmap field-names tokens)]
    (-> instruction
        (dissoc :if)
        (assoc :amount (u/parse-int (:amount instruction)))
        (assoc :check-value (u/parse-int (:check-value instruction)))
        (assoc :affected-reg (keyword (:affected-reg instruction)))
        (assoc :check-reg (keyword (:check-reg instruction)))
        (assoc :check (get-fun (:check instruction))))))

(defn parse [input]
  (let [lines (s/split-lines input)]
    (map parse-instruction lines)))

(defn get-from-state [state aff-reg]
  (if-let [val (aff-reg (:regs state))]
    val
    0))

(defn update-state [state change-fun aff-reg amount]
  (let [regs (:regs state)
        aff-reg-val (get-from-state state aff-reg)
        new-val (change-fun aff-reg-val amount)
        new-regs (assoc regs aff-reg new-val)
        new-max (max new-val (:max state))]
    (assoc state :regs new-regs :max new-max)))

(defn apply-inst [state inst]
  (let [check (:check inst)
        aff-reg (:affected-reg inst)
        check-reg-val (get-from-state state (:check-reg inst))
        change-fun (get-fun (:direction inst))]
    (if (check check-reg-val (:check-value inst))
      (update-state state change-fun aff-reg (:amount inst))
      state)))

(defn run [state prog]
  (let [inst (first prog)
        rem-prog (rest prog)
        new-state (apply-inst state inst)]
    (if (empty? rem-prog)
      new-state
      (recur new-state rem-prog))))


(defn puzzle1 [input]
  (let [program (parse input)
        end-state (run {:max 0} program)]
    (pprint { :end-max (apply max (vals (:regs end-state))) :all-max (:max end-state) })))

(defn puzzle2 [input]
    (puzzle1 input))
