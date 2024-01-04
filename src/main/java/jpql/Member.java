package jpql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Member {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "name")
  private String username;
  private int age;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Team team;
}
