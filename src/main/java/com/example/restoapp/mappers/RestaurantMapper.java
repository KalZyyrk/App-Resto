package com.example.restoapp.mappers;

import com.example.restoapp.business.Restaurant;
import com.example.restoapp.business.Table;
import com.example.restoapp.jpa.RestaurantEntity;
import com.example.restoapp.jpa.TableEntity;

public class RestaurantMapper {
  
  public static RestaurantEntity fromBusinessToEntity(Restaurant restaurant) {
    RestaurantEntity entity = new RestaurantEntity();
    entity.setAddress(restaurant.getAddress());
    entity.setNom(restaurant.getAddress());
    entity.setEmail(restaurant.getEmail());
    entity.setTelephone(restaurant.getTelephone());

    for(Table table : restaurant.getTables()){
      TableEntity tableEntity = TableMapper.fromBusinessToEntity(table);
      entity.addTable(tableEntity);
    }

    return entity;
  }
}
