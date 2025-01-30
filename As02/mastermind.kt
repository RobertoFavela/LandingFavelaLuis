/**
 * Asignación 2: Mastermind
 * Luis Roberto Favela Castro
 * 00000246853
 * 
 */
 
data class Evaluacion(val posicionExacta: Int, val posicionIncorrecta: Int)

fun main(args: Array<String>) {
    println(evaluar("ABCD", "ABCD") == Evaluacion(4, 0))
    println(evaluar("ABCD", "CDBA") == Evaluacion(0, 4))
    println(evaluar("ABCD", "ABDC") == Evaluacion(2, 2))
    println(evaluar("AABC", "ADFE") == Evaluacion(1, 0))
    println(evaluar("AABC", "DEAA") == Evaluacion(0, 2))
}	

fun evaluar(original: String, intento: String): Evaluacion {
    var posicionesExactas = 0
    var posicionesIncorrectas = 0

    for (i in original.indices) {
        if (original[i] == intento[i]) {
            posicionesExactas++
        } else if (intento[i] in original) {
            posicionesIncorrectas++
        }
    }

    return Evaluacion(posicionesExactas, posicionesIncorrectas)
}