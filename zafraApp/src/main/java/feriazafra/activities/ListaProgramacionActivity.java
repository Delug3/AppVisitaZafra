package feriazafra.activities;


import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import ayto.zafrApp.R;

public class ListaProgramacionActivity extends Activity {
	private ImageView fondorandom;
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     setContentView(R.layout.feriazafra_programacion_lista);
	     int array[]={R.drawable.res_feria_aleatoria_1,R.drawable.res_feria_aleatoria_2,R.drawable.res_feria_aleatoria_3,R.drawable.res_feria_aleatoria_4,R.drawable.res_feria_aleatoria_5,R.drawable.res_feria_aleatoria_6};
			Random rnd = new Random();
			//index 3 si hay 3 imagenes en array
	  	    int index = rnd.nextInt(6);
	  	    Drawable cur = getResources().getDrawable(array[index]); 
	  	  fondorandom = (ImageView)findViewById(R.id.imagenfondoFeriaZafra);
	  	  fondorandom.setBackgroundDrawable(cur);
	}
	public void Jueves18(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Jueves18";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Viernes19(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Viernes19";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Sabado20(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Sabado20";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Domingo21(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Domingo21";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Lunes22(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Lunes22";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Martes23(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Martes23";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Miercoles24(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Miercoles24";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Jueves25(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Jueves25";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Viernes26(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Viernes26";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Sabado27(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Sabado27";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Domingo28(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Domingo28";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Lunes29(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Lunes29";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Martes30(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Martes30";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Miercoles1(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Miercoles1";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Jueves2(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Jueves2";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Viernes3(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Viernes3";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Sabado4(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Sabado4";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Domingo5(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Domingo5";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Lunes6(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Lunes6";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Martes7(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Martes7";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Miercoles8(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Miercoles8";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void ActInteres(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="ActInteres";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void ExposicionesArte(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="ExposicionesArte";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Sabado11(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Sabado11";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Sabado18(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Sabado18";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	public void Domingo19(View v)
	 {
		 Intent act =new Intent(this, InfoDetalleProgramacionActivity.class);
		 String dia ="Domingo19";
		 act.putExtra("Programacion", dia.toString()+"");
		 startActivity(act);
	 }
	
	
}
