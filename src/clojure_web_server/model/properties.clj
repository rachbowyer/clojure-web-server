(ns clojure-web-server.model.properties
  (:require [clojurewerkz.elastisch.rest :as esr]
            [clojurewerkz.elastisch.rest.document :as esd]
            [clojure-web-server.model.schema :as schema]
            [schema.core :as s]))

;; Database access layer

(defn connect []
  (esr/connect "http://127.0.0.1:9200"))

(defn get-properties
  "Fetch properties from the database"
  []
  (let [conn (connect)
        results (esd/search conn "property" "property")]
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



;; Examples using Prismatic schema for validation

;(s/defn get-properties :- [schema/Property]
;  "Fetch properties from the database"
;  []
;  (let [conn (connect)
;        results (esd/search conn "property" "property")]
;    (->> (map :_source (-> results :hits :hits))
;         (sort-by #(:price %)))))
;
;(s/defn enrich-properties :- [schema/EnrichedProperty]
;  "Apply business rules to properties"
;  [properties :- [schema/Property]]
;  (map #(assoc % :standout (and (> (:price %) 5000000)
;                                (true? (:exclusive %))))
;                 properties))

