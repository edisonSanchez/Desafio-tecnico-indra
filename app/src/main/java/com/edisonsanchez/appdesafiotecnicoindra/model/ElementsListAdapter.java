package com.edisonsanchez.appdesafiotecnicoindra.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edisonsanchez.appdesafiotecnicoindra.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ElementsListAdapter extends RecyclerView.Adapter<ElementsListAdapter.ElementViewHolder> {

    private Context context;
    private List<Elemento> elementos;

    public ElementsListAdapter(Context context, List<Elemento> elementos){
        this.context = context;
        this.elementos = elementos;
    }
    @NonNull
    @Override
    public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_view, parent,
                false);
        return new ElementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementViewHolder holder, int position) {
        Elemento currentElement = elementos.get(position);
        holder.title.setText(currentElement.getTitle());
        Picasso.get().load(currentElement.getUrl()).placeholder(R.mipmap.ic_launcher)
                .into(holder.imagen);
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    public class ElementViewHolder extends  RecyclerView.ViewHolder {

        private TextView title;
        private ImageView imagen;
        public ElementViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            imagen = itemView.findViewById(R.id.imagen);
            itemView.setOnClickListener(v -> {
                elementos.remove(getAdapterPosition());
                notifyDataSetChanged();
            });
        }
    }

}
