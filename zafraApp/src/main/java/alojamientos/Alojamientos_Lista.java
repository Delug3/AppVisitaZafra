package alojamientos;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import ayto.zafrApp.R;


public class Alojamientos_Lista extends ListActivity {
	private AlojamientosDbAdapter Db_Adapter;
    private Cursor cursor;
    private AlojamientosCursorAdapter alojamientos_Adapter ;
    private ListView lista;
 
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
     setContentView(R.layout.alojamientos_lista);
     
      lista = (ListView) findViewById(android.R.id.list);
 
      Db_Adapter = new AlojamientosDbAdapter(this);
      Db_Adapter.abrir();
 
    String categoria = getIntent().getStringExtra("Categoria");
    if (categoria.equals("hoteles"))
    	{
      consultarHoteles();
    	}
    
    if (categoria.equals("hostales"))
    	{
        consultarHostales();
        }
    
    if (categoria.equals("albergues"))
	{
    consultarAlbergues();
    }

    if (categoria.equals("apartamentos"))
	{
    consultarApartamentos();
    }
    
    if (categoria.equals("rural"))
	{
    consultarRural();
    }
}
 
   @SuppressWarnings("deprecation")
   private void consultarHoteles()
   {
	  cursor=Db_Adapter.getCursorSeleccionHoteles();
      startManagingCursor(cursor);
      alojamientos_Adapter = new AlojamientosCursorAdapter(this, cursor);
      lista.setAdapter(alojamientos_Adapter);
      ImageView btn = (ImageView)findViewById(R.id.imgbuttonbtnfijoalojamientos);
	  btn.setImageResource(R.drawable.boton_categorias_alojamientos_hotelazul);

   }
   
   @SuppressWarnings("deprecation")
private void consultarHostales()
   {
	  cursor=Db_Adapter.getCursorSeleccionHostales();
      startManagingCursor(cursor);
      alojamientos_Adapter = new AlojamientosCursorAdapter(this, cursor);
      lista.setAdapter(alojamientos_Adapter);
      ImageView btn = (ImageView)findViewById(R.id.imgbuttonbtnfijoalojamientos);
	  btn.setImageResource(R.drawable.boton_categorias_alojamientos_hostalesazul);

   }
 
   @SuppressWarnings("deprecation")
private void consultarAlbergues()
   {
	  cursor=Db_Adapter.getCursorSeleccionAlbergues();
      startManagingCursor(cursor);
      alojamientos_Adapter = new AlojamientosCursorAdapter(this, cursor);
      lista.setAdapter(alojamientos_Adapter);
      ImageView btn = (ImageView)findViewById(R.id.imgbuttonbtnfijoalojamientos);
	  btn.setImageResource(R.drawable.boton_categorias_alojamientos_alberguesazul);

   }
   
   @SuppressWarnings("deprecation")
private void consultarApartamentos()
   {
	  cursor=Db_Adapter.getCursorSeleccionApartamentosTuristicos();
      startManagingCursor(cursor);
      alojamientos_Adapter = new AlojamientosCursorAdapter(this, cursor);
      lista.setAdapter(alojamientos_Adapter);
      ImageView btn = (ImageView)findViewById(R.id.imgbuttonbtnfijoalojamientos);
	  btn.setImageResource(R.drawable.boton_categorias_alojamientos_apartamentosazul);

   }
   
   @SuppressWarnings("deprecation")
private void consultarRural()
   {
	  cursor=Db_Adapter.getCursorSeleccionRural();
      startManagingCursor(cursor);
      alojamientos_Adapter = new AlojamientosCursorAdapter(this, cursor);
      lista.setAdapter(alojamientos_Adapter);
      ImageView btn = (ImageView)findViewById(R.id.imgbuttonbtnfijoalojamientos);
	  btn.setImageResource(R.drawable.boton_categorias_alojamientos_alojamientoruralazul);

   }
   
   
   
   private void visualizar(long id)
	   {
	      Intent i = new Intent(Alojamientos_Lista.this, Alojamientos_TabSwipe.class);
	      i.putExtra(AlojamientosDbAdapter.C_ALO_COLUMNA_ID, id);
	      startActivityForResult(i, 1);
	    }
	
   protected void onListItemClick(ListView l, View v, int position, long id)
	   {
	      super.onListItemClick(l, v, position, id);
	      visualizar(id);
	   }
	
}


