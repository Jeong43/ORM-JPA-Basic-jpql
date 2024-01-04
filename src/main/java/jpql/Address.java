package jpql;

import javax.persistence.Embeddable;
import lombok.Value;

@Value
@Embeddable
public class Address {

  String city;
  String street;
  String zipcode;

  public Address() {
    city = null;
    street = null;
    zipcode = null;
  }

  public Address(String city, String street, String zipcode) {
    this.city = city;
    this.street = street;
    this.zipcode = zipcode;
  }
}
