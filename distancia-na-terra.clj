
(def earth-radius 6371.009)

(defn degrees->radians [point]
(mapv #(Math/toRadians %) point))

(defn distance-between
"Calculate the distance in km between two points on Earth. Each
point is a pair of degrees latitude and longitude, in that order."
([p1 p2] (distance-between p1 p2 earth-radius))
([p1 p2 radius]
(let [[lat1 long1] (degrees->radians p1)
[lat2 long2] (degrees->radians p2)]
(* radius 
   (Math/acos (+ (* (Math/sin lat1) (Math/sin lat2))
(* (Math/cos lat1)
(Math/cos lat2)
(Math/cos (- long1 long2)))))))))

(println "Distancia: " (distance-between [49.2000 -98.1000] [35.9939, -78.8989]))
