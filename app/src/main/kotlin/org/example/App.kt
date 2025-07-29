package org.example

import java.util.Scanner
import kotlin.math.abs

class Fraccion(var numerador: Int, var denominador: Int) : Comparable<Fraccion> {

    init {
        require(denominador != 0) { "El denominador no puede ser cero." }
        normalizarSigno()
        simplificar()
    }

    private fun mcd(a: Int, b: Int): Int {
        return if (b == 0) abs(a) else mcd(b, a % b)
    }

    private fun simplificar() {
        val divisor = mcd(numerador, denominador)
        numerador /= divisor
        denominador /= divisor
    }

    private fun normalizarSigno() {
        if (denominador < 0) {
            numerador *= -1
            denominador *= -1
        }
    }

    operator fun plus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.denominador + otra.numerador * this.denominador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun minus(otra: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * otra.denominador - otra.numerador * this.denominador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador)
    }

    operator fun times(otra: Fraccion): Fraccion {
        return Fraccion(this.numerador * otra.numerador, this.denominador * otra.denominador)
    }

    operator fun div(otra: Fraccion): Fraccion {
        require(otra.numerador != 0) { "No se puede dividir por una fracción con numerador 0." }
        return Fraccion(this.numerador * otra.denominador, this.denominador * otra.numerador)
    }

    override fun toString(): String = "$numerador/$denominador"

    fun aDecimal(): Double = numerador.toDouble() / denominador

    override fun compareTo(other: Fraccion): Int {
        return (this.numerador * other.denominador).compareTo(other.numerador * this.denominador)
    }

    override fun equals(other: Any?): Boolean {
        return other is Fraccion && this.compareTo(other) == 0
    }

    fun esMayor(otra: Fraccion): Boolean = this > otra

    fun esMenor(otra: Fraccion): Boolean = this < otra

    companion object {
        fun desdeDecimal(decimal: Double, precision: Int = 100000): Fraccion {
            val numerador = (decimal * precision).toInt()
            val denominador = precision
            return Fraccion(numerador, denominador)
        }
    }
}

// ==============================
// Función MAIN con menú completo
// ==============================

fun main() {
    val scanner = Scanner(System.`in`)
    while (true) {
        println("\n=== CALCULADORA DE FRACCIONES ===")
        println("1. Sumar fracciones")
        println("2. Restar fracciones")
        println("3. Multiplicar fracciones")
        println("4. Dividir fracciones")
        println("5. Comparar fracciones")
        println("6. Convertir fracción a decimal")
        println("7. Crear fracción desde decimal")
        println("8. Ejemplos predefinidos")
        println("0. Salir")
        print("Ingrese su opción: ")

        val opcion = try {
            scanner.nextLine().toInt()
        } catch (e: Exception) {
            println("⚠️ Entrada inválida.")
            continue
        }

        if (opcion == 0) break

        fun leerFraccion(orden: String): Fraccion {
            print("Ingrese numerador de la $orden fracción: ")
            val num = scanner.nextLine().toInt()
            print("Ingrese denominador de la $orden fracción: ")
            val den = scanner.nextLine().toInt()
            return Fraccion(num, den)
        }

        when (opcion) {
            1 -> {
                val f1 = leerFraccion("primera")
                val f2 = leerFraccion("segunda")
                println("Resultado: ${f1 + f2}")
            }
            2 -> {
                val f1 = leerFraccion("primera")
                val f2 = leerFraccion("segunda")
                println("Resultado: ${f1 - f2}")
            }
            3 -> {
                val f1 = leerFraccion("primera")
                val f2 = leerFraccion("segunda")
                println("Resultado: ${f1 * f2}")
            }
            4 -> {
                val f1 = leerFraccion("primera")
                val f2 = leerFraccion("segunda")
                println("Resultado: ${f1 / f2}")
            }
            5 -> {
                val f1 = leerFraccion("primera")
                val f2 = leerFraccion("segunda")
                when {
                    f1 > f2 -> println("$f1 es mayor que $f2")
                    f1 < f2 -> println("$f1 es menor que $f2")
                    else -> println("$f1 es igual a $f2")
                }
            }
            6 -> {
                val f = leerFraccion("única")
                println("Decimal: ${f.aDecimal()}")
            }
            7 -> {
                print("Ingrese número decimal: ")
                val decimal = scanner.nextLine().toDouble()
                val fraccion = Fraccion.desdeDecimal(decimal)
                println("Fracción equivalente: $fraccion")
            }
            8 -> {
                val f1 = Fraccion(1, 2)
                val f2 = Fraccion(1, 3)
                println("$f1 + $f2 = ${f1 + f2}")
                println("$f1 - $f2 = ${f1 - f2}")
                println("$f1 * $f2 = ${f1 * f2}")
                println("$f1 / $f2 = ${f1 / f2}")
            }
            else -> println("❌ Opción inválida.")
        }
    }
    println("Gracias por usar la calculadora.")
}
