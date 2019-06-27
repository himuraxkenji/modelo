package dominio;

public class Principio {

	private String nombrePrincipio;
	private String abreviatura;

	public Principio(String nombrePrincipio, String abreviatura) {
		this.nombrePrincipio = nombrePrincipio;
		this.abreviatura = abreviatura;
	}
 
	@Override
	public String toString() {
		return this.nombrePrincipio.substring(0,1).toUpperCase() +  this.nombrePrincipio.substring(1,nombrePrincipio.length()).toLowerCase();
	}

	public String formatoFormula() {
		
		return "<<" + getAbreviaturaPrincipio() + ">>";
	}
	
	public String getAbreviaturaPrincipio() {
		String abr = "";
		abr = this.abreviatura.substring(0,1).toUpperCase();
		if(this.abreviatura.length() > 1)
			abr += this.abreviatura.substring(1).toLowerCase();
		
		return abr;
	}
	

}
