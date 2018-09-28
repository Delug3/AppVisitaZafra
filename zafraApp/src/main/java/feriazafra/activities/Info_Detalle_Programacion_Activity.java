package feriazafra.activities;

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

public class Info_Detalle_Programacion_Activity extends AppCompatActivity {
	private ActionBar cabecera;
	WebView webinfo;
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     setContentView(R.layout.feriazafra_info);
	     cabecera = getSupportActionBar();
			@SuppressWarnings("deprecation")
			BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.boton_actionbar_feriazafra));
			cabecera.setBackgroundDrawable(background);
			cabecera.setDisplayUseLogoEnabled(false);
			cabecera.setDisplayHomeAsUpEnabled(false);
			cabecera.setDisplayShowHomeEnabled(false);
			cabecera.setDisplayShowTitleEnabled(false);
			webinfo = (WebView) findViewById(R.id.webferiazafrainfo);
			
String dia = getIntent().getStringExtra("Programacion");

    if (dia.equals("Jueves18"))
    	{
    	Jueves18();
    	}
    if (dia.equals("Viernes19"))
	{
    	Viernes19();
	}
    if (dia.equals("Sabado20"))
	{
    	Sabado20();
	}
    if (dia.equals("Domingo21"))
	{
    	Domingo21();
	}
    if (dia.equals("Lunes22"))
	{
    	Lunes22();
	}
    if (dia.equals("Martes23"))
	{
    	Martes23();
	}
    if (dia.equals("Miercoles24"))
	{
    	Miercoles24();
	}
    if (dia.equals("Jueves25"))
	{
    	Jueves25();
	}
    if (dia.equals("Viernes26"))
	{
    	Viernes26();
	}
    if (dia.equals("Sabado27"))
	{
    	Sabado27();
	}
    if (dia.equals("Domingo28"))
	{
    	Domingo28();
	}
    if (dia.equals("Lunes29"))
	{
    	Lunes29();
	}
    
    if (dia.equals("Martes30"))
	{
    	Martes30();
	}
    
    if (dia.equals("Miercoles1"))
	{
    	Miercoles1();
	}
    
    if (dia.equals("Jueves2"))
	{
    	Jueves2();
	}
    
    if (dia.equals("Viernes3"))
	{
    	Viernes3();
	}
   
    if (dia.equals("Sabado4"))
	{
    	Sabado4();
	}
    
    if (dia.equals("Domingo5"))
	{
    	Domingo5();
	}
    
    if (dia.equals("Lunes6"))
	{
    	Lunes6();
	}
    
    if (dia.equals("Martes7"))
   	{
    	Martes7();
   	}
    
    if (dia.equals("Miercoles8"))
   	{
    	Miercoles8();
   	}
    
    if (dia.equals("ActInteres"))
   	{
    	ActInteres();
   	}
    
    if (dia.equals("ExposicionesArte"))
   	{
    	ExposicionesArte();
   	}
    
    if (dia.equals("Sabado11"))
   	{
    	Sabado11();
   	}
    
    if (dia.equals("Sabado18"))
   	{
    	Sabado18();
   	}
    
    if (dia.equals("Domingo19"))
   	{
    	Domingo19();
   	}
    
    
    
    
    }

	 

	private void Domingo19() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Domingo19);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Sabado18() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Sabado18);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Sabado11() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Sabado11);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void ExposicionesArte() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.exposicionesarte);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void ActInteres() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.actinteres);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Miercoles8() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Miercoles8);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Martes7() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Martes7);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Lunes6() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Lunes6);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Domingo5() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Domingo5);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Sabado4() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Sabado4);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Viernes3() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Viernes3);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Jueves2() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Jueves2);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Miercoles1() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Miercoles1);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Martes30() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Martes30);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Lunes29() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Lunes29);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Domingo28() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Domingo28);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Sabado27() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Sabado27);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Viernes26() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Viernes26);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Jueves25() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Jueves25);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Miercoles24() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Miercoles24);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Martes23() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Martes23);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Lunes22() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Lunes22);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Domingo21() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Domingo21);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Sabado20() {
		String text;
		text = "<html><body><p align=\"justify\">";
		text+= getString(R.string.Sabado20);
		text+= "</p></body></html>";
		webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
		webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
		webinfo.setFocusable(false);
	}



	private void Jueves18()
	   {
		  /*TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Gastronomia));
		  stringevento.setText(sp);
		  */
		  String text;
			text = "<html><body><p align=\"justify\">";
			text+= getString(R.string.Jueves18);
			text+= "</p></body></html>";
			webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
			webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
			webinfo.setFocusable(false);
	   }
	  
	 private void Viernes19() {
		 String text;
			text = "<html><body><p align=\"justify\">";
			text+= getString(R.string.Viernes19);
			text+= "</p></body></html>";
			webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
			webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
			webinfo.setFocusable(false);	
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
			  cabecera.setDisplayUseLogoEnabled(false);
				cabecera.setDisplayHomeAsUpEnabled(false);
				cabecera.setDisplayShowHomeEnabled(false);
				cabecera.setDisplayShowTitleEnabled(false);
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
	  
	  
	  
	  
	  
	  
	  

