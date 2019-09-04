package leyendas.Activities;

import java.util.Random;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import ayto.zafrApp.R;
import leyendas.Adapters.ListViewLeyendasAdapter;

public class ListaLeyendasActivity extends AppCompatActivity {
	ListView list;
	ListViewLeyendasAdapter adapter;
	String[] nombre;
	String[] leyenda;
	private ImageView fondorandom;
	 
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from listview_main.xml
		setContentView(R.layout.leyendas_listview_principal);
		ActionBar cabecera = getSupportActionBar();
		BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.boton_actionbar));
		cabecera.setBackgroundDrawable(background);
		cabecera.hide();
		cabecera.setDisplayUseLogoEnabled(false);
		cabecera.setDisplayHomeAsUpEnabled(false);
		cabecera.setDisplayShowTitleEnabled(false);
		

		int array[]={R.drawable.res_aleatoria_1,R.drawable.res_aleatoria_2,R.drawable.res_aleatoria_3,R.drawable.res_aleatoria_4};
		Random rnd = new Random();
		//index 3 si hay 3 imagenes en array
  	    int index = rnd.nextInt(4);
  	    Drawable cur = getResources().getDrawable(array[index]); 
  	    fondorandom = (ImageView)findViewById(R.id.imagenfondolistaleyenda);
  	    fondorandom.setBackgroundDrawable(cur);
  	 
		Resources res = this.getResources();
		nombre = res.getStringArray(R.array.nombre);
		 
		Resources res2 = this.getResources();
		leyenda = res2.getStringArray(R.array.leyenda);
		
		// Locate the ListView in listview_main.xml
		list = (ListView) findViewById(R.id.listviewleyendas);

		// Pass results to ListViewAdapter Class
		adapter = new ListViewLeyendasAdapter(this, nombre);
		// Binds the Adapter to the ListView
		list.setAdapter(adapter);
		// Capture ListView item click
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int posicion, long id) {
				Intent i = new Intent(ListaLeyendasActivity.this, MostrarItemLeyendasActivity.class);
				// Pass all data rank
				i.putExtra("nombre", nombre);
				// Pass all data country
				i.putExtra("leyenda", leyenda);
				// Pass a single position
				i.putExtra("posicion", posicion);
				// Open SingleItemView.java Activity
				startActivity(i);
			}
		});
	}
}
	
	
	
	
