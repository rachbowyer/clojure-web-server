(ns user)

; Functions have been put into 'dev not 'user to allow the REPL
; to start even if code does not compile
(defn dev []
  (require 'dev)
  (in-ns 'dev))
