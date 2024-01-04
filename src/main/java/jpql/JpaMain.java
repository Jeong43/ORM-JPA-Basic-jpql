package jpql;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Member member = new Member();
      member.setUsername("member1");
      member.setAge(20);
      em.persist(member);

      List<Member> memberList = em.createQuery("select m from Member m", Member.class)
          .getResultList();
      for (Member m : memberList) {
        System.out.println(m);
      }

      Member findMember = em.createQuery("select m from Member m where m.username = :username",
              Member.class)
          .setParameter("username", "member1")
          .getSingleResult();

      System.out.println("findMember: " + findMember);

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      System.out.println(e);
    } finally {
      em.close();
    }
    emf.close();
  }
}
