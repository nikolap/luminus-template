(ns leiningen.new.auth
  (:require [leiningen.new.common :refer :all]))

(defn auth-features [[assets options :as state]]
  (if (some #{"+auth"} (:features options))
    [assets
     (-> options
         (append-formatted :auth-session
                           [['buddy.auth.backends.session :refer ['session-backend]]]
                           plugin-indent))]
    state))
