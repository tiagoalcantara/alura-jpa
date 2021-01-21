package br.com.tiago.jpa.testes;

import br.com.tiago.jpa.modelos.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaConta {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Tiago");
        conta.setAgencia(1234);
        conta.setNumero(4321);

        em.getTransaction().begin();

        em.persist(conta);

        em.getTransaction().commit();
    }
}
