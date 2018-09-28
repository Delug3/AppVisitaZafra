package rss.adapters;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import ayto.zafrApp.R;


public class Lista_Adapter extends SimpleAdapter {
	//private int[] colors = new int[] { Color.parseColor("#F0F0F0"), Color.parseColor("#D2E4FC") };  
 
    public Lista_Adapter(Context context, List<HashMap<String, String>> items, int resource, String[] from, int[] to) {
        super(context, items, resource, from, to);
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View view = super.getView(position, convertView, parent);
     // int colorPos = position % colors.length;
      //view.setBackgroundColor(colors[colorPos]);
      if (position % 2 == 0) {
          view.setBackgroundResource(R.drawable.selector_rss_color);
      } else {
          view.setBackgroundResource(R.drawable.selector_rss_color2);
      }
      return view;
      
    }
}
