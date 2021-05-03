(ns ex1.core
  (:gen-class)
  (:require [seesaw.core :as seesaw]))
(def window (seesaw/frame
  :title "First Example"
  :content "hello world"
  :width 200
  :height 50))
(defn -main
  [& args]
  (seesaw/show! window))
