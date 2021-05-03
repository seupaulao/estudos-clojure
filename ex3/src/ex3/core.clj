(ns ex3.core
  (:gen-class)
  (:require [seesaw.core :as seesaw]))

(defn -main [& args]
  ;exemplo de funcao dentro de funcao
  (defn display[conteudo] 
    (let [janela (seesaw/frame :title "Exemplo 3" :on-close :exit)]
      (-> janela
        (seesaw/config! :content conteudo)
        (seesaw/pack!)
        (seesaw/show!))))
  ;define uma variavel imutavel, pois os componentes sao imutaveis    
  (def label (seesaw/label
    :text "Isto eh um LABEL"
    :background :white
    :foreground :black
    :font "ARIAL-BOLD-10"))
  (def textfield
      (seesaw/text
         :text "Isto eh um Campo de Texto FIXO"
         :editable? false
         :columns 50))
  (def botao
    (seesaw/button 
      :text "Clique Nesse Botão!"
  ;perceba aqui a força do seesaw
  ;ao inves de usar um ActionListener e depois criar um ActionPerform com renfy
  ;simplesmente ouço a ação e disparo um evento  
      :listen [:action (fn [event] (seesaw/alert "Click!!!"))]))      
  (def hpanel
    (seesaw/horizontal-panel :items [textfield botao]))  

  (def vpanel 
        (seesaw/vertical-panel :items [label hpanel]))      
      
        (display vpanel))
