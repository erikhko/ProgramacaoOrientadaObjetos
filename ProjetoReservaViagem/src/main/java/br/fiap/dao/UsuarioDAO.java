package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.entidade.Usuario;

public class UsuarioDAO {
	
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	private Conexao conexao;
	
	public UsuarioDAO() {
		conexao = new Conexao();
	}
	
	public Usuario pesquisar(String email, String senha) {
		Usuario usuario = null;
		sql = "select * from java_usuario where email = ? and senha = ?";
		
		try(Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			
			if(rs != null) {
				usuario = new Usuario();
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(email);
				usuario.setSenha(senha);
				usuario.setTipo_usuario(rs.getString("tipo_usuario"));
			}
		} 
		catch (SQLException e) {
			System.out.println("Erro ao pesquisar\n" + e);
		}
		
		return usuario;
	}
	
}
