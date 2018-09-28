package monumentos.adapters;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import monumentos.fragments.FotosMonumentos_Fragment;
import monumentos.fragments.InfoMonumentos_Fragment;
import monumentos.fragments.InicioMonumentos_Fragment;


public class TabsPager_Monumentos_Adapter extends FragmentPagerAdapter {
		
		private final Bundle fragmentBundle;
		public TabsPager_Monumentos_Adapter(FragmentManager fm, Bundle data) {
			super(fm);
			fragmentBundle = data;
				}
		 
		@Override
		public Fragment getItem(int index) {

			switch (index) {
			case 0:
				final InicioMonumentos_Fragment f0 = new InicioMonumentos_Fragment();
		        f0.setArguments(this.fragmentBundle);
		        return f0;
				
			case 1:
				final InfoMonumentos_Fragment f1 = new InfoMonumentos_Fragment();
		        f1.setArguments(this.fragmentBundle);
		        return f1;
				
			case 2:
				final FotosMonumentos_Fragment f2 = new FotosMonumentos_Fragment();
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


