(ns tabelificando.core
  (:gen-class))

(defn tableify [row]
   (apply format "%-20s | %-20s | %-20s" row)) 

(def header ["First Name", "Last Name", "Employee ID"])

(def employees [["Ryan", "Neufeld", 2] ["Luke", "Vanderhart", 1]])


(defn -main
  "I don't do a whole lot ... yet."
  [& args]

(->> (concat [header] employees)
(map tableify)
(mapv println))
  )
