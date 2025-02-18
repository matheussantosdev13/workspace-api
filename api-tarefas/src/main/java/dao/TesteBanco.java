package dao;

import java.sql.Connection;

public class TesteBanco {

	public static void main(String[] args) {
		Connection conexao = Dao.getConexao();
	}

}
