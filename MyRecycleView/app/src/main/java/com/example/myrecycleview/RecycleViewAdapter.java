package com.example.myrecycleview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.LinkedList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    final static String TAG = "RecycleViewAdapter";

    LinkedList<String> images = new LinkedList<String>();
    LinkedList<String> text = new LinkedList<String>();
    Context context;

    public RecycleViewAdapter(LinkedList<String> images, LinkedList<String> text, Context context) {
        this.images = images;
        this.text = text;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclelist, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "Caslled" + this.images.get(position));
        Glide.with(context).asBitmap().load(this.images.get(position)).into(holder.imageView);
        holder.textView.setText(this.text.get(position));
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, text.get(position), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return this.text.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageView;
        TextView textView;
        RelativeLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.listitem_image);
            textView = itemView.findViewById(R.id.lititem_text);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
