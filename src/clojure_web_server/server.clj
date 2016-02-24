(ns clojure-web-server.server
  (:require [clojure-web-server.server-def :refer [server]]
            [clojure-web-server.handler :refer [app]]
            [clojure.core.async :as async]
            [ring.adapter.jetty :as jetty]
            [stencil.loader :as sl])
  (:gen-class))


;; Web server

(defn stop-server []
  (when server
    (.stop server)
    (alter-var-root #'server (constantly nil))))

(def ^:private a-channel (async/chan 1))

(defn start-server []
  (sl/set-cache (clojure.core.cache/ttl-cache-factory {} :ttl 0))

  (stop-server)
  (alter-var-root #'server (fn [_] (jetty/run-jetty #'app {:port 3000 :join? false}))))


;; Main entry point

(defn -main [& args]
  (.addShutdownHook (Runtime/getRuntime) (Thread. (fn [] (println "Shutting down...")
                                                         (stop-server)
                                                         (async/>!! a-channel "c"))))
  (println "OnTheMarket webserver")
  (start-server)
  (async/<!! a-channel))
