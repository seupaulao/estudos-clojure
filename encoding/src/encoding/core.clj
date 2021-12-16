(ns encoding.core
  (:gen-class))

(defn encoding [msg] (map int msg))

(defn decoding [lista] (reduce #(str %1 (char %2)) "" (vec lista)))

(defn -main  [& args]
  (println (str "Lista de ints: ") (encoding "amo a xu"))
  (println (str "Mensagem decodificada: " (decoding (encoding "amo a xu")))))
  
