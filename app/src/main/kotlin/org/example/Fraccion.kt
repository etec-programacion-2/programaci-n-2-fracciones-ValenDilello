package org.example

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
        val signo = if (denominador < 0) -1 else 1
        val mcd = mcd(numerador, denominador)
        return Fraccion(signo * numerador / mcd, signo * denominador / mcd)
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
}
