(ns clojure.examples.example
   (:gen-class))
(defn Example []
  ;Since the send function is an asynchronous function, there is a time delay for when the value of the agent is updated.
  ;Secondly, when you run the above program, the program WILL NOT TERMINATE immediately. This is because the Clojure environment does not know whether it is safe to shut down the agent
   (def counter (agent 0))
   (println @counter)
   
   (send counter + 100)
   (println "Incrementing Counter")
   (println @counter))
(Example)
