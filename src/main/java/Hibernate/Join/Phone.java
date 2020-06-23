package Hibernate.Join;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Phone {

  public Phone() {
  }

  public Phone(String number) {
    this.number = number;
  }

  @Id
  @GeneratedValue
  Integer id;

  @Column(name = "name")
  String number;

  @ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "person_id")
  Person person;
}
