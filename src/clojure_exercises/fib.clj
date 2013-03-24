(ns clojure-exercises.fib)

(defn fib [a b]
  (cons a (lazy-seq (fib b (+ b a)))))

(def total (reduce + (filter even? (take-while #(< % 4000000) (fib 1 2)))))
