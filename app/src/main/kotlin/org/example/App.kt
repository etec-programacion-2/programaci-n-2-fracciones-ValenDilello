package org.example

import java.util.InputMismatchException
import java.util.NoSuchElementException
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var opcion: Int

    do {
        mostrarMenu()

        try {
            opcion = scanner.nextInt()
            scanner.nextLine()

            when (opcion) {
                1 -> realizarSuma(scanner)
                2 -> realizarResta(scanner)
                3 -> realizarMultiplicacion(scanner)
                4 -> realizarDivision(scanner)
                5 -> compararFracciones(scanner)
                6 -> convertirADecimal(scanner)
                7 -> convertirDesdeDecimal(scanner)
                8 -> simplificarFraccion(scanner)
                9 -> mostrarEjemplos()
                0 -> println("¡Hasta luego! Saliendo del programa...")
                else -> println("Opción inválida. Por favor, intentá de nuevo.")
            }
        } catch (e: InputMismatchException) {
            println("Error: Ingresaste un valor no numérico. Por favor, intentá de nuevo.")
            scanner.nextLine()
            opcion = -1
        } catch (e: NoSuchElementException) {
            println("Error: La entrada fue cerrada inesperadamente. Saliendo del programa.")
            opcion = 0
        }

        if (opcion != 0) {
            println("\nPresioná Enter para continuar...")
            scanner.nextLine()
        }

    } while (opcion != 0)

    scanner.close()
}