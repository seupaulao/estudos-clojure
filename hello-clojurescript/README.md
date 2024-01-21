# Projeto com clojurescript = cljs.jar puro

### abra o projeto, e dentro dele faça o download

fazer download de [cljs.jar](https://github.com/clojure/clojurescript/releases/download/r1.11.60/cljs.jar)

precisa ter java 8+ pra rodar corretamente

### compilar e disparar o REPL
```shell
java -cp "cljs.jar;src" cljs.main --compile hello-clojurescript.core --repl
```

### disparar o browser
```shell
java -cp "cljs.jar;src" cljs.main --repl-opts "{:launch-browser false}" --compile hello-clojurescript.core --repl
```

### recompilar e recarregar o REPL
```clojure
(require '[hello-world.core :as hello] :reload)
```

### olhar o help
```shell
java -cp "cljs.jar;src" cljs.main --help
```

### o diretorio out

contem a saida necessária compilada e otimizada pelo Google Closure Compiler

### otimizando a saida - todas as opções : advanced, whitespaces, simple e none [default]
```shell
java -cp "cljs.jar;src" cljs.main --optimizations advanced -c hello-world.core
```

### testando a aplicação como um simples webserver
```shell
java -cp "cljs.jar;src" cljs.main --serve
```

### instalando node 
```shell
npm install source-map-support
```

# preparando o projeto para rodar via node
```shell
java -cp "cljs.jar;src" cljs.main --target node --output-to main.js -c hello-world.core
```

### rodando via node
```shell
node main.js
```

### rodando o node.js REPL
```shell
java -cp "cljs.jar;src" cljs.main --repl-env node
```

