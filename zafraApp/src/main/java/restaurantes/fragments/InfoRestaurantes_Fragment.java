package restaurantes.fragments;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import ayto.zafrApp.R;
import restaurantes.adapters.RestaurantesDb_Adapter;


public class InfoRestaurantes_Fragment extends Fragment {

	private WebView webtext;
	private TextView labelinfo;
	private RestaurantesDb_Adapter Db_Adapter;
    private Cursor cursor;
    private Context context;
    private long identificador;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.restaurantes_tabinfo, container, false);
		
		labelinfo = (TextView)rootView.findViewById(R.id.label_Informacion);
		webtext  = (WebView)rootView.findViewById(R.id.web_texto_restaurantes);
		
		
		final Bundle args = getArguments();
		identificador = args.getLong("ids");
		 
		Db_Adapter = new RestaurantesDb_Adapter(context);
		Db_Adapter.abrir();
        cursor = Db_Adapter.getRegistro(identificador);
        
        labelinfo.setText(cursor.getString(cursor.getColumnIndex(RestaurantesDb_Adapter.C_RES_COLUMNA_NOMBRE)));
        String jtext=(cursor.getString(cursor.getColumnIndex(RestaurantesDb_Adapter.C_RES_COLUMNA_INFORMACION)));
        String text;
		text = "<html><body><p align=\"justify\">";
		text+= jtext;
		text+= "</p></body></html>";
		webtext.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webtext.setBackgroundColor(getResources().getColor(R.color.blanco));
        return rootView;
	}
}
