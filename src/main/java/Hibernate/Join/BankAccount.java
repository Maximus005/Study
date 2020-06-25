package Hibernate.Join;

import Hibernate.Join.BillingDetails;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import javax.persistence.*;

@Entity
@Table(name = "BANK_ACCOUNT")
@Polymorphism(type = PolymorphismType.EXPLICIT)
@Getter
@Setter
public class BankAccount extends BillingDetails {

  private int account;

  @Column(name = "bank_name")
  private String bankName;

  private String swift;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "human_id")
  Human human;

//  public int getHuman() {
//    return human;
//  }
//
//  public void setHuman(int human) {
//    this.human = human;
//  }
//
//  public String getBankName() {
//    return bankName;
//  }
//
//  public void setBankName(String bankName) {
//    this.bankName = bankName;
//  }
//
//  public String getSwift() {
//    return swift;
//  }
//
//  public void setSwift(String swift) {
//    this.swift = swift;
//  }

  @Override
  public String toString() {
    return "BankAccount{" +
        "account=" + account +
        ", bankName='" + bankName + '\'' +
        ", swift='" + swift + '\'' +
        " , owner = " + getOwner() + '\n' +
        " , id = " + getId();
  }

}