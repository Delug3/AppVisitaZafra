package lunaalfuego.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import ayto.zafrApp.R;


public class ListaActividadesActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     setContentView(R.layout.lunafuego_actividades_lista);
	}
	public void evento_Gastronomia(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleActividadesActivity.class);
		 String opcion ="Gastronomia";
		 act.putExtra("Actividad", opcion.toString()+"");
		 startActivity(act);
	 }
	
	public void evento_Visitas(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleActividadesActivity.class);
		 String opcion ="Visitas";
		 act.putExtra("Actividad", opcion.toString()+"");
		 startActivity(act);
	 }
	
	public void evento_Exposiciones(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleActividadesActivity.class);
		 String opcion ="Exposiciones";
		 act.putExtra("Actividad", opcion.toString()+"");
		 startActivity(act);
	 }
	
	public void evento_Deporte(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleActividadesActivity.class);
		 String opcion ="Deporte";
		 act.putExtra("Actividad", opcion.toString()+"");
		 startActivity(act);
	 }
	
	public void evento_Otras(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleActividadesActivity.class);
		 String opcion ="Otras";
		 act.putExtra("Actividad", opcion.toString()+"");
		 startActivity(act);
	 }
	
	
}
