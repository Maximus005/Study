package Hibernate.TablePerClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name = "choice_answer")
@DiscriminatorColumn()
@Getter
@Setter
public class ChoiceAnswer extends SimpleAnswer{

//  @Builder
//  public ChoiceAnswer(Long id, String text, Feedback feedback, String choice, Feedback feedback1) {
//    super(id, text, feedback);
//    this.choice = choice;
//    this.feedback = feedback1;
//  }

//  public static class ChoiceAnswerBuilder extends SimpleAnswerBuilder{
//    ChoiceAnswerBuilder() {
//      super();
//    }
//  }

  String choice;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "feedback_id")
  Feedback feedback;

}
