package feriazafra;

import java.util.Random;

import rss_feria.RssNoticiasFeria;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import ayto.zafrApp.R;


public class Categorias_FeriaZafra extends Activity{
	private ImageView fondorandom;
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     setContentView(R.layout.feriazafra_categorias);
	     int array[]={R.drawable.res_feria_aleatoria_1,R.drawable.res_feria_aleatoria_2,R.drawable.res_feria_aleatoria_3,R.drawable.res_feria_aleatoria_4,R.drawable.res_feria_aleatoria_5,R.drawable.res_feria_aleatoria_6};
			Random rnd = new Random();
			//index 3 si hay 3 imagenes en array
	  	    int index = rnd.nextInt(6);
	  	    Drawable cur = getResources().getDrawable(array[index]); 
	  	  fondorandom = (ImageView)findViewById(R.id.imagenfondoCategoriasFeriaZafra);
	  	  fondorandom.setBackgroundDrawable(cur);
	}
	
	public void verProgramaFeria_Lista(View v)
	 {
		Intent act =new Intent(this,Programacion_Lista.class);
		startActivity(act);
	 }
	
	public void verNoticiasFeria(View v)
	 {
		 if (existeConexionInternet()){
				Intent act = new Intent(this, RssNoticiasFeria.class);
				startActivity(act);
				}else{
				   Toast.makeText(this, getResources().getString(R.string.conexion), Toast.LENGTH_LONG).show();
				}
	 }
	
	
	public void verExpositoresFeria_Lista(View v)
	 {
		 Intent act =new Intent(this,Expositores_Lista.class);
		 startActivity(act);
	 }
	
	public void verPlanoFeria(View v)
	 {
		Intent act =new Intent(this,Plano_Feria.class);
		startActivity(act);
	 }
	
	public void verGaleriaFotosFeria(View v)
	 {
		Intent act =new Intent(this,Swipe_GaleriaZafra.class);
		startActivity(act);
	 }
	
	public void InformacionInteresFeria(View v)
	 {
		Intent act =new Intent(this,Informacion_Interes.class);
		startActivity(act);
	 }
	
	public void ComoLlegarFeria(View v)
	 {
		if (existeConexionInternet())
		{
		  final Double latgps = 38.426060522646374;
		  final Double longps = -6.410529743347183;
				Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
		              Uri.parse("http://maps.google.com/maps?&daddr="+latgps+","+longps));
				startActivity(intent);
		}else{
			   Toast.makeText(this, getResources().getString(R.string.conexion), Toast.LENGTH_LONG).show();
			}
	 }
	
	 public boolean existeConexionInternet() {
		   ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		   NetworkInfo netInfo = cm.getActiveNetworkInfo();
		   if (netInfo != null && netInfo.isConnectedOrConnecting()) {
		      return true;
		   }
		   return false;
		}
}
