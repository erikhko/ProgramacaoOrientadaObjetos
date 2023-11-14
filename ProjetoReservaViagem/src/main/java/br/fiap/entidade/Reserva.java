package br.fiap.entidade;

public class Reserva {
	
	private int id_reserva;
	private Usuario usuario;
	private String destino;
	private String tipo_de_viagem;
	private String seguro;
	private double valor;
	
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getTipo_de_viagem() {
		return tipo_de_viagem;
	}
	public void setTipo_de_viagem(String tipo_de_viagem) {
		this.tipo_de_viagem = tipo_de_viagem;
	}
	public String getSeguro() {
		return seguro;
	}
	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
