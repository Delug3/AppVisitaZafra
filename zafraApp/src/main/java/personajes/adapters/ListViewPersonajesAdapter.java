package personajes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import ayto.zafrApp.R;

public class ListViewPersonajesAdapter extends BaseAdapter {

	// Declare Variables
		Context context;
		String[] personaje;
		String[] vida;
		LayoutInflater inflater;

		public ListViewPersonajesAdapter(Context context, String[] personaje) {
			this.context = context;
			this.personaje = personaje;
			
		}

		@Override
		public int getCount() {
			return personaje.length;
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
			TextView txtpersonaje;
			
			
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				
			View itemView = inflater.inflate(R.layout.personajes_row, parent, false);
			
			// Locate the TextViews in listview_item.xml
			txtpersonaje= (TextView) itemView.findViewById(R.id.personaje);
			
			
			// Capture position and set to the TextViews
			txtpersonaje.setText(personaje[posicion]);
			
			
			return itemView;
		}
	}
