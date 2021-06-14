(ns ex4.core
  (:gen-class)
  (:require [seesaw.core :as seesaw]))

  (defn celsius2far[cel] (+ (/ (* 9 cel) 5) 32))

  (defn -main [& args]
    ;exemplo de funcao dentro de funcao
    (defn display[conteudo] 
      (let [janela (seesaw/frame :title "Exemplo 4" :on-close :exit)]
        (-> janela
          (seesaw/config! :content conteudo)
          (seesaw/pack!)
          (seesaw/show!))))
    ;define uma variavel imutavel, pois os componentes sao imutaveis    
    (def label1 (seesaw/label
      :text "Celsius"
      :background :white
      :foreground :black
      :font "ARIAL-BOLD-10"))
    (def label2 (seesaw/label
        :text "Farenheit"
        :background :white
        :foreground :black
        :font "ARIAL-BOLD-10"))
    (def label3 (seesaw/label
          :text "Farenheit"
          :background :white
          :foreground :red
          :font "ARIAL-BOLD-14"))
      (def textfield1
        (seesaw/text
           :text "32"
           :editable? true
           :columns 50))
    (def botao
      (seesaw/button 
        :text "Clique Nesse Botão!"
        :listen [:action (fn [event] (let [fahr (celsius2far (Double/parseDouble (.getText textfield1)))]
          (.setText label3 (str fahr))))]))      
  
    (def gpanel 
          (seesaw/grid-panel :columns 2 :items [label1 textfield1 label2 label3]))      
    (def vpanel 
              (seesaw/vertical-panel :items [gpanel botao]))        

    (display vpanel))
