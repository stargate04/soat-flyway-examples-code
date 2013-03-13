package fr.soat.lab.flyway.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientDAOImpl implements ClientDAO {

	private final String URL = "jdbc:mysql://localhost/base_1";
	private String selectAllClientsQuery = "SELECT * FROM client ORDER BY nom";

	public ArrayList<Client> getAllClients() {
		ArrayList<Client> clients = new ArrayList<Client>();
		try {
			// chargement du Driver
			Class.forName("org.gjt.mm.mysql.Driver");
			// connexion � la base de donn�es
			Connection conn = DriverManager.getConnection(URL, "root", "root");
			// pr�paration du statement
			Statement st = conn.createStatement();
			// ex�cution de la requ�te
			ResultSet rs = st.executeQuery(selectAllClientsQuery);
			// r�cup�ration des donn�es
			while (rs.next()) {
				Client client = new Client(rs.getString("id"),
						rs.getString("nom"));
				clients.add(client);
			}
		} catch (Exception e) {
			System.err.println("Erreur de connexion : " + e.getMessage());
		}
		return clients;
	}

}
