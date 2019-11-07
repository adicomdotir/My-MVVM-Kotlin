package ir.adicom.app.mymvvmkotlin.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ir.adicom.app.mymvvmkotlin.datasource.NameModel
import ir.adicom.app.mymvvmkotlin.databinding.RowItemBinding

class NameAdapter(private var names: ArrayList<NameModel>) : RecyclerView.Adapter<NameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowItemBinding = RowItemBinding.inflate(layoutInflater)
        return ViewHolder(rowItemBinding)
    }

    override fun getItemCount(): Int = names.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(names[position])

    fun reloadData(list: ArrayList<NameModel>) {
        names = list
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(nameModel: NameModel) {
            binding.model = nameModel
            binding.executePendingBindings()
        }
    }
}