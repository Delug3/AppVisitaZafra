package lunaalfuego.activities;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import ayto.zafrApp.R;


public class Categorias_LunaFuego_Activity extends Activity {
	
		protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		     setContentView(R.layout.lunafuego_categorias);
		}
		public void verProgramacion_Lista(View v)
		 {
			 Intent act =new Intent(this, Programacion_Lista_Activity.class);
			 startActivity(act);
		 }
		
		public void verActividades_Lista(View v)
		 {
			 Intent act =new Intent(this, Actividades_Lista_Activity.class);
			 startActivity(act);
		 }
		
		public void verMapa_LunaFuego(View v)
		 {
			 Intent act =new Intent(this, Swipe_Mapa_Activity.class);
			 startActivity(act);
		 }
		
		public void verGaleria_LunaFuego(View v)
		 {
			Intent act =new Intent(this, Swipe_LunaFuego_Activity.class);
			startActivity(act);
		 }
	}


