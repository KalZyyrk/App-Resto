package com.example.restoapp.business;

import java.time.LocalDateTime;

public class DemandeReservation {
  private int nombreDeCouverts;
  private LocalDateTime horaire;
  private String prenom;
  private String nom;

  public int getNombreDeCouverts() {
    return nombreDeCouverts;
  }
  public void setNombreDeCouverts(int nombreDeCouverts) {
    this.nombreDeCouverts = nombreDeCouverts;
  }
  public LocalDateTime getHoraire() {
    return horaire;
  }
  public void setHoraire(LocalDateTime horaire) {
    this.horaire = horaire;
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
  public DemandeReservation() {
  }
  public DemandeReservation(int nombreDeCouverts, LocalDateTime horaire, String prenom, String nom) {
    this.nombreDeCouverts = nombreDeCouverts;
    this.horaire = horaire;
    this.prenom = prenom;
    this.nom = nom;
  }

  @Override
  public String toString() {
    return "DemandeReservation [nombreDeCouverts=" + nombreDeCouverts + ", horaire=" + horaire + ", prenom=" + prenom
        + ", nom=" + nom + "]";
  }
}
