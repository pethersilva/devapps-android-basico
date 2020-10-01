package com.pethersilva.devapps20201_helloworld.adapter

import android.content.Context
import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pethersilva.devapps20201_helloworld.R
import com.pethersilva.devapps20201_helloworld.model.Estado
import kotlinx.android.synthetic.main.item_estado.view.*

class EstadoAdapter(private val context: Context,
					private val estados: List<Estado>,
					private val callback: (Estado) -> Unit) : RecyclerView.Adapter<EstadoAdapter.VH>() {

	private val bandeiras: TypedArray by lazy {
		context.resources.obtainTypedArray(R.array.bandeiras)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
		val v = LayoutInflater.from(parent.context).inflate(R.layout.item_estado
			, parent, false)
		val vh = VH(v)
		vh.itemView.setOnClickListener {
			val estado = estados[vh.adapterPosition]
			callback(estado)
		}
		return vh
	}

	override fun getItemCount() = estados.size

	override fun onBindViewHolder(holder: VH, position: Int) {
		val (name, bandeira) = estados[position]
		holder.imgBandeira.setImageDrawable(bandeiras.getDrawable(bandeira))
		holder.txtName.text = name
	}

	class VH(itemView: View): RecyclerView.ViewHolder(itemView) {
		val imgBandeira : ImageView = itemView.imageViewFlag
		val txtName: TextView = itemView.textViewEstadoNome
	}
}
