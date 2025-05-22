package favela.luis.calculadoraaritmetica

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var primerNumero: Double? = null
    private var tipoOperacion: String? = null

    private lateinit var pantalla: TextView

    private lateinit var boton1: Button
    private lateinit var boton2: Button
    private lateinit var boton3: Button
    private lateinit var boton4: Button
    private lateinit var boton5: Button
    private lateinit var boton6: Button
    private lateinit var boton7: Button
    private lateinit var boton8: Button
    private lateinit var boton9: Button
    private lateinit var boton0: Button

    private lateinit var sumar: Button
    private lateinit var restar: Button
    private lateinit var multiplicar: Button
    private lateinit var dividir: Button
    private lateinit var calcular: Button
    private lateinit var limpiar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inicializarComponentes()
        configurarNumericos()
        configurarOperaciones()
    }

    private fun inicializarComponentes() {
        pantalla = findViewById(R.id.txtResultado)

        boton1 = findViewById(R.id.btnUno)
        boton2 = findViewById(R.id.btnDos)
        boton3 = findViewById(R.id.btnTres)
        boton4 = findViewById(R.id.btnCuatro)
        boton5 = findViewById(R.id.btnCinco)
        boton6 = findViewById(R.id.btnSeis)
        boton7 = findViewById(R.id.btnSiete)
        boton8 = findViewById(R.id.btnOcho)
        boton9 = findViewById(R.id.btnNueve)
        boton0 = findViewById(R.id.btnCero)

        sumar = findViewById(R.id.btnSuma)
        restar = findViewById(R.id.btnResta)
        multiplicar = findViewById(R.id.btnMulti)
        dividir = findViewById(R.id.btnDivision)
        calcular = findViewById(R.id.btnIgual)
        limpiar = findViewById(R.id.btnLimpiar)
    }

    private fun configurarNumericos() {
        val botones = listOf(
            boton0 to "0", boton1 to "1", boton2 to "2",
            boton3 to "3", boton4 to "4", boton5 to "5",
            boton6 to "6", boton7 to "7", boton8 to "8",
            boton9 to "9"
        )

        for ((boton, valor) in botones) {
            boton.setOnClickListener {
                pantalla.append(valor)
            }
        }
    }

    private fun configurarOperaciones() {
        sumar.setOnClickListener { prepararOperacion("+") }
        restar.setOnClickListener { prepararOperacion("-") }
        multiplicar.setOnClickListener { prepararOperacion("*") }
        dividir.setOnClickListener { prepararOperacion("/") }

        calcular.setOnClickListener {
            val segundoValor = pantalla.text.toString().toDoubleOrNull()
            if (segundoValor != null && primerNumero != null && tipoOperacion != null) {
                val resultado = ejecutarOperacion(primerNumero!!, segundoValor, tipoOperacion!!)
                pantalla.text = resultado.toString()
                reiniciar()
            } else {
                pantalla.text = "Error"
            }
        }

        limpiar.setOnClickListener {
            pantalla.text = ""
            reiniciar()
        }
    }

    private fun prepararOperacion(op: String) {
        primerNumero = pantalla.text.toString().toDoubleOrNull()
        if (primerNumero != null) {
            tipoOperacion = op
            pantalla.text = ""
        }
    }

    private fun ejecutarOperacion(a: Double, b: Double, operacion: String): Double {
        return when (operacion) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> if (b != 0.0) a / b else Double.NaN
            else -> Double.NaN
        }
    }

    private fun reiniciar() {
        primerNumero = null
        tipoOperacion = null
    }
}
