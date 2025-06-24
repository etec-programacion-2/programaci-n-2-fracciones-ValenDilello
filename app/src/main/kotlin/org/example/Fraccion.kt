package org.example

class Fraccion(
    numerador: Int,
    denominador: Int
) {
    var numerador: Int = numerador
        set(value) { field = value }
    
    var denominador: Int = denominador
        set(value) {
            if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
            field = value
        }

    init {
        require(denominador != 0) { "El denominador no puede ser cero." }
    }

    fun simplificar(): Fraccion {
        val mcd = mcd(numerador, denominador)
        return Fraccion(numerador / mcd, denominador / mcd)
    }

    fun mostrar(): String = toString()

    private fun mcd(a: Int, b: Int): Int {
        return if (b == 0) a else mcd(b, a % b)
    }

    override fun toString(): String {
        return "$numerador/$denominador"
    }
}