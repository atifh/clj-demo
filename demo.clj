(ns clj-openai.fun
  (:require
   [clj-http.client :as client]))
   

(defn hello-world []
  (println "Hello World!"))


;; Immutable example
(def numbers [64 11 20 22 47])

(conj numbers 10)

(map #(inc %) numbers)

(filter odd? numbers)


;; Functions
(defn square [x]
  (* x x))

(defn factorial [n]
  (if (zero? n)
    1
    (* n (factorial (dec n)))))

;; Usage
(factorial 5)  ;; Returns 120
(factorial 10)  ;; Returns 3628800

;; Fizz Buzz
;; for multiple of 3 > Fiz
;; for multiple of 5 > Buzz
;; for multiple of 3 & 5 > FizzBuzz
;; for
(defn fizz-buzz-1 []
  (doseq [i (range 1 101)]
    (let [fizz? (zero? (mod i 3))
          buzz? (zero? (mod i 5))]
      (cond (and fizz? buzz?)
            (println "FizzBuzz" i)
            fizz?
            (println "Fizz" i)
            buzz?
            (println "Buzz" i)
            :else
            (println i)))))

(defn fizzbuzz-2 [n]
  (let [fizz? #(zero? (mod % 3))
        buzz? #(zero? (mod % 5))
        fizzbuzz? #(and (fizz? %) (buzz? %))
        to-words (some-fn #(when (fizzbuzz? %) "FizzBuzz")
                          #(when (fizz? %) "Fizz")
                          #(when (buzz? %) "Buzz"))]
    (map (fn [n]
           (or (to-words n) n)) (range n))))


;; Higher-order function
;; a function that takes one or more functions as arguments
(defn apply-twice [f x]
  (f (f x)))

;; Usage
(apply-twice inc 5)  ;; Returns 7
(apply-twice square 5)  ;; Returns 9



(defn get-audi []
  {:brand "audi" :models ["A6" "Q3"]})

(defn get-nissan []
  {:brand "nissan" :models ["sunny" "magnite"]})

(defn get-hyundai []
  {:brand "hyundai" :models ["creta" "venue"]})


(defn get-all-cars []
  [(get-audi)
   (get-nissan)
   (get-hyundai)])


;; [{:brand "audi" :models ["A6" "Q3"]}
;; {:brand "nissan", :models ["sunny" "magnite"]}
;;  {:brand "hyundai", :models ["creta" "venue"]}]
