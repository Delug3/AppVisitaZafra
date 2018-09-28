package restaurantes.adapters;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import restaurantes.fragments.FotosRestaurantes_Fragment;
import restaurantes.fragments.InfoRestaurantes_Fragment;
import restaurantes.fragments.InicioRestaurantes_Fragment;

public class TabsPager_Restaurantes_Adapter extends FragmentPagerAdapter {
	
	private final Bundle fragmentBundle;
	public TabsPager_Restaurantes_Adapter(FragmentManager fm, Bundle data) {
		super(fm);
		fragmentBundle = data;
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			final InicioRestaurantes_Fragment f0 = new InicioRestaurantes_Fragment();
	        f0.setArguments(this.fragmentBundle);
	        return f0;
			
			//return new InicioFragment();
		case 1:
			final InfoRestaurantes_Fragment f1 = new InfoRestaurantes_Fragment();
	        f1.setArguments(this.fragmentBundle);
	        return f1;
			//return new InfoFragment();
		case 2:
			final FotosRestaurantes_Fragment f2 = new FotosRestaurantes_Fragment();
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
