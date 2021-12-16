
(defn mentions [tweet]
(re-seq #"(@|#)(\w+)" tweet))

(defn extraindo[]
   (println (re-seq #"\w+" "Minhas coisas favoritas"))
   (println (re-seq #"\d{3}-\d{4}" "Meu telefone eh: 555-6578"))
   (println (mentions "So long, @earth, and thanks for all the #fish. #goodbyes")))

(extraindo)
