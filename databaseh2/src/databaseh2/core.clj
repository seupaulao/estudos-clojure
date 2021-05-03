(ns databaseh2.core
  (:require [clojure.java.jdbc :as sql])
  (:gen-class))

(def db-spec
  {
  :classname   "org.h2.Driver"
  :subprotocol "h2:mem"
  :subname     "demo;DB_CLOSE_DELAY=-1"
  :user        "sa"
  :password    ""})

(defn criar-frutas-ddl[]
; o uso de do-do-commands para dizer qual conexao devo usar, senao nao cria a tabela temporaria
 (sql/db-do-commands db-spec
  (sql/create-table-ddl :fruta
                         [[:nome "varchar(32)"]
                          [:aparencia "varchar(32)"]
                          [:custo :int]]))
  (println "-----TABELA CRIADA-----"))

(defn insert-fruta[nome aparencia custo]
   ;(println "A ser inserido: " nome aparencia custo)
   (sql/insert! db-spec :fruta {:nome nome :aparencia aparencia :custo custo}))
   ;(println "INSERIDO: " nome))

(defn atualizar-custo-fruta[novovalor nome]
    (sql/update! db-spec :fruta {:custo novovalor} ["nome = ?" nome])
)

(defn apagar-fruta[nome]
  (sql/delete! db-spec :fruta ["nome = ?" nome]))

(defn get-nome-all-frutas [] 
  (println (sql/query db-spec ["select nome from fruta"] {:row-fn :nome})))   

(defn get-all-frutas [] 
  (println (sql/query db-spec ["select * from fruta"])))   


(defn -main
  "Teste em cima do banco de memoria H2"
  [& args]
  (criar-frutas-ddl)
  (insert-fruta "maca" "vermelha" "3")
  (insert-fruta "morango" "vermelho" "10")
  (insert-fruta "uva" "vermelho-escuro" "6")
  (insert-fruta "piqui" "verde-musgo" "14")
  (get-all-frutas)
  (atualizar-custo-fruta 12 "morango")
  (get-all-frutas)
  (apagar-fruta "piqui")
  (get-all-frutas)
 )
