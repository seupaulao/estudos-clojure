(ns clojure.examples.example
   (:gen-class))
(defn Example []
   (def counter (agent 0))
   (println @counter)
   ; faz o mesmo que send, porem o send-off retornara o agente primeiro e continuara com a operacao
   ; quando tudo estiver completo, ele atualiza o agente   
   ; ou seja, fara o contrario do send
   (send-off counter + 100)
   (println @counter)
   (println @counter)
   (println @counter)
   (shutdown-agents)
   )
(Example)

