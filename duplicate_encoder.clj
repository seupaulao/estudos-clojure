; criar strings to tamanho dos originais com '(' e ')'
; se o caractere nao se repete entao ele sera '('
; se o caractere se repete pelo menos uma vez ')'
;"din"      =>  "((("
;"recede"   =>  "()()()"
;"Success"  =>  ")())())"
;"(( @"     =>  "))((" 

;
; Alterar a abordagem para aumentar a velocidade
; porque os textos do teste sao muito grandes
; 1. guardar os elementos lidos num conjunto separado incremental
;    se  o valor dentro do conjunto entao ) senao (

(ns kata.core)

;(defn contem [x lista] (map #(= x %) lista))

(defn contem [x conjunto] (if (nil? (conjunto x)) false true))

;(defn contar-true[lista] (count (filter identity lista)))

(defn encode-dups [text]
   ; Your brilliant code here :)
  ; (println text)
   (loop [
         ;original (seq (clojure.string/upper-case text))
         temp (seq (clojure.string/upper-case text))
         conjunto (set (keys (remove (fn [[k v]] (= v 1)) (frequencies (seq (clojure.string/upper-case text))))))
         nova ()
        ]
       ; (print (first temp) conjunto)
        (if (empty? temp) 
            (apply str (reverse nova))
            (recur (rest temp) 
                   conjunto
                   (if (not (contem (first temp) conjunto)) 
                          (conj nova "(") 
                          (conj nova ")"))))))


(defn encode-dups-meu-2[text]
   (apply str (map #(if (> ((frequencies (seq (clojure.string/upper-case text))) %) 1) ")" "(") (clojure.string/upper-case text))))
    

