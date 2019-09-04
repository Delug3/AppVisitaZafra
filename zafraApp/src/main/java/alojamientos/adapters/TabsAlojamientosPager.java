package alojamientos.adapters;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import alojamientos.fragments.FotosAlojamientosFragment;
import alojamientos.fragments.InfoAlojamientosFragment;
import alojamientos.fragments.InicioAlojamientosFragment;

public class TabsAlojamientosPager extends FragmentPagerAdapter {
	
	private final Bundle fragmentBundle;
	public TabsAlojamientosPager(FragmentManager fm, Bundle data) {
		super(fm);
		fragmentBundle = data;
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			final InicioAlojamientosFragment f0 = new InicioAlojamientosFragment();
	        f0.setArguments(this.fragmentBundle);
	        return f0;
			
			//return new InicioFragment();
		case 1:
			final InfoAlojamientosFragment f1 = new InfoAlojamientosFragment();
	        f1.setArguments(this.fragmentBundle);
	        return f1;
			//return new InfoFragment();
		case 2:
			final FotosAlojamientosFragment f2 = new FotosAlojamientosFragment();
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
{

}
}
