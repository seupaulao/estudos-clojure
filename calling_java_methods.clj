(ns Project
   (:gen-class))
(import java.util.Stack)

(defn metodoJava []
   (println (.toUpperCase "Hello World")))

(defn metodoJavaComParams []
   (println (.indexOf "Hello World","e")))

(defn criarJavaObjects []
   (def str1 (new String "Hello"))
   (println str1))

(defn criarJavaObjects2 []
   (def my-int(new Integer 1))
   (println (+ 2 my-int)))

(defn importJavaCommand []
   (let [stack (Stack.)]
   (.push stack "First Element")
   (.push stack "Second Element")
   (println (first stack))))
;java built-in
(defn mostrarBuiltIn []
   (println (. Math PI)))

(defn mostrarSystemProperties []
   (println (.. System getProperties (get "java.version"))))

(println "*-*-*-*-*-*-* DEMONSTRACAO *-*-*--*-*-*-*-*\n\n")
(println "++++++++++++++++++")
(metodoJava)
(println "******************")
(metodoJavaComParams)
(println "++++++++++++++++++")
(criarJavaObjects)
(println "==================")
(criarJavaObjects2)
(println "------------------")
(importJavaCommand)
(println "-------------")
(mostrarBuiltIn)
(println "-------------")
(mostrarSystemProperties)
(println "-------------")
