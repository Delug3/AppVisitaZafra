package monumentos.activities;
import java.util.Random;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import ayto.zafrApp.R;
import monumentos.adapters.MonumentosCursor_Adapter;
import monumentos.adapters.MonumentosDb_Adapter;


public class Monumentos_Lista_Activity extends ListActivity {
		
		private MonumentosDb_Adapter Db_Adapter;
	    private Cursor cursor;
	    private MonumentosCursor_Adapter monumentos_Adapter ;
	    private ListView lista;
	    private ImageView fondorandom;
	 
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	     setContentView(R.layout.monumentos_lista);
	     int array[]={R.drawable.res_aleatoria_1,R.drawable.res_aleatoria_2,R.drawable.res_aleatoria_3,R.drawable.res_aleatoria_4};
			Random rnd = new Random();
			//index 3 si hay 3 imagenes en array
	  	    int index = rnd.nextInt(4);
	  	    Drawable cur = getResources().getDrawable(array[index]); 
	  	  fondorandom = (ImageView)findViewById(R.id.imagenfondoListaMonumentos);
	  	  fondorandom.setBackgroundDrawable(cur);
	  	  
	      lista = (ListView) findViewById(android.R.id.list);
	      Db_Adapter = new MonumentosDb_Adapter(this);
	      Db_Adapter.abrir();
	      
	      consultar();
	      
	      
	    }
	  
	   @SuppressWarnings("deprecation")
	private void consultar()
	   {
		  cursor=Db_Adapter.getCursorSeleccion();
	      //Cursor empleado para realizar una seleccion de determindos campos(hoteles por estrellas)
		   //cursor = dbAdapter.getCursorSeleccion();
	      startManagingCursor(cursor);
	      monumentos_Adapter = new MonumentosCursor_Adapter(this, cursor);
	      lista.setAdapter(monumentos_Adapter);
	   }
	 
	   private void visualizar(long id)
		   {
		     Intent i = new Intent(Monumentos_Lista_Activity.this, Monumentos_TabSwipe_Activity.class);
		     i.putExtra(MonumentosDb_Adapter.C_MON_COLUMNA_ID, id);
		     String opcion ="monumentos";
		  	 i.putExtra("Opcion", opcion.toString()+"");
		     startActivityForResult(i, 1);
		    }
		
		protected void onListItemClick(ListView l, View v, int position, long id)
		   {
		      super.onListItemClick(l, v, position, id);
		      visualizar(id);
		   }
		
	}

