package br.com.tiago.jpa.testes;

import br.com.tiago.jpa.modelos.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlteraSaldoContaTiago {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta contaDoTiago = em.find(Conta.class, 1L);

        em.getTransaction().begin();

        contaDoTiago.setSaldo(50.0);

        em.getTransaction().commit();
    }
}
