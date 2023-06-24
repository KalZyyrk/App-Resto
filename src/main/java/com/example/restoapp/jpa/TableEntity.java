package com.example.restoapp.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "tables")
public class TableEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private int numeroTable;
  private int nombreDeCouverts;
  
  public int getNumeroTable() {
    return numeroTable;
  }
  public void setNumeroTable(int numeroTable) {
    this.numeroTable = numeroTable;
  }
  public int getNombreDeCouverts() {
    return nombreDeCouverts;
  }
  public void setNombreDeCouverts(int nombreDeCouverts) {
    this.nombreDeCouverts = nombreDeCouverts;
  }
  public TableEntity() {
  }

  public TableEntity(int numeroTable, int nombreDeCouverts) {
    this.numeroTable = numeroTable;
    this.nombreDeCouverts = nombreDeCouverts;
  }
 
  @Override
  public String toString() {
    return "Table [numeroTable=" + numeroTable + ", nombreCouverts=" + nombreDeCouverts + "]";
  }
}
