package Hibernate.Join;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import javax.persistence.*;

@Entity
@Table(name = "BILLING_DETAILS")
@Inheritance(strategy = InheritanceType.JOINED)
@Polymorphism(type = PolymorphismType.EXPLICIT)
@Getter
@Setter
@ToString(of = {"id", "owner"})
public class BillingDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  private String owner;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "human_id")
  Human human;

  public BillingDetails() {
  }

  public int getId() {
    return id;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

}