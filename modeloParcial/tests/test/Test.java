package test;

import static org.junit.jupiter.api.Assertions.*;

import dominio.Compuesto;
import dominio.Fertilizante;
import dominio.Principio;

class Test {

	@org.junit.jupiter.api.Test
	void test01() {
		Principio p01 = new Principio("Nitrogeno", "N");
		Principio p02 = new Principio("hidrogeno", "h");
		Principio p03 = new Principio("fosfOro", "p");
		Principio p04 = new Principio("calcio", "ca");
		
		assertEquals("Nitrogeno", p01.toString());
		assertEquals("Hidrogeno", p02.toString());
		assertEquals("Fosforo", p03.toString());
		assertEquals("Calcio", p04.toString());
		

		assertEquals("<<N>>", p01.formatoFormula());
		assertEquals("<<H>>", p02.formatoFormula());
		assertEquals("<<P>>", p03.formatoFormula());
		assertEquals("<<Ca>>", p04.formatoFormula());
	}
	
	
	@org.junit.jupiter.api.Test
	void test02() {
		Principio p01 = new Principio("Nitrogeno", "N");
		Principio p02 = new Principio("hidrogeno", "h");
		Principio p03 = new Principio("fosforo", "p");
		Principio p04 = new Principio("calcio", "ca");
		
		Fertilizante f01 = new Fertilizante("Mata bicho");
		Fertilizante f02 = new Fertilizante("Nuevo mata bicho");
		
		f01.addPrincipio(p01,20);		//20%
		f01.addPrincipio(p02,5);		//5%		//25%
		
		f02.addPrincipio(p01,10);		//10%
		f02.addPrincipio(p02,4);		//4%
		f02.addPrincipio(p03,1);		//1%		//15%
		
		assertEquals("MATA BICHO", f01.toString());
		assertEquals("NUEVO MATA BICHO", f02.toString());
		
		assertEquals(2, f01.cantPrincipios());
		assertEquals(3, f02.cantPrincipios());
	
		assertEquals("<<N,H>>", f01.principios());
		assertEquals("<<N,H,P>>", f02.principios());
		
		assertEquals(25.0, f01.getPorcentajeActivo());
		assertEquals(15.0, f02.getPorcentajeActivo());
		
	}
	
	@org.junit.jupiter.api.Test
	void test03() {
		Principio p01 = new Principio("Nitrogeno", "N");
		Principio p02 = new Principio("hidrogeno", "h");
		Principio p03 = new Principio("fosforo", "p");
		Principio p04 = new Principio("calcio", "ca");
		
		Fertilizante f01 = new Fertilizante("Mata bicho");
		Fertilizante f02 = new Fertilizante("Nuevo mata bicho");
		Fertilizante f03 = new Fertilizante("Pre-Bicho");
		
		f01.addPrincipio(p01,20);		//20%
		f01.addPrincipio(p02,5);		//5%		//25%
		
		f02.addPrincipio(p01,10);		//10%
		f02.addPrincipio(p02,4);		//4%
		f02.addPrincipio(p03,1);		//1%		//15%
		
		f03.addPrincipio(p01,10);		//10%
		f03.addPrincipio(p02,4);		//4%
		f03.addPrincipio(p04,1);		//1%		//15%
		
		Compuesto c01 = new Compuesto("Comp 01");
		
		c01.addFertilizante(f01, 10, "Litros");
		c01.addFertilizante(f02, 20, "Litros");
		
		assertEquals(true, c01.tienePrincipio("<<N>>"));
		assertEquals(30.0, c01.getConcentracionPrincipio("<<N>>"));
		assertEquals("2.00 Litros", c01.getCantidadReal("<<N>>"));
		
		assertEquals(true, c01.tienePrincipio("<<H>>"));
		assertEquals(9.00, c01.getConcentracionPrincipio("<<H>>"));
		assertEquals("1.30 Litros", c01.getCantidadReal("<<H>>"));
		
		assertEquals(true, c01.tienePrincipio("<<P>>"));
		assertEquals(1.00, c01.getConcentracionPrincipio("<<P>>"));
		assertEquals("0.20 Litros", c01.getCantidadReal("<<P>>"));
		
		assertEquals(false, c01.tienePrincipio("<<Ca>>"));
		assertEquals(0.00, c01.getConcentracionPrincipio("<<Ca>>"));
		assertEquals("0.00 Litros", c01.getCantidadReal("<<Ca>>"));	
	}
	
	@org.junit.jupiter.api.Test
	void test04() {
		Principio p01 = new Principio("Nitrogeno", "N");
		Principio p02 = new Principio("hidrogeno", "h");
		Principio p03 = new Principio("fosforo", "p");
		Principio p04 = new Principio("calcio", "ca");
		
		Fertilizante f01 = new Fertilizante("Mata bicho");
		Fertilizante f02 = new Fertilizante("Nuevo mata bicho");
		Fertilizante f03 = new Fertilizante("Pre-Bicho");
		
		f01.addPrincipio(p01,20);		//20%
		f01.addPrincipio(p02,5);		//5%		//25%
		
		f02.addPrincipio(p01,10);		//10%
		f02.addPrincipio(p02,4);		//4%
		f02.addPrincipio(p03,1);		//1%		//15%
		
		f03.addPrincipio(p01,10);		//10%
		f03.addPrincipio(p02,4);		//4%
		f03.addPrincipio(p04,1);		//1%		//15%
		
		Compuesto c01 = new Compuesto("Comp 01");
		
		c01.addFertilizante(f01, 10, "Litros");
		c01.addFertilizante(f02, 20, "Litros");
		
		assertEquals("<<N,H,P>> - << 30.0%,  9.00%,  1.00%>>", c01.getResumen());
		
		assertEquals("<<N>> - << 30.0%>>\n"+
				     "<<H>> - <<  9.0%>>\n"+
				     "<<P>> - <<  1.0%>>",c01.getDetalle());
		
		assertEquals("<<N - 30.0%>>\n"+
			     	 "<<H - 9.0%>>\n"+
			         "<<P - 1.0%>>",c01.getDetalleConFormato());
	}
	
}
