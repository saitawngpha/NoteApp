package com.saitawngpha.koinexample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.saitawngpha.koinexample.R
import com.saitawngpha.koinexample.databinding.FragmentAddNoteBinding
import com.saitawngpha.koinexample.db.NoteEntity
import com.saitawngpha.koinexample.viewmodel.DatabaseViewModel
import org.koin.android.ext.android.inject


class AddNoteFragment : BottomSheetDialogFragment() {

    private var _binding : FragmentAddNoteBinding? = null
    private val binding get() = _binding

    private val noteEntity by lazy { NoteEntity() }
    private val viewModel : DatabaseViewModel by inject()

    private var noteTitle = ""
    private var noteDesc = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNoteBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (dialog as? BottomSheetDialog)?.behavior?.state = STATE_EXPANDED
        binding!!.apply {
            imgClose.setOnClickListener {
                dismiss()
            }
            btnSave.setOnClickListener {
                noteTitle = edtTitle.text.toString()
                noteDesc = edtDesc.text.toString()

                if(noteTitle.isEmpty() || noteDesc.isEmpty()){
                    Snackbar.make(it, "Title and description can't be empty.", Snackbar.LENGTH_SHORT).show()
                }else{
                    noteEntity.noteId = 0
                    noteEntity.noteTitle = noteTitle
                    noteEntity.noteDesc = noteDesc
                    viewModel.saveNote(noteEntity)

                    edtTitle.setText("")
                    edtDesc.setText("")

                    dismiss()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}