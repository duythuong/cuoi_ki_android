package com.example.duynguyen.new_app.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.duynguyen.new_app.R;
import com.example.duynguyen.new_app.doi_tuong.doi_tuong_sale_foods;
import java.util.ArrayList;

public class adapter_sale_foods extends RecyclerView.Adapter<adapter_sale_foods.ViewHolder> {
    private ArrayList<doi_tuong_sale_foods> mContacts;
    private Context mContext;
    Intent intent;
    public adapter_sale_foods(ArrayList<doi_tuong_sale_foods> mContacts, Context mContext) {
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
    public void onBindViewHolder(adapter_sale_foods.ViewHolder holder, int i) {
        doi_tuong_sale_foods doituong = mContacts.get(i);
//        holder.text1.setText(doituong.getTitle());
//        holder.te xt2.setText(doituong.getDiscount());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView text1;

        //        TextView text2;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            text1 = (TextView) itemView.findViewById(R.id.text_id);
//            text2 = (TextView) itemView.findViewById(R.id.textkk);
//            imageView = (ImageView) itemView.findViewById(R.id.img);
//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////            intent = new Intent(mContext,ScrollingActivity.class);
////            intent.putExtra("id","ádasd");
////            mContext.startActivity(intent);
//                }
//            });
        }
    }
}

