package dominio;

public class Fertilizante {

	private String nombreFertilizante;
	private Principio [] principios;
	private int [] porcentajesPrincipios;
	private int indice = 0;
	
	
	public Fertilizante(String nombreFertilizante) {
		this.nombreFertilizante = nombreFertilizante;
		this.principios = new Principio [5] ;
		this.porcentajesPrincipios = new int [5];
	}

	public void addPrincipio(Principio principio, int porcentaje) {
		if(indice < 5) {
			this.principios[indice] = principio;
			this.porcentajesPrincipios[indice] = porcentaje;
			indice++;
		}
		
	}

	@Override
	public String toString() {
		return nombreFertilizante.toUpperCase();
	}

	public int cantPrincipios() {
		
		return indice;
	}

	public String principios() {
		String principios = "";
		for(int i = 0 ; i < this.indice; i++) {
			principios += this.principios[i].getAbreviaturaPrincipio();
			if (i < this.indice-1)
				principios+= ",";
		}
		return "<<" + principios + ">>";
	}

	public double getPorcentajeActivo() {
		double sumaPorcentajes = 0;
		
		for(int i = 0 ; i < this.indice; i++)
			sumaPorcentajes += this.porcentajesPrincipios[i];
		
		return sumaPorcentajes;
	}
	
	public Principio getPrincipio(String abrPrincipio) {
		for (int i = 0; i < principios.length; i++) {
			if(abrPrincipio.equals(principios[i].formatoFormula()))
				return principios[i];
		}
		return null;
	}
	
	public int getPorcentajePrincipio(String abrPrincipio) {
		for (int i = 0; i < principios.length; i++) {
			if(abrPrincipio.equals(principios[i].formatoFormula()))
				return this.porcentajesPrincipios[i];
		}
		return 0;
	}
	
	
	

}
