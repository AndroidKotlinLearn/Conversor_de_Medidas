package tk.williamsouza.conversordemedidas

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.lang.Double

class ConversorComprimento : AppCompatActivity() {

    var unidades = arrayOf("Milimetro (mm)", "Centimentro (cm)", "Metro (m)", "Quilometro (km)")
    var selecao = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_comprimento)

        //carregar os componentes
        val spinner = findViewById<Spinner>(R.id.select)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val txtValor = findViewById<EditText>(R.id.txtValor)
        val btnCalcular = findViewById<Button>(R.id.btnConverter)

        // cria array adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, unidades)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selecao = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        btnCalcular.setOnClickListener {
            val valor = txtValor.text.toString()
            if (valor != "") {
                if (selecao == 0){
                    var valor = Double.parseDouble(valor)
                    var texto = "centimetro= ${valor/10f} metro=${valor/1000f} km=${valor/1000000f}"

                    txtResultado.text = texto
                }
            } else {
                txtResultado.text = "Adicione um valor para ser Convertido."
            }
        }

        // ativar o "up navigation" na actionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}