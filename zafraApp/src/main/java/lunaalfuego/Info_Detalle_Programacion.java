package lunaalfuego;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import ayto.zafrApp.R;


public class Info_Detalle_Programacion extends AppCompatActivity {
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	     setContentView(R.layout.lunafuego_info);
	     final ActionBar cabecera = getSupportActionBar();
			@SuppressWarnings("deprecation")
			BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(),R.drawable.boton_actionbar_lunafuego));
			cabecera.setBackgroundDrawable(background);
			cabecera.setDisplayUseLogoEnabled(false);
			cabecera.setDisplayHomeAsUpEnabled(false);
			cabecera.setDisplayShowHomeEnabled(false);
			cabecera.setDisplayShowTitleEnabled(false);
	
String actos = getIntent().getStringExtra("Dia");
/*
    if (actos.equals("Dia 20"))
    	{
    	Dia20();
    	}
    if (actos.equals("Dia 21"))
	{
    	Dia21();
	}
    if (actos.equals("Dia 22"))
   	{
       	Dia22();
   	}
    if (actos.equals("Dia 23"))
   	{
       	Dia23();
   	}
    if (actos.equals("Dia 24"))
   	{
       	Dia24();
   	}
    if (actos.equals("Dia 25"))
   	{
       	Dia25();
   	}
    if (actos.equals("Dia 26"))
   	{
       	Dia26();
   	}
    if (actos.equals("Dia 27"))
   	{
       	Dia27();
   	} 
    if (actos.equals("Dia 28"))
	{
    	Dia28();
    	} 
   	if (actos.equals("Dia 29"))
	{
    	Dia29();
	}
   	*/
	} 
	/*
	  private void Dia20()
	   {
		  TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  //String ste = ( getString(R.string.htmlsource));
		 // stringevento.setText(ste);
		  Spanned sp = Html.fromHtml( getString(R.string.Dia20));
		  stringevento.setText(sp);
		} 
		
	  private void Dia21()
	   {
		  TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Dia21));
		  stringevento.setText(sp);

	   }
	  
	  private void Dia22()
	   {
		  TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Dia22));
		  stringevento.setText(sp);
	   }
	  
	  private void Dia23()
	   {
		  TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Dia23));
		  stringevento.setText(sp);
	   }

	  private void Dia24()
	   {
		  TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Dia24));
		  stringevento.setText(sp);
	   }

	  private void Dia25()
	   {
		  TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Dia25));
		  stringevento.setText(sp);
	   }

	  private void Dia26()
	   {
		  TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Dia26));
		  stringevento.setText(sp);
	   }

	  private void Dia27()
	   {
		  TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Dia27));
		  stringevento.setText(sp);
	   }

	  private void Dia28()
	   {
		  TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Dia28));
		  stringevento.setText(sp);
	   }

	  private void Dia29()
	   {
		  TextView stringevento= (TextView)findViewById(R.id.txtlunafuegoinfo);
		  Spanned sp = Html.fromHtml( getString(R.string.Dia29));
		  stringevento.setText(sp);
	   }
*/
	  

}
