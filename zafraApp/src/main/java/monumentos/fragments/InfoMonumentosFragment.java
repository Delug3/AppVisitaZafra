package monumentos.fragments;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import ayto.zafrApp.R;
import monumentos.adapters.DbMonumentosAdapter;

public class InfoMonumentosFragment extends Fragment {
	
	private TextView labelinfo;
	public WebView webtext;
	private DbMonumentosAdapter Db_Adapter;
    private Cursor cursor;
    private Context context;
    private long identificador;
    private ActionBar cabecera;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.monumentos_tabinfo, container, false);
		
		setHasOptionsMenu(true);
		
		labelinfo = (TextView)rootView.findViewById(R.id.label_Informacion);
		webtext  = (WebView)rootView.findViewById(R.id.web_texto_monumentos);
		webtext.setBackgroundColor(getResources().getColor(R.color.blanco));
		webtext.setFocusable(false);
		final Bundle args = getArguments();
		identificador = args.getLong("ids");
		 
		Db_Adapter = new DbMonumentosAdapter(context);
		Db_Adapter.abrir();
        cursor = Db_Adapter.getRegistro(identificador);
        
        labelinfo.setText(cursor.getString(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_NOMBRE)));
        //informacion.setText(cursor.getString(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_INFORMACION)));
       
        String jtext=(cursor.getString(cursor.getColumnIndex(DbMonumentosAdapter.C_MON_COLUMNA_INFORMACION)));
        String text;
		text = "<html><body><p align=\"justify\">";
		text+= jtext;
		text+= "</p></body></html>";
		webtext.loadDataWithBaseURL(null,text, "text/html","utf-8", null);
		
				
	    return rootView;
	}
	
	/*@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	   inflater.inflate(R.menu.buscador, menu);
	}
	*/
	
	
}


