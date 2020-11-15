package com.example.mvvmtesttask.ui.noteList;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmtesttask.R;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<Note> noteList;
    private OnNoteClicked onNoteClickedListener;

    public NoteAdapter(OnNoteClicked onNoteClickedListener) {
        this.onNoteClickedListener = onNoteClickedListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item_view, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = noteList.get(position);
        holder.bind(note);
    }

    @Override
    public int getItemCount() {
        return noteList!= null? noteList.size() : 0 ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private  TextView noteDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.note_title);
            noteDesc = itemView.findViewById(R.id.note_description);

            }

        public void bind(final Note note){
            title.setText(note.getNoteTitle());
            noteDesc.setText(note.getNoteDescription());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.v("note in adapter is",note.getNoteTitle());
                    onNoteClickedListener.noteClicked(note);
                }
            });
        }
    }

    public void setNotes(List<Note> notes){
        noteList = notes;
        notifyDataSetChanged();
    }

    public interface OnNoteClicked{
        public void noteClicked(Note note);
    }
}
