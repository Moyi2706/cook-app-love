package com.cookapp.moyiapps.cookapp.activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.cookapp.moyiapps.cookapp.adapters.RecipeAdapter;
import com.cookapp.moyiapps.cookapp.R;
import com.cookapp.moyiapps.cookapp.Clases.Receta;

import java.util.ArrayList;
import java.util.List;

public class MisRecetas extends AppCompatActivity {


    private List<Receta> recetas;

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recycleview;
    private RecipeAdapter recipeAdapter;

    //Items en el menu option
    private MenuItem cambiarVista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mis_recetas;


        //Activar Flecha para atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recetas = getAllRecetas();

        recycleview = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);

        recipeAdapter = new RecipeAdapter(recetas, R.layout.recycle_view_recipe_item, this,new RecipeAdapter.OnItemClickListener(){
        @Override
            public void onItemClick(Receta receta, int position){

        }};

            recycleview.setHasFixedSize(true);
            recycleview.setLayoutManager(layoutManager);
            recycleview.setAdapter(recipeAdapter);


    }
        //Option Menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
             default:
                return onOptionsItemSelected(item);
        }
    }

    //Context Menu Borrar por ahora.
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(recetas.get(info.position).getTitulo());
        inflater.inflate(R.menu.context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();


        switch (item.getItemId()) {
            case R.id.delete_item:
                deleteReceta(info.position);
                this.adapterListView.notifyDataSetChanged();
                this.adapterGridView.notifyDataSetChanged();
            default:
                return super.onContextItemSelected(item);
        }


    }


    //Actions, get, add and delete

    private List<Receta> getAllRecetas() {
        List<Receta> list = new ArrayList<Receta>() {{
            add(new Receta(null, null, 10, 12, "Arroz con leche", null, R.mipmap.ic_launcher));
            add(new Receta(null, null, 10, 12, "Macarons", null, R.mipmap.ic_launcher));
            add(new Receta(null, null, 10, 12, "Dulce de Leche", null, R.mipmap.ic_launcher));
            add(new Receta(null, null, 10, 12, "Brownies", null, R.mipmap.ic_launcher));
            add(new Receta(null, null, 10, 12, "Flan", null, R.mipmap.ic_launcher));
            add(new Receta(null, null, 10, 12, "Pan Casero", null, R.mipmap.ic_launcher));
            add(new Receta(null, null, 10, 12, "Tu Vieja", null, R.mipmap.ic_launcher));

        }};
        return list;
    }

    private void addReceta(Receta receta) {
        this.recetas.add(receta);
        this.adapterListView.notifyDataSetChanged();
        this.adapterGridView.notifyDataSetChanged();
    }

    private void deleteReceta(int position) {
        recetas.remove(position);
        this.adapterListView.notifyDataSetChanged();
        this.adapterGridView.notifyDataSetChanged();
    }


}



