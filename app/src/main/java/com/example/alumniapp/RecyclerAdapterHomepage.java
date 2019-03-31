package com.example.alumniapp;

/**
 * Created by Amisha on 22-02-2019.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by csa on 3/7/2017.
 */

public class RecyclerAdapterHomepage extends RecyclerView.Adapter<RecyclerAdapterHomepage.MyHolder> {

    List<HomePageData> list;
    Context context;

    public RecyclerAdapterHomepage(List<HomePageData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_item_layout,parent,false);
        MyHolder myHolder = new MyHolder(view);


        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        HomePageData mylist = list.get(position);
        holder.profilename.setText(mylist.getPostownername());
        holder.posttext.setText(mylist.getPosttext());
        Glide.with(context).load(mylist.getPostownerimage()).into(holder.circleImageView);
        Glide.with(context).load(mylist.getPostimage()).into(holder.postimage);

    }

    @Override
    public int getItemCount() {

        int arr = 0;

        try{
            if(list.size()==0){

                arr = 0;

            }
            else{

                arr=list.size();
            }



        }catch (Exception e){



        }

        return arr;

    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CircleImageView circleImageView;
        ImageView postimage;
        TextView posttext;
        TextView profilename;

        public MyHolder(View itemView) {
            super(itemView);
            circleImageView = (CircleImageView) itemView.findViewById(R.id.image);
            posttext= (TextView) itemView.findViewById(R.id.posttext);
            profilename= (TextView) itemView.findViewById(R.id.name);
            postimage=  itemView.findViewById(R.id.postImage);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
