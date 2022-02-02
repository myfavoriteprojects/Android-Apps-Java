package com.mcm.brainstorm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    RealmResults<Idea> ideasList;

    public MyAdapter(Context context, RealmResults<Idea> ideasList) {
        this.context = context;
        this.ideasList = ideasList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Idea idea = ideasList.get(position);
        holder.titleOutput.setText(idea.getTitle());
        holder.detailsInput.setText(idea.getDetails());

        String timeFormat = DateFormat.getDateTimeInstance().format(idea.getCreatedTime());
        holder.timeOutput.setText(timeFormat);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                PopupMenu menu = new PopupMenu(context,v);
                menu.getMenu().add("DELETE");
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getTitle().equals("DELETE")){
                            //delete idea
                            Realm realm = Realm.getDefaultInstance();
                            realm.beginTransaction();
                            idea.deleteFromRealm();
                            realm.commitTransaction();
                            Toast.makeText(context,"Idea deleted",Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
                menu.show();

                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return ideasList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titleOutput;
        TextView detailsInput;
        TextView timeOutput;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleOutput = itemView.findViewById(R.id.titleoutput);
            detailsInput = itemView.findViewById(R.id.detailsoutput);
            timeOutput = itemView.findViewById(R.id.timeoutput);
        }
    }
}
