(ns	financeiro.saldo-aceitacao-test
  (:require [midje.sweet :refer :all]
            [cheshire.core :as json]
            [financeiro.auxiliares :refer :all]
            [clj-http.client :as http]))

(against-background [(before :facts (iniciar-servidor porta-padrao))
                     (after :facts (parar-servidor))]

                    (fact "O saldo inicial e 0" :aceitacao
                           (json/parse-string (conteudo "/saldo") true) => {:saldo 0})

                    ;; lein midje :filters aceitacao (roda somente esse filtro/fact)
                    ;; lein midje :filters -aceitacao (roda tudo menos o filtro/fact escolhido)

                    (fact "O saldo e 10 quando a unica transacao e uma receita de 10" :aceitacao
                          (http/post (endereco-para "/transacoes")
                                     {:body (json/generate-string {:valor 10 :tipo "receita"})})
                          (json/parse-string (conteudo "/saldo") true) => {:saldo 10}))







