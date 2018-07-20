package clases_principales;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import ayto.zafrApp.R;


@SuppressLint("SetJavaScriptEnabled")
public class LectorQR extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.lectorqr);

		Bundle bundle = getIntent().getExtras();
		WebView myWebViewDATOS = (WebView) findViewById(R.id.webViewQReader);
		 myWebViewDATOS.getSettings().setJavaScriptEnabled(true);
	        
		 /* Prevent WebView from Opening the Browser */
		 myWebViewDATOS.setWebViewClient(new InsideWebViewClient());
		 myWebViewDATOS.loadUrl(bundle.getString("contenido"));
			}
	    
	    /* Class that prevents opening the Browser */
	    private class InsideWebViewClient extends WebViewClient {
	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            view.loadUrl(url);
	            return true;
	        }
	    }


}

