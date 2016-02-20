(ns clojure-web-server.render
  (:require [stencil.core :as sc]))

(defn render-properties [properties]
  (let [formatted-properties (map (fn [p] (assoc p :price-formatted (format "£%,d" (:price p)))) properties)]
    (sc/render-file "property.html" {:properties formatted-properties})))

