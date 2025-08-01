package org.example

import java.util.InputMismatchException
import java.util.NoSuchElementException
import java.util.Scanner

fun mostrarMenu() {
    println("==== CALCULADORA DE FRACCIONES ====")
    println("1. Sumar fracciones")
    println("2. Restar fracciones")
    println("3. Multiplicar fracciones")
    println("4. Dividir fracciones")
    println("5. Comparar fracciones")
    println("6. Convertir fracción a decimal")
    println("7. Convertir decimal a fracción")
    println("8. Simplificar fracción")
    println("9. Ejemplos predefinidos")
    println("0. Salir")
    println("===================================")
    print("Ingresá tu opción: ")
}

fun leerFraccion(scanner: Scanner, numero: Int): Fraccion? {
    try {
        print("Ingresá el numerador de la fracción $numero: ")
        val numerador = scanner.nextInt()
        print("Ingresá el denominador de la fracción $numero: ")
        val denominador = scanner.nextInt()
        return Fraccion(numerador, denominador)
    } catch (e: InputMismatchException) {
        println("Error: Ingresá solo números enteros.")
        scanner.nextLine() 
        return null
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
        scanner.nextLine() 
        return null
    }
}

fun realizarSuma(scanner: Scanner) {
    println("\n--- Sumar fracciones ---")
    val f1 = leerFraccion(scanner, 1)
    if (f1 == null) return
    scanner.nextLine() 
    val f2 = leerFraccion(scanner, 2)
    if (f2 == null) return

    val resultado = f1 + f2
    println("Resultado: $f1 + $f2 = ${resultado.mostrar()} = ${resultado.aDecimal()}")
}

fun realizarResta(scanner: Scanner) {
    println("\n--- Restar fracciones ---")
    val f1 = leerFraccion(scanner, 1)
    if (f1 == null) return
    scanner.nextLine() 
    val f2 = leerFraccion(scanner, 2)
    if (f2 == null) return

    val resultado = f1 - f2
    println("Resultado: $f1 - $f2 = ${resultado.mostrar()} = ${resultado.aDecimal()}")
}

fun realizarMultiplicacion(scanner: Scanner) {
    println("\n--- Multiplicar fracciones ---")
    val f1 = leerFraccion(scanner, 1)
    if (f1 == null) return
    scanner.nextLine() 
    val f2 = leerFraccion(scanner, 2)
    if (f2 == null) return

    val resultado = f1 * f2
    println("Resultado: $f1 * $f2 = ${resultado.mostrar()} = ${resultado.aDecimal()}")
}

fun realizarDivision(scanner: Scanner) {
    println("\n--- Dividir fracciones ---")
    val f1 = leerFraccion(scanner, 1)
    if (f1 == null) return
    scanner.nextLine() 
    val f2 = leerFraccion(scanner, 2)
    if (f2 == null) return

    try {
        val resultado = f1 / f2
        println("Resultado: $f1 / $f2 = ${resultado.mostrar()} = ${resultado.aDecimal()}")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}

fun compararFracciones(scanner: Scanner) {
    println("\n--- Comparar fracciones ---")
    val f1 = leerFraccion(scanner, 1)
    if (f1 == null) return
    scanner.nextLine() 
    val f2 = leerFraccion(scanner, 2)
    if (f2 == null) return

    when {
        f1 == f2 -> println("$f1 es igual a $f2")
        f1 > f2 -> println("$f1 es mayor que $f2")
        else -> println("$f1 es menor que $f2")
    }
}

fun convertirADecimal(scanner: Scanner) {
    println("\n--- Fracción a decimal ---")
    val f = leerFraccion(scanner, 1)
    if (f == null) return
    println("Decimal: ${f.aDecimal()}")
}

fun convertirDesdeDecimal(scanner: Scanner) {
    println("\n--- Decimal a fracción ---")
    try {
        print("Ingresá un número decimal: ")
        val decimal = scanner.nextDouble()
        val fraccion = Fraccion.desdeDecimal(decimal)
        println("Fracción equivalente: ${fraccion.mostrar()}")
    } catch (e: InputMismatchException) {
        println("Error: Ingresá un número decimal válido.")
        scanner.nextLine()
    }
}

fun simplificarFraccion(scanner: Scanner) {
    println("\n--- Simplificar fracción ---")
    val f = leerFraccion(scanner, 1)
    if (f == null) return
    val simplificada = f.simplificar()
    println("Fracción original: ${f.mostrar()}")
    println("Fracción simplificada: ${simplificada.mostrar()}")
}

fun mostrarEjemplos() {
    println("\n=== EJEMPLOS PREDEFINIDOS ===")

    val f1 = Fraccion(1, 2)
    val f2 = Fraccion(1, 3)

    println("Fracción 1: $f1")
    println("Fracción 2: $f2")
    println("Suma: $f1 + $f2 = ${f1 + f2}")
    println("Resta: $f1 - $f2 = ${f1 - f2}")
    println("Multiplicación: $f1 * $f2 = ${f1 * f2}")
    println("División: $f1 / $f2 = ${f1 / f2}")
    println("¿$f1 > $f2? ${f1 > f2}")
    println("$f1 en decimal: ${f1.aDecimal()}")
}
