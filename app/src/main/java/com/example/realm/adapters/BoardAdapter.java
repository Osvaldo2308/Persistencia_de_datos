package com.example.realm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.realm.R;
import com.example.realm.model.Board;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class BoardAdapter extends BaseAdapter {

    private Context context;
    private List<Board> list;
    private int layout;

public BoardAdapter(Context context, List<Board> boards, int layout){
    this.context = context;
    this.list = boards;
    this.layout = layout;
}
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Board getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.title = (TextView) convertView.findViewById(R.id.textViewBoardTitle);
            vh.notes = (TextView) convertView.findViewById(R.id.textViewBoardNotes);
            vh.createdAt = (TextView) convertView.findViewById(R.id.textViewBoardDate);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Board board = list.get(position);
        vh.title.setText(board.getTitle());

        int numOfNotes = board.getNotes().size();
        String textForNotes = (numOfNotes == 1) ? numOfNotes + " Note" : numOfNotes + " Notes";
        vh.notes.setText(textForNotes);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String createdAt = df.format(board.getCreatedAt());
        vh.createdAt.setText(createdAt);
        return convertView;
    }
public class ViewHolder{
    TextView title;
    TextView notes;
    TextView createdAt;
    }
}
