package me.patrick.laboratory.jpatest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JpaTest {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("laboratory");
    private final EntityManager em = emf.createEntityManager();
    private final EntityTransaction transaction = em.getTransaction();

    @Test
    public void test() throws Exception {
        Member m = Member.builder()
                .id(14L)
                .username("유호연")
                .age(33)
                .build();

        transaction.begin();

        em.persist(m);

        System.out.println(m.getUsername());

        em.flush();
        transaction.commit();
        em.close();
    }
}
