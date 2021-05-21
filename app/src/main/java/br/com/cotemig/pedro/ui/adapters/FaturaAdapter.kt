package br.com.cotemig.pedro.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.pedro.R
import br.com.cotemig.pedro.models.Despesas
import br.com.cotemig.pedro.models.Fatura
import coil.load

class FaturaAdapter(var context: Context, var list: List<Despesas>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_fatura, parent, false)
        return FaturaHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FaturaHolder).bind(context, list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class FaturaHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(context: Context, despesas: Despesas) {

            var imagem = view.findViewById<ImageView>(R.id.imagem)
            imagem.load(despesas.imagem)

            var descricao = view.findViewById<TextView>(R.id.descricao)
            descricao.text = despesas.descricao

            var tipo = view.findViewById<TextView>(R.id.tipo)
            tipo.text = despesas.tipo

            var valorItem = view.findViewById<TextView>(R.id.valoritem)
            valorItem.text = String.format("R$ %.2f", despesas.valor.toString().toDouble())

            var data = view.findViewById<TextView>(R.id.data)
            data.text = despesas.data

        }

    }

}