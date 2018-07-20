package restaurantes;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ayto.zafrApp.R;


public class RestaurantesCursorAdapter extends CursorAdapter
{
 private RestaurantesDbAdapter Db_Adapter = null ;
 
 
   @SuppressWarnings("deprecation")
   public RestaurantesCursorAdapter(Context context, Cursor c)
   {
      super(context, c);
      Db_Adapter = new RestaurantesDbAdapter(context);
      Db_Adapter.abrir();
   }
 
   @Override
   public void bindView(View view, Context context, Cursor cursor)
   {
   TextView tv = (TextView) view.findViewById(R.id.txtNombreRestaurante);
   tv.setText(cursor.getString(cursor.getColumnIndex(RestaurantesDbAdapter.C_RES_COLUMNA_NOMBRE)));
   tv.setTextSize(20);  
   String uri = cursor.getString(cursor.getColumnIndex(RestaurantesDbAdapter.C_RES_COLUMNA_ICONOIMAGEN));
   int Idfoto = context.getResources().getIdentifier(uri,null,context.getPackageName());
   ImageView im2= (ImageView)view.findViewById(R.id.ImgViewImagenRestaurantes);
   
   if (uri == null || uri.trim().equals(""))
	{
	 im2.setImageResource(R.drawable.res_auxiliares_icononodisposible); 
	}
   else
   {
	   im2.setImageResource(Idfoto);  
   }
   
  }
   
   @Override
   public View newView(Context context, Cursor cursor, ViewGroup parent)
   {
      final LayoutInflater inflater = LayoutInflater.from(context);
      final View view = inflater.inflate(R.layout.restaurantes_row, parent, false);
     return view;
   }
}

