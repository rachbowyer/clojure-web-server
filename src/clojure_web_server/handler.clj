(ns clojure-web-server.handler
  (:require [clojure-web-server.model.properties :as properties]
            [clojure-web-server.render :as render]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as response]))

;; Handlers
(defn- handle-get-properties []
  (-> (properties/get-properties)
      (properties/enrich-properties)
      (render/render-properties)))

;; Routes

(defroutes app-routes
  (GET "/get-properties" [] (handle-get-properties))
  (GET "/" [] (response/redirect "index.html"))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

