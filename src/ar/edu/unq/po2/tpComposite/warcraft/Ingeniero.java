package ar.edu.unq.po2.tpComposite.warcraft;

public class Ingeniero extends Personaje {
	
	private int cantidadLajas;
	
	public int getCantidadLajas() {
		return cantidadLajas;
	}

	public void setCantidadLajas(int cantidadLajas) {
		this.cantidadLajas = cantidadLajas;
	}
	
	@Override
	public void moverHaciaElPunto(String unPunto) {
//		while(puntoActual != unPunto) {
			this.ponerLajaSiHay();
//		}
//		
		super.setPunto(unPunto);
	}
	
	private void ponerLajaSiHay() {
		if (quedanLajas()) {
			construirCamino();
		}
	}
	
	private boolean quedanLajas() {
		return this.getCantidadLajas() > 0;
	}
	
	private void construirCamino() {
		// poner una laja
		this.cantidadLajas -= 1;
	}


}


