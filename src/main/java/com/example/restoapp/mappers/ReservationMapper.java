package com.example.restoapp.mappers;

import com.example.restoapp.business.Reservation;
import com.example.restoapp.jpa.ReservationEntity;


public class ReservationMapper {

    public static ReservationEntity fromBusinessToEntity(Reservation reservation){
        ReservationEntity entity = new ReservationEntity(
                reservation.getNombreDeCouverts()
                , reservation.getHoraire()
                , reservation.getPrenom()
                , reservation.getNom()
        );

        entity.setTable(TableMapper.fromBusinessToEntity(reservation.getTable()));
        //entity.getRestaurantEntity(RestaurantMapper.fromBusinessToEntity(reservation.getRestaurant));

        return entity;
    }
}
