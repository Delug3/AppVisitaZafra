package alojamientos;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import ayto.zafrApp.R;


public class Alojamientos_Categorias extends Activity{
	private ImageView fondorandom;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alojamientos_categorias);	
		int array[]={R.drawable.res_aleatoria_1,R.drawable.res_aleatoria_2,R.drawable.res_aleatoria_3,R.drawable.res_aleatoria_4};
		Random rnd = new Random();
		//index 3 si hay 3 imagenes en array
  	    int index = rnd.nextInt(4);
  	    Drawable cur = getResources().getDrawable(array[index]); 
  	  fondorandom = (ImageView)findViewById(R.id.imagenfondoCategoriasAlojamientos);
  	  fondorandom.setBackgroundDrawable(cur);
		
		}
	
	public void verHoteles(View v) {
		Intent act = new Intent(this, Alojamientos_Lista.class);
		String opcion ="hoteles";
		act.putExtra("Categoria", opcion.toString()+"");
		startActivity(act);
		//Toast.makeText(this, getResources().getString(R.string.construccion), Toast.LENGTH_SHORT).show();
		}
	
	public void verHostales(View v) {
		Intent act = new Intent(this, Alojamientos_Lista.class);
		String opcion ="hostales";
		act.putExtra("Categoria", opcion.toString()+"");
		startActivity(act);
		}
	
	public void verApartamentos(View v) {
		Intent act = new Intent(this, Alojamientos_Lista.class);
		String opcion ="apartamentos";
		act.putExtra("Categoria", opcion.toString()+"");
		startActivity(act);
		}
	
	public void verRural(View v) {
		Intent act = new Intent(this, Alojamientos_Lista.class);
		String opcion ="rural";
		act.putExtra("Categoria", opcion.toString()+"");
		startActivity(act);
		}
	
	public void verAlbergues(View v) {
		Intent act = new Intent(this, Alojamientos_Lista.class);
		String opcion ="albergues";
		act.putExtra("Categoria", opcion.toString()+"");
		startActivity(act);
		}
	}
