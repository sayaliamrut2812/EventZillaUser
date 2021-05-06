package com.example.eventzillauser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class productadapter extends RecyclerView.Adapter<productadapter.productviewholder> {

    private Context mCtx;
    private List<product> productList;

    public productadapter(Context mCtx, List<product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public productviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.list_layout,null);
        productviewholder holder=new productviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull productviewholder holder, int position) {

        product product=productList.get(position);
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewtime.setText(product.getTime());
        holder.textViewdate.setText(product.getDate());
        holder.textViewvenue.setText(product.getVenue());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class productviewholder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewTitle,textViewtime,textViewdate,textViewvenue;



        public productviewholder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);

            textViewTitle=itemView.findViewById(R.id.textViewTitle);

            textViewtime=itemView.findViewById(R.id.textViewtime);
            textViewdate=itemView.findViewById(R.id.textViewdate);
            textViewvenue=itemView.findViewById(R.id.textViewvenue);
        }
    }

}
