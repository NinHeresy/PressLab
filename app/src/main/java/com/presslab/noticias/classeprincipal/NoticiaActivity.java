package com.presslab.noticias.classeprincipal;


import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.presslab.R;
import com.presslab.noticias.adapters.Adapterdrawer;
import com.presslab.noticias.adapters.ListaAdapter;
import com.presslab.noticias.noticias.Noticias;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class NoticiaActivity extends AppCompatActivity{
    //NAVIGATION DRAWER
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private String[] listdrawer;
    private ListView lista;
    private List iList;
    private ArrayList<Adapterdrawer> mlistdrawer;

    //Toolbar
    public Toolbar mToolbar;
    //Lista de array da classe Noticias
    private ArrayList<Noticias> mNoticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contlista);
        //drawer
        ArrayAdapter<String> adapterarray;
        //Toolbar
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.londrina));
        setSupportActionBar(mToolbar);
        setContentView(R.layout.contlista);
        //ListView das noticias
        mNoticias = new ArrayList<Noticias>();
        //mNoticias.add(new Noticias(0, R.drawable.cuba,
               // "O que a maconha pode fazer pela sua saúde ")); //int id, int imagem, String titulo, String noticia
        for (int i=1; i<50; i++) {
            mNoticias.add(new Noticias(i, R.drawable.uol1,
                    "27/07/2015", "Milhares de anos depois das primeiras referências históricas do consumo de maconha."));
        }
        //acessando minha view
        ListView listView = (ListView)findViewById(R.id.listNews);
        ListaAdapter listaNoticias = new ListaAdapter(this, mNoticias);
        listView.setAdapter(listaNoticias);



        //NAVIGATION DRAWER
        mDrawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        lista = (ListView)findViewById(R.id.list_drawer);

        listdrawer = getResources().getStringArray(R.array.listdrawer);
        adapterarray = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listdrawer);
        

        //mostrando o item que foi clickado dentro do listView
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //String dados = parent.getItemAtPosition(position).toString();
                int listposition = position +1;
                Toast.makeText(NoticiaActivity.this, "Item selecionado" +listposition, Toast.LENGTH_SHORT).show();
                mDrawer.closeDrawer(lista);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawer, mToolbar, R.string.drawer_open, R.string.drawer_close){

            //Chamado quando o Drawer se estabeleceu em um estado completamente fechada.
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
                syncState();
            }
            //Chamado quando uma gaveta se estabeleceu em um estado completamente aberto. A gaveta é interativo neste momento.
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
                syncState();
            }
        };
        //
        mDrawer.setDrawerListener(actionBarDrawerToggle);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.syncState();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }
            ////ENCERRA AQUI Á PARTE DO NAVIGATION DRAWER

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_noticia, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                mDrawer.openDrawer(GravityCompat.START);

                return true;
            }
            default:return super.onOptionsItemSelected(item);
        }
    }

}
