package com.cookapp.moyiapps.cookapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.cookapp.moyiapps.cookapp.adapters.RecipeAdapter;
import com.cookapp.moyiapps.cookapp.R;
import com.cookapp.moyiapps.cookapp.Clases.Receta;

import java.util.ArrayList;
import java.util.List;

public class MisRecetasGridView extends AppCompatActivity {

    private List<Receta> recetas;
    private GridView gridView;
    private Receta r1 = new Receta();
    private Receta r2= new Receta();
    private Receta r3 = new Receta();
    private Receta r4= new Receta();
    private Receta r5 = new Receta();
    private Receta r6= new Receta();
    private Receta r7 = new Receta();
    private Receta r8= new Receta();
    private Receta r9 = new Receta();
    private Receta r10= new Receta();
    private Receta r11= new Receta();
    private Receta r12=new Receta();
    private Receta r13= new Receta();
    private Receta r14= new Receta();
    private Receta r15= new Receta();
    private Receta r16= new Receta();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_recetas_grid_view);

        //Activar Flecha para atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        gridView = (GridView) findViewById(R.id.gridViewRecetas);

        //Datos a mostrar
        r1.setTitulo("macarons");
        r2.setTitulo("brownies");
        r3.setTitulo("macarons");
        r4.setTitulo("brownies");
        r5.setTitulo("macarons");
        r6.setTitulo("brownies");
        r7.setTitulo("macarons");
        r8.setTitulo("brownies");
        r9.setTitulo("macarons");
        r10.setTitulo("brownies");
        r11.setTitulo("macarons");
        r12.setTitulo("brownies");
        r13.setTitulo("macarons");
        r14.setTitulo("brownies");
        r15.setTitulo("macarons");
        r16.setTitulo("brownies");





        recetas =  new ArrayList<>();
        recetas.add(r1);
        recetas.add(r2);
        recetas.add(r3);
        recetas.add(r4);
        recetas.add(r5);
        recetas.add(r6);
        recetas.add(r7);
        recetas.add(r8);
        recetas.add(r9);
        recetas.add(r10);
        recetas.add(r11);
        recetas.add(r12);
        recetas.add(r13);
        recetas.add(r14);
        recetas.add(r15);
        recetas.add(r16);


        //Enlazamos con nuestro adaptador personalizado

        RecipeAdapter recipeAdapter = new RecipeAdapter(this, recetas, R.layout.grid_item);

        gridView.setAdapter(recipeAdapter);




    }
}
