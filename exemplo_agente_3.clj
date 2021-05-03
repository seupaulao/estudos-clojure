(ns clojure.examples.example
   (:gen-class))
(defn Example []
   (def counter (agent 0))
   (println @counter)
   ;essa funcao altera o agente de forma assincrona
   (send counter + 100)
   (println "Incrementing Counter")
   ;para esse valor aparecer de imediato eh necessario aguardar alguns
   ;milisegundos, o q nao ocorre aqui
   (println @counter)
   ;funcao usada para terminar o agente
   (shutdown-agents))
(Example)
