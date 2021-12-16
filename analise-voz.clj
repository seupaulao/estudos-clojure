(def altura 5)

(def minha-voz 2)

(defn minha-voz-elevada[] (* minha-voz altura))

(defn analise-voz[] (str "\nMinha voz padrao: " minha-voz "\nMinha voz elevada: " (minha-voz-elevada) "\n\n"))

(print (analise-voz))
