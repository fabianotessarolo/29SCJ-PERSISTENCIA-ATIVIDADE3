package br.com.fiap.persistencia.atividade3.app;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import br.com.fiap.persistencia.atividade3.dao.GenericDao;
import br.com.fiap.persistencia.atividade3.entity.Clientes;
import br.com.fiap.persistencia.atividade3.entity.Pedidos;

public class Main {

	public static void main(String[] args) {

		// Cria Clientes e Pedidos
		for (int i = 1; i <= 10; i++) {

			Clientes cliente = new Clientes();
			cliente.setNome("Cliente " + i);
			cliente.setEmail("Email@email.com");

			Pedidos pedido = new Pedidos();
			pedido.setValor(2000);
			pedido.setDescricao("Descricao do pedido " + i);

			pedido.setData(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
			pedido.setCliente(cliente);
			GenericDao<Clientes> clientesDao = new GenericDao<>(Clientes.class);
			GenericDao<Pedidos> pedidosDao = new GenericDao<>(Pedidos.class);
			clientesDao.adicionar(cliente);
			pedidosDao.adicionar(pedido);

		}

		// Busca Cliente ID1
		GenericDao<Clientes> clientesDao = new GenericDao<>(Clientes.class);
		Clientes clienteBusca = clientesDao.buscar(1);
		System.out.println(clienteBusca.getNome());

		// Atualiza nome Cliente ID1
		clienteBusca.setNome("Cliente joaquim");
		clientesDao.atualizar(clienteBusca);

		// Mostra nome atualizado
		clienteBusca = clientesDao.buscar(1);
		System.out.println(clienteBusca.getNome());

		// Remove cliente ID1
		System.out.println("Removendo cliente ID=1");
		clientesDao.remover(clienteBusca);

	}

}
