package Hibernate.TablePerClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.FilterJoinTable;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Feedback {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  Long id;

  String name;

  @Where(clause = "dtype = 'SimpleAnswer'")
  @OneToMany(mappedBy = "feedback", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  List<SimpleAnswer> simpleAnswers = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "feedback_id")
  List<ChoiceAnswer> choiceAnswers = new ArrayList<>();

}
