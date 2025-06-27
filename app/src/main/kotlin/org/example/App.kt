package org.example

fun main() {
    var miFraccion: Fraccion? = null // el signo de interrogación indica que la variable puede ser nula, o sea que la variable puede no tener valor, y el "= null" indica que no se le asigna un valor inicial

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
}

