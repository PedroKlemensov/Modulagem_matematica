(ns b3final.core
  (:require [clojure.tools.cli :refer[parse-opts]])
  (:gen-class)
  )

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


;(def    opcoes-do-programa
;  [["-d" "--de" "moeda base para conversão"
;    :default "eur"]
;   ["-p" "--para" "moeda destino"
;    "moeda a qual queremos saber o valor"]])

(def    opcoes-do-programa
  [["-d" "--de moeda base" "moeda base para conversão"
    :default "eur"]
   ["-p" "--para moeda destino"
    "moeda a qual queremos saber o valor"]])

(defn valores-sao [argumento]
  (cond
    (.startsWith argumento "--de=") {:de (.substring argumento 5)}
    (.startsWith argumento "--para=") {:para (.substring argumento 7)}
    :else {}
    )
  )

(defn -main
  [& args]
  (println "temos" (count args) "argumentos no total")
  ;(println "os argumentos sao:" (map valores-sao args))

  ;;	2	forma	de	criar	uma	string
  (new	String	"Vamos	converter	moedas")
  (String. "Vamos	converter	moedas")
  ;;	"Vamos	converter	moedas"



  ;;	toUpperCase	tem	um	.	antes
  ;;	que	é	a	macro	que	vai	converter	o	código	para	nós
  (.toUpperCase	(String. "Vamos	converter	moedas"))
  ;;	"VAMOS	CONVERTER	MOEDAS"
  ;;	mesmo	com	toLowerCase
  (.toLowerCase "BRL")
  ;;	"brl"
  ;(def StringQualquer (String. "TETANO"))
  ;(def MiniStringQualquer (.toLowerCase StringQualquer))
  ;
  ;(println StringQualquer "virou" MiniStringQualquer)

  (prn "as opcoes sao:"	(:options
                             (parse-opts args	opcoes-do-programa)))

  )