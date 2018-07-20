package lunaalfuego;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import ayto.zafrApp.R;


public class Programacion_Lista extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     setContentView(R.layout.lunafuego_programacion_lista);
	     
	}
	public void evento_Dia_20(View v)
	 {
		 Intent act =new Intent(this,Info_Detalle_Programacion.class);
		 String opcion ="Dia 20";
		 act.putExtra("Dia", opcion.toString()+"");
		 startActivity(act);
	 }
	
	public void evento_Dia_21(View v)
	 {
		 Intent act =new Intent(this,Info_Detalle_Programacion.class);
		 String opcion ="Dia 21";
		 act.putExtra("Dia", opcion.toString()+"");
		 startActivity(act);
	 }
	
	public void evento_Dia_22(View v)
	 {
		 Intent act =new Intent(this,Info_Detalle_Programacion.class);
		 String opcion ="Dia 22";
		 act.putExtra("Dia", opcion.toString()+"");
		 startActivity(act);
	 }
	
	public void evento_Dia_23(View v)
	 {
		 Intent act =new Intent(this,Info_Detalle_Programacion.class);
		 String opcion ="Dia 23";
		 act.putExtra("Dia", opcion.toString()+"");
		 startActivity(act);
	 }
	
	public void evento_Dia_24(View v)
	 {
		 Intent act =new Intent(this,Info_Detalle_Programacion.class);
		 String opcion ="Dia 24";
		 act.putExtra("Dia", opcion.toString()+"");
		 startActivity(act);
	 }
	
	public void evento_Dia_25(View v)
	 {
		 Intent act =new Intent(this,Info_Detalle_Programacion.class);
		 String opcion ="Dia 25";
		 act.putExtra("Dia", opcion.toString()+"");
		 startActivity(act);
	 }
	
	public void evento_Dia_26(View v)
	 {
		 Intent act =new Intent(this,Info_Detalle_Programacion.class);
		 String opcion ="Dia 26";
		 act.putExtra("Dia", opcion.toString()+"");
		 startActivity(act);
	 }
	
	public void evento_Dia_27(View v)
	 {
		 Intent act =new Intent(this,Info_Detalle_Programacion.class);
		 String opcion ="Dia 27";
		 act.putExtra("Dia", opcion.toString()+"");
		 startActivity(act);
	 }
	
	public void evento_Dia_28(View v)
	 {
		 Intent act =new Intent(this,Info_Detalle_Programacion.class);
		 String opcion ="Dia 28";
		 act.putExtra("Dia", opcion.toString()+"");
		 startActivity(act);
	 }
	
	public void evento_Dia_29(View v)
	 {
		 Intent act =new Intent(this,Info_Detalle_Programacion.class);
		 String opcion ="Dia 29";
		 act.putExtra("Dia", opcion.toString()+"");
		 startActivity(act);
	 }
	
}
