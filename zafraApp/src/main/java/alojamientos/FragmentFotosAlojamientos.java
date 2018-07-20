package alojamientos;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
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

import com.viewpagerindicator.CirclePageIndicator;


public class FragmentFotosAlojamientos extends Fragment {
	private AlojamientosDbAdapter Db_Adapter;
    private Cursor cursor;
    private long identificador ;
    private Context context;
    private int num=0;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
   final View rootView = inflater.inflate(R.layout.alojamientos_tabfotos, container, false);
   final Bundle args = getArguments();
   identificador = args.getLong("ids");
   Db_Adapter = new AlojamientosDbAdapter(context);
   Db_Adapter.abrir();
   cursor = Db_Adapter.getRegistro(identificador);
   String uri1 = cursor.getString(cursor.getColumnIndex(AlojamientosDbAdapter.C_ALO_COLUMNA_FOTO1));
   int Idfoto1 = this.getResources().getIdentifier(uri1,null,getActivity().getPackageName());
   String uri2 = cursor.getString(cursor.getColumnIndex(AlojamientosDbAdapter.C_ALO_COLUMNA_FOTO2));
   int Idfoto2 = this.getResources().getIdentifier(uri2,null,getActivity().getPackageName());
   String uri3 = cursor.getString(cursor.getColumnIndex(AlojamientosDbAdapter.C_ALO_COLUMNA_FOTO3));
   int Idfoto3 = this.getResources().getIdentifier(uri3,null,getActivity().getPackageName());
   String uri4 = cursor.getString(cursor.getColumnIndex(AlojamientosDbAdapter.C_ALO_COLUMNA_FOTO4));
   int Idfoto4 = this.getResources().getIdentifier(uri4,null,getActivity().getPackageName());
   
  // Integer imgArra[]={Idfoto1,Idfoto2,Idfoto3,Idfoto4};
   List<Integer> list = new ArrayList<Integer>();
   if (uri1 == null || uri1.trim().equals(""))
	{
	   num++;
	}
   else
   {
	   list.add(Idfoto1);   
   }
   if (uri2 == null || uri2.trim().equals(""))
  	{
  	 num++;  
  	}
     else
     {
  	   list.add(Idfoto2);   
     }
   if (uri3 == null || uri3.trim().equals(""))
  	{
  	  num++; 
  	}
     else
     {
  	   list.add(Idfoto3);   
     }
   if (uri4 == null || uri4.trim().equals(""))
  	{
  	  num++; 
  	}
     else
     {
  	   list.add(Idfoto4);   
     }
   if(num==4)
   {
	list.add(R.drawable.res_auxiliares_fotonodisponible);   
   }
   
   
   Integer[] imgArra = new Integer[ list.size() ];
   list.toArray( imgArra );
   
   TouchImageAdapter adapter = new TouchImageAdapter(imgArra);
   
        ExtendedViewPager myPager = (ExtendedViewPager) rootView.findViewById(R.id.pagerzoom);
        myPager.setAdapter(adapter);
        CirclePageIndicator mIndicator = (CirclePageIndicator)rootView.findViewById(R.id.indicator);
        mIndicator.setPageColor(0x880000FF);
        mIndicator.setStrokeColor(0xFF000000);
        mIndicator.setViewPager(myPager);
        
      return rootView;	
    }

    static class TouchImageAdapter extends PagerAdapter {

    	//private static int[] images = { R.drawable.foto1, R.drawable.foto2, R.drawable.foto3 };
         Integer imageArray[];
		 
		 public TouchImageAdapter(Integer imgArra[]) {
		 imageArray = imgArra;
		 
		 }
            @Override
            public int getCount() {
                    return imageArray.length;
            }

            @Override
            public View instantiateItem(ViewGroup container, int position) {
                    TouchImageView img = new TouchImageView(container.getContext());
                    img.setImageResource(imageArray[position]);
                    //NO USAR SCALETYPE O ADIOS AL ZOOM!!!!!!!
                    //img.setScaleType(ScaleType.FIT_XY);
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
