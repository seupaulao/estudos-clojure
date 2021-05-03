(ns demo.swing
    (:import [javax.swing JFrame JLabel JTextField JButton]
             [java.awt.event ActionListener]
             [java.awt GridLayout]))
  
  (comment
    (do (require 'clojure.pprint)
          (use 'clojure.repl)
          (use 'clojure.java.javadoc)))
  
  ;;Interop
  ;;Direct wrapper free access
  
  (defn celsius2far[cel] (+ (/ (* 9 cel) 5) 32))
  (defn celsius []
    (let [frame (JFrame. "Celsius Converter")
          temp-text (JTextField.)
          celsius-label (JLabel. "Celsius")
          convert-button (JButton. "Convert")
          fahrenheit-label (JLabel. "Fahrenheit")]
          (.addActionListener
            convert-button
            (reify java.awt.event.ActionListener
              (actionPerformed [_ evt]
                (let [cel (Double/parseDouble (.getText temp-text))
                      fahr (str (celsius2far cel))]
                  (.setText fahrenheit-label fahr)))))
      (doto frame
        (.setLayout (GridLayout. 2 2 3 3))
        (.add temp-text) 
        (.add celsius-label)
        (.add convert-button) 
        (.add fahrenheit-label)
        (.setSize 300 80) (.setVisible true))))
  
(celsius)        