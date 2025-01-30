/**
 Asignación 03: Cadena Fina
 Luis Roberto Favela Castro
 00000246853
*/

fun String.esFina(): Boolean {
    var condicionesCumplidas = 0
    
    if (!contains("bu") && !contains("ba") && !contains("be")) {
        condicionesCumplidas++
    }
    
    var contadorVocales = 0
    for (c in this) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            contadorVocales++
        }
    }
    if (contadorVocales >= 3) {
        condicionesCumplidas++
    }
    
    // en esta parte de plano le pedi a chatGPT que me corrijiera porque no funcionaba lo de las vocales seguidas
    // pero si estaba muy cerquita, solo me fallaba la condicional del for
    var tieneLetraDoble = false
    for (i in 0 until length - 1) {
        if (this[i] == this[i + 1]) {
            tieneLetraDoble = true
            break
        }
    }
    if (tieneLetraDoble) {
        condicionesCumplidas++
    }
    
    return condicionesCumplidas >= 2
}

fun main() {
    println("bac".esFina())
    println("aza".esFina())
    println("abaca".esFina())
    println("baaa".esFina())
    println("aaab".esFina())
} 