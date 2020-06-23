package Hibernate.Associations;

import Hibernate.HibernateUtil;
import javafx.geometry.Pos;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MainAss {

  public static void main(String[] args) {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    Post post = new Post("post 11");

//    session.persist(post);

    Long id = post.getId();

    post.getComments().add(new PostComment("comment 11"));
    post.getComments().add(new PostComment("comment 21"));
    post.getComments().add(new PostComment("comment 31"));

//    System.out.println(post.getComments().get(0).getPostId());

    session.persist(post);

//    Post post1 = session.get(Post.class, 85L);
//    PostComment postComment = session.get(PostComment.class, 50L);

//    post1.getComments().remove(0);

    transaction.commit();
    sessionFactory.close();
  }
}
