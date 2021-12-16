(ns tempo.core
  (:gen-class))

(defn tempo[t] (loop [size t] (when (> size 0) (print (str size "\n")) (recur (dec size)))))

(defn -main [& args]
  (tempo 15)
  (println (str "---Final---")))
