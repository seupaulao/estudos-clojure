;Implement the function unique_in_order which takes as argument 
;a sequence and returns a list of items without any elements 
;with the same value next to each other and preserving the 
;original order of elements.
;
;Example:
;uniqueInOrder("AAAABBBCCDAABBB") == ['A' 'B' 'C' 'D' 'A' 'B']
;uniqueInOrder("ABBCcAD")         == ['A' 'B' 'C' 'c' 'A' 'D']
;uniqueInOrder([1,2,2,3,3])       == [1 2 3]
;uniqueInOrder([ 0 0 0 1 1 2 2 2 2 1 1 2 2 2 2 3 3]) == [0 1 2 1 2 3]

(ns katas.unique-in-order)

; vai ser util se a entrada for uma string
(defn separar [n]
  "essa funcao separa strings em lista de caracteres"
  (->> n str (map (comp read-string str))))

; note que no problema usar o set e depois converter nao funciona,
; porque deve se obedecer a ordem
(defn unique-in-order [input]
    (loop [ultimo (last (separar input)) entrada (rest (separar input)) novo [] lido (first (separar input))] 
        (println entrada novo lido)
        (if (empty? entrada) (conj novo ultimo) 
            (if (not (= lido (first entrada)))
                (recur ultimo (rest entrada) (conj novo lido) (first entrada))
                (recur ultimo (rest entrada) novo lido)))))


(defn unique-in-order [input]
  (map first (partition-by identity input)))
