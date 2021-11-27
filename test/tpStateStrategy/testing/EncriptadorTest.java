package tpStateStrategy.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpStateStrategy.encriptacion.EncriptadorPorNumero;
import ar.edu.unq.po2.tpStateStrategy.encriptacion.EncriptadorPorVocal;
import ar.edu.unq.po2.tpStateStrategy.encriptacion.EncriptadorUser;

class EncriptadorTest {
	
	EncriptadorUser user;
	EncriptadorPorVocal porVocal;
	EncriptadorPorNumero porNumero;
	
	@BeforeEach
	public void setUp() throws Exception {
		porVocal  = new EncriptadorPorVocal();
		porNumero = new EncriptadorPorNumero();
	}

	@Test
	void testUnEncriptadorPorVocalCambiaLasVocalesPorElSiguiente() {
		user = new EncriptadorUser(porVocal);
		
		String encriptacion = user.encriptar("Hola");
		String encriptacion2 = user.encriptar("Como estas");
		
		assertEquals(encriptacion, "Hule");
		assertEquals(encriptacion2, "Cumu istes");
	}
	
	@Test
	void testUnDesencriptadorPorVocalCambiaLasVocalesPorElAnterior() {
		user = new EncriptadorUser(porVocal);
		
		String encriptacion = user.desencriptar("Hule");
		String encriptacion2 = user.desencriptar("Cumu istes");
		
		assertEquals(encriptacion, "Hola");
		assertEquals(encriptacion2, "Como estas");
	}
	
	@Test
	void testUnDesencriptadorPorNumerosCambiaLosNumerosPorLetras() {
		user = new EncriptadorUser(porNumero);
		String encriptacion = user.desencriptar("8,15,12,1");
		
		assertEquals(encriptacion, "hola");
	}
	
	@Test
	void testUnEncriptadorPorNumerosCambiaLasLetrasPorNumeros() {
		user = new EncriptadorUser(porNumero);
		String encriptacion = user.encriptar("hola");
		
		assertEquals(encriptacion, "8,15,12,1");
	}

}
