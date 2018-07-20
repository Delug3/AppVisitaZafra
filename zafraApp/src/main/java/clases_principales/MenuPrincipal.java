package clases_principales;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Random;

import ayto.zafrApp.BuildConfig;
import lunaalfuego.Categorias_LunaFuego;
import restaurantes.Restaurantes_Categorias;
import rss.RssNoticias;
import alojamientos.Alojamientos_Categorias;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import ayto.zafrApp.R;
import feriazafra.Categorias_FeriaZafra;


public class MenuPrincipal extends Activity{
	private ImageView fondorandom;
	Button btn;
@SuppressWarnings("deprecation")
protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    requestWindowFeature(Window.FEATURE_NO_TITLE);    
	        
		     setContentView(R.layout.menu_principal);

		   //IMAGENES BACKGROUND ALEATORIAS
				int array[]={R.drawable.res_aleatoria_1,R.drawable.res_aleatoria_2,R.drawable.res_aleatoria_3,R.drawable.res_aleatoria_4};
				Random rnd = new Random();
				//index 3 si hay 3 imagenes en array
		  	    int index = rnd.nextInt(4);
		  	    Drawable cur = getResources().getDrawable(array[index]); 
		  	  fondorandom = (ImageView)findViewById(R.id.imagenfondo);
		  	  fondorandom.setBackgroundDrawable(cur);
		     //REQUIERE API LVL 11
		  	
