package lunaalfuego;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import ayto.zafrApp.R;


public class Swipe_LunaFuego extends AppCompatActivity {
	
	private long id;	
	private ViewPager viewPager;
	private Pager_Fotos_LunaFuego lfAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.lunafuego_pageslide);
	final ActionBar cabecera = getSupportActionBar();
	@SuppressWarnings("deprecation")
	BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.boton_actionbar_lunafuego));
	cabecera.setBackgroundDrawable(background);
	cabecera.setDisplayUseLogoEnabled(false);
	cabecera.setDisplayHomeAsUpEnabled(false);
	cabecera.setDisplayShowHomeEnabled(false);
	cabecera.setDisplayShowTitleEnabled(false);
	 Bundle bundle = new Bundle();
	 bundle.putLong("ids",id);
	 
	viewPager = (ViewPager) findViewById(R.id.pagerLunaFuego);
	
	lfAdapter = new Pager_Fotos_LunaFuego(getSupportFragmentManager(),bundle);
	viewPager.setAdapter(lfAdapter);

	viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

		@Override
		public void onPageSelected(int position) {
			}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}
		@Override
		public void onPageScrollStateChanged (int arg0) {
			}
		});
		
	}
}

	   
	    


	
	
	

	

	

