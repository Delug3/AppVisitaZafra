package alojamientos;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

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
			final FragmentInicioAlojamientos f0 = new FragmentInicioAlojamientos();
	        f0.setArguments(this.fragmentBundle);
	        return f0;
			
			//return new InicioFragment();
		case 1:
			final FragmentInfoAlojamientos f1 = new FragmentInfoAlojamientos();
	        f1.setArguments(this.fragmentBundle);
	        return f1;
			//return new InfoFragment();
		case 2:
			final FragmentFotosAlojamientos f2 = new FragmentFotosAlojamientos();
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
