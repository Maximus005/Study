package Hibernate.Join;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Person {

  public Person() {
  }

  public Person(String name) {
    this.name = name;
  }

  @Id
  @GeneratedValue
  Integer id;

  String name;

//  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
//  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "person")
//  @JoinColumn(name = "person_id")
  List<Phone> phoneList = new ArrayList<>();

  public void addPhone(Phone phone) {
    phoneList.add(phone);
    phone.setPerson(this);
  }
}
