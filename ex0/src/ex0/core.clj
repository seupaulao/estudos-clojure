(ns ex0.core
  (:gen-class)
  (:use seesaw.core))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (invoke-later
    (-> (frame :title "Hello",
           :content "Hello, Seesaw",
           :on-close :exit)
     pack!
     show!)))
