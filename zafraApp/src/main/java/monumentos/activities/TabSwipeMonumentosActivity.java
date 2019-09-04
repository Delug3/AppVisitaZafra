package monumentos.activities;
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
import monumentos.adapters.DbMonumentosAdapter;
import monumentos.adapters.TabsPagerMonumentosAdapter;

public class TabSwipeMonumentosActivity extends AppCompatActivity implements ActionBar.TabListener {
	SlidingPaneLayout pane;
	private DbMonumentosAdapter Db_Adapter;
	private Cursor cursor;
	private long id;	
	private ViewPager viewPager;
	private TabsPagerMonumentosAdapter mAdapter;
	private ActionBar cabecera;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.monumentos_pageslide);

	cabecera = getSupportActionBar();
	@SuppressWarnings("deprecation")
	BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.boton_actionbar));
	cabecera.setBackgroundDrawable(background);
	
	cabecera.setDisplayUseLogoEnabled(true);
	cabecera.setDisplayHomeAsUpEnabled(true);
	cabecera.setDisplayShowTitleEnabled(false);
	
	Db_Adapter = new DbMonumentosAdapter(this);
	Db_Adapter.abrir(); 
		
	Intent intent = getIntent();
	Bundle extra = intent.getExtras();
	if (extra == null) return;

	// Obtenemos el identificador del registro si viene indicado
	if (extra.containsKey(DbMonumentosAdapter.C_MON_COLUMNA_ID))
	{
	   id = extra.getLong(DbMonumentosAdapter.C_MON_COLUMNA_ID);
	}

	 Bundle bundle = new Bundle();
	 bundle.putLong("ids",id);
	 
	viewPager = (ViewPager) findViewById(R.id.pagerMonumentos);
	final ActionBar cabecerapage = getSupportActionBar();

	mAdapter = new TabsPagerMonumentosAdapter(getSupportFragmentManager(),bundle);
	viewPager.setAdapter(mAdapter);

	cabecera.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);		

	//A�ADO TAB Y UN ICONO A CADA UNO DE ELLOS(SIN ARRAY)
	cabecerapage.addTab(cabecera.newTab().setText(R.string.tab1).setIcon(R.drawable.estado_grupo_inicio)
			.setTabListener(this));
	cabecerapage.addTab(cabecera.newTab().setText(R.string.tab2).setIcon(R.drawable.estado_tab_info)
			.setTabListener(this));
	cabecerapage.addTab(cabecera.newTab().setText(R.string.tab3).setIcon(R.drawable.estado_tab_fotos)
			.setTabListener(this));
	
	//cabecerapage.setStackedBackgroundDrawable(getResources().getDrawable(R.color.blanco));
	
	viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

		@Override
		public void onPageSelected(int position) {
			cabecerapage.setSelectedNavigationItem(position);
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}
		@Override
		public void onPageScrollStateChanged (int arg0) {
			}
		});
		}

	public boolean onOptionsItemSelected(MenuItem item){
	  
		cursor = Db_Adapter.getRegistro(id);
		String titulo=(cursor.getString(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_NOMBRE)));
		
	    switch (item.getItemId()) {
	        
	    case R.id.menu_item_share:
	    	Intent intent=new Intent(android.content.Intent.ACTION_SEND);
	    	intent.setType("text/plain");
	    	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
	        //intent.putExtra(Intent.EXTRA_TEXT,"Estoy viendo: "+ titulo +" y me encanta!!"+"www.hipersonica.com");
	        intent.putExtra(Intent.EXTRA_TEXT,"Estoy viendo: "+ titulo +" y me encanta!");
	    	startActivity(Intent.createChooser(intent, "Compartir en..."));
	    return true;
	    
	    case android.R.id.home:
	    	 Intent myIntent = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
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
		if (existeConexionInternet()){
			
		cursor = Db_Adapter.getRegistro(id);
	    final Double latgps = cursor.getDouble(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_GPSLATITUD));
	    final Double longps = cursor.getDouble(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_GPSLONGITUD));
			Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
	                Uri.parse("http://maps.google.com/maps?&daddr="+latgps+","+longps));
			startActivity(intent);
		}else{
			   Toast.makeText(this, getResources().getString(R.string.conexion), Toast.LENGTH_LONG).show();
			}
	}

	public void VerGPSLOC(View v)
	{
		if (existeConexionInternet()){
		
		cursor = Db_Adapter.getRegistro(id);
		String titulo=(cursor.getString(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_NOMBRE)));
		
	    final Double latgps = cursor.getDouble(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_GPSLATITUD));
	    final Double longps = cursor.getDouble(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_GPSLONGITUD));
	  
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
	
	public void onTabReselected(Tab tab,android.support.v4.app.FragmentTransaction ft) {
	}

	
	public void onTabSelected(Tab tab,android.support.v4.app.FragmentTransaction ft) {
	viewPager.setCurrentItem(tab.getPosition());
	}

	
	public void onTabUnselected(Tab tab,android.support.v4.app.FragmentTransaction ft) {
	}

	}

	

	

	

	

