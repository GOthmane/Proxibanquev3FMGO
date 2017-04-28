package dao;

import java.util.List;

import metier.Client;
import metier.Conseiller;
import metier.Coordonnees;

public interface IDao {

	public long addClient(Client c);
	public void deleteClient(Client c);
	public void majClient(Client c);
	public Client findClientById(long idClient);
	public Conseiller findConseillerById(long id);
	public long addCoordonnees(Coordonnees c);
	public long addCoordonneesToClient(Coordonnees co, Client cl);
	public long addClientToConseiller(Client cl, Conseiller co);
	public Conseiller findConseillerbyLoginAndPassword(String login, String pwd);
	public List<Client> listClientsByConseiller(Conseiller co);
	public List<Client> listClients();
	public List<Client> listClientsByName(String name);
	public Coordonnees getCoordonneesFromClient(Client cl);
 }
