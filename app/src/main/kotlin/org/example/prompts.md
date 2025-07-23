# Prompts de la AI

(punto 1)
(le pasamos el codigo:
Implementar el constructor principal que reciba numerador y denominador como parámetros.
Implementar las propiedades con getters y setters automáticos de Kotlin. 
Qué está mal en el codigo que no esté siguiendo esta consigna? )

(creame un ejemplo para que pueda implementar la funcion fraccion. )

-   no anda, te paso mi codigo de fraccion  y luego el app para que me digas porque da error al     compilar.
    (Fraccion.kt code)
    (App.kt code)

- ```
    operator fun plus(other: Fraccion): Fraccion {
        val f1 = Fraccion(1, 4)
        val f2 = Fraccion(1, 6)

        val suma = f1 + f2
        println("Suma: ${suma.mostrar()}")
    }

    operator fun minus(other: Fraccion): Fraccion {
        val resta = f1 - f2
        println("Resta: ${resta.mostrar()}")
    }

    fun simplificar(): Fraccion {
        val mcd = mcd(numerador, denominador)
        return Fraccion(numerador / mcd, denominador / mcd)
    }
    ```
  porque no me funciona mi codigo?

  -   dame el codigo completo corregido y explicame los cambios que hiciste como para un estudiante nivel básico
  -   4. **Aplicar simplificación:**
  - Usar el método simplificar() en los resultados de multiplicación y división

    no simplificaste no se si esta bien
  -   no simplifica nada arreglalo ahora pq sino me enojo mucho. quiero que simplifique todos los resultados ya mismo     (ahora me rio profe pero era un momento de mucho estres :grin: )
  -   pq pones var en una y no en la otra?
  -   * What went wrong:

    Execution failed for task ':app:compileKotlin'.
    
    > A failure occurred while executing org.jetbrains.kotlin.compilerRunner.GradleCompilerRunnerWithWorkers$GradleKotlinCompilerWorkAction
    
       > Compilation error. See log for more details
    
    
    
    * Try:
    
    > Run with --stacktrace option to get the stack trace.
    
    > Run with --info or --debug option to get more log output.
    
    > Run with --scan to get full insights.
    
    > Get more help at https://help.gradle.org.
      me sale este error, sabes que podria ser?
    
-   creame un ejemplo para que pueda implementar la funcion fraccion
-   tengo que llamar a la funcion class en el app.kt para que se muestre en el terminal?

> [!IMPORTANT]
> (perdón profe, cuando volví a mi casa me di cuenta que no te habia puesto casi ningún prompt. el mario nos dijo q habias faltado por un problema de salud, esperamos que no sea muy grave y que te mejores pronto! Saludos)
