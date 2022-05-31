package com.example.myapplication

/*
This class should call the Googles API, using HTTP Requests
in order to convert an address to a lat and lng pair
it will also be fetching the data tiles for the google maps view

In order to simplify things since this is not a coding course I will
skip the api calls, so this service will only return a few static pairs (locations)
and the corresponding images to display instead of the tiles.
*/
class GeocodingService {
    fun addressToCoords(address: String): Pair<Double, Double>? {
        if(address == "MVP Patra") {
            return Pair(38.25612055095445, 21.74074361147726)
        }
        if(address == "Icon Patra") {
            return Pair(38.246194170603275, 21.731702011298903)
        }
        if(address == "Fitness Mall") {
            return Pair(38.24655778719483, 21.737186497982538)
        }
        if(address == "Patraiko Gymnastirio") {
            return Pair(38.240997831680836, 21.731615169147265)
        }
        if(address == "Studio 6") {
            return Pair(38.24806663733413, 21.7346719268177)
        }
        return null
    }

    // In the case the address entered is not one that can be mapped to
    // coordinates use this function to get the coordinates of the tiles
    // (image in our impl) for the current location (plateia georgiou in out impl)
    fun getCurrentLocationTiles(): Int {
        return R.drawable.geo_plateia_georgiou
    }

    fun getCurrentLocation(): Pair<Double, Double> {
        return Pair(38.246071508095646, 21.735207972839923)
    }
}