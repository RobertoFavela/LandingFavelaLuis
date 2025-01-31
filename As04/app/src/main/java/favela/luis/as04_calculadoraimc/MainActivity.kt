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
                    tvResultado.text = "Tu IMC es: %.2f".format(imc)
                } else {
                    Toast.makeText(this, "Ingresa valores válidos para calcular", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Llena ambos campos para calclar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
