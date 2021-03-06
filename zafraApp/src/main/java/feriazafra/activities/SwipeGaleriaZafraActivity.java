package feriazafra.activities;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import ayto.zafrApp.R;
import feriazafra.adapters.PagerFotosFeriaZafraAdapter;

public class SwipeGaleriaZafraActivity extends AppCompatActivity {
	
	private long id;	
	private ViewPager viewPager;
	private PagerFotosFeriaZafraAdapter lfAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.feriazafra_pageslide);
	final ActionBar cabecera = getSupportActionBar();
	@SuppressWarnings("deprecation")
	BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.boton_actionbar_feriazafra));
	cabecera.setBackgroundDrawable(background);
	cabecera.setDisplayUseLogoEnabled(false);
	cabecera.setDisplayHomeAsUpEnabled(false);
	cabecera.setDisplayShowHomeEnabled(false);
	cabecera.setDisplayShowTitleEnabled(false);
	 Bundle bundle = new Bundle();
	 bundle.putLong("ids",id);
	 
	viewPager = (ViewPager) findViewById(R.id.pagerFeriaZafra);
	
	lfAdapter = new PagerFotosFeriaZafraAdapter(getSupportFragmentManager(),bundle);
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

	   
	    