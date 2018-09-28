package restaurantes.activities;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import ayto.zafrApp.R;


public class Restaurantes_Categorias_Activity extends Activity{
		private ImageView fondorandom;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.restaurantes_categorias);	
			int array[]={R.drawable.res_aleatoria_1,R.drawable.res_aleatoria_2,R.drawable.res_aleatoria_3,R.drawable.res_aleatoria_4};
			Random rnd = new Random();
			//index 3 si hay 3 imagenes en array
	  	    int index = rnd.nextInt(4);
	  	    Drawable cur = getResources().getDrawable(array[index]); 
	  	  fondorandom = (ImageView)findViewById(R.id.imagenfondoCategoriasRestaurantes);
	  	  fondorandom.setBackgroundDrawable(cur);
		}
				
		public void verCocinaTradicional(View v) {
			Intent act = new Intent(this, Restaurantes_Lista_Activity.class);
			String opcion ="tradicional";
			act.putExtra("Categoria", opcion.toString()+"");
			startActivity(act);
			//Toast.makeText(this, getResources().getString(R.string.construccion), Toast.LENGTH_SHORT).show();
			}
		
		public void verCocinaInternacional(View v) {
			Intent act = new Intent(this, Restaurantes_Lista_Activity.class);
			String opcion ="internacional";
			act.putExtra("Categoria", opcion.toString()+"");
			startActivity(act);
			}
		
		public void verCocinaAlaCarta(View v) {
			Intent act = new Intent(this, Restaurantes_Lista_Activity.class);
			String opcion ="carta";
			act.putExtra("Categoria", opcion.toString()+"");
			startActivity(act);
			}
		
		public void verCocinaTapas(View v) {
			Intent act = new Intent(this, Restaurantes_Lista_Activity.class);
			String opcion ="tapas";
			act.putExtra("Categoria", opcion.toString()+"");
			startActivity(act);
			}
		
		public void verCocinaLlevar(View v) {
			Intent act = new Intent(this, Restaurantes_Lista_Activity.class);
			String opcion ="llevar";
			act.putExtra("Categoria", opcion.toString()+"");
			startActivity(act);
			}
		
		public void verCocinaCatering(View v) {
			Intent act = new Intent(this, Restaurantes_Lista_Activity.class);
			String opcion ="catering";
			act.putExtra("Categoria", opcion.toString()+"");
			startActivity(act);
			}
}










