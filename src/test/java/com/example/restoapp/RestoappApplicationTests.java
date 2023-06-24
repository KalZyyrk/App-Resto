package com.example.restoapp;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.restoapp.business.Reservation;
import com.example.restoapp.business.Restaurant;
import com.example.restoapp.jpa.ReservationEntity;
import com.example.restoapp.jpa.ReservationRepository;
import com.example.restoapp.jpa.RestaurantEntity;
import com.example.restoapp.jpa.RestaurantRepository;
import com.example.restoapp.jpa.TableEntity;
import com.example.restoapp.jpa.TableRepository;
import com.example.restoapp.mappers.ReservationMapper;
import com.example.restoapp.mappers.RestaurantMapper;

@SpringBootTest
class RestoappApplicationTests {

  @Autowired
  RestaurantRepository restaurantRepository;
  
  @Autowired
  ReservationRepository reservationRepository;

  @Autowired
  TableRepository tableRepository;

	@Test
	void testCreationRestaurant() {
    Restaurant monRestaurant =  Restaurant.creationDeNotreRestaurant();
    RestaurantEntity entity = RestaurantMapper.fromBusinessToEntity(monRestaurant);
    restaurantRepository.save(entity);
	}

  @Test
	void testLireRestaurant() {
    List<RestaurantEntity> restaurants = restaurantRepository.findAll();
    for(RestaurantEntity r : restaurants){
      System.out.println(r);
    };
	}

  @Test
  void testReservation() {
    TableEntity entityTable = new TableEntity(1, 4);
    tableRepository.save(entityTable);

    Reservation reservation = new Reservation(4, LocalDateTime.of(2023, 6, 21, 10, 0), "Michel","Dupont");
    ReservationEntity entityReservation = ReservationMapper.fromBusinessToEntity(reservation);
    entityReservation.setTable(entityTable);

    reservationRepository.save(entityReservation);
  }
}
