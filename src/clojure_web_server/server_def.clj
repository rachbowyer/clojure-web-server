(ns clojure-web-server.server-def)

; If the file containing the server var is injected into the repl
; without the server being shutdown, then there the port gets blocked
; without a way to release it without restarting the repl. To protect
; against this the server variable is isolated to its own file.

(def server nil)
