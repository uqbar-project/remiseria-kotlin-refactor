package ar.edu.algo2.remiseria

import java.util.*
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

class Remiseria {
    val remiseros: MutableList<Remisero> = mutableListOf()
    val viajes: MutableList<Viaje> = mutableListOf()

    private fun distance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val theta = lon1 - lon2
        var dist = sin(deg2rad(lat1)) * sin(deg2rad(lat2)) + cos(deg2rad(lat1)) * cos(
            deg2rad(lat2)
        ) * cos(deg2rad(theta))
        dist = acos(dist)
        dist = rad2deg(dist)
        dist = dist * 60 * 1.1515
        return (dist)
    }

    private fun deg2rad(deg: Double): Double {
        return (deg * Math.PI / 180.0)
    }

    private fun rad2deg(rad: Double): Double {
        return (rad * 180.0 / Math.PI)
    }

    fun realizarViaje(remisero: Remisero, origen: Lugar, destino: Lugar): Viaje {
        var c_viaje = 1500.0 // valor base de la remiseria
        remisero.chequearComision()
        c_viaje = c_viaje * (1 + remisero.comision / 100) // le sumo el costo del remisero
        val distancia = distance(destino.x, destino.y, origen.x, origen.y)
        c_viaje = c_viaje + (distancia.toInt() * 300) // se cobra 300 mangos por milla
        val viaje = Viaje(remisero, origen, destino, c_viaje)
        viajes.add(viaje)
        return viaje
    }

    fun viajesCopados(): MutableList<Viaje> {
        val viajesCopados: MutableList<Viaje> = mutableListOf()
        for (viaje in viajes) {
            val distancia = distance(viaje.destino.x, viaje.destino.y, viaje.origen.x, viaje.origen.y)
            if (distancia > 5) {
                viajesCopados.add(viaje)
            }
        }
        return viajesCopados
    }
}

class Remisero(var nombre: String) {
    var comision: Double = 0.0

    fun chequearComision() {
        if (nombre == "Pepe") comision = 20.0
        else                  comision = nombre.length * 2.0
    }
}

data class Lugar(val nombre: String, val x: Double, val y: Double)

abstract class Trayecto {
    val fecha = Date()
}

data class Viaje(val remisero: Remisero, val origen: Lugar, val destino: Lugar, val costo: Double): Trayecto() {
}