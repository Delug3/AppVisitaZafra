package lunaalfuego.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import lunaalfuego.fragments.FotosLunaFuegoFragment;

public class PagerFotosLunaFuegoAdapter extends FragmentPagerAdapter {
	
	private final Bundle fragmentBundle;
	public PagerFotosLunaFuegoAdapter(FragmentManager fm, Bundle data) {
		super(fm);
		fragmentBundle = data;
			}
	 
	@Override
	public Fragment getItem(int index) {

		switch (index) {
			case 0:
			final FotosLunaFuegoFragment f2 = new FotosLunaFuegoFragment();
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


