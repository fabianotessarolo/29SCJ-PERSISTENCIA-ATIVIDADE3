package br.com.fiap.persistencia.atividade3.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="pedidos")
public class Pedidos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -145250068564185767L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDPEDIDO")
	private int idPedido;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "IDCLIENTE") 
	private Clientes cliente;
	
	@Temporal(value=TemporalType.TIMESTAMP) 
	@Column(name="DATA")
	private Date data;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="VALOR")
	private double valor;

	public Pedidos() {
		super();

	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
