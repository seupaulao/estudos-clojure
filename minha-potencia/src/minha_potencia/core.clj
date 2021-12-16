(ns minha-potencia.core
  (:gen-class))

(defn minha-potencia[x] (* x x))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (str "\n---Inicio---\n\nMinha potencia de 5: " (minha-potencia 5) "\na mesma por 25: " (minha-potencia 25) "\n\n---Fim---")))
