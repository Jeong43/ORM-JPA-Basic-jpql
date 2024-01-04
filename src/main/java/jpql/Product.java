package jpql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private int price;
  private int stockAmount;
}
