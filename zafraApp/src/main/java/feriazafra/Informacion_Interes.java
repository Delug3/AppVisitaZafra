package feriazafra;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import ayto.zafrApp.R;

public class Informacion_Interes extends AppCompatActivity {
	private ActionBar cabecera;
	WebView webinfo;
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     setContentView(R.layout.feriazafra_infointeres);
	     	cabecera = getSupportActionBar();
			@SuppressWarnings("deprecation")
			BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.boton_actionbar_feriazafra));
			cabecera.setBackgroundDrawable(background);
			cabecera.setDisplayUseLogoEnabled(false);
			cabecera.setDisplayHomeAsUpEnabled(false);
			cabecera.setDisplayShowHomeEnabled(false);
			cabecera.setDisplayShowTitleEnabled(false);
			webinfo = (WebView) findViewById(R.id.webferiainfointeres);
	
			String text;
			text = "<html><body><p align=\"justify\">";
			text+= getString(R.string.InfoInteres);
			text+= "</p></body></html>";
			webinfo.loadDataWithBaseURL(null,text, "text/html", "utf-8", null);
			webinfo.setBackgroundColor(getResources().getColor(R.color.blanco));
			webinfo.setFocusable(false);
}
}
