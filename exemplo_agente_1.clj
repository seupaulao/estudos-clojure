(ns clojure.examples.example
   (:gen-class))
(defn Example []
   (def counter (agent 0))
   (println @counter))
(Example)
