package clases_principales;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import ayto.zafrApp.R;


public class AcercaDeActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     setContentView(R.layout.acercade);
	
	
	Button theButton = (Button)findViewById(R.id.hidebutton);
	theButton.setVisibility(View.VISIBLE);
	theButton.setBackgroundColor(Color.TRANSPARENT);

	}
	public void HideButton(View v)
	{
	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	builder.setMessage("App Desarrollada por Manuel Fernandez Garcia.   "
			+ "2013-2014     "
			+ "mfgarcia87@gmail.com")
	        .setTitle("Informacion")
	        .setCancelable(false)
	        .setNeutralButton("Aceptar",
	                new DialogInterface.OnClickListener() {
	                    public void onClick(DialogInterface dialog, int id) {
	                        dialog.cancel();
	                    }
	                });
	AlertDialog alert = builder.create();
	alert.show();
	
	}
}
