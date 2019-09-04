package lunaalfuego.activities;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import ayto.zafrApp.R;


public class CategoriasLunaFuegoActivity extends Activity {
	
		protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		     setContentView(R.layout.lunafuego_categorias);
		}
		public void verProgramacion_Lista(View v)
		 {
			 Intent act =new Intent(this, ListaProgramacionActivity.class);
			 startActivity(act);
		 }
		
		public void verActividades_Lista(View v)
		 {
			 Intent act =new Intent(this, ListaActividadesActivity.class);
			 startActivity(act);
		 }
		
		public void verMapa_LunaFuego(View v)
		 {
			 Intent act =new Intent(this, SwipeMapaActivity.class);
			 startActivity(act);
		 }
		
		public void verGaleria_LunaFuego(View v)
		 {
			Intent act =new Intent(this, SwipeLunaFuegoActivity.class);
			startActivity(act);
		 }
	}


