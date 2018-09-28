package leyendas.Activities;

import java.lang.reflect.Method;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import ayto.zafrApp.R;
import clases_principales.MenuPrincipal;


public class MostrarItem_Leyendas_Activity extends AppCompatActivity {
	// Declare Variables
	TextView txtnombre;
	WebView webleyenda;
	String[] nombre;
	String[] leyenda;
	int posicion;
	private LinearLayout container;  
	private Button btnsiguiente, btncerrar;  
	private EditText edbusqueda;  
	private ActionBar cabecera;
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.leyendas_mostraritem);
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
		nombre = i.getStringArrayExtra("nombre");
		// Get the list of country
		leyenda = i.getStringArrayExtra("leyenda");
		
		txtnombre = (TextView) findViewById(R.id.nombre);
		webleyenda = (WebView) findViewById(R.id.leyenda);
		
		// Load the text into the TextViews followed by the position
		txtnombre.setText(nombre[posicion]);
		
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= leyenda[posicion];
		text+= "</p></body></html>";
		webleyenda.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webleyenda.setBackgroundColor(getResources().getColor(R.color.blanco));
		webleyenda.setFocusable(false);
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
		    		  webleyenda.findAll(search.getText().toString());  
		    	    
		    	  try{  
		    	  	for(Method m : WebView.class.getDeclaredMethods()){
		    	          if(m.getName().equals("setFindIsUp")){
		    	              m.setAccessible(true);
		    	              m.invoke(webleyenda, true);
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
	    	 Intent myIntent = new Intent(getApplicationContext(), MenuPrincipal.class);
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
	    
	//Opcion de busqueda(funciona pero descartada)
   public void busqueda()
    {  
    container = (LinearLayout)findViewById(R.id.layoutId);  
    edbusqueda = new EditText(this);  
  //para limitar numero de letras en el edittext
  edbusqueda.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});  
  edbusqueda.setSingleLine(true);  

  edbusqueda.setHint("busqueda...");  
    
  edbusqueda.setOnKeyListener(new OnKeyListener(){  
  @SuppressWarnings("deprecation")
public boolean onKey(View v, int keyCode, KeyEvent event){  
  if((event.getAction() == KeyEvent.ACTION_DOWN) && ((keyCode == KeyEvent.KEYCODE_ENTER))){  
	  webleyenda.findAll(edbusqueda.getText().toString());  
    
  try{  
  	for(Method m : WebView.class.getDeclaredMethods()){
          if(m.getName().equals("setFindIsUp")){
              m.setAccessible(true);
              m.invoke(webleyenda, true);
              break;
          }
      } 
  }catch(Exception ignored){}  
  }  
  return false;  
  }  
  });  
    container.addView(edbusqueda);  
  	btnsiguiente= new Button(this);  
    btnsiguiente.setText("--->");  
    btnsiguiente.setOnClickListener(new OnClickListener(){  
    	
@Override  
public void onClick(View v){  
	webleyenda.findNext(true);  
}  
});  
    container.addView(btnsiguiente);  
    btncerrar = new Button(this);  
    btncerrar.setText("(X)");  
    btncerrar.setOnClickListener(new OnClickListener(){  
@Override  
public void onClick(View v){  
container.removeAllViews();  
 
}  
});  
    container.addView(btncerrar);  
    }  
    
}
