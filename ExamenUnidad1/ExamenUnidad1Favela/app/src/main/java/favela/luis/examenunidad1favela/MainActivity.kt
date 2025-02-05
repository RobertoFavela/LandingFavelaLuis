package favela.luis.examenunidad1favela

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var tempC: Float = 0.0F
    var tempF: Float = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var farenheit: TextView = findViewById(R.id.inputGradosFa)
        var celsius: TextView = findViewById(R.id.inputGradosCe)
        var convertir: Button = findViewById(R.id.Convertir)
        var colorsito: TextView = findViewById(R.id.colorsito)

        convertir.setOnClickListener() {


            if (farenheit != null) {
                tempC = FtoC(farenheit.text.toString().toFloat())
                celsius.setText(tempC.toString())
            }
            if (celsius.text != null) {
                tempF = CtoF(celsius.text.toString().toFloat())
                farenheit.setText(tempF.toString())
            }

            if (tempC < 20) {
                colorsito.setBackgroundColor(0)
            } else if (tempC > 19.9 && tempC < 25) {
                colorsito.setBackgroundColor(0)
            } else if (tempC > 24.9) {
                colorsito.setBackgroundColor(0)
            }
        }
    }

    fun FtoC(farenheit: Float): Float {
        return ((farenheit - 32)* 5 / 9)
    }

    fun CtoF(celsius: Float): Float {
        return ((celsius * 9/5)+32)
    }
}
