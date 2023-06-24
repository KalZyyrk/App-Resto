package com.example.restoapp.business;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Restaurant {
  private String nom;
  private String address;
  private String telephone;
  private String email;

  private List<Table> tables = new ArrayList<>();
  private List<Reservation> reservations = new ArrayList<>();

  public Restaurant() {}

  public Restaurant(String nom, String address, String telephone, String email) {
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

  public List<Table> getTables() {
    return tables;
  }

  public void setTables(List<Table> tables) {
    this.tables = tables;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }

  @Override
  public String toString() {
    return "Restaurant [nom=" + nom + ", address=" + address + ", telephone=" + telephone + ", email=" + email + ", tables=" + tables + ", reservations=" + reservations + "]";
  }

  public static Restaurant creationDeNotreRestaurant() {
    Restaurant restaurant = new Restaurant("Chez Maria", "1 rue de la Paix", "0412345678", "maria@restaurant.fr");

    restaurant.ajouterTable(1, 6);
    restaurant.ajouterTable(2, 2);
    restaurant.ajouterTable(3, 2);
    restaurant.ajouterTable(4, 4);

    return restaurant;
  }

  private void ajouterTable(int numeroTable, int nombreDeCouverts) {
    tables.add(new Table(numeroTable, nombreDeCouverts));

    tables.sort(Comparator.comparing(Table::getNombreDeCouverts));
  }

  private void ajouterReservation(Reservation reservation){
    reservations.add(reservation);
  }

  public String validerDemandeReservation(DemandeReservation demande){
    if(demande.getHoraire().getHour() < 12) {
      return "Restaurant est ouvert à partir de 12h";
    }
    if(demande.getHoraire().getHour() > 13) {
      return "Vous pouvez reserver uniquement pour 12h ou 13h";
    }
    if (demande.getHoraire().getHour() == 13 && demande.getHoraire().getMinute() > 0) {
      return "Vous pouvez reserver uniquement pour 12h ou 13h";
    }
    if(demande.getNombreDeCouverts() > 6) {
      return "Le nombre de couvert maximum pour une réservation est de 6";
    }

    for(Table table: tables) {
      if(table.getNombreDeCouverts() >= demande.getNombreDeCouverts()){

        boolean tableDejaReserver = false;
        for(Reservation reservation: reservations){
          if(reservation.getHoraire().equals(demande.getHoraire()) && (reservation.getTable().getNumeroTable() == table.getNumeroTable()))
            tableDejaReserver = true;
          }

          if(tableDejaReserver) {
            continue;
          } else {
            Reservation reservation = new Reservation(demande.getNombreDeCouverts(), demande.getHoraire(), demande.getPrenom(), demande.getNom());
            reservation.setTable(table);
            ajouterReservation(reservation);
            return "OK: Réservation valider";
          }
      }
    }
    return "Désolé, il n'y a plus de tables disponibles"; 
  }
}
