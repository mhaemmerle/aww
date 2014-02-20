(ns aww.core
  (:gen-class)
  (:require [net.cgrand.enlive-html :as html]
            [cheshire.core :refer [generate-string]]))

(defn fetch-page [url]
  (html/html-resource (java.net.URL. url)))

(defn image-url [content]
  (get-in (first (html/select content [:div#siteTable :a])) [:attrs :href]))

(defn aww-image [url]
  (let [content (fetch-page url)
        img-url (image-url content)]
    {:title (first (html/select content [:title :> html/text-node]))
     :url img-url
     :img img-url}))

(defn -main [& args]
  (generate-string (aww-image "http://www.reddit.com/r/aww/random")))
