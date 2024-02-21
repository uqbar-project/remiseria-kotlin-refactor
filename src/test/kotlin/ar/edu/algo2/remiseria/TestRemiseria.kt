package ar.edu.algo2.remiseria

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TestRemiseria : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("costo de un viaje") {

        val remiseria = Remiseria()
        val origen = Lugar(nombre = "UNSAM Tornavías", x = -34.57820083943032, y = -58.52439793808785)
        val destino = Lugar(nombre = "Cancha de Huracán", x = -34.63838892841019, y = -58.396166895725194)

        it("el viaje debe considerar la comisión de Pepe + la distancia y el valor base de la remisería") {
            // arrange
            val pepe = Remisero(nombre = "Pepe")

            // act
            remiseria.realizarViaje(pepe, origen, destino)

            // assert
            remiseria.viajes.first().costo shouldBe 4200.0
        }

        it("el viaje debe considerar la comisión de la persona remisera + la distancia y el valor base de la remisería") {
            // arrange
            val remisera = Remisero(nombre = "Camila")

            // act
            remiseria.realizarViaje(remisera, origen, destino)

            // assert
            remiseria.viajes.first().costo shouldBe 4080.0
        }

    }

    describe("viajes copados") {

        val unsam = Lugar(nombre = "UNSAM Tornavías", x = -34.57820083943032, y = -58.52439793808785)
        val aulario = Lugar(nombre = "Aulario", x = -34.58046221355054, y = -58.5077467801587)
        val huracan = Lugar(nombre = "Cancha de Huracán", x = -34.63838892841019, y = -58.396166895725194)
        val parqueRoca = Lugar(nombre = "Parque Roca", x = -34.67534978366507,  y = -58.45780985464768)
        val remiseria = Remiseria()
        val remisera = Remisero(nombre = "Camila")

        it("debe filtrar correctamente los viajes copados") {
            // arrange
            val viaje1 = remiseria.realizarViaje(remisera, unsam, huracan)
            remiseria.realizarViaje(remisera, unsam, aulario)
            val viaje2 = remiseria.realizarViaje(remisera, unsam, parqueRoca)
            val viaje3 = remiseria.realizarViaje(remisera, huracan, aulario)

            // act

            // assert
            remiseria.viajesCopados() shouldBe listOf(viaje1, viaje2, viaje3)
        }

    }
})