package com.cookapp.moyiapps.cookapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cookapp.moyiapps.cookapp.Clases.Receta;
import com.cookapp.moyiapps.cookapp.R;

import java.util.List;

/**
 * Created by bmoyano on 22/3/2018.
 */

public class RecipeAdapter extends BaseAdapter {

    private Context context;
    private List<Receta>recetas;
    private int layout;


    public RecipeAdapter(Context context, List<Receta> recetas, int layout) {
        this.context = context;
        this.recetas = recetas;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return this.recetas.size();
    }

    @Override
    public Object getItem(int position) {
        return this.recetas.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        // View Holder Pattern (Aumenta la performance al no llegar a relizar la llamada de find)

        ViewHolder holder;

        if(convertView == null){
            //inflamos la vista con nuestro layour personaliado
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView =  layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();

            holder.titleTextView = (TextView) convertView.findViewById(R.id.textview_titulo);
           // holder.imagenImageView = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        //Capturamos los datos de la lista
        String currentTitle = recetas.get(position).getTitulo();
       // Drawable imagen= recetas.get(position).getImagen();

        holder.titleTextView.setText(currentTitle);
       // holder.imagenImageView.setImageDrawable(imagen);

        return convertView;
    }

    static class ViewHolder{
        private TextView titleTextView;
       // private ImageView imagenImageView;



    }

}
