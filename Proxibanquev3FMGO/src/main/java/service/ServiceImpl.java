package service;

import java.util.Collection;
import java.util.List;

import metier.Coordonnees;
import dao.Dao;
import dao.IDao;
import metier.Client;
import metier.Conseiller;

public class ServiceImpl implements IService, ILoginService {

	private IDao idao = new Dao();
	
	public long addCoordonneesToClient(Coordonnees co, Client cl)
	{		
		 idao.addCoordonneesToClient(co, cl);	
		 return cl.getId();
	}
	@Override
	public long addClient(Client c) {
		return idao.addClient(c);
	}

	@Override
	public void deleteClient(Client c) {
		idao.deleteClient(c);
	}

	@Override
	public void majClient(Client c) {
		idao.majClient(c);
	}

	@Override
	public Conseiller verificationLogin(String login, String pwd) {
		return idao.findConseillerbyLoginAndPassword(login, pwd);
	}
	@Override
	public List<Client> listClientsByConseiller(Conseiller co) {
		return idao.listClientsByConseiller(co);
	}
	@Override
	public List<Client> listClients() {
		return idao.listClients();
	}
	@Override
	public Conseiller findConseillerById(long id) {
		return idao.findConseillerById(id);
	}
	@Override
	public List<Client> listClientsByName(String name) {
		return idao.listClientsByName(name);
	}
	@Override
	public long addClientToConseiller(Client cl, Conseiller co) {
			return idao.addClientToConseiller(cl, co);
	}
	@Override
	public Coordonnees getCoordonneesFromClient(Client c) {
		return idao.getCoordonneesFromClient(c);
	}

}
