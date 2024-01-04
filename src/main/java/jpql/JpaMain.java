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

      List<Object[]> resultList = em.createQuery("select m.username, m.age from Member m")
          .getResultList();
      for (Object[] result : resultList) {
        System.out.println("result[0] = " + result[0]);
        System.out.println("result[1] = " + result[1]);
      }

      List<MemberDTO> resultList2 = em.createQuery(
              "select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
          .getResultList();
      for (MemberDTO m : resultList2) {
        System.out.println("m.getUsername() = " + m.getUsername());
        System.out.println("m.getAge() = " + m.getAge());
      }

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
