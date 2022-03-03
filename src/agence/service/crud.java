package agence.service;

import agence.models.*;
import agence.intefaces.*;

import java.util.HashMap;

public class crud implements Iclient<client>, Icompte<compte>, Iemploye<employe> {

    HashMap<String, client> clientList;
    HashMap<String, compte> compteList;
    HashMap<String, employe> employeList;

    public directeur d = new directeur("dana", "white", "fes", "A111", "directeur");

    public crud() {

        this.clientList = new HashMap<String, client>();
        this.compteList = new HashMap<String, compte>();
        this.employeList = new HashMap<String, employe>();

        client c = new client("maazouz", "youssef", "sale", "1bb");
        client c2 = new client("dustin", "poirier", "warzazat", "Ffb4");
        ajouter(c);
        ajouter(c2);

        compte com = new compte("courant", "4343", 1230);
        compte com2 = new compte("épargne", "2323", 2430);
        compte com3 = new compte("courant", "3443", 4230);

        ajouterCompte("1bb", com);
        ajouterCompte("1bb", com2);
        ajouterCompte("Ffb4", com3);

        employe emp = new employe("conor", "mcgregor", "dublin", "0826", "chef");
        ajouterEmploye(emp);
        System.out.println(d.toString());

        System.out.println("---------------------------------------");
        System.out.println("Chaabi bank by youssef maazouz\n");
    }

    @Override
    public void ajouter(client c) {
        this.clientList.put(c.getCode(), c);
    }

    @Override
    public void supprimer(String code) {
        this.clientList.remove(code);
    }

    @Override
    public void consulter() {
        System.out.println("\n");
        for (client cc : clientList.values()) {
            System.out.println(cc.toString());
        }
        System.out.println("\n");
    }

    @Override
    public client consulter(String code) {
        return clientList.get(code);
    }

    @Override
    public void verser(client c, int numero, double argent) {
        compte comp = c.getComptes().get(numero - 1);

        for (compte com : compteList.values()) {
            if (com.getNumero() == comp.getNumero()) {
                com.setSolde(com.getSolde() + argent);
                System.out.println("\n votre noveau solde est : " + com.getSolde() + "\n");
            }
        }
    }

    @Override
    public void retirer(client c, int numero, double argent) {
        compte comp = c.getComptes().get(numero - 1);

        for (compte com : compteList.values()) {
            if (com.getNumero() == comp.getNumero()) {
                if (com.getType().equals("courant")) {
                    com.setSolde(com.getSolde() - argent);
                    System.out.println("\n votre noveau solde est : " + com.getSolde() + "\n");
                } else {
                    if (com.setTImeAndMax(argent)) {
                        com.setSolde(com.getSolde() - argent);
                        System.out.println("\n votre noveau solde est : " + com.getSolde() + "\n");
                    } else {
                        System.out.println("\n vous avez achevez le max (4000)\n");
                    }
                }
            }
        }
    }

    public void deleteFromComptes(client c, compte com) {
        for (client cc : clientList.values()) {
            if (c.getCode().equals(cc.getCode())) {
                cc.deleteCompte(com);
            }
        }
    }

    @Override
    public void supprimerCompte(String codeC, String numero) {
        client cc = consulter(codeC);
        if (cc == null) {
            System.out.println("le code " + codeC + " n'existe pas");
        } else {
            compteList.remove(String.valueOf(numero));
            deleteFromComptes(cc, consulterCompte(numero));
        }
    }

    public void addToComptes(client c, compte com) {
        for (client cc : clientList.values()) {
            if (c.getCode().equals(cc.getCode())) {
                cc.addCompte(com);
            }
        }
    }

    @Override
    public void ajouterCompte(String code, compte com) {
        client cc = consulter(code);
        if (cc == null) {
            System.out.println("le code " + code + " n'existe pas");
        } else if (cc.getComptes().size() < 3) {
            compteList.put(String.valueOf(com.getNumero()), com);
            addToComptes(cc, com);
            System.out.println("\ncompte ajoutée :\t" + com.toString() + "\n");
        } else {
            System.out.println("le max est 3");
        }
    }

    @Override
    public void consulterComptes() {
        System.out.println("\n");
        for (compte cc : compteList.values()) {
            System.out.println(cc.toString());
        }
        System.out.println("\n");
    }

    @Override
    public compte consulterCompte(String numero) {
        return compteList.get(numero);
    }

    @Override
    public void ajouterEmploye(employe e) {
        employeList.put(e.getCode(), e);
    }

    @Override
    public void supprimerEmploye(String code) {
        employeList.remove(code);
    }

    @Override
    public void consulterEmployes() {
        System.out.println("\n");
        for (employe emp : employeList.values()) {
            System.out.println(emp.toString());
        }
        System.out.println("\n");
    }

    @Override
    public employe consulterEmploye(String code) {
        return employeList.get(code);
    }
}
