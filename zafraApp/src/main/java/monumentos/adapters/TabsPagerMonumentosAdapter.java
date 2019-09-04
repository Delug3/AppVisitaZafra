package monumentos.adapters;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import monumentos.fragments.FotosMonumentosFragment;
import monumentos.fragments.InfoMonumentosFragment;
import monumentos.fragments.InicioMonumentosFragment;


public class TabsPagerMonumentosAdapter extends FragmentPagerAdapter {
		
		private final Bundle fragmentBundle;
		public TabsPagerMonumentosAdapter(FragmentManager fm, Bundle data) {
			super(fm);
			fragmentBundle = data;
				}
		 
		@Override
		public Fragment getItem(int index) {

			switch (index) {
			case 0:
				final InicioMonumentosFragment f0 = new InicioMonumentosFragment();
		        f0.setArguments(this.fragmentBundle);
		        return f0;
				
			case 1:
				final InfoMonumentosFragment f1 = new InfoMonumentosFragment();
		        f1.setArguments(this.fragmentBundle);
		        return f1;
				
			case 2:
				final FotosMonumentosFragment f2 = new FotosMonumentosFragment();
		        f2.setArguments(this.fragmentBundle);
		        return f2;
				
		        }
			return null;
		}
		
		@Override
		public int getCount() {
			// get item count - equal to number of tabs
			return 3;
		}

	}


