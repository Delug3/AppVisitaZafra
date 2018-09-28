package clases_principales;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import ayto.zafrApp.R;
import clases_auxiliares.DB_Helper;


public class PantallaSplash_Activity extends Activity {
	
	  private DB_Helper dbHelper;
	
	private long splashDelay =3000; //6 segundos=6000
		
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     setContentView(R.layout.pantalla_splash);
	    //DELAY EN SPLASH PARA CREAR LA BASE DE DATOS
	    dbHelper = new DB_Helper(this);
	    dbHelper.getWritableDatabase();
	    dbHelper.close();
	    ///////////////////////////////////////  
	    TimerTask task = new TimerTask() {
	      @Override
	      public void run() {
	    	 
	        Intent mainIntent = new Intent().setClass(PantallaSplash_Activity.this, MenuPrincipal.class);
	        startActivity(mainIntent);
	        finish();//Destruimos esta activity para prevenir que el usuario retorne aqui presionando el boton Atras.
	      }
	    };

	    Timer timer = new Timer();
	    timer.schedule(task, splashDelay);//Pasado los segundos  dispara la tarea
	  }

}

