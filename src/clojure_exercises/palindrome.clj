(ns clojure-exercises.palindrome)

(require '[clojure.string :as s])

(defn palindrome? [n]
  (= (str n) (s/reverse (str n))))

(defn x-multiply [n]
  (sort >
    (for [x (range n 0 -1)
          y (range n 0 -1)]
      (* x y))))

(def result (first (filter palindrome? (x-multiply 999))))
