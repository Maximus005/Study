package Hibernate.Join;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import java.util.ArrayList;
import java.util.List;

@Entity
@Polymorphism(type = PolymorphismType.EXPLICIT)
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Human {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  Long id;

  @Column(name = "human_name")
  String humanName;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "human")
  List<BillingDetails> billingDetails;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "human")
  List<BankAccount> bankAccounts;

}
