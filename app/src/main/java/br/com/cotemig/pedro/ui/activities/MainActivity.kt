package br.com.cotemig.pedro.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cotemig.pedro.R
import br.com.cotemig.pedro.models.Despesas
import br.com.cotemig.pedro.models.Fatura
import br.com.cotemig.pedro.services.RetrofitInitializer
import br.com.cotemig.pedro.ui.adapters.FaturaAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getFatura()

    }

    fun getFatura() {
        var s = RetrofitInitializer().serviceFatura()
        var call = s.getFatura()

        call.enqueue(object : retrofit2.Callback<Fatura> {
            override fun onResponse(call: Call<Fatura>, response: Response<Fatura>) {
                if (response.code() == 200) {
                    response.body()?.let {
                        showFatura(it.despesas)
                        valor.text = String.format("R$ %.2f", it.valor.toString().toDouble())
                        limiteDisponivel.text = String.format(" %.2f", it.limiteDisponivel.toString().toDouble())
                    }
                }
            }

            override fun onFailure(call: Call<Fatura>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Ops", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun showFatura(list: List<Despesas>) {
        recyclerViewFatura.adapter = FaturaAdapter(this, list)
        recyclerViewFatura.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}