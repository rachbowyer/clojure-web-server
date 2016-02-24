(ns clojure-web-server.model.schema
  (:require [schema.core :as s]))

(def Property
  "Property for sale"
  {:description                 s/Str
   :price                       s/Num
   :pic                         s/Str
   (s/optional-key :exclusive)  s/Bool})

(def EnrichedProperty
  "Property for sale after application of businsess rules"
  (assoc Property :standout s/Bool))
