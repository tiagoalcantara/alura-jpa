package br.com.tiago.jpa.testes;

import br.com.tiago.jpa.modelos.Categoria;
import br.com.tiago.jpa.modelos.Conta;
import br.com.tiago.jpa.modelos.Movimentacao;
import br.com.tiago.jpa.modelos.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class TestaRelacionamentoMovimentacaoCategoria {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setNome("Viagem");

        Categoria categoria2 = new Categoria();
        categoria2.setNome("Negócios");

        Conta conta = new Conta();
        conta.setId(2L);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDescricao("Viagem ida");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setValor(new BigDecimal("300.0"));
        movimentacao.setCategoria(Arrays.asList(categoria, categoria2));
        movimentacao.setConta(conta);

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setDescricao("Viagem volta");
        movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao2.setData(LocalDateTime.now());
        movimentacao2.setValor(new BigDecimal("300.0"));
        movimentacao.setCategoria(Arrays.asList(categoria, categoria2));
        movimentacao2.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(categoria);
        em.persist(categoria2);
        em.persist(movimentacao);
        em.persist(movimentacao2);
        em.getTransaction().commit();
        em.close();
    }
}
