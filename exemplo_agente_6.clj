(ns clojure.examples.example
   (:gen-class))
(defn Example []
  ;Blocks the current thread (indefinitely!) until all actions dispatched thus far, from this thread or agent, to the agent(s) have occurred
   (def counter (agent 0))
   (println @counter)
   
   (send-off counter + 100)
   (await counter)
   (println @counter)
   ;the value of the agent is printed to the screen immediately because the await function will wait for Clojure to first update the value of the function
   ;and only then will return control to the calling program
   ;repare a espera implicita da thread do await, enquanto o primeiro println
   ;eh imediatamente impresso
   (shutdown-agents))
(Example)
