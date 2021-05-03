(ns clojure.examples.example
   (:gen-class))
(defn Example []
   (def counter (agent 0))
   (println @counter)
   
   (send-off counter + 100)
   ;aguarda um tempo para receber o valor assincrono
   (println (await-for 100 counter))
   (println @counter)
   
   (shutdown-agents))
(Example)
