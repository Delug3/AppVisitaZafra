package clases_principales;

import java.util.Random;

import leyendas.Activities.Leyendas_Lista_Activity;
import monumentos.activities.Monumentos_Lista_Activity;
import personajes.activity.Personajes_Lista_Activity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import ayto.zafrApp.R;

public class Zafra_Categorias_Activity extends Activity {
	private ImageView fondorandom;
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     setContentView(R.layout.zafra_categorias);
	   //IMAGENES BACKGROUND ALEATORIAS
			int array[]={R.drawable.res_aleatoria_1,R.drawable.res_aleatoria_2,R.drawable.res_aleatoria_3,R.drawable.res_aleatoria_4};
			Random rnd = new Random();
			//index 3 si hay 3 imagenes en array
	  	    int index = rnd.nextInt(4);
	  	    Drawable cur = getResources().getDrawable(array[index]); 
	  	  fondorandom = (ImageView)findViewById(R.id.imagenfondoCategoriasZafra);
	  	  fondorandom.setBackgroundDrawable(cur);
}
	public void VerMonumentos(View v)
	 {
		 Intent act =new Intent(this, Monumentos_Lista_Activity.class);
		 startActivity(act);
	 }
	
	public void VerLeyendas(View v)
	 {
		 Intent act =new Intent(this, Leyendas_Lista_Activity.class);
		 startActivity(act);
	 }
	
	public void VerPersonajes(View v)
	 {
		 Intent act =new Intent(this, Personajes_Lista_Activity.class);
		 startActivity(act);
	 }
	
	
	
	
}