package feriazafra.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import ayto.zafrApp.R;

public class ListView_Expositores_Adapter extends BaseAdapter {

	// Declare Variables
		Context context;
		String[] zona;
		String[] expositores;
		LayoutInflater inflater;

		public ListView_Expositores_Adapter(Context context, String[] zona) {
			this.context = context;
			this.zona = zona;
			
		}

		@Override
		public int getCount() {
			return zona.length;
		}

		@Override
		public Object getItem(int posicion) {
			return null;
		}

		@Override
		public long getItemId(int posicion) {
			return 0;
		}

		public View getView(int posicion, View convertView, ViewGroup parent) {
			
			// Declare Variables
			TextView txtzona;
			
			
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				
			View itemView = inflater.inflate(R.layout.feriazafra_expositores_row, parent, false);
			
			// Locate the TextViews in listview_item.xml
			txtzona= (TextView) itemView.findViewById(R.id.zona);
			
			
			// Capture position and set to the TextViews
			txtzona.setText(zona[posicion]);
			
			
			return itemView;
		}
	}
