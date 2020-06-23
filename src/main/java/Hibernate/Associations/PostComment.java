package Hibernate.Associations;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name = "post_comment1")
@Getter
@Setter
public class PostComment {

  @Id
  @GeneratedValue
  Long id;

  String comment;

//  @Column(name = "post_id")
//  Long postId;

  @ManyToOne
  Post post;

  public void addPost(Post post) {
    post.getComments().add(this);
  }

  public PostComment() {
  }

  public PostComment(String comment) {
    this.comment = comment;
  }

}

