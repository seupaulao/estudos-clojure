(ns dbname
    (:require [clojure.java.jdbc :as jdbc]))
; erro ao pegar clojure.java.jdbc - nao compila - tentar com lein
(def db-spec {
              :dbtype "h2:mem"
              :dbname "mydb" })

(jdbc/query dbspec ["SELECT 3*4 AS result"])
