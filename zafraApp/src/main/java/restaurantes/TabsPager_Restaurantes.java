package restaurantes;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPager_Restaurantes extends FragmentPagerAdapter {
	
	private final Bundle fragmentBundle;
	public TabsPager_Restaurantes(FragmentManager fm,Bundle data) {
		super(fm);
		fragmentBundle = data;
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			final FragmentInicioRestaurantes f0 = new FragmentInicioRestaurantes();
	        f0.setArguments(this.fragmentBundle);
	        return f0;
			
			//return new InicioFragment();
		case 1:
			final FragmentInfoRestaurantes f1 = new FragmentInfoRestaurantes();
	        f1.setArguments(this.fragmentBundle);
	        return f1;
			//return new InfoFragment();
		case 2:
			final FragmentFotosRestaurantes f2 = new FragmentFotosRestaurantes();
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
