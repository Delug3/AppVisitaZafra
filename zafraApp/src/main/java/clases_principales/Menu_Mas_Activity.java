package clases_principales;

import java.util.Random;

import radio.activities.Radio_Activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import ayto.zafrApp.R;


public class Menu_Mas_Activity extends Activity{
	private ImageView fondorandom;
	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     setContentView(R.layout.menu_mas);

	     int array[]={R.drawable.res_aleatoria_1,R.drawable.res_aleatoria_2,R.drawable.res_aleatoria_3,R.drawable.res_aleatoria_4};
			Random rnd = new Random();
			//index 3 si hay 3 imagenes en array
	  	    int index = rnd.nextInt(4);
	  	    Drawable cur = getResources().getDrawable(array[index]); 
	  	  fondorandom = (ImageView)findViewById(R.id.imagenfondomas);
	  	  fondorandom.setBackgroundDrawable(cur);

		int MY_PERMISSIONS_REQUEST_CAMERA=0;

		if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
		{
			if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA))
			{

			}
			else
			{
				ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA ); }
		}
	 	}
	
	public void verLectorQR(View v)
	 {
		 if (existeConexionInternet())
		 {

			 Intent intent = new Intent("app.proyecto.visitazafra.SCAN");
			 intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
			 startActivityForResult(intent, 0); 
		 }else{
			   Toast.makeText(this, getResources().getString(R.string.conexion), Toast.LENGTH_LONG).show();
			}
	 }
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    if (requestCode == 0) {
	        if (resultCode == RESULT_OK) {
	            String contenido = intent.getStringExtra("SCAN_RESULT");
	            Intent i = new Intent(this, LectorQR_Activity.class);
	  		   i.putExtra("contenido", contenido);
	  			startActivity(i);
	  		// Hacer algo con los datos obtenidos.
	        } else if (resultCode == RESULT_CANCELED) {
	            // Si se cancelo la captura.
	        }
	    }
	}
	
	public void verMas(View v)
	 {
		 Intent act =new Intent(this, AcercaDe_Activity.class);
		 startActivity(act);
	 }
	
	public void verRadio(View v)
	 {
		if (existeConexionInternet()){
			Intent act =new Intent(this, Radio_Activity.class);
			 startActivity(act);
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
