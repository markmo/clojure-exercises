(ns clojure-exercises.game-of-life)

(def not-nil? (complement nil?))

(defn game-of-life [coords]
  (def dim-x (first (sort > (map first coords))))
  (def dim-y (first (sort > (map #(% 1) coords))))
  (def c-map (zipmap coords (repeat 0)))
  (defn neighbours [c]
    (def x (c 0))
    (def y (c 1))
    (count (filter not-nil? [
      (c-map [(dec x) (dec y)]) (c-map [x (dec y)]) (c-map [(inc x) (dec y)])
      (c-map [(dec x) y])                           (c-map [(inc x) y])
      (c-map [(dec x) (inc y)]) (c-map [x (inc y)]) (c-map [(inc x) (inc y)])
    ])))
  (defn alive? [c]
    (if (nil? (c-map c))
      (= 3 (neighbours c))
      (and (> (neighbours c) 1) (< (neighbours c) 4))))
  (def cells (for [x (range 1 (+ 2 dim-x)) y (range 1 (+ 2 dim-y))] [x y]))
  (filter alive? cells))

(def test (game-of-life [[1 2] [2 2] [3 2]]))
