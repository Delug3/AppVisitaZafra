package restaurantes.adapters;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import restaurantes.fragments.FotosRestaurantesFragment;
import restaurantes.fragments.InfoRestaurantesFragment;
import restaurantes.fragments.InicioRestaurantesFragment;

public class TabsPagerRestaurantesAdapter extends FragmentPagerAdapter {
	
	private final Bundle fragmentBundle;
	public TabsPagerRestaurantesAdapter(FragmentManager fm, Bundle data) {
		super(fm);
		fragmentBundle = data;
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			final InicioRestaurantesFragment f0 = new InicioRestaurantesFragment();
	        f0.setArguments(this.fragmentBundle);
	        return f0;
			
			//return new InicioFragment();
		case 1:
			final InfoRestaurantesFragment f1 = new InfoRestaurantesFragment();
	        f1.setArguments(this.fragmentBundle);
	        return f1;
			//return new InfoFragment();
		case 2:
			final FotosRestaurantesFragment f2 = new FotosRestaurantesFragment();
	        f2.setArguments(this.fragmentBundle);
	        return f2;
			//return new FotosFragment();
	        }
		return null;
	}
	
	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}

}
