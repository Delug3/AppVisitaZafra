package monumentos;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import ayto.zafrApp.R;


public class MonumentosCursorAdapter extends CursorAdapter
{
 
   private MonumentosDbAdapter Db_Adapter = null ;
 
   @SuppressWarnings("deprecation")
   public MonumentosCursorAdapter(Context context, Cursor c)
   {
      super(context, c);
      Db_Adapter = new MonumentosDbAdapter(context);
      Db_Adapter.abrir();
   }
 
   @Override
   public void bindView(View view, Context context, Cursor cursor)
   {
   TextView tv = (TextView) view.findViewById(R.id.txtNombreMonumentos);
   tv.setText(cursor.getString(cursor.getColumnIndex(MonumentosDbAdapter.C_MON_COLUMNA_NOMBRE)));
   tv.setTextSize(20);  
   String uri = cursor.getString(cursor.getColumnIndex(MonumentosDbAdapter.C_MON_COLUMNA_ICONOIMAGEN));
   int Idfoto = context.getResources().getIdentifier(uri,null,context.getPackageName());
   ImageView im2= (ImageView)view.findViewById(R.id.ImgViewImagenMonumentos);
   im2.setImageResource(Idfoto);
   }
   
   @Override
   public View newView(Context context, Cursor cursor, ViewGroup parent)
   {
      final LayoutInflater inflater = LayoutInflater.from(context);
      final View view = inflater.inflate(R.layout.monumentos_row, parent, false);
 
      return view;
   }
}
