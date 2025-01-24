fun main(args: Array<String>) {
    println(verificaCadena("nombre")) // true
    println(verificaCadena("_nombre")) // true
    println(verificaCadena("_12")) // true
    println(verificaCadena("")) // false
    println(verificaCadena("012")) // false
    println(verificaCadena("no$")) // false
}
