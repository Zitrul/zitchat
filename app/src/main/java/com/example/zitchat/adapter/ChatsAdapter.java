package com.example.zitchat.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zitchat.R;
import com.example.zitchat.domain.Contact;

import java.util.ArrayList;
import java.util.List;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ViewHolder> {
    private ArrayList<Contact> list2d;
    private LayoutInflater mInflater;
    private Context context;
    private ItemClickListener mClickListener;

    public ChatsAdapter(Context context, ArrayList<Contact> list2d) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.list2d = list2d;
    }


    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.all_chats_items, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



        String text1 = list2d.get(position).getName();

        holder.myimgres.setImageResource(R.drawable.flag_russia);

        holder.myTextViewName.setText(list2d.get(position).getName());
        holder.myTextViewLastMsg.setText(list2d.get(position).getLastmsg());
    }


    @Override
    public int getItemCount() {
        return list2d.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView myimgres;

        ImageView myimgresof1;

        ImageView myimgresof2;
        TextView myTextViewName;
        TextView myTextViewLastMsg;
        TextView myTextView2;

        ViewHolder(View itemView) {
            super(itemView);
            myimgres = itemView.findViewById(R.id.imageres);
            myTextViewName = itemView.findViewById(R.id.tvname1);
            myTextViewLastMsg = itemView.findViewById(R.id.tvmsg1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public Object getItem(int id) {
        return list2d.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}