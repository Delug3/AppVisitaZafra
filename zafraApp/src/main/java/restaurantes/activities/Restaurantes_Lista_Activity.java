package restaurantes.activities;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import ayto.zafrApp.R;
import restaurantes.adapters.RestaurantesCursor_Adapter;
import restaurantes.adapters.RestaurantesDb_Adapter;


public class Restaurantes_Lista_Activity extends ListActivity{
	private RestaurantesDb_Adapter Db_Adapter;
    private Cursor cursor;
    private RestaurantesCursor_Adapter restaurantes_Adapter ;
    private ListView lista;
 
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
     setContentView(R.layout.restaurantes_lista);
     
      lista = (ListView) findViewById(android.R.id.list);
 
      Db_Adapter = new RestaurantesDb_Adapter(this);
      Db_Adapter.abrir();
 
    String categoria = getIntent().getStringExtra("Categoria");
    if (categoria.equals("tradicional"))
    	{
    	
      consultarTradicional();
    	}
    
    if (categoria.equals("internacional"))
    	{
        consultarInternacional();
        }
    
    if (categoria.equals("carta"))
	{
    consultarCarta();
    }

    if (categoria.equals("tapas"))
	{
    consultarTapas();
    }
    
    if (categoria.equals("llevar"))
	{
    consultarLlevar();
    }

    if (categoria.equals("catering"))
	{
    consultarCatering();
    }


    
    
   }
 
   @SuppressWarnings("deprecation")
private void consultarTradicional()
   {
	  cursor=Db_Adapter.getCursorSeleccionTradicional();
      startManagingCursor(cursor);
      restaurantes_Adapter = new RestaurantesCursor_Adapter(this, cursor);
      lista.setAdapter(restaurantes_Adapter);
      ImageView btn = (ImageView)findViewById(R.id.imgbuttonbtnfijoRestaurantesLista);
	  btn.setImageResource(R.drawable.boton_categorias_restaurantes_cocinatradicionalazul);

   }
   
   @SuppressWarnings("deprecation")
private void consultarInternacional()
   {
	  cursor=Db_Adapter.getCursorSeleccionInternacional();
      startManagingCursor(cursor);
      restaurantes_Adapter = new RestaurantesCursor_Adapter(this, cursor);
      lista.setAdapter(restaurantes_Adapter);
      ImageView btn = (ImageView)findViewById(R.id.imgbuttonbtnfijoRestaurantesLista);
	  btn.setImageResource(R.drawable.boton_categorias_restaurantes_cocinainternacionalazul);

   }
 
   @SuppressWarnings("deprecation")
private void consultarCarta()
   {
	  cursor=Db_Adapter.getCursorSeleccionCarta();
      startManagingCursor(cursor);
      restaurantes_Adapter = new RestaurantesCursor_Adapter(this, cursor);
      lista.setAdapter(restaurantes_Adapter);
      ImageView btn = (ImageView)findViewById(R.id.imgbuttonbtnfijoRestaurantesLista);
	  btn.setImageResource(R.drawable.boton_categorias_restaurantes_alacartaazul);

   }
   
   @SuppressWarnings("deprecation")
private void consultarTapas()
   {
	  cursor=Db_Adapter.getCursorSeleccionTapas();
      startManagingCursor(cursor);
      restaurantes_Adapter = new RestaurantesCursor_Adapter(this, cursor);
      lista.setAdapter(restaurantes_Adapter);
      ImageView btn = (ImageView)findViewById(R.id.imgbuttonbtnfijoRestaurantesLista);
	  btn.setImageResource(R.drawable.boton_categorias_restaurantes_detapasazul);

   }
   
   @SuppressWarnings("deprecation")
private void consultarLlevar()
   {
	  cursor=Db_Adapter.getCursorSeleccionLlevar();
      startManagingCursor(cursor);
      restaurantes_Adapter = new RestaurantesCursor_Adapter(this, cursor);
      lista.setAdapter(restaurantes_Adapter);
      ImageView btn = (ImageView)findViewById(R.id.imgbuttonbtnfijoRestaurantesLista);
	  btn.setImageResource(R.drawable.boton_categorias_restaurantes_parallevarazul);

   }
   
   @SuppressWarnings("deprecation")
private void consultarCatering()
   {
	  cursor=Db_Adapter.getCursorSeleccionCatering();
      startManagingCursor(cursor);
      restaurantes_Adapter = new RestaurantesCursor_Adapter(this, cursor);
      lista.setAdapter(restaurantes_Adapter);
      ImageView btn = (ImageView)findViewById(R.id.imgbuttonbtnfijoRestaurantesLista);
	  btn.setImageResource(R.drawable.boton_categorias_restaurantes_cateringazul);

   }
   
   private void visualizar(long id)
	   {
	      Intent i = new Intent(Restaurantes_Lista_Activity.this, Restaurantes_TabSwipe_Activity.class);
	      i.putExtra(RestaurantesDb_Adapter.C_RES_COLUMNA_ID, id);
	      startActivityForResult(i, 1);
	    }
	
   protected void onListItemClick(ListView l, View v, int position, long id)
	   {
	      super.onListItemClick(l, v, position, id);
	      visualizar(id);
	   }
	
}
