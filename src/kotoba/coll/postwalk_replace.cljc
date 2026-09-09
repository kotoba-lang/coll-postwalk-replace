(ns kotoba.coll.postwalk-replace
  "postwalk-replace -- one definition, addressed on its own.

  Split out of kotoba.lang.text on 2026-09-09. The unit here is the
  DEFINITION, not the library: this repo holds postwalk-replace and names, in its
  deps.edn, exactly the definitions postwalk-replace reaches. Nothing else."
  (:require [kotoba.coll.postwalk :refer [postwalk]]))

(defn postwalk-replace
  "Recursively transform `form` by replacing every node that is a key in
  `replacements` with that key's value, bottom-up. Mirrors
  clojure.walk/postwalk-replace."
  [replacements form]
  (postwalk (fn [x] (if (contains? replacements x) (get replacements x) x)) form))
