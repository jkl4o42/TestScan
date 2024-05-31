package com.jkl.testscan.scan.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.jkl.testscan.databinding.DashboardItemBinding
import com.jkl.testscan.scan.data.DashboardDetails
import com.jkl.testscan.scan.data.DashboardEntity

@SuppressLint("NotifyDataSetChanged")
class DashboardAdapter :
    RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {

    private val items: ArrayList<DashboardEntity> = arrayListOf()

    fun update(list: List<DashboardEntity>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val binding = DashboardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DashboardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item.details)
    }

    override fun getItemCount(): Int = items.size

    inner class DashboardViewHolder(private val binding: DashboardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DashboardDetails) {
            binding.root.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "${item.title}. You have ${item.alerts} problems",
                    Toast.LENGTH_SHORT
                ).show()
            }
            binding.iconAppCompatImageView.setImageResource(item.icon)
            binding.titleAppCompatTextView.text = item.title
            binding.infoAppCompatTextView.text = item.info
            binding.errorsAppCompatTextView.visibility =
                if (item.alerts == 0) View.GONE else View.VISIBLE
            binding.errorsAppCompatTextView.text = item.alerts.toString()
        }
    }
}
