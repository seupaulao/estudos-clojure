# Passo a passo - criando um projeto do zero com shadow-cjls
---


1. 
```shell
npx create-cljs-project counter-app
```
2. testando projeto recem criado 

```shell
npx shadow-cljs browser-repl
```

3. No arquivo shadow-cljs.edn

```clojure
{...
  :builds
  {:app                              ;; name of build
   {:target :browser                 ;; target the browser
    :output-dir "public/app/js"      ;; output js files here
    :asset-path "/app/js"            ;; used to construct the URL
    :modules {:main                  ;; we need one module
               ;; start `contador.app/init` when the JS loads
               {:init-fn contador.app/init}}}}}
```

4. Em public/index.html

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Counter Application</title>
  </head>
  <body>
    <div id="app"></div>
    <script src="/app/js/main.js"></script>
  </body>
</html>
```

4. em shadow-cljs.edn novamente abaixo de dependencies:

```clojure
:dev-http {8080 "public"}
``` 

5. crie o arquivo main/contador/app.cljs 

```clojure
(ns contador.app)

(defn init[]
   (println "o app esta funcionando")
)
```

6. 
```shell
npx shadow-cljs watch app	
```

observe a saida no console do dev.tools do seu browser 

7. ao mexer nas dependencias esteja com o servidor/REPL/
terminal desligado

Contrl + C

depois disso, instale o react no node

agora, use o comando do passo 6

8. adicione a seguinte linha em dependencias no arquivo edn :

```clojure
[reagent "1.1.0"]
```

```shell
npx shadow-cljs watch app
```
9. aplicacao minima com reagent

```clojure
(ns contador.app
  (:require [reagent.core :as r])
  (:require [reagent.dom :as dom])
  
  ....
   
   (defn Application [] "Ola mundo, ")   
  
  ...
 (dom/render [Application] (js/document.getElementById "app"))
```

10. gerando a versão para produção

```shell
npx shadow-cljs release app
```

11. subindo o servidor de produção 
```shell
npx shadow-cljs server app
```