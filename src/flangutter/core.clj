(ns flangutter.core
  ;; I'll move some of the code into a library once I'm more comfortable with how the infrastructure works
  ;; (:require [natlangfun :as lang])
  (:gen-class)
  (:require csv-map.core
            [clojure.java.io :as io])
  )

(defrecord language
    [
     reference-name
     own-name
     iso-code
     scripts
     templates
     vocabulary
     ])

(defmacro language-description
  "Describe a language which in the reference language is called
  @var{language-name}.

  If @var{language-name} is a list, it describes the language's place in
  the tree of languages, with the specific language name coming first
  and increasingly broad language families following.

  The language's own name for itself is @var{own-name} (which, like the
  reference name, may be a list; it, or any components of it, may be
  arrays consisting of the word in the language's script and a
  transliteration into Latin script).

  If a name or name component will be read by Scheme as a symbol, it may
  be given as a Scheme symbol.  Otherwise, it should be given as a
  string.

  The language's ISO 639-3 code is given as @var{code}.

  The writing systems are described by @var{scripts}, which is a list of
  lists of script-type and script-name.  If a third element is given for
  a script description, it is a vector containing the characters used in
  that script, in their conventional sorting order for that language, as
  strings, with symbols that share a place in the sorting order grouped
  in square brackets in the same string."
  [language-name own-name code scripts]
  ;; todo: put language description parts into language's definition
  )

(defmacro template
  "Define a template for a language construct, to be filled in with the given parts."
  [template-name template-parameters & templated-parts]
  ;; todo: put template onto language's templates list
  )

(defmacro template
  "Define a template for a language construct, to be filled in with the given parts."
  [template-name template-parameters & templated-parts]
  ;; todo: put template onto language's templates list
  )

;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; word database lookups ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn word-translation [word target-language source-language]
  ;; todo: translation database lookup
  )

(defn gender-of-noun []
  ;; todo: translation database lookup
  )

;;;;;;;;;;;;;
;; joining ;;
;;;;;;;;;;;;;

(defn words [& word-containers]
  ;; todo: traverse word-containers, flattening it, concatenating the strings with spaces inbetween?  Or should I leave it as a list (perhaps just flatten it?)
  )

;;;;;;;;;;;;;;;;;;;;;;;
;; top-level drivers ;;
;;;;;;;;;;;;;;;;;;;;;;;

(defn construct [language structure context]
  ;; todo: translate the words of STRUCTURE
  ;; should translate words before forming the structure, as the words may modify the structure
  (map
   (fn [item]
     (cond
       (string? item) (word-translation item language)
       ))
   structure))

;;;;;;;;;;;;;;;;;;;;;;;;
;; definition reading ;;
;;;;;;;;;;;;;;;;;;;;;;;;

(def language-directory ;; "~/open-projects/natlangfun/languages/"
  ;; todo: try (System/getProperty "user.home")
  "/home/jcgs/open-projects/natlangfun/languages/"
    )

(def vocabulary-directory
 ;; "~/open-projects/natlangfun/vocabulary/"
 "/home/jcgs/open-projects/natlangfun/vocabulary/"
)
(def source-language "eng")

(def languages {})

(defn read-language [language-name]
  ;; TODO: get the vocabulary file name from source-language and the language code field of the language we are loading
  (load-file
   (.getPath
    (io/file language-directory
             (clojure.string/join "." 
                                  (list language-name "clj"))))))

(defn read-vocabulary [vocab-file]
  ;; TODO: I think clojure has a special syntax for a nested call like this
  (let [raw-maps (csv-map.core/parse-csv 
                  (slurp
                   (io/file vocabulary-directory
                            (clojure.string/join "."
                                                 (list vocab-file "csv")))))]
    raw-maps
    ))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
