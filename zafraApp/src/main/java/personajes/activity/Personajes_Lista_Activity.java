package personajes.activity;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import ayto.zafrApp.R;
import personajes.adapters.ListView_Personajes_Adapter;

public class Personajes_Lista_Activity extends AppCompatActivity {
	ListView list;
	ListView_Personajes_Adapter adapter;
	String[] personaje;
	String[] vida;
	private ImageView fondorandom;
	 
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from listview_main.xml
		setContentView(R.layout.personajes_listview_principal);
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
  	    fondorandom = (ImageView)findViewById(R.id.imagenfondolistapersonajes);
  	    fondorandom.setBackgroundDrawable(cur);
  	 
		Resources res = this.getResources();
		personaje = res.getStringArray(R.array.personaje);
		 
		Resources res2 = this.getResources();
		vida = res2.getStringArray(R.array.vida);
		
		// Locate the ListView in listview_main.xml
		list = (ListView) findViewById(R.id.listviewpersonajes);

		// Pass results to ListViewAdapter Class
		adapter = new ListView_Personajes_Adapter(this, personaje);
		// Binds the Adapter to the ListView
		list.setAdapter(adapter);
		// Capture ListView item click
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int posicion, long id) {
				Intent i = new Intent(Personajes_Lista_Activity.this, MostrarItem_Personajes_Activity.class);
				// Pass all data rank
				i.putExtra("personaje", personaje);
				// Pass all data country
				i.putExtra("vida", vida);
				// Pass a single position
				i.putExtra("posicion", posicion);
				// Open SingleItemView.java Activity
				startActivity(i);
			}
		});
	}
}
