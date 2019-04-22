package br.ucsal.geu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.geu.model.Reserva;
import br.ucsal.util.Conexao;

public class ReservaDAO {

	private Conexao conexao;

	
	public ReservaDAO() {
		this.conexao = Conexao.getConexao();
		System.out.println(conexao.toString());
		List<Reserva> listinha = listar();
		System.out.println(listinha.toString());
	}

	public List<Reserva> listar() {
		Statement stmt;
		List<Reserva> reservas = new ArrayList<>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select id,titulo,descricao,justificativa,solicitante, telefone, data, hora_inicio, hora_fim from reservas");
			while(rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setTitulo(rs.getString("titulo"));
				r.setDescricao(rs.getString("descricao"));
				r.setJustificativa(rs.getString("justificativa"));
				r.setSolicitante(rs.getString("solicitante"));
				r.setTelefone(rs.getString("telefone"));
				r.setData(rs.getDate("data"));
				r.setHora_inicio(rs.getTime("hora_inicio"));
				r.setHora_fim(rs.getTime("hora_fim"));
				reservas.add(r);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return reservas;
	}

	public void inserir(Reserva reserva) {
		try {
			
			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("insert into reservas (titulo,descricao,justificativa,solicitante, telefone, data, hora_inicio, hora_fim) values (?,?,?,?,?,?,?,?);");
			ps.setString(1, reserva.getTitulo());
			ps.setString(2, reserva.getDescricao());
			ps.setString(3, reserva.getJustificativa());
			ps.setString(4, reserva.getSolicitante());
			ps.setString(5, reserva.getTelefone());
			ps.setDate(6, reserva.getData());
			ps.setTime(7, reserva.getHora_inicio());
			ps.setTime(8, reserva.getHora_fim());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void close() {
		conexao.closeConnection();
	}
	
	
	


}
