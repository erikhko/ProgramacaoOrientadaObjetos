package br.fiap.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.entidade.Cargo;
import br.fiap.entidade.Funcionario;



public class FuncionarioDAO extends DAO {

	// método para inserir um funcionário na base de dados
	public void inserir(Funcionario funcionario) {
		sql = "insert into java_funcionario values(funcionario_sequence.nextval, ?, ?, ?)";

		try (Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			ps.setString(1, funcionario.getNome());
			ps.setDouble(2, funcionario.getSalario());
			ps.setInt(3, funcionario.getCargo().getId());
			ps.execute();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar funcionário\n" + e);
		}
	}

	// método para retornar a lista de funcionários
	public List<Funcionario> listar() {
		List<Funcionario> lista = new ArrayList<>();
		sql = "select * from java_funcionario order by nome";
		
		try (Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Funcionario f = new Funcionario();
				f.setId(rs.getInt("id_funcionario"));
				f.setNome(rs.getString("nome"));
				int id = rs.getInt("id_cargo");
				for(Cargo cargo : Cargo.values()) {
					if(id == cargo.getId()) {
						f.setCargo(cargo);
					}
				}
				
				lista.add(f);
			}
			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Erro ao listar funcionário\n" + e);
		}
		
		return lista;
	}
	
}








