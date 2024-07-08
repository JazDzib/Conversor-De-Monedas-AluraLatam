package Modelo;

public class Moneda {
    private Double ars; //Dolar americano
    private Double bob; //Peso mexicano
    private Double brl; //Euro
    private Double clp; //Peso argentino
    private Double cop; //Real brasileño
    private Double usd; //Yen


    public Moneda(Intermediaria monedaRecord) {
        this.ars = monedaRecord.conversion_rates().get("ARS");
        this.bob = monedaRecord.conversion_rates().get("BOB");
        this.brl = monedaRecord.conversion_rates().get("BRL");
        this.clp = monedaRecord.conversion_rates().get("CLP");
        this.cop = monedaRecord.conversion_rates().get("COP");
        this.usd = monedaRecord.conversion_rates().get("USD");

    }

    public double cambio(Double entrada, int moneda){
        return(entrada * convertidor(moneda));

    }
    public double convertidor(int moneda){
        if(moneda==1) {
            return this.ars;
        }else if (moneda==2) {
            return this.bob;
        } else if (moneda==3) {
            return this.brl;
        } else if (moneda ==4) {
            return  this.clp;
        } else if (moneda==5) {
            return this.cop;
        } else {
            return this.usd;
        }

    }

    public Double getArs() {
        return ars;
    }

    public void setArs(Double ars) {
        this.ars = ars;
    }

    public Double getBob() {
        return bob;
    }

    public void setBob(Double bob) {
        this.bob = bob;
    }

    public Double getBrl() {
        return brl;
    }

    public void setBrl(Double brl) {
        this.brl = brl;
    }

    public Double getClp() {
        return clp;
    }

    public void setClp(Double clp) {
        this.clp = clp;
    }

    public Double getCop() {
        return cop;
    }

    public void setCop(Double cop) {
        this.cop = cop;
    }

    public Double getUsd() {
        return usd;
    }

    public void setUsd(Double usd) {
        this.usd = usd;
    }
}
