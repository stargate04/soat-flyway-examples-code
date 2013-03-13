package fr.soat.lab.flyway;

import java.util.ArrayList;

import javax.sql.DataSource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.soat.lab.flyway.data.Client;
import fr.soat.lab.flyway.data.ClientDAO;
import fr.soat.lab.flyway.data.ClientDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "test-context.xml")
public class TestFlywaySpring {
	@Autowired
	private DataSource dataSource;

	@Test
	public void test() {
		assert (dataSource != null);

		ClientDAO clientDAO = new ClientDAOImpl();
		ArrayList<Client> clients = clientDAO.getAllClients();

		Assert.assertNotNull(clients);

	}

}
