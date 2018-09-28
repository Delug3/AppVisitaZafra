package feriazafra.adapters;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import feriazafra.fragments.Fotos_FeriaZafra_Fragment;

public class Pager_Fotos_FeriaZafra_Adapter extends FragmentPagerAdapter {
	
	private final Bundle fragmentBundle;
	public Pager_Fotos_FeriaZafra_Adapter(FragmentManager fm, Bundle data) {
		super(fm);
		fragmentBundle = data;
			}
	 
	@Override
	public Fragment getItem(int index) {

		switch (index) {
			case 0:
			final Fotos_FeriaZafra_Fragment f2 = new Fotos_FeriaZafra_Fragment();
	        f2.setArguments(this.fragmentBundle);
	        return f2;
			
	        }
		return null;
	}
	//PRUEBA,TESTEAR SI FUNCIONA
	@Override
	public void destroyItem(View collection, int position, Object view) {
	     ((ViewPager) collection).removeView((View) view);
	}
	
	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 1;
	}

}
