(ns financeiro.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [cheshire.core :as json]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]))

(defn	saldo-como-json	[]
  {:headers	{"Content-Type" "application/json; charset=utf-8"}
   :body	(json/generate-string	{:saldo	0})})

(defroutes app-routes
            (GET "/" [] "oi")
            (GET "/saldo" [] (saldo-como-json))
            (POST "/transacoes" [] {})
            (route/not-found "Recurso não encontrado"))

(def app
  (wrap-defaults app-routes api-defaults))

;;curl --head http://localhost:3000/saldo (não roda, diz que n acha)
;;lein ring server (tbm n esta rodando)



