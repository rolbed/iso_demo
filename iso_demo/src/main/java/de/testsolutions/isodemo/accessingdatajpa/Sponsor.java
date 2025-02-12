package de.testsolutions.isodemo.accessingdatajpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sponsor")
public class Sponsor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  protected Sponsor() {
    // needed for hibernate
  }

  public Sponsor(final String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return String.format("Customer[id=%d, name='%s']", id, name);
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
