package agence.models;

import java.util.Date;

public class compte {
    private String type;
    private int numero;
    private double solde;

    private Date date = new Date();
    private double max =4000;
    private int day;

    public compte(String type, int numero, double solde) {

        if (type.equals("courant") || type.equals("épargne")) {
            this.type = type;
            this.solde = solde;
            this.numero = numero;
            this.day=date.getDay();

        } else {
            System.out.println("faux type");
        }

    }

    public boolean setTImeAndMax(double money){
        if(day==date.getDay()&& max-money>0){
            max=max-money;
            return true;
        }
        else if(day!=date.getDay()&& max-money>0){
            max=max-money;
            return true;
        }
        else{
            return false;
        }
    }



    public int getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public String getType() {
        return type;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setType(String type) {
        if (type.equals("courant") || type.equals("épargne")) {
            this.type = type;
        } else {
            System.out.println("faux type");
        }
    }

    @Override
    public String toString() {
        return "le type est : "+getType() + " le numero est : " + getNumero() + " le solde est : " + getSolde();
    }
}
