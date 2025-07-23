package org.example

class Fraccion(
    numerador: Int,
    denominador: Int
) : Comparable<Fraccion> {

    var numerador: Int = numerador
        set(value) {
            field = value
        }

    var denominador: Int = denominador
        set(value) {
            require(value != 0) { "El denominador no puede ser cero" }
            field = value
        }

    init {
        require(denominador != 0) { "El denominador no puede ser cero." }
    }

    private fun mcd(a: Int, b: Int): Int {
        return if (b == 0) kotlin.math.abs(a) else mcd(b, a % b)
    }

    fun simplificar(): Fraccion {
        val signo = if (denominador < 0) -1 else 1
        val mcd = mcd(numerador, denominador)
        return Fraccion(signo * numerador / mcd, signo * denominador / mcd)
    }

    fun mostrar(): String = toString()

    override fun toString(): String {
        return "$numerador/$denominador"
    }

    fun resolver(): Double {
        return numerador.toDouble() / denominador.toDouble()
    }

    fun aDecimal(): Double = resolver()

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
        require(other.numerador != 0) { "No se puede dividir por una fracción con numerador 0." }
        val nuevoNumerador = this.numerador * other.denominador
        val nuevoDenominador = this.denominador * other.numerador
        require(nuevoDenominador != 0) { "El resultado tendría denominador cero." }
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraccion) return false
        val f1 = this.simplificar()
        val f2 = other.simplificar()
        return f1.numerador == f2.numerador && f1.denominador == f2.denominador
    }

    override fun compareTo(other: Fraccion): Int {
        val diferencia = this.resolver() - other.resolver()
        return when {
            diferencia > 0 -> 1
            diferencia < 0 -> -1
            else -> 0
        }
    }

    fun esMayor(otra: Fraccion): Boolean = this > otra

    fun esMenor(otra: Fraccion): Boolean = this < otra

    companion object {

        fun desdeDecimal(decimal: Double, precision: Int = 10000): Fraccion {
            val numerador = (decimal * precision).toInt()
            val denominador = precision
            return Fraccion(numerador, denominador).simplificar()
        }
    }
}