package Hibernate.TablePerClass;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DiscriminatorOptions;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
//@DiscriminatorValue()
//@Table(name = "simple_answer")
@Getter
@Setter
public class SimpleAnswer {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  Long id;

  String text;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "feedback_id")
  Feedback feedback;

}
