(ns aprenda_linguagem.frases_importantes (:gen-class))

(def ingles [["I love you" "Eu te amo"]
             ["You make me so happy" "Voce me faz tao feliz"]
             ["I miss you" "Senti sua falta"]
             ["Kiss me!" "Me beije!"]])

(defn -main[qual]
 (let [frases (get ingles (Integer. qual))]
    (println "Ingles:" (first frases))
    (println "Portugues:" (second frases))))
