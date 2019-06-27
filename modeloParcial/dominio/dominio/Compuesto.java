package dominio;

public class Compuesto {

	private String nombreCompuesto;
	private Fertilizante fertilizantes[];
	private int cantidades [];
	private String unidadMedida [];
	private int indice = 0;
	
	public Compuesto(String nombreCompuesto) {
		this.nombreCompuesto = nombreCompuesto;
		this.fertilizantes = new Fertilizante[5];
		this.cantidades = new int [5];
		this.unidadMedida = new String [5];
		
	}

	public void addFertilizante(Fertilizante fertilizante, int cantidadDeFertilizante, String unidadMedida) {
		if(indice < 5) {
			this.fertilizantes[indice] = fertilizante;
			this.cantidades[indice] = cantidadDeFertilizante;
			this.unidadMedida[indice] = unidadMedida;
			indice++;
		}
		
	}

	public boolean tienePrincipio(String formulaPrincipio) {
		for(int i = 0; i < indice ; i++) {
			if(fertilizantes[i].getPrincipio(formulaPrincipio).getAbreviaturaPrincipio().equals(formulaPrincipio))
				return true;
		}
		
		return false;
	}

	public double getConcentracionPrincipio(String formulaPrincipio) {
		double sumaPorcentajes = 0;
		
		
		for(int i = 0; i < indice ; i++) {
			if(fertilizantes[i].getPrincipio(formulaPrincipio).getAbreviaturaPrincipio().equals(formulaPrincipio))
				sumaPorcentajes+=fertilizantes[i].getPorcentajePrincipio(formulaPrincipio);
		}
		
		return sumaPorcentajes;
	}

	public Object getCantidadReal(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
