package tk.williamsouza.conversordemedidas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // carregar comp
        val btnComprimento = findViewById<ImageButton>(R.id.btnComprimento)
        val btnTemperatura = findViewById<ImageButton>(R.id.btnTemperatura)
        val btnDados = findViewById<ImageButton>(R.id.btnDados)
        val btnPeso = findViewById<ImageButton>(R.id.btnPeso)

        btnComprimento.setOnClickListener{
            val intent = Intent(this, ConversorComprimento::class.java)
            startActivity(intent)
        }

        btnTemperatura.setOnClickListener{
            val intent = Intent(this, ConversorTemperatura::class.java)
            startActivity(intent)
        }

        btnDados.setOnClickListener{
            val intent = Intent(this, ConversorDados::class.java)
            startActivity(intent)
        }

        btnPeso.setOnClickListener {
            val intent = Intent(this, ConversorPeso::class.java)
            startActivity(intent)
        }
    }
}