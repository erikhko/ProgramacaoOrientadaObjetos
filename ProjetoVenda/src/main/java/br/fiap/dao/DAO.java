package br.fiap.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.fiap.conexao.Conexao;

public class DAO {
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected String sql;
	protected Conexao conexao;
	
	public DAO() {
		this.conexao = new Conexao();
	}
}
