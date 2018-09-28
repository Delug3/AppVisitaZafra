package lunaalfuego.fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import ayto.zafrApp.R;
import clases_auxiliares.ExtendedViewPager;
import clases_auxiliares.TouchImageView;


public class Mapa_Fragment extends Fragment {
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
   final View rootView = inflater.inflate(R.layout.lunafuego_mapa, container, false);
   
   Integer imgArra[]={};
   TouchImageAdapter adapter = new TouchImageAdapter(imgArra);
   ExtendedViewPager myPager = (ExtendedViewPager) rootView.findViewById(R.id.pagerzoom);
   
        myPager.setAdapter(adapter);
       /* CirclePageIndicator mIndicator =(CirclePageIndicator)rootView.findViewById(R.id.indicator);
        mIndicator.setPageColor(0x880000FF);
        mIndicator.setStrokeColor(0xFF000000);
        mIndicator.setViewPager(myPager);
        */
        
   return rootView;	
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
}

