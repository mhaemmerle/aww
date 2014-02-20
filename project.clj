(defproject aww "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [cheshire "5.2.0"]
                 [enlive "1.1.5"]
                 [compojure "1.1.6"]]
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
  :plugins [[lein-ring "0.8.10"]]
  :jvm-opts ["-Djava.awt.headless=true"]
  :ring {:handler aww.ring/app}
  :main aww.core)
