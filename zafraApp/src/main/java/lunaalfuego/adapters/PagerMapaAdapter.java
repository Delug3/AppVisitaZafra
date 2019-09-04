package lunaalfuego.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import lunaalfuego.fragments.MapaFragment;

public class PagerMapaAdapter extends FragmentPagerAdapter {
	
	private final Bundle fragmentBundle;
	public PagerMapaAdapter(FragmentManager fm, Bundle data) {
		super(fm);
		fragmentBundle = data;
			}
	 
	@Override
	public Fragment getItem(int index) {

		switch (index) {
			case 0:
			final MapaFragment f2 = new MapaFragment();
	        f2.setArguments(this.fragmentBundle);
	        return f2;
			
	        }
		return null;
	}
	
	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 1;
	}

}


