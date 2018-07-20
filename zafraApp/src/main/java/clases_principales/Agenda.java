package clases_principales;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import ayto.zafrApp.R;


@SuppressLint("SetJavaScriptEnabled")
public class Agenda extends AppCompatActivity {
	ProgressDialog barProgressDialog;
	Handler updateBarHandler;
	String html = "<iframe src=https://www.google.com/calendar/embed?src=zafrApp%40gmail.com&ctz=Europe/Madrid </iframe>";
	//String html = "<iframe src=https://www.google.com/calendar/embed?src=mfgarcia87%40gmail.com&ctz=Europe/Madrid </iframe>";
		@Override
	    protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		 ActionBar cabecera = getSupportActionBar();
		@SuppressWarnings("deprecation")
		BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.boton_actionbar));
		cabecera.setBackgroundDrawable(background);
		cabecera.setDisplayShowTitleEnabled(false);
		cabecera.setDisplayShowHomeEnabled(false);
	        //this.setContentView(R.layout.tab3);
	       
	        //WebView myWebView = (WebView) findViewById(R.id.webView1);
	        WebView myWebView = new WebView(this);
	        myWebView.setClickable(true);
	        myWebView.setFocusableInTouchMode(true);
	        myWebView.getSettings().setJavaScriptEnabled(true);
	        
	        //myWebView.loadUrl("https://www.google.com/calendar/embed?src=mfgarcia87%40gmail.com&ctz=Europe/Madrid");
	        myWebView.loadUrl("https://www.google.com/calendar/embed?src=zafrApp%40gmail.com&ctz=Europe/Madrid");
	        WebClientClass webViewClient = new WebClientClass();
	        myWebView.setWebViewClient(webViewClient);
	        WebChromeClient webChromeClient=new WebChromeClient();
	        myWebView.setWebChromeClient(webChromeClient);
	        setContentView(myWebView);
}
	
public class WebClientClass extends WebViewClient {
		  ProgressDialog pd = null;

		  @Override
		  public void onPageStarted(WebView view, String url, Bitmap favicon) {
		   super.onPageStarted(view, url, favicon);
		   pd = new ProgressDialog(Agenda.this);
		   pd.setTitle(R.string.esperar);
		   pd.setMessage(Agenda.this.getString(R.string.cargar));
		   pd.show();
		  }

		  @Override
		  public void onPageFinished(WebView view, String url) {
		   super.onPageFinished(view, url);
		   pd.dismiss();
		  }
		 }
public class WebChromeClass extends WebChromeClient{
	 }
	 }
