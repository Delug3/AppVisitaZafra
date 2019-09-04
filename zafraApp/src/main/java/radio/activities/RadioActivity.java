package radio.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import ayto.zafrApp.R;
import radio.services.MyMediaPlayerService;

public class RadioActivity extends Activity {

	private ImageButton stopButton = null;
	private ImageButton playButton = null;
	private WifiLock lock;
	public int control;
	@SuppressLint("InlinedApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio);
		playButton = (ImageButton)findViewById(R.id.PlayButton);
		
		if(control==1)
		{
		playButton.setBackgroundResource(R.drawable.pause);
		} 
		//WebView wv = (WebView) findViewById(R.id.radiogif);
		//wv.loadUrl("file:///android_asset/loading.gif");
		
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
		lock = wifiManager.createWifiLock(WifiManager.WIFI_MODE_FULL, "LockTag");
		 
		if (android.os.Build.VERSION.SDK_INT >= 12) 
		 {
			 lock = wifiManager.createWifiLock(WifiManager.WIFI_MODE_FULL_HIGH_PERF, "LockTag");
		 }
		
		playButton = (ImageButton)findViewById(R.id.PlayButton);
        playButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
        		Intent intent = new Intent(getApplicationContext(), 
                                           MyMediaPlayerService.class);
        		intent.putExtra(MyMediaPlayerService.START_PLAY, true);
        		startService(intent);
        		
      	  	  playButton.setBackgroundResource(R.drawable.pause);
      	  	  control=1;
        		try {
       			 lock.acquire();
                } catch (Throwable th) {
                    // ignoring this exception, probably wakeLock was already released
                }
        	}
        });
		
		stopButton = (ImageButton)findViewById(R.id.StopButton);
        stopButton.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Intent intent = new Intent(getApplicationContext(),
                                            MyMediaPlayerService.class);
        		stopService(intent);
        		
        		 playButton.setBackgroundResource(R.drawable.play);
         	  	  control=0;
        		 try {
        			 lock.release();
                 } catch (Throwable th) {
                     // ignoring this exception, probably wakeLock was already released
                 }
        		
            }
        });
	}
	

}

