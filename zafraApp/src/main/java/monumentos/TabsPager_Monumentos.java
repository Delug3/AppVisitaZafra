package monumentos;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



public class TabsPager_Monumentos extends FragmentPagerAdapter {
		
		private final Bundle fragmentBundle;
		public TabsPager_Monumentos(FragmentManager fm,Bundle data) {
			super(fm);
			fragmentBundle = data;
				}
		 
		@Override
		public Fragment getItem(int index) {

			switch (index) {
			case 0:
				final FragmentInicioMonumentos f0 = new FragmentInicioMonumentos();
		        f0.setArguments(this.fragmentBundle);
		        return f0;
				
			case 1:
				final FragmentInfoMonumentos f1 = new FragmentInfoMonumentos();
		        f1.setArguments(this.fragmentBundle);
		        return f1;
				
			case 2:
				final FragmentFotosMonumentos f2 = new FragmentFotosMonumentos();
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


