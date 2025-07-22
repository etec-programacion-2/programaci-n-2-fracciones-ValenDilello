package org.example

import kotlin.math.abs

class Fraccion(
    numerador: Int,
    denominador: Int
) {
    var numerador: Int = numerador
        set(value) { field = value }

    var denominador: Int = denominador
        set(value) {
            require(value != 0) { "El denominador no puede ser cero" }
            field = value
        }

    init {
        require(denominador != 0) { "El denominador no puede ser cero." }
    }

    private fun mcd(a: Int, b: Int): Int {
        return if (b == 0) a else mcd(b, a % b)
    }

    fun simplificar(): Fraccion {
        val mcd = mcd(abs(numerador), abs(denominador))
        var num = numerador / mcd
        var den = denominador / mcd

        // Dejar el signo en el numerador
        if (den < 0) {
            num *= -1
            den *= -1
        }

        return Fraccion(num, den)
    }

    fun mostrar(): String = toString()

    override fun toString(): String {
        return "$numerador/$denominador"
    }

    fun resolver(): Double {
        return numerador.toDouble() / denominador
    }

    operator fun plus(other: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * other.denominador + other.numerador * this.denominador
        val nuevoDenominador = this.denominador * other.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }

    operator fun minus(other: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * other.denominador - other.numerador * this.denominador
        val nuevoDenominador = this.denominador * other.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }

    operator fun times(other: Fraccion): Fraccion {
        val nuevoNumerador = this.numerador * other.numerador
        val nuevoDenominador = this.denominador * other.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }

    operator fun div(other: Fraccion): Fraccion {
        require(other.numerador != 0) { "No se puede dividir por una fracción con numerador cero" }
        val nuevoNumerador = this.numerador * other.denominador
        val nuevoDenominador = this.denominador * other.numerador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }
}