package br.com.fiap.persistencia.atividade3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Clientes implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4054999717701748063L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="IDCLIENTE")
	private int idCliente;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="EMAIL")
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cliente")
	private List<Pedidos> pedido = new ArrayList<Pedidos>();

	public Clientes() {

	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List <Pedidos> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedidos> pedido) {
		this.pedido = pedido;
	}

}
