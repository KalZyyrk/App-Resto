package com.example.restoapp.jpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurants")
public class RestaurantEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nom;
  private String address;
  private String telephone;
  private String email;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "restaurant_id")
  private List<TableEntity> tables = new ArrayList<>();

  public RestaurantEntity() {
  }
  public RestaurantEntity(String nom, String address, String telephone, String email) {
    this.nom = nom;
    this.address = address;
    this.telephone = telephone;
    this.email = email;
  }

  public String getNom() {
    return nom;
  }
  public void setNom(String nom) {
    this.nom = nom;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getTelephone() {
    return telephone;
  }
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  
  public void addTable(TableEntity tableEntity) {
    tables.add(tableEntity);
  }

  @Override
  public String toString() {
    return "RestaurantEntity [id=" + id + ", nom=" + nom + ", address=" + address + ", telephone=" + telephone
        + ", email=" + email + "]";
  }

}
