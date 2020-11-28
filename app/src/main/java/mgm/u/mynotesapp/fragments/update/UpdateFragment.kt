package mgm.u.mynotesapp.fragments.update

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
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_update.*
import mgm.u.mynotesapp.R
import mgm.u.mynotesapp.databinding.FragmentUpdateBinding
import mgm.u.mynotesapp.model.Note
import mgm.u.mynotesapp.viewmodel.NoteViewModel

class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var myNoteViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_update, container, false)

        myNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        binding.updateTitleNote.setText(args.currentNote.title)
        binding.updateContentNote.setText(args.currentNote.content)

        binding.buttonUpdateNote.setOnClickListener {
            updateNote()
        }

        return binding.root
    }

    private fun updateNote() {
        val title = update_title_note.text.toString()
        val content = update_content_note.text.toString()

        if (inputCheck(title, content)) {
            val updatedNote = Note(args.currentNote.id, title, content)
            myNoteViewModel.updateNote(updatedNote)
            Toast.makeText(requireContext(), "Note was successfully updated!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please, fill out all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(title: String, content: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(content))
    }
}