(ns revrot.core)
(require '[clojure.string :as str])

;The input is a string str of digits. Cut the string into 
;chunks (a chunk here is a substring of the initial string) of size 
;sz (ignore the last chunk if its size is less than sz).

;If a chunk represents an integer such as the sum of the cubes of its digits 
;is divisible by 2, reverse that chunk; 
;otherwise rotate it to the left by one position. 
;Put together these modified chunks and return the result as a string.

;If
;sz is <= 0 or if str is empty return ""
;sz is greater (>) than the length of str it is impossible to 
;take a chunk of size sz hence return "".

;;;Examples
;revrot("123456987654", 6) --> "234561876549"
;revrot("123456987653", 6) --> "234561356789"
;revrot("66443875", 4) --> "44668753"
;revrot("66443875", 8) --> "64438756"
;revrot("664438769", 8) --> "67834466"
;revrot("123456779", 8) --> "23456771"
;revrot("", 8) --> ""
;revrot("123456779", 0) --> ""
;revrot("563000655734469485", 4) --> "0365065073456944"

;Example of a string rotated to the left by one position:
;s = "123456" gives "234561".

(defn rol [a] (concat (rest a) (list (first a))))

(defn digitos [n]
  "converte um numero numa lista de digitos"
  (->> n str (map (comp read-string str))))

(defn processar[pedaco]
  (if (= (mod (reduce + (map #(* % % %) (digitos pedaco))) 2) 0)
    (reduce str (reverse (digitos pedaco)))
    (reduce str (rol (digitos pedaco)))
  ))
; o problema aqui eh transformar a string de numero
; em uma lista quebrada por pedacos de tamanho fixo
; onde o proximo pedaco so eh valido, se tiver caracteres suficientes
; para preencher, alem das dimensoes de entrada abaixo
;
;
; no exemplo revrot("563000655734469485", 4) --> "0365065073456944"
; a entrada tem 18 caracteres, mas a saida tem uma string de 16
; porque o ultimo pedaco nao teve caracteres suficientes, entao foi removido 
;
; se strng == "" entao resultado == ""
; se sz == 0 entao resultado == ""
; se sz > (count strng) entao resultado == ""
(defn quebrar[entrada n]
  (loop [et entrada lista () nt n total (count entrada) tam n passo 0] 
    (if (> tam total) (reverse lista) 
      (recur et (conj lista (subs et passo tam)) nt total (+ tam nt) (+ passo nt)))))

(defn revrot [strng sz]
  (if (or (= sz 0) (= (count strng) 0) (> sz (count strng)))
    ""
    (loop [input (quebrar (subs strng 0 (- (count strng) (mod (count strng) sz))) sz) 
           resultado ""]
          (if (empty? input) resultado
           (recur (rest input) (str resultado (processar (first input))))))))
    



