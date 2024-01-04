package jpql;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ORDERS")
public class Order {

  @Id
  @GeneratedValue
  private Long id;
  private int orderAmount;
  @Embedded
  private Address address;
  @ManyToOne
  @JoinColumn(name = "PRODUCT_ID")
  private Product product;
  @ManyToOne
  @JoinColumn(name = "ORDER_ID")
  private Member member;
}
