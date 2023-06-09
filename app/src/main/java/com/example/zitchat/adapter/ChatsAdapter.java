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

import java.util.ArrayList;
import java.util.List;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ViewHolder> {

    private List<Integer> mViewImg;
    private ArrayList<Order> list2d;
    private List<String> mJobs1;
    private List<String> mJobs2;
    private List<String> mJobs3;
    private LayoutInflater mInflater;
    private Context context;
    private ItemClickListener mClickListener;

    public ChatsAdapter(Context context, ArrayList<Order> list2d) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.list2d = list2d;
    }


    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.rec_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



        String text1 = list2d.get(position).getName();

        holder.myimgres.setImageResource(R.drawable.flag_russia);
        if(list2d.get(position).getMsg().equals("none") == false && list2d.get(position).getMsg().equals("gs://neighbours-f1462.appspot.com/images/image5.jpg") == false ){
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageRef = storage.getReferenceFromUrl("gs://neighbours-f1462.appspot.com");
            StorageReference imageRef = storageRef.child(list2d.get(position).getMsg());

            Task<Uri> uriTask = imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    String downloadUrl = uri.toString();
                           .load(downloadUrl)
                            .into(holder.myimgres);
                    System.out.println("OK");
                    // здесь вы можете использовать полученную ссылку на файл
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    System.out.println("ERRERER");// обработка ошибок получения ссылки на файл
                }
            });

        }
        Glide.with(context)

        holder.myTextView.setText(text1);
    }


    @Override
    public int getItemCount() {
        return list2d.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView myimgres;

        ImageView myimgresof1;

        ImageView myimgresof2;
        TextView myTextView;
        TextView myTextView1;
        TextView myTextView2;

        ViewHolder(View itemView) {
            super(itemView);
            myimgres = itemView.findViewById(R.id.imageres);
            myTextView = itemView.findViewById(R.id.tvname1);
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