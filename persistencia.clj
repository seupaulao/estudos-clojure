(ns persistent.core)

;Write a function, persistence, that takes in a 
;positive parameter num and returns its multiplicative persistence, 
;which is the number of times you must multiply the digits in num until 
;you reach a single digit.
;exemplo:
; (persistence 39) ; returns 3, because 3*9=27, 2*7=14, 1*4=4
;                  ; and 4 has only one digit
;                  
; (persistence 999) ; returns 4, because 9*9*9=729, 7*2*9=126,
;                   ; 1*2*6=12, and finally 1*2=2
; (persistence 4) ; returns 0, because 4 is already a one-digit number
;


(defn digitos [n]
  "converte um numero numa lista de digitos"
  (->> n str (map (comp read-string str))))

(defn contador[n c]
 "realiza o algoritmo do problema pressuposto"   
    (if (< (count (digitos n)) 2)
        c
        (contador (reduce * (digitos n)) (+ c 1))
  ))

(defn persistence [n]
     (contador n 0)
  )
