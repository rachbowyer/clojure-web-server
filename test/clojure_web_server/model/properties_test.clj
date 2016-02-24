(ns clojure-web-server.model.properties-test
  (:require [clojure-web-server.model.properties :refer :all]
            [midje.sweet :refer :all]))

; Due to the greater composibility of the functional style,
; mocking is not actually required in this example.

;(facts "Properties are enriched"
;       (fact "Properties have standout attribute"
;             (->> (get-properties)
;                  enrich-properties
;                  (map :standout)) => [true, false]
;
;             (provided (get-properties) =>
;                [{:price 7000000 :exclusive true},
;                 {:price 400000 :exclusive true}])))
