package ar.edu.unq.po2.tpTempMethodAdapter.ayudandoAlSoberano;

import java.util.ArrayList;
import java.util.List;

public abstract class CuentaBancaria {
	 private String titular;
	 private int saldo;
	 private List<String> movimientos;

	 public CuentaBancaria(String titular){
		 this.titular=titular;
		 this.saldo=0;
		 this.movimientos=new ArrayList<String>();
	 }
	 
	 public void extraer(int monto) {
		 if(this.cumpleConCondicionParaExtraer(monto)) {
			 	this.setSaldo(this.getSaldo()-monto);
			 	this.agregarMovimientos("Extraccion");
		 }
	 }
	 
	 protected abstract boolean cumpleConCondicionParaExtraer(int monto);

	 public String getTitular(){
		 return this.titular;
	 }

	 public int getSaldo(){
		 return this.saldo;
	 }
	
	 protected void setSaldo(int monto){
		 this.saldo=monto;
	 }
	 public void agregarMovimientos(String movimiento){
		 this.movimientos.add(movimiento);
	 }	
}