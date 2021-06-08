package com.example.ffffffff8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{

    private ArrayList<RoomAccount> arrayList;
    private Context context; //adapter에서 액티비티에서 뭥ㄴ갈 가져올때 필요

    public CustomAdapter(ArrayList<RoomAccount> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    //@org.jetbrains.annotations.NotNull
    @Override
    //실제 리스트뷰가 어댑터에 연결된 다음 뷰 홀더를 최초로 만들어낸다.
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.iv_profile);
        holder.tv_roomName.setText(arrayList.get(position).getRoomName());
        holder.tv_placeActivity.setText(arrayList.get(position).getPlaceActivity());
        holder.tv_entryNumber.setText(String.valueOf(arrayList.get(position).getEntryNumber()));
    }

    @Override
    public int getItemCount() {
        //삼항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile;
        TextView tv_roomName;
        TextView tv_placeActivity;
        TextView tv_entryNumber;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = itemView.findViewById(R.id.iv_profile);
            this.tv_roomName = itemView.findViewById(R.id.tv_roomName);
            this.tv_placeActivity = itemView.findViewById(R.id.tv_placeActivity);
            this.tv_entryNumber = itemView.findViewById(R.id.tv_entryNumber);

        }
    }
}
