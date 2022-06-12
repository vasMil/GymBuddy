package com.example.myapplication.services

import com.example.myapplication.entities.Gym
import com.example.myapplication.R

class GymService {
var gyms: Array<Gym> = emptyArray();

    init {
        fetchGyms()
    }

    fun fetchGyms() {
        // Empty the gyms array
        if(gyms.isNotEmpty()) gyms = emptyArray()

        // Create the Gyms
        val icon = Gym("Icon", Pair(38.246194170603275, 21.731702011298903),
            R.drawable.geo_icon_kentro
        )
        val mvp = Gym("MVP", Pair(38.25612055095445, 21.74074361147726),
            R.drawable.geo_mvp_agiasofia
        )
        val studio6 = Gym("Studio 6", Pair(38.24806663733413, 21.7346719268177),
            R.drawable.geo_studio6_kentro
        )
        val patraiko = Gym("Patraiko", Pair(38.240997831680836, 21.731615169147265),
            R.drawable.geo_patraiko_gymnasthrio
        )
        val fitnessMall = Gym("Fintess Mall", Pair(38.24655778719483, 21.737186497982538),
            R.drawable.geo_fitness_mall_kentro
        )

        // Add them to the array
        gyms = arrayOf(icon, mvp, studio6, patraiko, fitnessMall)
    }

    fun getGymsNearby(curLoc: Pair<Double, Double>, maxDistance: Int): Array<Gym> {
        var nearbyGyms = mutableListOf<Gym>()
        gyms.forEach { gym ->
            // If > 230m add Studio 6
            if (maxDistance > 230 && gym.name == "Studio 6") {
                nearbyGyms.add(gym)
                return@forEach
            }
            // If > 250m add Fitness Mall
            if (maxDistance > 250 && gym.name == "Fintess Mall") {
                nearbyGyms.add(gym)
                return@forEach
            }
            // If > 400m add Icon
            if (maxDistance > 400 && gym.name == "Icon") {
                nearbyGyms.add(gym)
                return@forEach
            }
            // If > 900m add Patraiko Gymnastirio
            if (maxDistance > 900 && gym.name == "Patraiko") {
                nearbyGyms.add(gym)
                return@forEach
            }
            // If > 1300m add MVP
            if (maxDistance > 1300 && gym.name == "MVP") {
                nearbyGyms.add(gym)
                return@forEach
            }
        }

        // Return the array with gyms nearby
        return nearbyGyms.toTypedArray()
    }

    fun getGymByLocation(location: Pair<Double, Double>): Gym? {
        gyms.forEach { gym ->
            if(gym.location == location) return gym
        }
        return null
    }
}