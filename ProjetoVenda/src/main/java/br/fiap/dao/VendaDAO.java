package br.fiap.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.entidade.Funcionario;
import br.fiap.entidade.Venda;


public class VendaDAO extends DAO {
	
	// método para inserir uma venda na tabela java_venda
	public void inserir(Venda venda) {
		sql = "insert into java_venda values(venda_sequence.nextval, ?, ?, ?)";
		
		try (Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, venda.getFuncionario().getId());
			ps.setDouble(2, venda.getValor());
			ps.setDouble(3, venda.calcularComissao());
			ps.execute();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir vendas");
		}
	}
	
	// método para listar todos os funcionários e a soma de suas vendas
	public List<Venda> listar() {
		List<Venda> lista = new ArrayList<>();
		Venda venda;
		Funcionario funcionario;
		
		sql = "SELECT f.nome, f.salario, SUM(v.comissao) AS total_comissao \r\n"
				+ "FROM java_funcionario f \r\n"
				+ "INNER JOIN java_venda v\r\n"
				+ "ON f.id_funcionario = v.id_funcionario\r\n"
				+ "GROUP BY f.nome, f.salario";
		
		try(Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				funcionario = new Funcionario();
				venda = new Venda();
				funcionario.setNome(rs.getString("nome"));
				funcionario.setSalario(rs.getDouble("salario"));
				venda.setFuncionario(funcionario);
				venda.setComissao(rs.getDouble("total_comissao"));
				lista.add(venda);
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Erro ao listar vendas\n" + e);
		}
		
		return lista;
	}
	
}

