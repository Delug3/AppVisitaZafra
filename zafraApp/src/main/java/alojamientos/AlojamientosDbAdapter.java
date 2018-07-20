package alojamientos;

import java.util.Locale;

import clases_auxiliares.DB_Helper;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class AlojamientosDbAdapter {
	 /**
	    * Definimos constante con el nombre de la tabla
	    */
	   public static final String C_ALO_TABLA = "ALOJAMIENTOS" ;
	 
	   /**
	    * Definimos constantes con el nombre de las columnas de la tabla
	    */
	   public static final String C_ALO_COLUMNA_ID   = "_id";
	   public static final String C_ALO_COLUMNA_NOMBRE = "ALO_Nombre";
	   public static final String C_ALO_COLUMNA_ESTRELLAFOTO = "ALO_EstrellaFoto";
	   public static final String C_ALO_COLUMNA_DIRECCION = "ALO_Direccion";
	   public static final String C_ALO_COLUMNA_TELEFONO = "ALO_Telefono";
	   public static final String C_ALO_COLUMNA_EMAIL = "ALO_Email";
	   public static final String C_ALO_COLUMNA_WEB = "ALO_Web";
	   public static final String C_ALO_COLUMNA_INFORMACION = "ALO_Informacion";
	   public static final String C_ALO_COLUMNA_ICONOIMAGEN = "ALO_Icono";
	   public static final String C_ALO_COLUMNA_INICIOIMAGEN = "ALO_InicioImagen";
	   public static final String C_ALO_COLUMNA_GPSLATITUD = "ALO_Latitud";
	   public static final String C_ALO_COLUMNA_GPSLONGITUD= "ALO_Longitud";
	   public static final String C_ALO_COLUMNA_FOTO1 = "ALO_Foto1";
	   public static final String C_ALO_COLUMNA_FOTO2 = "ALO_Foto2";
	   public static final String C_ALO_COLUMNA_FOTO3 = "ALO_Foto3";
	   public static final String C_ALO_COLUMNA_FOTO4 = "ALO_Foto4";
	   public static final String C_ALO_COLUMNA_CATEGORIA = "ALO_Categoria"; 
	   public static final String C_ALO_COLUMNA_IDIOMA ="ALO_Idioma";
	   
	   private Context contexto;
	   private DB_Helper Db_Helper;
	   private SQLiteDatabase db;
	    
	   /**
	    * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
	    */
	   private String[] COLUMNAS = new String[]{ C_ALO_COLUMNA_ID, C_ALO_COLUMNA_NOMBRE,C_ALO_COLUMNA_ESTRELLAFOTO, C_ALO_COLUMNA_DIRECCION, C_ALO_COLUMNA_TELEFONO, C_ALO_COLUMNA_EMAIL,C_ALO_COLUMNA_WEB,C_ALO_COLUMNA_INFORMACION,C_ALO_COLUMNA_ICONOIMAGEN, C_ALO_COLUMNA_INICIOIMAGEN,C_ALO_COLUMNA_GPSLATITUD,C_ALO_COLUMNA_GPSLONGITUD,C_ALO_COLUMNA_FOTO1,C_ALO_COLUMNA_FOTO2,C_ALO_COLUMNA_FOTO3,C_ALO_COLUMNA_FOTO4,C_ALO_COLUMNA_CATEGORIA,C_ALO_COLUMNA_IDIOMA} ;
	  
	   public AlojamientosDbAdapter(Context context)
	   {
	      this.contexto = context;
	   }
	 
	   public AlojamientosDbAdapter abrir() throws SQLException
	   {
		  Db_Helper= DB_Helper.getInstance(contexto);
	      db = Db_Helper.getWritableDatabase();
	      return this;
	   }
	 
	   public void cerrar()
	   {
		   Db_Helper.close();
	   }
	
	   public Cursor getCursor() throws SQLException
	   {
	      Cursor c = db.query( true, C_ALO_TABLA, COLUMNAS, null, null, null, null, null, null);
	      return c;
	   }
	   
	   public Cursor getCursorSeleccionHoteles() throws SQLException
	   {
		      String idioma=Locale.getDefault().getLanguage();
		      Cursor c =db.rawQuery(" SELECT * FROM ALOJAMIENTOS WHERE ALO_Categoria='hoteles'AND ALO_Idioma ='"+idioma+"'", null);
		     return c;
	   }
	   
	   public Cursor getCursorSeleccionHostales() throws SQLException
	   {
		      String idioma=Locale.getDefault().getLanguage();
		      Cursor c =db.rawQuery(" SELECT * FROM ALOJAMIENTOS WHERE ALO_Categoria='hostales'AND ALO_Idioma ='"+idioma+"'", null);
		     return c;
	   }
	   
	   public Cursor getCursorSeleccionApartamentosTuristicos() throws SQLException
	   {
		      String idioma=Locale.getDefault().getLanguage();
		      Cursor c =db.rawQuery(" SELECT * FROM ALOJAMIENTOS WHERE ALO_Categoria='apartamentos'AND ALO_Idioma ='"+idioma+"'", null);
		     return c;
	   }
	   
	   public Cursor getCursorSeleccionRural() throws SQLException
	   {
		      String idioma=Locale.getDefault().getLanguage();
		      Cursor c =db.rawQuery(" SELECT * FROM ALOJAMIENTOS WHERE ALO_Categoria='rural'AND ALO_Idioma ='"+idioma+"'", null);
		     return c;
	   }
	   
	   public Cursor getCursorSeleccionAlbergues() throws SQLException
	   {
		      String idioma=Locale.getDefault().getLanguage();
		      Cursor c =db.rawQuery(" SELECT * FROM ALOJAMIENTOS WHERE ALO_Categoria='albergues'AND ALO_Idioma ='"+idioma+"'", null);
		     return c;
	   }
	   
	  public Cursor getRegistro(long id) throws SQLException
	   {
	      Cursor c = db.query( true, C_ALO_TABLA, COLUMNAS, C_ALO_COLUMNA_ID + "=" + id, null, null, null, null,null);
	     //Nos movemos al primer registro de la consulta
	      if (c != null) {
	         c.moveToFirst();
	      }
	      return c;
	   }
}
