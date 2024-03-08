package mx.edu.tecmm.moviles.ejercicio6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var txtTexto: TextView
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lugares = arrayOf(
            "Tequila", "Magdalena", "Talpa", "MonteSeco", "Guadalajara", "Hostotipaquillo", "Tala",
            "Amatitan", "Zacatecas", "Atenguillo", "Amatitan", "Tepic"
        )

        txtTexto = findViewById(R.id.txtTexto)
        listView = findViewById(R.id.vista_Lugares)

        val adaptador = ArrayAdapter(this, R.layout.list_items, lugares)
        listView.adapter = adaptador

        listView.onItemClickListener =
            object : AdapterView.OnItemClickListener {
                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val valor = listView.getItemAtPosition(position) as String
                    Log.e("list ApP", "valor $valor")
                    Toast.makeText(applicationContext, "valor $valor", Toast.LENGTH_LONG).show()

                    // Mostrar el valor seleccionado en txtTexto
                    txtTexto.text = "se seleciono: $valor"
                }
            }
    }
}


