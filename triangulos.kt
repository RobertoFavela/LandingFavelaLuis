fun tipoDeTriangulo(a: Int, b: Int, c: Int): String {

    if (a <= 0 || b <= 0 || c <= 0) {
        return "numero menor a cero"
    }

    if (a + b <= c || a + c <= b || b + c <= a) {
        return "triangulo invalido"
    }

    return when {
        a == b && b == c -> "equilatero"
        a == b || b == c || a == c -> "isosceles"
        else -> "escaleno"
    }
}