(ns lendo-arquivo.core
  (:gen-class))

(defn readAllFile[] (slurp "/home/paulo/Documentos/estudos-clojure/Example.txt"))

(defn readEachLine[] 
     (with-open [rdr (clojure.java.io/reader "/home/paulo/Documentos/estudos-clojure/Example.txt")]
       (reduce conj [] (line-seq rdr))))

(defn writeStringInFile[]
  (spit "/home/paulo/Documentos/estudos-clojure/Arquivo1.txt" "Conteudo Arquivo 1"))

(defn appendLineInFile[arquivo] 
  (with-open [w (clojure.java.io/writer arquivo :append true)] 
    (.write w (str "ola " "mundo\n"))
    (.write w (str "ola grandes riquezas!" "\n"))
    (.write w (str "ola " "conhecimento " "abstrato!"))))

(defn isArquivoThere[path] 
     (println (.exists (clojure.java.io/file path))))

(defn -main
  [& args]
  (def string1 (readAllFile))
  (println string1)
  (println (readEachLine))
  (writeStringInFile)
  (appendLineInFile "/home/paulo/Documentos/estudos-clojure/Arquivo1.txt")
  (isArquivoThere "/home/paulo/Documentos/estudos-clojure/Arquivo1.txt")
  (isArquivoThere "/home/paulo/Documentos/estudos-clojure/Arquivo2.txt")
  )

