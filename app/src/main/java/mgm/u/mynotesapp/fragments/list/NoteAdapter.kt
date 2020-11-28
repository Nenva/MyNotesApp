package mgm.u.mynotesapp.fragments.list


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_view.view.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import mgm.u.mynotesapp.R
import mgm.u.mynotesapp.data.Note

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {

    private var noteList = emptyList<Note>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_view, parent, false))
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = noteList[position]
        holder.itemView.id_note.text = currentItem.id.toString()
        holder.itemView.title_note.text = currentItem.title
        holder.itemView.content_note.text = currentItem.content
    }

    fun setData(note: List<Note>) {
        this.noteList = note
        notifyDataSetChanged()
    }


}