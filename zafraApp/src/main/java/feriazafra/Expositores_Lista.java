package feriazafra;

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

public class Expositores_Lista extends AppCompatActivity {
	ListView list;
	ListViewAdapter_Expositores adapter;
	String[] zona;
	String[] expositores;
	private ImageView fondorandom;
	 
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from listview_main.xml
		setContentView(R.layout.feriazafra_expositores_listview);
		ActionBar cabecera = getSupportActionBar();
		BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.boton_actionbar_feriazafra));
		cabecera.setBackgroundDrawable(background);
		cabecera.hide();
		cabecera.setDisplayUseLogoEnabled(false);
		cabecera.setDisplayHomeAsUpEnabled(false);
		cabecera.setDisplayShowTitleEnabled(false);
		

		int array[]={R.drawable.res_feria_aleatoria_1,R.drawable.res_feria_aleatoria_2,R.drawable.res_feria_aleatoria_3,R.drawable.res_feria_aleatoria_4,R.drawable.res_feria_aleatoria_5,R.drawable.res_feria_aleatoria_6};
		Random rnd = new Random();
		//index 3 si hay 3 imagenes en array
  	    int index = rnd.nextInt(6);
  	    Drawable cur = getResources().getDrawable(array[index]); 
  	    fondorandom = (ImageView)findViewById(R.id.imagenfondolistaexpositores);
  	    fondorandom.setBackgroundDrawable(cur);
  	 
		Resources res = this.getResources();
		zona = res.getStringArray(R.array.zona);
		 
		Resources res2 = this.getResources();
		expositores = res2.getStringArray(R.array.expositores);
		
		// Locate the ListView in listview_main.xml
		list = (ListView) findViewById(R.id.listviewexpositores);

		// Pass results to ListViewAdapter Class
		adapter = new ListViewAdapter_Expositores(this, zona);
		// Binds the Adapter to the ListView
		list.setAdapter(adapter);
		// Capture ListView item click
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int posicion, long id) {
				Intent i = new Intent(Expositores_Lista.this, MostrarItem_Expositores.class);
				// Pass all data rank
				i.putExtra("zona", zona);
				// Pass all data country
				i.putExtra("expositores", expositores);
				// Pass a single position
				i.putExtra("posicion", posicion);
				// Open SingleItemView.java Activity
				startActivity(i);
			}
		});
	}
}
