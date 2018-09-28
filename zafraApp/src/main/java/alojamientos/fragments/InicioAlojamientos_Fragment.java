package alojamientos.fragments;
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

import alojamientos.adapters.AlojamientosDbAdapter;
import ayto.zafrApp.R;


public class InicioAlojamientos_Fragment extends Fragment{
	private TextView nombre;
	private TextView direccion;
	private ImageView imagen;
	private TextView telefono;
	private TextView email;
	private TextView web;
	private Context context;
    private AlojamientosDbAdapter Db_Adapter;
	private Cursor cursor;
	public Button btnboton;
	private long identificador ;
	LocationManager locManager;
	LocationListener locListener;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		 View rootView = inflater.inflate(R.layout.alojamientos_tabinicio, container, false);
		 
		 nombre=(TextView)rootView.findViewById(R.id.txtNombreAlojamiento);
		 direccion=(TextView)rootView.findViewById(R.id.txtDireccionAlojamientos);
		 telefono=(TextView)rootView.findViewById(R.id.txtTelefonoAlojamientos);
		 email=(TextView)rootView.findViewById(R.id.txtEmailAlojamientos);
		 web=(TextView)rootView.findViewById(R.id.txtWebAlojamientos);
		 imagen=(ImageView)rootView.findViewById(R.id.imgViewImagenAlojamiento);
	        
	     final Bundle args = getArguments();
	     identificador = args.getLong("ids");
		
	     Db_Adapter = new AlojamientosDbAdapter(context);
	     Db_Adapter.abrir();
	     cursor = Db_Adapter.getRegistro(identificador);
        
	     nombre.setText(cursor.getString(cursor.getColumnIndex(AlojamientosDbAdapter.C_ALO_COLUMNA_NOMBRE)));
	     telefono.setText(cursor.getString(cursor.getColumnIndex(AlojamientosDbAdapter.C_ALO_COLUMNA_TELEFONO)));
	     direccion.setText(cursor.getString(cursor.getColumnIndex(AlojamientosDbAdapter.C_ALO_COLUMNA_DIRECCION)));
	     email.setText(cursor.getString(cursor.getColumnIndex(AlojamientosDbAdapter.C_ALO_COLUMNA_EMAIL)));
	     web.setText(cursor.getString(cursor.getColumnIndex(AlojamientosDbAdapter.C_ALO_COLUMNA_WEB)));
       
	     String uri = cursor.getString(cursor.getColumnIndex(AlojamientosDbAdapter.C_ALO_COLUMNA_INICIOIMAGEN));
	     int Idfoto = this.getResources().getIdentifier(uri,null,getActivity().getPackageName());
       
         imagen.setImageResource(Idfoto);
        
       return rootView;
	}
}
