package org.example

fun main() {
    var miFraccion: Fraccion? = null

    try {
        miFraccion = Fraccion(5, 3)
    } catch (e: IllegalArgumentException) {
        println("Error al crear fracción: ${e.message}")
    }

    if (miFraccion != null) {
        println("Mi fracción es: ${miFraccion.mostrar()}")
        println("Y tiene numerador = ${miFraccion.numerador}")
        println("Y denominador = ${miFraccion.denominador}")
        println("El resultado de la fracción es: ${miFraccion.resolver()}")
    } else {
        println("No se pudo crear la fracción.")
    }

    val f1 = Fraccion(1, 4)
    val f2 = Fraccion(1, 6)

    val suma = f1 + f2
    val resta = f1 - f2
    val multiplicacion = f1 * f2
    val division = f1 / f2

    println("\n--- Operaciones entre fracciones ---")
    println("Fracción 1: ${f1.mostrar()}")
    println("Fracción 2: ${f2.mostrar()}")
    println("Suma: ${suma.mostrar()} = ${suma.resolver()}")
    println("Resta: ${resta.mostrar()} = ${resta.resolver()}")
    println("Multiplicación: ${multiplicacion.mostrar()} = ${multiplicacion.resolver()}")
    println("División: ${division.mostrar()} = ${division.resolver()}")
}
