
[![build](https://github.com/uqbar-project/remiseria-kotlin-refactor/actions/workflows/build.yml/badge.svg?branch=master)](https://github.com/uqbar-project/remiseria-kotlin-refactor/actions/workflows/build.yml) [![codecov](https://codecov.io/gh/uqbar-project/remiseria-kotlin-refactor/graph/badge.svg?token=g3idDVbxaX)](https://codecov.io/gh/uqbar-project/remiseria-kotlin-refactor)

## Ejercicio Refactor: Remisería

Modelar una remisería que realiza viajes con diferentes remiseros. Cada viaje registra

- origen
- destino
- la persona que realizó el viaje
- la fecha en la que ocurrió dicho viaje
- el costo del viaje

> **Costo del viaje**: es la sumatoria de: 1. el costo base de la remisería (1.500) + 2. la comisión qeu cobra cada remisero (cada remisero cobra 2 veces la cantidad de letras de su nombre menos Pepe que cobra 20% fijo) y 3. el costo en base a la distancia que son 300 pesos por milla (sí, se calcula en millas).

Por otra parte, nos interesa conocer los viajes copados, que son aquellos en donde se recorrió más de 5 millas.

## Qué se pide

Tenemos una solución actual donde tenemos

- [estas definiciones](./src/main/kotlin/ar/edu/algo2/remiseria/Remiseria.kt)
- [y estos tests](./src/test/kotlin/ar/edu/algo2/remiseria/Remiseria.kt)

Se pide que encuentre code smells y piense refactors para mejorar el código.

