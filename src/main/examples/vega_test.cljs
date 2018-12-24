(ns examples.vega-test
  (:require ["vega-embed" :as embed]))

(defn- group-data [& names]
  (apply concat (for [n names]
                  (map-indexed (fn [i x] {:x i :y x :col n}) (take 20 (repeatedly #(rand-int 100)))))))

(def line-plot
  {:data {:values (group-data "monkey" "slipper" "broom")}
   :encoding {:x {:field "x"}
              :y {:field "y"}
              :color {:field "col" :type "nominal"}}
   :mark "line"})

(defn- init! []
  ;(embed "#app" (clj->js line-plot))
  (embed "#app" "https://vega.github.io/vega/examples/nested-bar-chart.vg.json"))

(defn ^{:export true} main []
  (init!))

(comment
  (js/console.dir embed))