		     btn = (Button)findViewById(R.id.btnidiomasleccion);
		     btn.setOnClickListener(new OnClickListener() {

					//alternativa a oncontext menu o dialog de single choice
	public void onClick(final View v) {
				PopupMenu popup = new PopupMenu(MenuPrincipal.this, v);
					popup.getMenuInflater().inflate(R.menu.opcion, popup.getMenu());
					popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {					
						@Override
						public boolean onMenuItemClick(MenuItem item ) {
							CharSequence resultado=item.getTitle();
								if (resultado.equals("Espanol")){
									   cambiarIdiomaEspanol(v );
									      }
									    if (resultado.equals("English")){
									   cambiarIdiomaIngles(v );
									      }
									   return true;
									   }
						});
						popup.show();
						}
				});

		        
		  	
	 }



	 public void verZafra(View v)
	 {
		 Intent act = new Intent(this, Zafra_Categorias.class);
		 startActivity(act);
		 
	 }
	 
	 public void verCategoriasRestaurantes(View v)
	 {
		 Intent act =new Intent(this,Restaurantes_Categorias.class);
		 startActivity(act);
	 }
	 
	 public void verCategoriasAlojamientos(View v)
	 {
		 Intent act =new Intent(this,Alojamientos_Categorias.class);
		 startActivity(act);
	 }
	 
	 public void verMas(View v)
	 {

		 Intent act =new Intent(this,Menu_Mas.class);
		 startActivity(act);
	 }
	 
	 public void verRssNoticias(View v)
	 {
		 if (existeConexionInternet()){
				Intent act = new Intent(this, RssNoticias.class);
				startActivity(act);
				}else{
				   Toast.makeText(this, getResources().getString(R.string.conexion), Toast.LENGTH_LONG).show();
				}
	 }
	 
	 public void verAgenda(View v)
	 {
		 if (existeConexionInternet()){
				
			//Intent act = new Intent(this, Boletin.class);
				//startActivity(act);
				new DownloadPDFTask().execute("http://www.visitazafra.com/images/Boletin/Boletin.pdf", "boletin.pdf"); 
				 
		 }else{
			   Toast.makeText(this, getResources().getString(R.string.conexion), Toast.LENGTH_LONG).show();
			}
	 }
	 
	 public void CategoriasFeria(View v)
	 {
		 //listado categorias feria de zafra!!!!!
		 Intent act =new Intent(this,Categorias_FeriaZafra.class);
		 startActivity(act);
	 }
	 
	 public void CategoriasLunaFuego(View v)
	 {
		 Intent act =new Intent(this,Categorias_LunaFuego.class);
		 startActivity(act);
	 }
	 
	 
	 public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		    if (requestCode == 0) {
		        if (resultCode == RESULT_OK) {
		            String contenido = intent.getStringExtra("SCAN_RESULT");
		            Intent i = new Intent(this, LectorQR.class);
		  		   i.putExtra("contenido", contenido);
		  			startActivity(i);
		  		// Hacer algo con los datos obtenidos.
		        } else if (resultCode == RESULT_CANCELED) {
		            // Si se cancelo la captura.
		        }
		    }
		}
	 
	 public void cambiarIdiomaEspanol(View v)
	 {
		 String languageToLoad  = "es";
			Locale locale = new Locale(languageToLoad);
			Locale.setDefault(locale);
			Configuration config = new Configuration();
			config.locale = locale;
			getBaseContext().getResources().updateConfiguration(config, null);
			super.onRestart();
		    Intent i = new Intent(MenuPrincipal.this, PantallaSplash.class);  //your class
		    startActivity(i);
		    finish();    
	 }
	 
	 public void cambiarIdiomaIngles(View v)
	 {
		 String languageToLoad  = "en";
			Locale locale = new Locale(languageToLoad);
			Locale.setDefault(locale);
			Configuration config = new Configuration();
			config.locale = locale;
			getBaseContext().getResources().updateConfiguration(config, null);
			super.onRestart();
			    Intent i = new Intent(MenuPrincipal.this, PantallaSplash.class);  //your class
			    startActivity(i);
			    finish(); 
	 }
	 
	 public boolean existeConexionInternet() {
		   ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		   NetworkInfo netInfo = cm.getActiveNetworkInfo();
		   if (netInfo != null && netInfo.isConnectedOrConnecting()) {
		      return true;
		   }
		   return false;
		}
	 
	//AL PULSAR BOTON BACK SALE DIALOGO DE CONFIRMACION
		@Override
		public void onBackPressed() {
		    new AlertDialog.Builder(this)
		           .setMessage(R.string.salir)
		           .setCancelable(false)
		           .setPositiveButton(R.string.afirmativo, new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int id) {
		                    MenuPrincipal.this.finish();
		               }
		           })
		           .setNegativeButton(R.string.negativo, null)
		           .show();
		}
		
		public class DownloadPDFTask extends AsyncTask<String, Void, Integer> 
	    {
	        protected ProgressDialog mWorkingDialog;    // progress dialog
	        protected String Boletin;         // downloaded file
	        protected String mError;            // for errors

	        @Override
	        protected Integer doInBackground(String... urls)
	        {

	         try
	         {
	          byte[] dataBuffer = new byte[4096];
	              int nRead = 0;

	              // set local filename to last part of URL
	              String[] strURLParts = urls[0].split("/");
	              if (strURLParts.length > 0)
	            	  Boletin = strURLParts[strURLParts.length - 1];
	              else
	            	  Boletin = "Boletin.pdf";

	              // download URL and store to strFileName

	              // connection to url
	              java.net.URL urlReport = new java.net.URL(urls[0]);
	              URLConnection urlConn = urlReport.openConnection();
	              InputStream streamInput = urlConn.getInputStream();
	              BufferedInputStream bufferedStreamInput = new BufferedInputStream(streamInput);
	              FileOutputStream outputStream = MenuPrincipal.this.openFileOutput(Boletin,Context.MODE_PRIVATE);
	              while ((nRead = bufferedStreamInput.read(dataBuffer)) > 0)
	                    outputStream.write(dataBuffer, 0, nRead);
	              streamInput.close();
	              outputStream.close();
	          }
	          catch (Exception e)
	          {
	           Log.e("myApp", e.getMessage());
	           mError = e.getMessage();
	           return (1);
	          }

	         return (0);
	        }

	        //-------------------------------------------------------------------------
	        // PreExecute - UI thread setup
	        //-------------------------------------------------------------------------

	        @Override
	        protected void onPreExecute()
	        {
	         // show "Downloading, Please Wait" dialog
	         mWorkingDialog = ProgressDialog.show(MenuPrincipal.this, "", "Descargando Documento PDF, Espere...", true);
	         return;
	        }

	        //-------------------------------------------------------------------------
	        // PostExecute - UI thread finish
	        //-------------------------------------------------------------------------

	        @Override
	        protected void onPostExecute (Integer result)
	        {
	             if (mWorkingDialog != null)
	          {
	           mWorkingDialog.dismiss();
	           mWorkingDialog = null;
	          }

	             switch (result)
	             {
	             case 0:                            // a URL

	                // Intent to view download PDF-REEMPLAZADO URI POR FILEPROVIDER EN NUEVA VERSION
	                //Uri uri  = Uri.fromFile(MenuPrincipal.this.getFileStreamPath(Boletin));

                     Uri uri = FileProvider.getUriForFile(MenuPrincipal.this, BuildConfig.APPLICATION_ID + ".provider",MenuPrincipal.this.getFileStreamPath(Boletin));


					 try
	                {
	                    Intent intentUrl = new Intent(Intent.ACTION_VIEW);
	                    intentUrl.setDataAndType(uri, "application/pdf");
						intentUrl.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);//añadido permiso, se mostraba vacio
	                    MenuPrincipal.this.startActivity(intentUrl);
	                }                
	                catch (ActivityNotFoundException e)
	                {
	                    Toast.makeText(MenuPrincipal.this, "Lector PDF No Instalado", Toast.LENGTH_LONG).show();
	                }

	                break;

	            case 1:                         // Error

	                Toast.makeText(MenuPrincipal.this, mError, Toast.LENGTH_LONG).show();
	                break;

	            }

	        }

	    }

}

