package com.example.cinema_booking_mobile.model.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinema_booking_mobile.R;
import com.example.cinema_booking_mobile.model.Phim;

import java.util.List;

public class PhimDangChieuAdapter extends RecyclerView.Adapter<PhimDangChieuAdapter.PhimDangChieuHolder> {
    private List<Phim> phimList;
    private PhimDangChieuListener phimDangChieuListener;

    public PhimDangChieuAdapter(List<Phim> phimList) {
        this.phimList = phimList;
    }

    public void setPhimDangChieuListener(PhimDangChieuListener phimDangChieuListener) {
        this.phimDangChieuListener = phimDangChieuListener;
    }

    @NonNull
    @Override
    public PhimDangChieuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item2, parent, false);
        return new PhimDangChieuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhimDangChieuHolder holder, int position) {
        Phim phim = phimList.get(position);
        holder.poster.setImageResource(R.drawable.poster);
    }

    @Override
    public int getItemCount() {
        return phimList.size();
    }

    public class PhimDangChieuHolder extends RecyclerView.ViewHolder {
        ImageView poster;

        public PhimDangChieuHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.poster);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (phimDangChieuListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            phimDangChieuListener.onPhimDangChieuClick(position);
                        }
                    }
                }
            });
        }
    }

    public interface PhimDangChieuListener {
        void onPhimDangChieuClick(int position);
    }
}
