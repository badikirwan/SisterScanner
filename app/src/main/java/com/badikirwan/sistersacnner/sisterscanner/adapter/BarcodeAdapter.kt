package com.badikirwan.sistersacnner.sisterscanner.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.badikirwan.sistersacnner.sisterscanner.R
import com.badikirwan.sistersacnner.sisterscanner.model.Data
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row.view.*

class BarcodeAdapter(private val data: List<Data>) : RecyclerView.Adapter<BarcodeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row, parent, false
            )
        )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: BarcodeAdapter.ViewHolder, position: Int) {
        holder.bindItem(data[position])
    }

    class ViewHolder(itemView: View ): RecyclerView.ViewHolder(itemView) {
        fun bindItem(data: Data) {
            itemView.tv_nama.text = data.namaLengkap
            itemView.tv_nim.text = data.mhsNim
            itemView.tv_jurusan.text = data.jurusan
            itemView.tv_angkatan.text = data.tahunAngkatan
            Glide.with(itemView.context).load(data.fileFoto).into(itemView.img_mhs)
        }
    }

}