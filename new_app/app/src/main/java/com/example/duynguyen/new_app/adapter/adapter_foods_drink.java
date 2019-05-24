package com.example.duynguyen.new_app.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duynguyen.new_app.R;
import com.example.duynguyen.new_app.ScrollingActivity;
import com.example.duynguyen.new_app.doi_tuong.doi_tuong_foods_drink;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class adapter_foods_drink extends RecyclerView.Adapter<adapter_foods_drink.ViewHolder> {

    private ArrayList<doi_tuong_foods_drink> mContacts;
    private Context mContext;
    private doi_tuong_foods_drink doituong;
    Intent intent;

    public adapter_foods_drink(ArrayList<doi_tuong_foods_drink> mContacts, Context mContext) {
        this.mContacts = mContacts;
        this.mContext = mContext;
        System.out.println(mContacts.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(adapter_foods_drink.ViewHolder holder, final int i) {
        doituong = mContacts.get(i);
        System.out.println("kkkk"+doituong.getId()+"  "+i);
        holder.text1.setText(doituong.getName());
        holder.text2.setText(String.valueOf(doituong.getPrice()));
        Picasso.get().load(doituong.getImage()).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(mContext,ScrollingActivity.class);
                intent.putExtra("id",mContacts.get(i).getId());
                intent.putExtra("name",mContacts.get(i).getName());
                intent.putExtra("img",mContacts.get(i).getImage());
                intent.putExtra("title",mContacts.get(i).getTitle());

                mContext.startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation((Activity) mContext).toBundle());
                System.out.println("kkkk"+mContacts.get(i).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView text1,text2;
        ImageView imageView;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            text1 = (TextView) itemView.findViewById(R.id.text_id);
            text2 = (TextView) itemView.findViewById(R.id.text_price);
            text1.setBackgroundColor(Color.WHITE);
            text2.setBackgroundColor(Color.WHITE);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            cardView = (CardView) itemView.findViewById(R.id.zz);
        }
    }
}

