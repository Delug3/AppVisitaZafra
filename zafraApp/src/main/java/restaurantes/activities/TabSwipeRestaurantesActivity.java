package restaurantes.activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import ayto.zafrApp.R;
import clases_principales.MenuPrincipalActivity;
import restaurantes.adapters.DbRestaurantesAdapter;
import restaurantes.adapters.TabsPagerRestaurantesAdapter;

public class TabSwipeRestaurantesActivity extends AppCompatActivity implements
ActionBar.TabListener {
	 SlidingPaneLayout pane;
	   
	    private DbRestaurantesAdapter Db_Adapter;
	    private Cursor cursor;
	    private long id;	
	    private ViewPager viewPager;
	    private TabsPagerRestaurantesAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.restaurantes_pageslide);
		/*NavDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		//Lista
        NavList = (ListView) findViewById(R.id.lista);
        //Declaramos el header el caul sera el layout de header.xml
        View header = getLayoutInflater().inflate(R.layout.header, null);
        //Establecemos header
        NavList.addHeaderView(header);
		//Tomamos listado  de imgs desde drawable
        NavIcons = getResources().obtainTypedArray(R.array.navigation_iconos);			
		//Tomamos listado  de titulos desde el string-array de los recursos @string/nav_options
        titulos = getResources().getStringArray(R.array.nav_options);
        //Listado de titulos de barra de navegacion
        NavItms = new ArrayList<Items>();
        //Agregamos objetos Item_objct al array
        //Perfil	      
        NavItms.add(new Items(titulos[0], NavIcons.getResourceId(0, -1)));
        //Favoritos
        NavItms.add(new Items(titulos[1], NavIcons.getResourceId(1, -1)));
        //Eventos
        NavItms.add(new Items(titulos[2], NavIcons.getResourceId(2, -1)));
        //Lugares
        NavItms.add(new Items(titulos[3], NavIcons.getResourceId(3, -1)));
        //Etiquetas
        NavItms.add(new Items(titulos[4], NavIcons.getResourceId(4, -1)));
        //Configuracion
        NavItms.add(new Items(titulos[5], NavIcons.getResourceId(5, -1)));
        //Share
         //Declaramos y seteamos nuestrp adaptador al cual le pasamos el array con los titulos	       
        NavAdapter= new NavigationAdapter(this,NavItms);
        NavList.setAdapter(NavAdapter);	
        //Siempre vamos a mostrar el mismo titulo
       	NavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       		public void onItemClick(AdapterView<?> arg0,View arg1,int position,long id)
       		{
       			if(position==1)
       			{
       			AbrirMonumentos();
       			}
       			if(position==2)
       			{
       			AbrirAlojamientos();	
       			}
       			if(position==3)
       			{
       			AbrirRestaurantes();
       			}
       		}
		});             
        */
       	
		final ActionBar cabecera = getSupportActionBar();
		@SuppressWarnings("deprecation")
		BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.boton_actionbar));
		cabecera.setBackgroundDrawable(background);

		cabecera.setDisplayUseLogoEnabled(true);
		cabecera.setDisplayHomeAsUpEnabled(true);
		cabecera.setDisplayShowTitleEnabled(false);
		
		Db_Adapter = new DbRestaurantesAdapter(this);
		Db_Adapter.abrir(); 
	
		Intent intent = getIntent();
		Bundle extra = intent.getExtras();
		if (extra == null) return;

		// Obtenemos el identificador del registro si viene indicado
		if (extra.containsKey(DbRestaurantesAdapter.C_RES_COLUMNA_ID))
		{
			id = extra.getLong(DbRestaurantesAdapter.C_RES_COLUMNA_ID);
		}
		Bundle bundle = new Bundle();
		bundle.putLong("ids",id);

		viewPager = (ViewPager) findViewById(R.id.pagerRestaurantes);
		final ActionBar cabecerapage = getSupportActionBar();
		mAdapter = new TabsPagerRestaurantesAdapter(getSupportFragmentManager(),bundle);
		viewPager.setAdapter(mAdapter);
		cabecera.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);		

//A�ADO TAB Y UN ICONO A CADA UNO DE ELLOS(SIN ARRAY)
cabecerapage.addTab(cabecera.newTab().setText(R.string.tab1).setIcon(R.drawable.estado_grupo_inicio)
		.setTabListener(this));
