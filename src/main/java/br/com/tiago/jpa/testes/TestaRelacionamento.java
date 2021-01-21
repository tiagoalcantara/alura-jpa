package br.com.tiago.jpa.testes;

import br.com.tiago.jpa.modelos.Conta;
import br.com.tiago.jpa.modelos.Movimentacao;
import br.com.tiago.jpa.modelos.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestaRelacionamento {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setTitular("Mario Alberto");
        conta.setSaldo(100.0);
        conta.setAgencia(1234);
        conta.setNumero(4321);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescricao("Pizza");
        movimentacao.setValor(new BigDecimal("200.0"));
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(conta);
        em.persist(movimentacao);
        em.getTransaction().commit();
        em.close();
    }
}
