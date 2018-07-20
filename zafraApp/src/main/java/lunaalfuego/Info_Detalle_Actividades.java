package lunaalfuego;
import java.lang.reflect.Method;
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
import ayto.zafrApp.R;


public class Info_Detalle_Actividades extends AppCompatActivity {
	private ActionBar cabecera;
	WebView webinfo;
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     setContentView(R.layout.lunafuego_info);
	     cabecera = getSupportActionBar();
			@SuppressWarnings("deprecation")
			BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.boton_actionbar_lunafuego));
			cabecera.setBackgroundDrawable(background);
			cabecera.setDisplayUseLogoEnabled(false);
			cabecera.setDisplayHomeAsUpEnabled(false);
			cabecera.setDisplayShowHomeEnabled(false);
			cabecera.setDisplayShowTitleEnabled(false);
			webinfo = (WebView) findViewById(R.id.weblunafuegoinfo);
			
String actos = getIntent().getStringExtra("Actividad");

    if (actos.equals("Gastronomia"))
    	{
    	Gastronomia();
    	}
    if (actos.equals("Visitas"))
	{
    	Visitas();
	}
    if (actos.equals("Exposiciones"))
	{
    	Exposiciones();
	}
    if (actos.equals("Deporte"))
	{
    	Deporte();
	}
    if (actos.equals("Otras"))
	{
    	Otras();
	}
	}

	  private void Gastronomia()
	   {
		  /*TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Gastronomia));
		  stringevento.setText(sp);
		  */
		  String text;
			text = "<html><body><p align=\"justify\">";
			text+= getString(R.string.Gastronomia);
			text+= "</p></body></html>";
			webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
			webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
			webinfo.setFocusable(false);
	   }
	  
	  private void Visitas()
	   {
		/*  TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Visitas));
		  stringevento.setText(sp);
		  */
	   }
	  
	  private void Exposiciones()
	   {
		  /*TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Exposiciones));
		  stringevento.setText(sp);
		  */
	   }
	  
	  private void Deporte()
	   {
		 /* TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Deporte));
		  stringevento.setText(sp);*/
	   }
	  
	  private void Otras()
	   {
		 /* TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Otras));
		  stringevento.setText(sp);*/
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
			    		  webinfo.findAll(search.getText().toString());  
			    	    
			    	  try{  
			    	  	for(Method m : WebView.class.getDeclaredMethods()){
			    	          if(m.getName().equals("setFindIsUp")){
			    	              m.setAccessible(true);
			    	              m.invoke(webinfo, true);
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
		    	//busqueda();
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
