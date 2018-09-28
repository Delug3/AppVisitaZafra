package monumentos.adapters;

import java.util.Locale;

import clases_auxiliares.DB_Helper;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class MonumentosDb_Adapter {
	 
	   /**
	    * Definimos constante con el nombre de la tabla
	    */
	   public static final String C_MON_TABLA = "MONUMENTOS" ;
	 
	   /**
	    * Definimos constantes con el nombre de las columnas de la tabla
	    */
	   public static final String C_MON_COLUMNA_ID   = "_id";
	   public static final String C_MON_COLUMNA_NOMBRE = "MON_Nombre";
	   public static final String C_MON_COLUMNA_DIRECCION = "MON_Direccion";
	   public static final String C_MON_COLUMNA_TELEFONO = "MON_Telefono";
	   public static final String C_MON_COLUMNA_HORARIO = "MON_Horario";
	   public static final String C_MON_COLUMNA_INFORMACION = "MON_Informacion";
	   public static final String C_MON_COLUMNA_ICONOIMAGEN = "MON_Icono";
	   public static final String C_MON_COLUMNA_INICIOIMAGEN = "MON_InicioImagen";
	   public static final String C_MON_COLUMNA_GPSLATITUD = "MON_Latitud";
	   public static final String C_MON_COLUMNA_GPSLONGITUD= "MON_Longitud";
	   public static final String C_MON_COLUMNA_FOTO1 = "MON_Foto1";
	   public static final String C_MON_COLUMNA_FOTO2 = "MON_Foto2";
	   public static final String C_MON_COLUMNA_FOTO3 = "MON_Foto3";
	   public static final String C_MON_COLUMNA_FOTO4 = "MON_Foto4";
	   public static final String C_MON_COLUMNA_IDIOMA ="MON_Idioma";
	   
	   private Context contexto;
	   private DB_Helper dbHelper;
	   private SQLiteDatabase db;
	    
	   /**
	    * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
	    */
	   private String[] COLUMNAS = new String[]{ C_MON_COLUMNA_ID, C_MON_COLUMNA_NOMBRE, C_MON_COLUMNA_DIRECCION, C_MON_COLUMNA_TELEFONO, C_MON_COLUMNA_HORARIO,C_MON_COLUMNA_INFORMACION,C_MON_COLUMNA_ICONOIMAGEN, C_MON_COLUMNA_INICIOIMAGEN,C_MON_COLUMNA_GPSLATITUD,C_MON_COLUMNA_GPSLONGITUD,C_MON_COLUMNA_FOTO1,C_MON_COLUMNA_FOTO2,C_MON_COLUMNA_FOTO3,C_MON_COLUMNA_FOTO4,C_MON_COLUMNA_IDIOMA} ;
	  
	   public MonumentosDb_Adapter(Context context)
	   {
	      this.contexto = context;
	   }
	 
	   public MonumentosDb_Adapter abrir() throws SQLException
	   {
	      //dbHelper = new HipotecaDbHelper(contexto);
	      dbHelper= DB_Helper.getInstance(contexto);
	      db = dbHelper.getWritableDatabase();
	      return this;
	   }
	 
	   public void cerrar()
	   {
	      dbHelper.close();
	   }
	 
	   /**
	    * Devuelve cursor con todos las columnas de la tabla
	    */
	   public Cursor getCursor() throws SQLException
	   {
	      Cursor c = db.query( true, C_MON_TABLA, COLUMNAS, null, null, null, null, null, null);
	      return c;
	   }
	   
	   public Cursor getCursorSeleccion() throws SQLException
	   {
		  String idioma=Locale.getDefault().getLanguage();
		  Cursor c =db.rawQuery(" SELECT * FROM MONUMENTOS WHERE MON_Idioma ='"+idioma+"'", null);
		  return c;
	   }
	   
	   
	   public Cursor getRegistro(long id) throws SQLException
	   {
	      Cursor c = db.query( true, C_MON_TABLA, COLUMNAS, C_MON_COLUMNA_ID + "=" + id, null, null, null, null,null);
	     //Nos movemos al primer registro de la consulta
	      if (c != null) {
	         c.moveToFirst();
	      }
	      return c;
	   }
	}

