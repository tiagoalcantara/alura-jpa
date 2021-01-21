package br.com.tiago.jpa.testes;

import br.com.tiago.jpa.modelos.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestandoEstados {
    public static void main(String[] args) {
        // Transient
        Conta conta = new Conta();
        conta.setTitular("João");
        conta.setSaldo(10.0);
        conta.setAgencia(1234);
        conta.setNumero(4321);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        // Transient -> Managed
        em.persist(conta);
        // Managed -> Removed
        em.remove(conta);
        em.getTransaction().commit();
    }
}
