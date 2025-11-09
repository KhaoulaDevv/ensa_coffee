package com.rkbm.ensa_coffee;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class AdapterCoffees extends RecyclerView.Adapter<AdapterCoffees.Holder> {
    List<Coffee> coffees;
    Context context;

    public AdapterCoffees(List<Coffee> coffees, Context context) {
        this.coffees = coffees;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterCoffees.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.model_coffee,parent,false);


        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCoffees.Holder holder, int position) {
        Coffee p= coffees.get(position);
        holder.tId.setText(String.valueOf(p.getId()));
        holder.tName.setText(p.getName());
        Glide.with(context).load(p.getImageURL())
                .apply(new RequestOptions()
                        .centerCrop() // Crop to center and fill the `ImageView` bounds
                        .override(320, 180)  // Resize the image to the desired dimensions (240dp x 135dp)
                )
                .placeholder(R.drawable.chargement)
                .error(R.drawable.error)
                .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Instructions.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("MEAL",p);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return coffees.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tId,tName;
        public Holder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageView);
            tId=itemView.findViewById(R.id.modelId);
            tName=itemView.findViewById(R.id.modelName);

        }
    }
}