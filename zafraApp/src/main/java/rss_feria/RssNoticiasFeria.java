package rss_feria;

import java.util.HashMap;
import java.util.LinkedList;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import ayto.zafrApp.R;

public class RssNoticiasFeria extends AppCompatActivity {
	/**
	 * constantes necesarias a utilizar al guardar la informaci�n 
	 * en un HashMap, por el momento son necesarias para el parser
	 * de XML
	 * 
	 */
	static final String DATA_TITLE = "T";
	static final String DATA_LINK  = "L";
	/**
	 * Utilizaremos un SimpleAdapter que toma un listado de mapas para llenar su informaci�n, la 
	 * implementaci�n se realizar� con un LinkedList y un HashMap. Para este ejemplo utilizaremos un
	 * campo est�tico no final, es decir, una variable de clase, al realizar sus aplicaciones NO 
	 * deber�an hacerlo, lo correcto es utilizar clases de aplicaci�n, pero esto lo veremos hasta
	 * la siguiente gu�a. Adem�s, m�s adelante es buena idea utilizar otro almacenamiento no vol�til
	 * como una base de datos de SQLite.
	 */
	static LinkedList<HashMap<String, String>> data;

	/**
	 * Guardamos la direcci�n del feed como otra variable de clase para poder modificarla sin
	 * complicaciones m�s adelante.
	 */
	//static String feedUrl = "http://zafra.es/index.php/typography/tablon-de-anuncios-y-novedades?format=feed&type=rss";	
	static String feedUrlferia= "http://www.figzafra.es/index.php/menu-feria-de-zafra/noticias?format=feed&type=rss";
	
	/**
	 * para el di�logo de progreso es necesaria una variable global porque iniciamos el di�logo en
	 * una funci�n y lo ocultamos en otra
	 */
	private ProgressDialog progressDialog;
	
	/**
	 * Android nos presenta la restricciones que no podemos alterar los elementos de interfaz 
	 * gr�fica en un hilo de ejecuci�n que no sea el principal por lo que es necesario utilizar 
	 * un manejador(Handler) para enviar un mensaje de un hilo a otro cuando la carga de datos
	 * haya terminado.
	 */	
	private final Handler progressHandler = new Handler() {
		@SuppressWarnings("unchecked")
		public void handleMessage(Message msg) {
			if (msg.obj != null) {
				data = (LinkedList<HashMap<String, String>>)msg.obj;
				setData(data);					
			}
			progressDialog.dismiss();
	    }
	};
	
    /** Este m�todo es llamado cuando la actividad es creada */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss_noticiasferia);
        /** 
         * Le ponemos nombre a la ventana 
         */
      //  setTitle("Prueba Lector Rss Feed Ayuntamiento Zafra");
        
       // Button btn = (Button) findViewById(R.id.btnLoad);
        final ActionBar cabecera = getSupportActionBar();
		@SuppressWarnings("deprecation")
		BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.boton_actionbar_feriazafra));
		cabecera.setBackgroundDrawable(background);
		cabecera.setDisplayShowTitleEnabled(false);
		cabecera.setDisplayShowHomeEnabled(false);
		/**
         * personalizamos el evento del click del bot�n de carga  
         */
        loadData();
        
    				
    			/**
    			 * Si el ListView no contiene datos (es null) cargamos con loadData()
    			 */    				
    			
        
        ListView lv = (ListView) findViewById(R.id.lstDataFeria);
        /**
         * Cuando el usuario haga click en alg�n elemento de la lista, lo llevaremos al 
         * enlace del elemento a trav�s del navegador.
         */
        lv.setOnItemClickListener(new OnItemClickListener() {

    		@Override
    		public void onItemClick(AdapterView<?> av, View v, int position,
    				long id) {
		        /**
		         * Obtenemos el elemento sobre el que se presion�
		         */
    			HashMap<String, String> entry = data.get(position);

		        /**
		         * Preparamos el intent ACTION_VIEW y luego iniciamos la actividad (navegador en este caso)
		         */
    			Intent browserAction = new Intent(Intent.ACTION_VIEW, 
    					Uri.parse(entry.get(DATA_LINK)));
    			startActivity(browserAction);				
    		}
    	});        
    }
    
    /** 
     * Funci�n auxiliar que recibe una lista de mapas, y utilizando esta data crea un adaptador
     * para poblar al ListView del dise�o
     * */
    
    private void setData(LinkedList<HashMap<String, String>> data){
    	AdapterListaFeria sAdapter = new AdapterListaFeria(getApplicationContext(), data, 
    			R.layout.row_rssnoticiasferia, 
    			
    			new String[] { DATA_TITLE, DATA_LINK }, 
    			new int[] { R.id.txtrssnoticiasferia});
    	
    	ListView lv = (ListView) findViewById(R.id.lstDataFeria);
    	lv.setAdapter(sAdapter);
    }   
    
    /**
     * Funci�n auxiliar que inicia la carga de datos, muestra al usuario un di�logo de que
     * se est�n cargando los datos y levanta un thread para lograr la carga.
     */
    private void loadData() {
    	progressDialog = ProgressDialog.show(
    			RssNoticiasFeria.this,
    			"", 
    			"Cargando datos.Espere...", 
    			true);
    	
    	new Thread(new Runnable(){
    		@Override
    		public void run() {
    			XMLParserFeria parser = new XMLParserFeria(feedUrlferia); 
                Message msg = progressHandler.obtainMessage();
                msg.obj = parser.parse();
    			progressHandler.sendMessage(msg);
    			}}).start();
    }    
}
