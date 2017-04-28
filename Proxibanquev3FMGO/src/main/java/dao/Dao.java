package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Client;
import metier.Conseiller;
import metier.Coordonnees;

public class Dao implements IDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdd-pu");

	public long addCoordonnees(Coordonnees c){
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();
		return c.getId();
	}
	
	@Override
	public long addClient(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();
		return c.getId();
	}

	@Override
	public List<Client> listClients() {
		EntityManager em = emf.createEntityManager();
		List<Client> clients = em.createQuery("SELECT c from Client c LEFT JOIN c.coordonnees").getResultList();
		em.close();
		return clients;
	}

	@Override
	public void deleteClient(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.contains(c) ? c : em.merge(c));
		tx.commit();
		em.close();
	}

	@Override
	public Client findClientById(long idClient) {
		EntityManager em = emf.createEntityManager();
		Client client = em.find(Client.class, idClient);
		em.close();
		return client;
	}

	@Override
	public void majClient(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
		em.close();
	}

	@Override
	public long addCoordonneesToClient(Coordonnees co, Client cl) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		cl.setCoordonnees(co);
		em.persist(cl);
		tx.commit();
		em.close();
		return cl.getId();
	}
	
	@Override
	public Conseiller findConseillerbyLoginAndPassword(String login, String pwd) {
		Conseiller conseiller = new Conseiller();
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT c from Conseiller c WHERE c.login=:leLogin AND c.pwd=:lePwd");
		q.setParameter("leLogin", login);
		q.setParameter("lePwd", pwd);
		List<Conseiller> results = q.getResultList();
		if (!results.isEmpty()){
			   conseiller = results.get(0);}
		em.close();
		return conseiller;
	}

	@Override
	public List<Client> listClientsByConseiller(Conseiller co) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT c from Client c WHERE c.conseiller=:leConseiller");
		q.setParameter("leConseiller", co);
		List<Client> clients = q.getResultList();
		em.close();
		return clients;
	}

	@Override
	public Conseiller findConseillerById(long id) {
		EntityManager em = emf.createEntityManager();
		Conseiller conseiller = em.find(Conseiller.class, id);
		em.close();
		return conseiller;
	}

	@Override
	public List<Client> listClientsByName(String name) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT c FROM Client c where c.nom LIKE :leNom");
		q.setParameter("leNom", "%name%");
		List<Client> clients = q.getResultList();
		em.close();
		return clients;
	}

	@Override
	public long addClientToConseiller(Client cl, Conseiller co) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		if (co.getClients().size()<10){
			co.getClients().add(cl);
			em.persist(co);
			tx.commit();
			em.close();
			return co.getId();
		}
		else{
			em.close();
			return 0;
		}	
	}

	@Override
	public Coordonnees getCoordonneesFromClient(Client cl) {
		Coordonnees coordonnees = new Coordonnees();
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT c.coordonnees from Client c WHERE c.id=:lId");
		q.setParameter("lId", cl.getId());
		List<Coordonnees> results = q.getResultList();
		if (!results.isEmpty()){
			   coordonnees = results.get(0);}
		em.close();
		return coordonnees;
	}

}
