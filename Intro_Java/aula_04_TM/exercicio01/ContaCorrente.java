package aula_04_TM.exercicio01;

import java.math.BigDecimal;

public class ContaCorrente {
	private BigDecimal saldo;
	private int numero, agencia;
	private String nomeCliente;
	
	public ContaCorrente() {
	
	}

	public ContaCorrente(BigDecimal saldo, int numero, int agencia, String nomeCliente) {
		this.saldo = saldo;
		this.numero = numero;
		this.agencia = agencia;
		this.nomeCliente = nomeCliente;
	}
	
	public ContaCorrente(ContaCorrente conta) {
		this.saldo = conta.getSaldo();
		this.numero = conta.getNumero();
		this.agencia = conta.getAgencia();
		this.nomeCliente = conta.nomeCliente;
	}

	
	public void deposito(BigDecimal valor) {
		this.saldo = this.saldo.add(valor);
	}
	
	public boolean saque(BigDecimal valor) {
		if(!(this.saldo.compareTo(valor)==Util.MENOR)) {
			this.saldo = this.saldo.subtract(valor);
			return true;
		}		
		return false;
	}	
	
	public void transferir(BigDecimal valor, ContaCorrente destino) {
		if(saque(valor)) {
			destino.deposito(valor);
		}
	}	
	
	public void devolucao(BigDecimal valor, ContaCorrente destino) {
		if(saque(valor)) {
			destino.deposito(valor);
		}
	}	
	
	
	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "**********************************************\n"
				+ nomeCliente
				+"\nNúm. Conta: "+numero+"   Agência: "+agencia
				+"\nSaldo: "+saldo;
	}
	
	
	
	

}