cabecerapage.addTab(cabecera.newTab().setText(R.string.tab2).setIcon(R.drawable.estado_tab_info)
		.setTabListener(this));
cabecerapage.addTab(cabecera.newTab().setText(R.string.tab3).setIcon(R.drawable.estado_tab_fotos)
		.setTabListener(this));

viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

	@Override
	public void onPageSelected(int position) {
		cabecerapage.setSelectedNavigationItem(position);
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}
	@Override
	public void onPageScrollStateChanged(int arg0) {
	}
});
}
	/*public void AbrirMonumentos()
	{
		   Intent main = new Intent(this, MenuPrincipalActivity.class);
		    main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
		        | Intent.FLAG_ACTIVITY_NEW_TASK);
		    startActivity(main);

		    Intent actual = new Intent(this, ListaMonumentosActivity.class);
		    actual.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
		        | Intent.FLAG_ACTIVITY_NEW_TASK);
		    startActivity(actual);
		    finish();
		}
	*/
	
	
public boolean onOptionsItemSelected(MenuItem item){
 
	cursor = Db_Adapter.getRegistro(id);
	String titulo=(cursor.getString(cursor.getColumnIndex(DbRestaurantesAdapter.C_RES_COLUMNA_NOMBRE)));
	
   switch (item.getItemId()) {
   case R.id.menu_item_share:
   	Intent intent=new Intent(android.content.Intent.ACTION_SEND);
   	intent.setType("text/plain");
   	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
    intent.putExtra(Intent.EXTRA_TEXT,"Estoy viendo: "+ titulo +" y me encanta!");
	startActivity(Intent.createChooser(intent, "Compartir en..."));
   return true;
   
   case android.R.id.home:
   	 Intent myIntent = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
        //Con esto prevenimos de crear una nueva activity de la principal
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(myIntent);
   return true;
   
   default:
      
    return true;
   }
}

public boolean onCreateOptionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.compartir, menu);
	return true;
}


public void VerGPS(View v)
{
	if (existeConexionInternet())
	{
	cursor = Db_Adapter.getRegistro(id);
   final Double latgps = cursor.getDouble(cursor.getColumnIndex(DbRestaurantesAdapter.C_RES_COLUMNA_GPSLATITUD));
   final Double longps = cursor.getDouble(cursor.getColumnIndex(DbRestaurantesAdapter.C_RES_COLUMNA_GPSLONGITUD));
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
               Uri.parse("http://maps.google.com/maps?&daddr="+latgps+","+longps));
		startActivity(intent);
	}else{
		   Toast.makeText(this, getResources().getString(R.string.conexion), Toast.LENGTH_LONG).show();
		}
}

public void VerGPSLOC(View v)
{
	if (existeConexionInternet())
	{
	cursor = Db_Adapter.getRegistro(id);
	String titulo=(cursor.getString(cursor.getColumnIndex(DbRestaurantesAdapter.C_RES_COLUMNA_NOMBRE)));
	
    final Double latgps = cursor.getDouble(cursor.getColumnIndex(DbRestaurantesAdapter.C_RES_COLUMNA_GPSLATITUD));
    final Double longps = cursor.getDouble(cursor.getColumnIndex(DbRestaurantesAdapter.C_RES_COLUMNA_GPSLONGITUD));
 
    String uriBegin = "geo:" + latgps + "," + longps; 
	String query = latgps + "," + longps + "(" + titulo + ")"; 
	String encodedQuery = Uri.encode(query); 
	String uriString = uriBegin + "?q=" + encodedQuery + "&z=16"; 
	Uri uri = Uri.parse(uriString); 
	Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri); 
	startActivity(mapIntent);
	}else{
		   Toast.makeText(this, getResources().getString(R.string.conexion), Toast.LENGTH_LONG).show();
		}
}

public boolean existeConexionInternet() {
	   ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	   NetworkInfo netInfo = cm.getActiveNetworkInfo();
	   if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	      return true;
	   }
	   return false;
	}
@Override
public void onTabReselected(Tab tab, android.support.v4.app.FragmentTransaction ft) {
}

@Override
public void onTabSelected(Tab tab, android.support.v4.app.FragmentTransaction ft) {
viewPager.setCurrentItem(tab.getPosition());
}

@Override
public void onTabUnselected(Tab tab, android.support.v4.app.FragmentTransaction ft) {
}




}
