(ns dev
  (:require [clojure-web-server.server :as server]
            [clojure.tools.namespace.repl :refer [refresh-all set-refresh-dirs]]
            [clojure.repl :as repl]
            [clojurewerkz.elastisch.rest :as esr]
            [clojurewerkz.elastisch.rest.index :as esi]
            [clojurewerkz.elastisch.rest.document :as esd]
            [clojure-web-server.model.properties :refer [connect]]
            [clojure-web-server.database.schema :as schema]
            [midje.repl :refer :all]))

;; Start/stop webserver; reset repl

(defn start []
  ; Automatically run unit tests
  (autotest)
  (server/start-server))

(defn stop []
  (server/stop-server))

; Provides a synchronised stop, code reload, start - ensuring the server
; and code remain in sync
;(defn reset []
;  (stop)
;  ;(set-refresh-dirs "src" "dev")
;  (refresh-all :after 'dev/start))


;; Repl utilities
(defn pst []
  (repl/pst))


;; Database utilities

(defn create-mapping-property []
  (let [conn (connect)]
    (esi/update-mapping conn "_all" "property" :mapping {:property schema/property-mapping})))

(defn populate-properties [properties]
  (let [conn (connect)]
    (doseq [property properties]
      (esd/put conn "property" "property" (:id property) (dissoc property :id)))))

(defn create-index-property []
  (let [conn (connect)]
    (when (esi/exists? conn "property")
      (esi/delete conn "property"))
    (esi/create conn "property")
    (create-mapping-property)))



