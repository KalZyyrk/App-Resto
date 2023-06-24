package com.example.restoapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import com.example.restoapp.business.DemandeReservation;
import com.example.restoapp.business.Restaurant;

public class RestoappUnitTests {
  
  static Restaurant restaurant;

  @BeforeEach
  void setUp() {
    restaurant = Restaurant.creationDeNotreRestaurant();
  }
  
  // @Test
  // void testCreationRestaurant(){
  //   System.out.println(restaurant);
  //   assertEquals(4, restaurant.getTables().size());
  // }

  @Test
  void testHoraireMin() {
    DemandeReservation demande = new DemandeReservation(4, LocalDateTime.of(2023, 6, 21, 10, 00, 00), "Ulysse", "Hischke");
    assertEquals("Restaurant est ouvert à partir de 12h", restaurant.validerDemandeReservation(demande));
  }
  
  @Test
  void testHoraireMax() {
    DemandeReservation demande = new DemandeReservation(4, LocalDateTime.of(2023, 6, 21, 14 , 00), "Ulysse", "Hischke");
    assertEquals("Vous pouvez reserver uniquement pour 12h ou 13h", restaurant.validerDemandeReservation(demande));
  }

    @Test
  void testHoraireMidi() {
    DemandeReservation demande = new DemandeReservation(4, LocalDateTime.of(2023, 6, 21, 12 , 00), "Ulysse", "Hischke");
    assertEquals("OK: Réservation valider", restaurant.validerDemandeReservation(demande));
  }

    @Test
  void testHoraire() {
    DemandeReservation demande = new DemandeReservation(4, LocalDateTime.of(2023, 6, 21, 13 , 05), "Ulysse", "Hischke");
    assertEquals("Vous pouvez reserver uniquement pour 12h ou 13h", restaurant.validerDemandeReservation(demande));
  }

  @Test
  void testOrdreTables() {
    System.out.println(restaurant.getTables());
  }

  @Test
  void testReservation() {
    DemandeReservation demande = new DemandeReservation(6, LocalDateTime.of(2023, 6, 21, 12, 0), "Michel", "Dupont");
    String response = restaurant.validerDemandeReservation(demande);
    assertEquals("OK: Réservation valider", response);
  }
}
