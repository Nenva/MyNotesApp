package mgm.u.mynotesapp.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.custom_view.*
import kotlinx.android.synthetic.main.fragment_add.*
import mgm.u.mynotesapp.R
import mgm.u.mynotesapp.data.Note
import mgm.u.mynotesapp.data.NoteViewModel
import mgm.u.mynotesapp.databinding.FragmentAddBinding
import mgm.u.mynotesapp.databinding.FragmentListBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var myNoteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false)

        myNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        binding.buttonSaveNote.setOnClickListener {
            insertDataToDatabase()
        }

        return binding.root
    }

    private fun insertDataToDatabase() {
        val titleNote = insert_title_note.text.toString()
        val contentNote = insert_content_note.text.toString()

        if (inputCheck(titleNote, contentNote)) {
            val note = Note(0, titleNote, contentNote)
            myNoteViewModel.addNote(note)
            Toast.makeText(requireContext(), "Note successfully added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please, fill out all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(titleNote: String, contentNote: String): Boolean {
        return !(TextUtils.isEmpty(titleNote) && TextUtils.isEmpty(contentNote))
    }
}