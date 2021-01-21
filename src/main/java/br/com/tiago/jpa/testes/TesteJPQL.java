package br.com.tiago.jpa.testes;

import br.com.tiago.jpa.modelos.Categoria;
import br.com.tiago.jpa.modelos.Conta;
import br.com.tiago.jpa.modelos.Movimentacao;

import javax.persistence.*;
import java.util.List;

public class TesteJPQL {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Categoria categoria = new Categoria();
        categoria.setId(2L);

        String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pCategoria", categoria);

        List<Movimentacao> resultList = query.getResultList();

        for (Movimentacao movimentacao :
                resultList) {
            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
        }
    }
}
