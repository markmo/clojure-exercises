(ns clojure-exercises.multiples)

(defn divisible-by-any [divisors]
  (fn [n]
    (defn divisible-by? [d]
      (= 0 (mod n d)))
    (some divisible-by? divisors)))

(def divisible? (divisible-by-any [3 5]))

(def total (reduce + (filter divisible? (range 1000))))
