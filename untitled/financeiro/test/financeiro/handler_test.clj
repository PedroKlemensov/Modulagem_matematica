(ns financeiro.handler-test
  (:require [midje.sweet :refer :all]
            [ring.mock.request :as mock]
            [cheshire.core	:as	json]
            [financeiro.handler :refer :all]))

(facts "Dá um 'Olá, mundo!' na rota raiz"
       (let	[response	(app (mock/request :get "/"))]
         (fact "o	status da reposta	é	200"
               (:status	response)	=>	200)
         (fact "o	texto	do corpo é 'Olá, mundo!'"
               (:body	response)	=> "oi")))


(facts "Rota inválida não existe"
       (let	[response	(app (mock/request :get	"/invalid"))]
         (fact "o	código de erro é	404"
               (:status	response)	=> 404)
         (fact "o	texto	do corpo é 'Recurso	não	encontrado'"
               (:body	response)	=> "Recurso não encontrado")))


(facts "Saldo	inicial	é	0"
       ;;	aqui	a	gente	define	o	mock
       (against-background (json/generate-string {:saldo 0})
                            => "{\"saldo\":0}")
       (let	[response	(app (mock/request :get	"/saldo"))]

         (fact "o formato é 'application/json'"
               (get-in response [:headers "Content-Type"])
               => "application/json; charset=utf-8")

         (fact "o	status da	resposta é 200"
               (:status	response)	=> 200)

         ;;	e	aqui	nós	mudamos	a	descrição	e	o	conteúdo	do	fato
         (fact "o	texto	do corpo é um	JSON cuja	chave	é	saldo	e	o	valor	é 0"
               (:body	response)	=> "{\"saldo\":0}")))





;;qualquer quebra de linha pode ser um problema, cuidado ao copiar do livro







