package favela.luis.as04_calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etEstatura = findViewById<EditText>(R.id.etEstatura)
        val etPeso = findViewById<EditText>(R.id.etPeso)
        val btnCalcular = findViewById<Button>(R.id.button2)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        btnCalcular.setOnClickListener {
            val estaturaStr = etEstatura.text.toString()
            val pesoStr = etPeso.text.toString()

            if (estaturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val estatura = estaturaStr.toDoubleOrNull()
                val peso = pesoStr.toDoubleOrNull()

                if (estatura != null && peso != null && estatura > 0) {
                    val imc = peso / (estatura * estatura)
                    val categoria = when {
                        imc < 18.5 -> "Bajo peso"
                        imc in 18.5..24.9 -> "Normal"
                        imc in 25.0..29.9 -> "Sobrepeso"
                        imc in 30.0..34.9 -> "Obesidad grado 1"
                        imc in 35.0..39.9 -> "Obesidad grado 2"
                        else -> "Obesidad grado 3"
                    }
                    tvResultado.text = "Tu IMC es: %.2f\nCategoría: %s".format(imc, categoria)
                } else {
                    Toast.makeText(this, "Ingresa valores válidos para calcular", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Llena ambos campos para calcular", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
