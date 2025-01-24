fun verificaCadena(cadena: String): Boolean {

    if (cadena.isEmpty()) {
        return false
    }

    val primerCaracter = cadena[0]
    if (!primerCaracter.isLetter() && primerCaracter != '_') {
        return false
    }

    for (caracter in cadena) {
        if (!caracter.isLetterOrDigit() && caracter != '_') {
            return false
        }
    }

    return true
}

fun main(args: Array<String>) {
    println(verificaCadena("nombre")) // true
    println(verificaCadena("_nombre")) // true
    println(verificaCadena("_12")) // true
    println(verificaCadena("")) // false
    println(verificaCadena("012")) // false
    println(verificaCadena("no$")) // false
}
