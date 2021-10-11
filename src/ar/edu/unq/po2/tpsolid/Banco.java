package ar.edu.unq.po2.tpsolid;

import java.util.List;

public class Banco implements OtorgadorCredito {

	List<Cliente> clientes;
	
	public Banco(List<Cliente> clientes) {
		this.setClientes(clientes);
	}
	
	
	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


	@Override
	public void consultarPorCredito(SolicitudCredito solicitud) {
		if (this.esCliente(solicitud.getCliente()) && 
			solicitud.esSolicitudAceptable()) { 
			this.otorgarCredito(solicitud);
		}
		
	}

	private boolean esCliente(Cliente cliente) {
		return clientes.contains(cliente);
	}


	@Override
	public void otorgarCredito(SolicitudCredito solicitud) {
		solicitud.getCliente().recibirCreditoDe(solicitud.getMontoSolicitado());
	}

}
