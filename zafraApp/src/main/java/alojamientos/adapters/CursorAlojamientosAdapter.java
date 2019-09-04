package alojamientos.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ayto.zafrApp.R;


public class CursorAlojamientosAdapter extends CursorAdapter{
	private DbAlojamientosAdapter Db_Adapter = null ;
	 
	   @SuppressWarnings("deprecation")
	   public CursorAlojamientosAdapter(Context context, Cursor c)
	   {
	      super(context, c);
	      Db_Adapter = new DbAlojamientosAdapter(context);
	      Db_Adapter.abrir();
	   }
	 
	   @Override
	   public void bindView(View view, Context context, Cursor cursor)
	   {
	   TextView tv = (TextView) view.findViewById(R.id.txtNombreAlojamiento);
	   tv.setText(cursor.getString(cursor.getColumnIndex(DbAlojamientosAdapter.C_ALO_COLUMNA_NOMBRE)));
	   tv.setTextSize(20);  
	   String uri = cursor.getString(cursor.getColumnIndex(DbAlojamientosAdapter.C_ALO_COLUMNA_ICONOIMAGEN));
	   int Idfoto = context.getResources().getIdentifier(uri,null,context.getPackageName());
	   ImageView im2= (ImageView)view.findViewById(R.id.ImgViewImagenAlojamientos);
	   if (uri == null || uri.trim().equals(""))
		{
		 im2.setImageResource(R.drawable.res_auxiliares_icononodisposible); 
		}
	   else
	   {
		   im2.setImageResource(Idfoto);  
	   }
	 
	   String uri2 = cursor.getString(cursor.getColumnIndex(DbAlojamientosAdapter.C_ALO_COLUMNA_ESTRELLAFOTO));
	   int Idfoto2 = context.getResources().getIdentifier(uri2,null,context.getPackageName());
	   ImageView im3= (ImageView)view.findViewById(R.id.ImgViewEstrella);
	   im3.setImageResource(Idfoto2);
	   
	   
	   }
	   
	   @Override
	   public View newView(Context context, Cursor cursor, ViewGroup parent)
	   {
	      final LayoutInflater inflater = LayoutInflater.from(context);
	      final View view = inflater.inflate(R.layout.alojamientos_row, parent, false);
	 
	      return view;
	   }
}
