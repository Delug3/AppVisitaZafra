package personajes.activity;

import java.lang.reflect.Method;

import clases_principales.MenuPrincipalActivity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import ayto.zafrApp.R;

public class MostrarItemPersonajesActivity extends AppCompatActivity {
	// Declare Variables
	TextView txtpersonaje;
	WebView webvida;
	String[] personaje;
	String[] vida;
	int posicion;
	private ActionBar cabecera;
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personajes_mostraritem);
		cabecera = getSupportActionBar();
		BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.boton_actionbar));
		cabecera.setBackgroundDrawable(background);
		
		cabecera.setDisplayUseLogoEnabled(true);
		cabecera.setDisplayHomeAsUpEnabled(true);
		cabecera.setDisplayShowTitleEnabled(false);
		

		// Retrieve data from MainActivity on listview item click
		Intent i = getIntent();
		// Get a single position
		posicion = i.getExtras().getInt("posicion");
		// Get the list of rank
		personaje = i.getStringArrayExtra("personaje");
		// Get the list of country
		vida = i.getStringArrayExtra("vida");
		
		//String leye = String.valueOf(leyenda[posicion]);
		//Toast.makeText(this, "Txt: "+leye, Toast.LENGTH_SHORT).show();
		
		// Locate the TextViews in singleitemview.xml
		txtpersonaje = (TextView) findViewById(R.id.personaje);
		webvida = (WebView) findViewById(R.id.vida);
		
		// Load the text into the TextViews followed by the position
		txtpersonaje.setText(personaje[posicion]);
		
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= vida[posicion];
		text+= "</p></body></html>";
		webvida.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webvida.setBackgroundColor(getResources().getColor(R.color.blanco));
		webvida.setFocusable(false);
		}
	public boolean onOptionsItemSelected(MenuItem item){
		  
		 switch (item.getItemId()) {
		 case R.id.buscar:
		    	cabecera.setCustomView(R.layout.buscar);
			    final EditText search = (EditText) cabecera.getCustomView().findViewById(R.id.searchfield);
			   
			    search.setHint("Busqueda...");  
			    search.setOnKeyListener(new OnKeyListener(){  
			    	  @SuppressWarnings("deprecation")
					public boolean onKey(View v, int keyCode, KeyEvent event){  
			    	  if((event.getAction() == KeyEvent.ACTION_DOWN) && ((keyCode == KeyEvent.KEYCODE_ENTER))){  
			    		  webvida.findAll(search.getText().toString());  
			    	    
			    	  try{  
			    	  	for(Method m : WebView.class.getDeclaredMethods()){
			    	          if(m.getName().equals("setFindIsUp")){
			    	              m.setAccessible(true);
			    	              m.invoke(webvida, true);
			    	              break;
			    	          }
			    	      } 
			    	  }catch(Exception ignored){}  
			    	  }  
			    	  return false;  
			    	  }  
			    	  });  
			  cabecera.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM
				        | ActionBar.DISPLAY_SHOW_HOME);
		    	
		    return true;
	        
	    case android.R.id.home:
	    	 Intent myIntent = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
	         myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
	         startActivity(myIntent);
	    return true;
	    
	    default:
	       
	    return true;
	    }
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.buscador, menu);
		return true;
		}
	    
}

