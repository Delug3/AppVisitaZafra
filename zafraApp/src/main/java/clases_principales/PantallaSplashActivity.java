package clases_principales;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import ayto.zafrApp.R;
import clases_auxiliares.DbHelper;


public class PantallaSplashActivity extends Activity {
	
	  private DbHelper dbHelper;
	
	private long splashDelay =3000; //6 segundos=6000
		
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     setContentView(R.layout.pantalla_splash);
	    //DELAY EN SPLASH PARA CREAR LA BASE DE DATOS
	    dbHelper = new DbHelper(this);
	    dbHelper.getWritableDatabase();
	    dbHelper.close();
	    ///////////////////////////////////////  
	    TimerTask task = new TimerTask() {
	      @Override
	      public void run() {
	    	 
	        Intent mainIntent = new Intent().setClass(PantallaSplashActivity.this, MenuPrincipalActivity.class);
	        startActivity(mainIntent);
	        finish();//Destruimos esta activity para prevenir que el usuario retorne aqui presionando el boton Atras.
	      }
	    };

	    Timer timer = new Timer();
	    timer.schedule(task, splashDelay);//Pasado los segundos  dispara la tarea
	  }

}

