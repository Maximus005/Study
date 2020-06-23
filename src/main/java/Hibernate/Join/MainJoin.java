package Hibernate.Join;

import Hibernate.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class MainJoin {

  public static void main(String[] args) throws Exception {

//    CreditCard creditCard = new CreditCard();
//    creditCard.setCardNumber(334);
//    creditCard.setExpMonth("yes");
//    creditCard.setExpYear("20121217");
//    creditCard.setOwner("nope");
//
//    BankAccount bankAccount = new BankAccount();
//    bankAccount.setAccount(32);
//    bankAccount.setBankName("hmm");
//    bankAccount.setSwift("fck");
//    bankAccount.setOwner("opps");

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    Session session;
    Transaction transaction = null;
//    try {
//      session = sessionFactory.getCurrentSession();
//      transaction  = session.beginTransaction();
//      session.persist(creditCard);
//      session.persist(bankAccount);
//      transaction.commit();
//    } catch (Exception e) {
//      transaction.rollback();
//      throw e;
//    }
//
//    Session session1;
//    Transaction transaction1 = null;
//    try {
//      session1 = sessionFactory.getCurrentSession();
//      transaction1  = session1.beginTransaction();
//      List billingDetails = session1.createQuery("select a from BillingDetails a").list();
//
//      for (int i = 0; i < billingDetails.size(); i++) {
//        System.out.println(billingDetails.get(i));
//      }
//
//      System.out.println("---------");
//
//      CreditCard creditCard1 = (CreditCard)session1
//          .createQuery("select a from CreditCard a").list().get(0);
//
//      System.out.println(creditCard1.toString());
//
//    } catch (Exception e) {
//      transaction1.rollback();
//      throw e;
//    }
//
//    System.out.println("\n--------------------");

    Person person = new Person("max");
    Phone phone = new Phone("12111-11-22");
    Phone phone1 = new Phone("12111-11-22");

//    phone.setPerson(person);
    person.getPhoneList().add(phone);
    person.getPhoneList().add(phone1);

//    person.addPhone(phone);

    try {
      session = sessionFactory.openSession();
      transaction  = session.beginTransaction();

      Person person1 = session.get(Person.class, 370);
//      System.out.println(person1.getPhoneList().size());
//      session.persist(person);
//      session.persist(phone);

//      session.flush();
      session.delete(person1);
      transaction.commit();


//      transaction.commit();
      sessionFactory.close();

    } catch (Exception e) {
      System.out.println("Exception !!!");
      System.out.println(e.toString());
      transaction.rollback();
      throw e;
    }

  }
}