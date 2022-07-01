package com.example.tugassesi3.view;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tugassesi3.databinding.ItemTeamBinding;
import com.example.tugassesi3.remote.TeamsItem;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    private final List<TeamsItem> TeamsItem;

    public TeamsAdapter(List<TeamsItem> TeamsItem) {
        this.TeamsItem = TeamsItem;
    }

    OnItemClickCallback monItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.monItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTeamBinding binding = ItemTeamBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(TeamsItem.get(position));
        holder.binding.btnSave.setOnClickListener(view ->monItemClickCallback.onInsertClick(TeamsItem.get(position)));
    }

    @Override
    public int getItemCount() {
        return TeamsItem.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemTeamBinding binding;

        public ViewHolder(@NonNull ItemTeamBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(TeamsItem TeamItem) {
            binding.tvName.setText(TeamItem.getName());
            Glide.with(binding.getRoot())
                    .load(TeamItem.getLogo())
                    .into(binding.ivLogo);
        }
    }

    public interface OnItemClickCallback {
        void onInsertClick(TeamsItem nbaTeamItem);
    }
}