package restaurantes;

import java.util.Locale;




import clases_auxiliares.DB_Helper;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RestaurantesDbAdapter {
	 
	   /**
	    * Definimos constante con el nombre de la tabla
	    */
	   public static final String C_RES_TABLA = "RESTAURANTES" ;
	 
	   /**
	    * Definimos constantes con el nombre de las columnas de la tabla
	    */
	   public static final String C_RES_COLUMNA_ID   = "_id";
	   public static final String C_RES_COLUMNA_NOMBRE = "RES_Nombre";
	   public static final String C_RES_COLUMNA_DIRECCION = "RES_Direccion";
	   public static final String C_RES_COLUMNA_TELEFONO = "RES_Telefono";
	   public static final String C_RES_COLUMNA_EMAIL = "RES_Email";
	   public static final String C_RES_COLUMNA_WEB = "RES_Web";
	   public static final String C_RES_COLUMNA_INFORMACION = "RES_Informacion";
	   public static final String C_RES_COLUMNA_ICONOIMAGEN = "RES_Icono";
	   public static final String C_RES_COLUMNA_INICIOIMAGEN = "RES_InicioImagen";
	   public static final String C_RES_COLUMNA_GPSLATITUD = "RES_Latitud";
	   public static final String C_RES_COLUMNA_GPSLONGITUD= "RES_Longitud";
	   public static final String C_RES_COLUMNA_FOTO1 = "RES_Foto1";
	   public static final String C_RES_COLUMNA_FOTO2 = "RES_Foto2";
	   public static final String C_RES_COLUMNA_FOTO3 = "RES_Foto3";
	   public static final String C_RES_COLUMNA_FOTO4 = "RES_Foto4";
	   public static final String C_RES_COLUMNA_CATEGORIA = "RES_Categoria"; 
	   public static final String C_RES_COLUMNA_IDIOMA ="RES_Idioma";
	   
	   private Context contexto;
	   private DB_Helper Db_Helper;
	   private SQLiteDatabase db;
	    
	   /**
	    * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
	    */
	   private String[] COLUMNAS = new String[]{ C_RES_COLUMNA_ID, C_RES_COLUMNA_NOMBRE, C_RES_COLUMNA_DIRECCION, C_RES_COLUMNA_TELEFONO, C_RES_COLUMNA_EMAIL,C_RES_COLUMNA_WEB,C_RES_COLUMNA_INFORMACION,C_RES_COLUMNA_ICONOIMAGEN, C_RES_COLUMNA_INICIOIMAGEN,C_RES_COLUMNA_GPSLATITUD,C_RES_COLUMNA_GPSLONGITUD,C_RES_COLUMNA_FOTO1,C_RES_COLUMNA_FOTO2,C_RES_COLUMNA_FOTO3,C_RES_COLUMNA_FOTO4,C_RES_COLUMNA_CATEGORIA,C_RES_COLUMNA_IDIOMA} ;
	  
	   public RestaurantesDbAdapter(Context context)
	   {
	      this.contexto = context;
	   }
	 
	   public RestaurantesDbAdapter abrir() throws SQLException
	   {
	      //dbHelper = new HipotecaDbHelper(contexto);
		   Db_Helper= DB_Helper.getInstance(contexto);
	      db = Db_Helper.getWritableDatabase();
	      return this;
	   }
	 
	   public void cerrar()
	   {
		   Db_Helper.close();
	   }
	 
	   /**
	    * Devuelve cursor con todos las columnas de la tabla
	    */
	   public Cursor getCursor() throws SQLException
	   {
	      Cursor c = db.query( true, C_RES_TABLA, COLUMNAS, null, null, null, null, null, null);
	      return c;
	   }
	   
	   public Cursor getCursorSeleccionTradicional() throws SQLException
	   {
		      String idioma=Locale.getDefault().getLanguage();
		      Cursor c =db.rawQuery(" SELECT * FROM RESTAURANTES WHERE RES_Categoria='tradicional'AND RES_Idioma ='"+idioma+"'", null);
		      return c;
	   }
	   
	   public Cursor getCursorSeleccionInternacional() throws SQLException
	   {
		      String idioma=Locale.getDefault().getLanguage();
		      Cursor c =db.rawQuery(" SELECT * FROM RESTAURANTES WHERE RES_Categoria='internacional'AND RES_Idioma ='"+idioma+"'", null);
		      return c;
	   }
	   
	   public Cursor getCursorSeleccionCarta() throws SQLException
	   {
		      String idioma=Locale.getDefault().getLanguage();
		      Cursor c =db.rawQuery(" SELECT * FROM RESTAURANTES WHERE RES_Categoria='carta'AND RES_Idioma ='"+idioma+"'", null);
		      return c;
	   }
	   
	   public Cursor getCursorSeleccionTapas() throws SQLException
	   {
		      String idioma=Locale.getDefault().getLanguage();
		      Cursor c =db.rawQuery(" SELECT * FROM RESTAURANTES WHERE RES_Categoria='tapas'AND RES_Idioma ='"+idioma+"'", null);
		      return c;
	   }
	   
	   public Cursor getCursorSeleccionLlevar() throws SQLException
	   {
		      String idioma=Locale.getDefault().getLanguage();
		      Cursor c =db.rawQuery(" SELECT * FROM RESTAURANTES WHERE RES_Categoria='llevar'AND RES_Idioma ='"+idioma+"'", null);
		      return c;
	   }
	   
	   public Cursor getCursorSeleccionCatering() throws SQLException
	   {
		      String idioma=Locale.getDefault().getLanguage();
		      Cursor c =db.rawQuery(" SELECT * FROM RESTAURANTES WHERE RES_Categoria='catering'AND RES_Idioma ='"+idioma+"'", null);
		      return c;
	   }
	   
	   
	   public Cursor getRegistro(long id) throws SQLException
	   {
	      Cursor c = db.query( true, C_RES_TABLA, COLUMNAS, C_RES_COLUMNA_ID + "=" + id, null, null, null, null,null);
	     //Nos movemos al primer registro de la consulta
	      if (c != null) {
	         c.moveToFirst();
	      }
	      return c;
	   }
	}


