package radio.services;

import java.io.IOException;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import ayto.zafrApp.R;
import radio.activities.Radio_Activity;

public class MyMediaPlayerService extends Service {

	private MediaPlayer mediaPlayer = null;
	private boolean      isPlaying = false;

	private static int classID = 579; // just a number
	
	public static String START_PLAY = "START_PLAY";

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if (intent.getBooleanExtra(START_PLAY, false)) {
			play();	
		}
		return Service.START_STICKY;	
	}

	private void play() {
		if (!isPlaying) {			
			isPlaying = true;
			
			Intent intent = new Intent(this, Radio_Activity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|
							Intent.FLAG_ACTIVITY_SINGLE_TOP);

			PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
			
			Notification notification = new NotificationCompat.Builder(getApplicationContext())
	         	.setContentTitle("Radio_Activity Emisur")
	         	.setContentText("En Streaming")
	         	.setSmallIcon(R.drawable.radiopush)
	         	.setContentIntent(pi)
	         	.build();
			
				mediaPlayer = new MediaPlayer();
				try {
					mediaPlayer.setDataSource(this, Uri.parse("http://94.75.206.136:8028"));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					mediaPlayer.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mediaPlayer.start();
			

			startForeground(classID, notification);
		}
	}

	@Override
	public void onDestroy() {
		stop();
	}	
	
	private void stop() {
		if (isPlaying) {
			isPlaying = false;
			if (mediaPlayer != null) {
				mediaPlayer.release();
				mediaPlayer = null;
			}
			stopForeground(true);
		}
	}
	
}
