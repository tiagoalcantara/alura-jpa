package br.com.tiago.jpa.testes;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabelas {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        emf.createEntityManager();
        emf.close();
    }
}
