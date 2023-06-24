package com.example.restoapp.business;

import java.time.LocalDateTime;

public class Reservation {
  private int nombreDeCouverts;
  private LocalDateTime horaire;
  private String prenom;
  private String nom;
  
  private Table table;
  
  public Reservation() {
  }

  public Reservation(int nombreDeCouverts, LocalDateTime horaire, String prenom, String nom) {
    this.nombreDeCouverts = nombreDeCouverts;
    this.horaire = horaire;
    this.prenom = prenom;
    this.nom = nom;
  }

  public int getNombreDeCouverts() {
    return nombreDeCouverts;
  }

  public void setNombreDeCouverts(int nombreDeCouverts) {
    this.nombreDeCouverts = nombreDeCouverts;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public LocalDateTime getHoraire() {
    return horaire;
  }

  public void setHoraire(LocalDateTime horaire) {
    this.horaire = horaire;
  }

  public Table getTable() {
    return table;
  }

  public void setTable(Table table) {
    this.table = table;
  }
  
  @Override
  public String toString() {
    return "Reservation [nombreDeCouverts=" + nombreDeCouverts + ", horaire=" + horaire + ", prenom=" + prenom + ", nom=" + nom + ", table=" + table + "]";
  }

}
