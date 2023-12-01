package com.saitawngpha.koinexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.saitawngpha.koinexample.databinding.NoteItemBinding
import com.saitawngpha.koinexample.db.NoteEntity

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 01/12/2023.
 */
class NoteAdapter : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private lateinit var binding: NoteItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = NoteItemBinding.inflate(inflater, parent, false)
        return ViewHolder()
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }


    inner class ViewHolder(): RecyclerView.ViewHolder(binding.root) {
            fun bind(noteEntity: NoteEntity){
                binding.apply {
                    tvTitle.text = noteEntity.noteTitle
                    tvDesc.text = noteEntity.noteDesc
                }
            }
    }

    private val differCallback = object : DiffUtil.ItemCallback<NoteEntity>() {
        override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
            return oldItem.noteId == newItem.noteId
        }

        override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}