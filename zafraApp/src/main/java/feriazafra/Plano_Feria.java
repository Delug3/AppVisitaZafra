package feriazafra;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import ayto.zafrApp.R;
import clases_auxiliares.ExtendedViewPager;
import clases_auxiliares.TouchImageView;

public class Plano_Feria extends AppCompatActivity{
	private ActionBar cabecera;
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     setContentView(R.layout.feriazafra_plano);
	     cabecera = getSupportActionBar();
	 	@SuppressWarnings("deprecation")
	 	BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.boton_actionbar_feriazafra));
	 	cabecera.setBackgroundDrawable(background);
	 	cabecera.setDisplayUseLogoEnabled(false);
	 	cabecera.setDisplayHomeAsUpEnabled(false);
	 	cabecera.setDisplayShowHomeEnabled(false);
	 	cabecera.setDisplayShowTitleEnabled(false);
	 	
	    Integer imgArra[]={R.drawable.planoferia};
	    TouchImageAdapter adapter = new TouchImageAdapter(imgArra);
	  
	    ExtendedViewPager myPager = (ExtendedViewPager)findViewById(R.id.pagerzoom);
	   
	        myPager.setAdapter(adapter);	  
	   }
	    
	final class TouchImageAdapter extends PagerAdapter {

	         Integer imageArray[];
			 public TouchImageAdapter(Integer imgArra[]) {
			 imageArray = imgArra;
			 }
			 
			 public int getCount() {
	                    return imageArray.length;
	            }
			 @Override
	            public View instantiateItem(ViewGroup container, int position) {
	                    TouchImageView img = new TouchImageView(container.getContext());
	                    img.setImageResource(imageArray[position]);
	                    
	                    //NO USAR SCALETYPE O ADIOS AL ZOOM!!!!!!!
	                    //img.setScaleType(ScaleType.FIT_CENTER);
	                    //----------------------------------
	                    container.addView(img, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
	                    return img;
	            }

	            @Override
	            public void destroyItem(ViewGroup container, int position, Object object) {
	                    container.removeView((View) object);
	            }

	            @Override
	            public boolean isViewFromObject(View view, Object object) {
	                    return view == object;
	            }
		}
	
	
	/*@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);

	    // Checks the orientation of the screen
	    if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
	        cabecera.hide();
	        
	    } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
	        cabecera.show();
	    }
	}
	*/
	}
	

