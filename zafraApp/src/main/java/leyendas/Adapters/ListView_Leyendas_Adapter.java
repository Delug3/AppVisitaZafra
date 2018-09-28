package leyendas.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import ayto.zafrApp.R;

public class ListView_Leyendas_Adapter extends BaseAdapter {

	// Declare Variables
		Context context;
		String[] nombre;
		String[] leyenda;
		LayoutInflater inflater;

		public ListView_Leyendas_Adapter(Context context, String[] nombre) {
			this.context = context;
			this.nombre = nombre;
			
		}

		@Override
		public int getCount() {
			return nombre.length;
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
			TextView txtnombre;
			
			
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				
			View itemView = inflater.inflate(R.layout.leyendas_row, parent, false);
			
			// Locate the TextViews in listview_item.xml
			txtnombre= (TextView) itemView.findViewById(R.id.nombre);
			
			
			// Capture position and set to the TextViews
			txtnombre.setText(nombre[posicion]);
			
			
			return itemView;
		}
	}
