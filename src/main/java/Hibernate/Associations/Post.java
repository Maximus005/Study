package Hibernate.Associations;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Post {

  @Id
  @GeneratedValue
  Long id;

  String title;

  @OneToMany(cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.EAGER,
      mappedBy = "post")
//  @JoinColumn(name = "post_id")
  List<PostComment> comments = new ArrayList<>();

  public Post() {
  }

  public Post(String title) {
    this.title = title;
  }

}
