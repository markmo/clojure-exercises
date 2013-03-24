(ns clojure-exercises.smallest)

(defn divisible [divisors]
  (fn [n]
    (defn divisible-by? [d]
      (= 0 (mod n d)))
    (every? divisible-by? divisors)))

(def divisible? (divisible (range 1 21)))

(def result (first (filter divisible? (iterate (partial + 20) 20))))
