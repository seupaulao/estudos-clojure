(ns contador.app
  (:require [reagent.core :as r])
  (:require [reagent.dom :as dom])
)
(defn init[]
   (println "o app esta funcionando")
)
; com def cada vez que atualizar ela inicia
; usar defonce
(defonce current-count (r/atom 0))
(defonce contadores (r/atom []))

;; testando o mapa de um range
(println (map vector (range) [:a :b :c :d]))

(defn vec-delete [v i] (into (subvec v 0 i) (subvec v (inc i))))

;; testando a funcao acima no console
(println (vec-delete [:a :b :c] 1))

(defn Counter [i counter]
[:div
            counter
            " "
            [:button 
                          {:onClick (fn [] (swap! contadores update i inc))}
                          "+1"]
            [:button 
                          {:onClick (fn [] (swap! contadores update i dec))}
                          "-1"]
            [:button 
                          {:onClick (fn [] (swap! contadores vec-delete i))}
                          "X"]
                          
                          ]
)

(defn Application [] 
   [:div 
      [:h1 "Contador"] 
      (doall
      (for [[i counter] (map vector (range) @contadores)]
      ^{:key (str i)}[Counter i counter]
        ))
   [:button {:onClick (fn [] (swap! contadores conj 0))} "Adiciona Contador"]
   ]
)



 (dom/render [Application] (js/document.getElementById "app"))


