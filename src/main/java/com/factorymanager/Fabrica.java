package com.factorymanager;

public class Fabrica {
  private   int idFabrica;
   private String tipoFabrica;
   private String nomeFabrica;

    public Fabrica(int idFabrica,String tipoFabrica,String nomeFabrica){
    this.idFabrica = idFabrica;
    this.tipoFabrica = tipoFabrica;
    this.nomeFabrica = nomeFabrica;
    }

    public int getIdFabrica() {
        return idFabrica;
    }

    public void setIdFabrica(int idFabrica) {
        this.idFabrica = idFabrica;
    }

    public String getTipoFabrica() {
        return tipoFabrica;
    }

    public void setTipoFabrica(String tipoFabrica) {
        this.tipoFabrica = tipoFabrica;
    }

    public String getNomeFabrica() {
        return nomeFabrica;
    }

    public void setNomeFabrica(String nomeFabrica) {
       this.nomeFabrica = nomeFabrica;
    }
}
