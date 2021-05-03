(ns ex2.core
  (:require [seesaw.core :as seesaw]))
  (def window (seesaw/frame
     :title "First Example"
     :content "hello world"
     :width 200
     :height 50))
  (defn -main
     [& args]
    ;seesaw eh uma lib usada para criar swing apps
    ;lanca o janela
     (seesaw/show! window)
    ;altera o conteudo da janela
     (seesaw/config! window :content "Good Bye")
    ;lancamento de um alert
     (seesaw/alert "Hello World"))
