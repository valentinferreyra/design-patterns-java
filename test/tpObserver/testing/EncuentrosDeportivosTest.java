package tpObserver.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpObserver.encuentrosDeportivos.Aplicacion;
import ar.edu.unq.po2.tpObserver.encuentrosDeportivos.AplicacionMovil;
import ar.edu.unq.po2.tpObserver.encuentrosDeportivos.Partido;
import ar.edu.unq.po2.tpObserver.encuentrosDeportivos.Servidor;

class EncuentrosDeportivosTest {
	
	private Aplicacion oneFootball;
	private AplicacionMovil app;
	private Partido partido1;
	private Partido partido2;
	private Partido partido3;
	private Servidor soloFutbol;
	private Servidor soloBasquet;
	private Servidor futbolYTenis;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.oneFootball = new Aplicacion();
		this.partido1 = new Partido("2-0", Arrays.asList("Boca", "Estudiantes"), "Futbol");
		this.partido2 = new Partido("6-3", Arrays.asList("Rafael Nadal", "Novak Djokovic"), "Tenis");
		this.partido3 = new Partido("115-129", Arrays.asList("Chicago Bulls", "Golden State Warriors"), "Basquet");
		
		this.soloFutbol = new Servidor(Arrays.asList("Futbol", "Atletismo"));
		this.soloBasquet = new Servidor(Arrays.asList("Basquet"));
		this.futbolYTenis = new Servidor(Arrays.asList("Futbol", "Tenis"));
		
		this.app = new AplicacionMovil(Arrays.asList("Tenis", "Boca"));
	}

	@Test
	public void testUnaAplicacionRegistraLosPartidos() {
		this.oneFootball.agregarPartido(partido1);
		this.oneFootball.agregarPartido(partido2);
		
		assertEquals(oneFootball.getPartidos().size(), 2);
		assertEquals(oneFootball.getPartidos().get(0).getDeporte(), "Futbol");
		assertEquals(oneFootball.getPartidos().get(1).getContrincantes().get(0), "Rafael Nadal");
	}
	
	@Test
	public void testSoloFutbolTieneDosInteres() {
		assertEquals(soloFutbol.getIntereses().size(), 2);
		assertEquals(soloFutbol.getIntereses().get(0), "Futbol");
	}
	
	@Test
	public void testSoloFutbolSeSuscribeAOneFootballYObtieneUnaNotificacion() {
		soloFutbol.suscribir(oneFootball);
		oneFootball.agregarPartido(partido1);
		
		assertEquals(soloFutbol.getPartidosDeInteres().size(), 1);
	}
	
	@Test
	public void testSoloBasquetSeSuscribeAOneFootballYObtieneUnaNotificacion() {
		soloBasquet.suscribir(oneFootball);
		oneFootball.agregarPartido(partido3);
		
		assertEquals(soloBasquet.getPartidosDeInteres().size(), 1);
	}
	
	@Test
	public void testSoloBasquetYSoloFootballSeSuscribenPeroNoObtienenNotificaciones() {
		soloBasquet.suscribir(oneFootball);
		soloFutbol.suscribir(oneFootball);
		
		oneFootball.agregarPartido(partido2); // partido de tenis
		
		assertEquals(soloBasquet.getPartidosDeInteres().size(), 0);
	}
	
	@Test
	public void testFutbolYTenisSeSuscribeAOneFootballYObtieneDosNotificaciones() {
		futbolYTenis.suscribir(oneFootball);
		
		oneFootball.agregarPartido(partido1);
		oneFootball.agregarPartido(partido2);
		
		assertEquals(futbolYTenis.getPartidosDeInteres().size(), 2);
	}
	
	@Test
	public void testUnaAplicacionMovilSeSuscribeAOneFootball_YObtieneMensajesDeLosResultados() {
		app.suscribir(oneFootball);
		
		oneFootball.agregarPartido(partido1);
		oneFootball.agregarPartido(partido2); // a la app le interesa boca y tenis
		
		assertEquals(app.getResultadosDeInteres().size(), 2);
		assertEquals(app.getResultadosDeInteres().get(0), "2-0");
	}

}
