package Hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "BANK_ACCOUNT")
@Setter
@Getter
public class BankAccount extends BillingDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  private int account;

  @Column(name = "bank_name")
  private String bankName;

  private String swift;

  public BankAccount() {
  }

  @Override
  public String toString() {
    return "BankAccount{" +
        "account=" + account +
        ", bankName='" + bankName + '\'' +
        ", swift='" + swift + '\'' +
        '}';
  }
}
