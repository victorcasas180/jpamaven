package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(0, "Joao", "ffff");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p1);
		em.getTransaction().commit();
		System.out.println("Pronto!");
		
		
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println("Encontrado: " + p);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Removido;");
		
		em.close();
		emf.close();
	}

} 
