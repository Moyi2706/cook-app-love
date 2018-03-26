package com.cookapp.moyiapps.cookapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cookapp.moyiapps.cookapp.Clases.Receta;
import com.cookapp.moyiapps.cookapp.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by bmoyano on 22/3/2018.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private Context context;
    private List<Receta> recetas;
    private int layout;
    private Activity activity;
    private OnItemClickListener listener;


    public RecipeAdapter(List<Receta> recetas, int layout, Activity activity, OnItemClickListener listener) {
        this.recetas = recetas;
        this.layout = layout;
        this.activity = activity;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder();
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(recetas.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return recetas.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, MenuItem {

        private TextView textViewName;
        private ImageView imageViewFoto;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            imageViewFoto = (ImageView) itemView.findViewById(R.id.imageViewFoto);

            itemView.setOnCreateContextMenuListener(this);

        }

        public void bind(final Receta receta, final OnItemClickListener listener){

            this.textViewName.setText(receta.getTitulo());
            this.textViewName.setTypeface(Typeface.DEFAULT_BOLD);
            Picasso.

                    load(receta.getImagen()).fit().into(this.imageViewFoto);

        }




    }

    public interface OnItemClickListener {
        void onItemClick(Receta receta, int position);

    }

}
