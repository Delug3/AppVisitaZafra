package monumentos.fragments;
import android.content.Context;
import android.database.Cursor;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import ayto.zafrApp.R;
import monumentos.adapters.DbMonumentosAdapter;


public class InicioMonumentosFragment extends Fragment {
	
	private TextView nombre;
	private TextView direccion;
	private ImageView imagen;
	private TextView telefono;
	private TextView horario;
	private TextView horariotag;
	private Context context;
    private DbMonumentosAdapter Db_Adapter;
	private Cursor cursor;
	public Button btnboton;
	private long identificador ;
	LocationManager locManager;
	LocationListener locListener;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		 View rootView = inflater.inflate(R.layout.monumentos_tabinicio, container, false);
		 
		 nombre=(TextView)rootView.findViewById(R.id.txtNombreMonumento);
		 direccion=(TextView)rootView.findViewById(R.id.txtDireccionMonumento);
		 telefono=(TextView)rootView.findViewById(R.id.txtTelefonoMonumento);
		 horario=(TextView)rootView.findViewById(R.id.txtHorarioMonumento);
		 imagen=(ImageView)rootView.findViewById(R.id.imgViewImagenMonumento);
	     horariotag=(TextView)rootView.findViewById(R.id.tagHorarioMonumento);
			   
	     final Bundle args = getArguments();
	     identificador = args.getLong("ids");
		
	     Db_Adapter = new DbMonumentosAdapter(context);
	     Db_Adapter.abrir();
	     cursor = Db_Adapter.getRegistro(identificador);
        
       nombre.setText(cursor.getString(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_NOMBRE)));
       telefono.setText(cursor.getString(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_TELEFONO)));
       direccion.setText(cursor.getString(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_DIRECCION)));
       horario.setText(cursor.getString(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_HORARIO)));
       String vacio=(cursor.getString(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_HORARIO)));
       
     //ocultar tag del horario si no esta disponible
       if (vacio == null || vacio.trim().equals(""))
    	{
       horariotag.setVisibility(View.GONE);
       }
       
       
       String uri = cursor.getString(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_INICIOIMAGEN));
       int Idfoto = this.getResources().getIdentifier(uri,null,getActivity().getPackageName());
       
       imagen.setImageResource(Idfoto);
        
       return rootView;
	}
}

