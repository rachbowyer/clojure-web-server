(ns clojure-web-server.database.schema)

(def property-mapping
  {:properties {:desc          {:type "string" :store "yes"}
                :price         {:type "integer" :store "yes"}
                :pic           {:type "string" :store "yes"}
                :exclusive     {:type "boolean" :store "yes"}
                }})
