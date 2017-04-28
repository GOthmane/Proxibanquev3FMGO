package service;

import java.util.Collection;
import java.util.List;

import metier.Client;
import metier.Conseiller;
import metier.Coordonnees;


public interface IService {

	public long addClient(Client c);
	public void deleteClient(Client c);
	public void majClient(Client c);
	public long addCoordonneesToClient(Coordonnees co, Client cl);
	public long addClientToConseiller(Client cl, Conseiller co);
	public List<Client> listClientsByConseiller(Conseiller co);
	public List<Client> listClients();
	public Conseiller findConseillerById(long id);
	public List<Client> listClientsByName(String name);
	public Coordonnees getCoordonneesFromClient(Client c); 
}
