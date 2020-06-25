package Hibernate.TablePerClass;

import Hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.concurrent.Future;


public class Main {

  public static void main(String[] args) throws Exception {


    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    Session session;
    Transaction transaction = null;
    try {
      session = sessionFactory.getCurrentSession();
      transaction  = session.beginTransaction();

      Feedback feedback = new Feedback();
      feedback.setName("feedback 1");

      SimpleAnswer simpleAnswer = new SimpleAnswer();
      simpleAnswer.setText("text simple answer");
      simpleAnswer.setFeedback(feedback);

      ChoiceAnswer choiceAnswer = new ChoiceAnswer();
      choiceAnswer.setText("text choice answer");
      choiceAnswer.setChoice("choice");
      choiceAnswer.setFeedback(feedback);

      Feedback feedback1 = feedback;
      feedback1.getChoiceAnswers().add(choiceAnswer);
      feedback1.getSimpleAnswers().add(simpleAnswer);

//      session.persist(feedback1);
//      session.persist(choiceAnswer);
      Feedback feedback2 = session.get(Feedback.class, 4L);
//      feedback2.getSimpleAnswers().size();
//      feedback2.getChoiceAnswers().size();


      transaction.commit();
      sessionFactory.close();
    } catch (Exception e) {
      transaction.rollback();
      sessionFactory.close();
      throw e;
    }

  }
}