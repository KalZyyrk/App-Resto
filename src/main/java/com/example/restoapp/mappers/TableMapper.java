package com.example.restoapp.mappers;

import com.example.restoapp.business.Table;
import com.example.restoapp.jpa.TableEntity;

public class TableMapper {
  public static TableEntity fromBusinessToEntity (Table table) {
    TableEntity entity = new TableEntity();
    entity.setNombreDeCouverts(table.getNombreDeCouverts());
    entity.setNumeroTable(table.getNumeroTable());
    return entity;
  }
}
