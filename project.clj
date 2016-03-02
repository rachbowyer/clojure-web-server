(defproject clojure-web-server "0.1.0-SNAPSHOT"
  :description "Demonstration of Clojure web development for QCon2016"
  :url "https://github.com/rachbowyer/clojure-web-server"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :global-vars {*warn-on-reflection* false
                *assert* true}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/core.async "0.2.374"]

                 ; Elastic search
                 [clojurewerkz/elastisch "2.2.1"]

                 ; Web server
                 [compojure "1.4.0"]
                 [ring "1.4.0"]
                 [ring/ring-defaults "0.1.5"]

                 ; Templating
                 [stencil "0.5.0"]]


  ;:plugins [[lein-ring "0.9.7"]]

  ;:ring {:handler clojure-web-server.handler/app}

  :repl-options {:welcome (println "Type (dev) and then (start) to bring up the webserver")
                 :init-ns user}

  :main ^:skip-aot clojure-web-server.server

  :profiles {:dev {:source-paths ["src" "dev"]
                   :plugins [[jonase/eastwood "0.2.1" :exclusions [org.clojure/clojure]]
                             [lein-kibit "0.1.2" :exclusions [org.clojure/clojure]]
                             [lein-vanity "0.2.0" :exclusions [org.clojure/clojure]]
                             [lein-midje "3.2"]]

                   :dependencies [[org.clojure/tools.namespace "0.2.11"]
                                  ;[javax.servlet/servlet-api "2.5"]
                                  ;[ring/ring-mock "0.3.0"]
                                  [midje "1.8.3"]]}
             :uberjar {:aot :all}})
