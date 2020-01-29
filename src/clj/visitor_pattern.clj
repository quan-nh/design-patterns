(ns visitor-pattern)

;; Multimethods
; assume we have 2 data types
(def c {:shape :circle :r 10})
(def r {:shape :rectangle :l 5 :w 10})

; to define a new method on these data types
(defmulti pdf-export :shape)

(defmethod pdf-export :circle [_]
  (println "Exporting circle to pdf.."))

(defmethod pdf-export :rectangle [_]
  (println "Exporting rectangle to pdf.."))

(defmethod pdf-export :default [shape]
  (throw (Exception. (str "unrecognized shape: " shape))))

; call method on each data
(pdf-export c)
(pdf-export r)

;; Protocols
