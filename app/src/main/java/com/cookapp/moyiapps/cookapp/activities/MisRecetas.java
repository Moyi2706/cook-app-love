package com.cookapp.moyiapps.cookapp.activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import android.widget.GridView;
import android.widget.ListView;

import com.cookapp.moyiapps.cookapp.adapters.RecipeAdapter;
import com.cookapp.moyiapps.cookapp.R;
import com.cookapp.moyiapps.cookapp.Clases.Receta;

import java.util.ArrayList;
import java.util.List;

public class MisRecetas extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private List<Receta> recetas;

    private ListView listView;
    private GridView gridView;

    //Items en el menu option
    private MenuItem itemlistview;
    private MenuItem itemgridview;

    private RecipeAdapter adapterListView;
    private RecipeAdapter adapterGridView;

    private int counter = 0;
    private final int SWITCH_TO_LIST_VIEW = 0;
    private final int SWITCH_TO_GRID_VIEW = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_recetas);


        //Activar Flecha para atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recetas = getAllRecetas();

        this.listView = (ListView) findViewById(R.id.listview);
        this.gridView = (GridView) findViewById(R.id.gridView);

        //Adjuntamos metodo click para ambos
        this.listView.setOnItemClickListener(this);
        this.gridView.setOnItemClickListener(this);

        this.adapterListView = new RecipeAdapter(this, recetas, R.layout.list_item);
        this.adapterGridView = new RecipeAdapter(this, recetas, R.layout.grid_item);

        this.listView.setAdapter(adapterListView);
        this.gridView.setAdapter(adapterGridView);


        //Registrar el context menu para ambos
        registerForContextMenu(this.listView);
        registerForContextMenu(this.gridView);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        this.clickRecipe(recetas.get(position));
    }

    private void clickRecipe(Receta receta) {

    }


    //Option Menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        this.itemlistview = menu.findItem(R.id.list_view);
        this.itemgridview = menu.findItem(R.id.grid_view);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.add_recipe:
                return true;

            case R.id.list_view:
                this.switchListGridView(this.SWITCH_TO_LIST_VIEW);
                return true;
            case R.id.grid_view:
                this.switchListGridView(this.SWITCH_TO_GRID_VIEW);
                return true;
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


    private void switchListGridView(int option) {
        if (option == SWITCH_TO_LIST_VIEW) {
            if (this.listView.getVisibility() == View.INVISIBLE) {
                this.gridView.setVisibility(View.INVISIBLE);
                this.itemgridview.setVisible(true);
                this.listView.setVisibility(View.VISIBLE);
                this.itemlistview.setVisible(false);
            }
        } else if (option == SWITCH_TO_GRID_VIEW) {
            if (this.gridView.getVisibility() == View.INVISIBLE) {
                this.listView.setVisibility(View.INVISIBLE);
                this.itemlistview.setVisible(true);
                this.gridView.setVisibility(View.VISIBLE);
                this.itemgridview.setVisible(false);
            }
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
        this.recetas.remove(position);
        this.adapterListView.notifyDataSetChanged();
        this.adapterGridView.notifyDataSetChanged();
    }


}



