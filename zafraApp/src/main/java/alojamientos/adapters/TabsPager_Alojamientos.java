package alojamientos.adapters;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import alojamientos.fragments.FotosAlojamientos_Fragment;
import alojamientos.fragments.InfoAlojamientos_Fragment;
import alojamientos.fragments.InicioAlojamientos_Fragment;

public class TabsPager_Alojamientos extends FragmentPagerAdapter {
	
	private final Bundle fragmentBundle;
	public TabsPager_Alojamientos(FragmentManager fm,Bundle data) {
		super(fm);
		fragmentBundle = data;
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			final InicioAlojamientos_Fragment f0 = new InicioAlojamientos_Fragment();
	        f0.setArguments(this.fragmentBundle);
	        return f0;
			
			//return new InicioFragment();
		case 1:
			final InfoAlojamientos_Fragment f1 = new InfoAlojamientos_Fragment();
	        f1.setArguments(this.fragmentBundle);
	        return f1;
			//return new InfoFragment();
		case 2:
			final FotosAlojamientos_Fragment f2 = new FotosAlojamientos_Fragment();
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
