package com.example.notelocationtake;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Note> noteList;

    Adapter(Context context, List<Note> notes){
        this.inflater = LayoutInflater.from(context);
        this.noteList = notes;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.menu_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        String title = noteList.get(position).getTitle();
        String date = noteList.get(position).getDate();
        String time = noteList.get(position).getTime();
        String address = noteList.get(position).getAddress();

        holder.itemTitle.setText(title);
        holder.itemDate.setText(date);
        holder.itemTime.setText(time);
        holder.itemAddress.setText(address);

    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemTitle,itemDate,itemTime,itemAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.textViewTitleItem);
            itemDate = itemView.findViewById(R.id.textViewDateItem);
            itemTime = itemView.findViewById(R.id.textViewTimeItem);
            itemAddress = itemView.findViewById(R.id.textViewLocationItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Toast.makeText(view.getContext(),"Menu Item Clicked",Toast.LENGTH_SHORT).show();//Test menu item click

                    Intent intent = new Intent(view.getContext(), DetailActivity.class);
                    intent.putExtra("ID",noteList.get(getAdapterPosition()).getID());
                    view.getContext().startActivity(intent);

                }
            });

        }
    }
}
