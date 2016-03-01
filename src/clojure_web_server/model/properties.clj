(ns clojure-web-server.model.properties
  (:require [clojurewerkz.elastisch.rest :as esr]
            [clojurewerkz.elastisch.rest.document :as esd]))

;; Database access layer

(defn connect []
  (esr/connect "http://127.0.0.1:9200"))

(defn get-properties
  "Fetch properties from the database"
  []
  (let [results (esd/search (connect) "property" "property")]
    (sort-by :price (map :_source (-> results :hits :hits)))))


;; Business rules

(defn enrich-properties
 "Apply business rules to properties"
 [properties]
  properties)

;(defn enrich-properties
;  "Apply business rules to properties"
;  [properties]
;  (map #(assoc % :standout (and (> (:price %) 5000000)
;                                   (true? (:exclusive %))))
;       properties))

