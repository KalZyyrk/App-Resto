package com.example.restoapp.business;

public class Table {
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
  public Table() {
  }

  public Table(int numeroTable, int nombreDeCouverts) {
    this.numeroTable = numeroTable;
    this.nombreDeCouverts = nombreDeCouverts;
  }
 
  @Override
  public String toString() {
    return "Table [numeroTable=" + numeroTable + ", nombreCouverts=" + nombreDeCouverts + "]";
  }
}
