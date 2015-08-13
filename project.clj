(defproject flangutter "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  ;; :repositories [
  ;;                ;; point to wherever natlangfun goes
  ;;                ]
  ;; :import (java.util.jar JarFile)
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [csv-map "0.1.2"]
                 [clojure.java.io :as io]
                 ;; todo: put natlangfun here when I separate it out
                 ]
  :main ^:skip-aot flangutter.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
