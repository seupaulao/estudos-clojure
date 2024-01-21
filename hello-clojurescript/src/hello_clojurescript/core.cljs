(ns hello-clojurescript.core
(:require react-dom))

(println "ola mundo clojurescript")

(defn media [a b]
  (/ (+ a b) 2.0))

  (.render js/ReactDOM
  (.createElement js/React "h2" nil "Hello, React!")
  (.getElementById js/document "app"))