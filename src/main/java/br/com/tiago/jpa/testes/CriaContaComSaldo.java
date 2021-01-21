package br.com.tiago.jpa.testes;

import br.com.tiago.jpa.modelos.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaContaComSaldo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Reinaldo");
        conta.setAgencia(1234);
        conta.setNumero(4321);
        conta.setSaldo(10.0);

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        em.close();

        EntityManager em2 = emf.createEntityManager();
        conta.setSaldo(500.0);

        em2.getTransaction().begin();
        em2.merge(conta);
        em2.getTransaction().commit();
    }
}
