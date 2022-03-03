package agence;

import java.util.Scanner;
import agence.models.*;
import agence.service.crud;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static crud crd = new crud();

    public static void main(String[] args) throws Exception {

        
        int choix;

        do {
            System.out.println("si vous etes le directeur clickez sur :\t1");
            System.out.println("si vous etes le employee clickez sur :\t2");
            System.out.println("si vous etes le client clickez sur :\t3");
            System.out.println("exit any key");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    loginD();
                    break;
                case 2:
                    loginE();
                    break;
                case 3:
                    loginC();
                    break;

            }
        } while (choix < 4 && choix > 0);
    }

    public static boolean loginD() {
        boolean login = false;
        int choix;
        System.out.println("donnez votre nom :\t");
        String nomD = sc.next();
        System.out.println("donnez votre code :\t");
        String codeD = sc.next();
        if (crd.d.getNom().equals(nomD) && crd.d.getCode().equals(codeD)) {
            System.out.println("\nbienvenue monsieur " + crd.d.getNom() + "\n");
            do {
                System.out.println("consulter les employes :   1");
                System.out.println("consulter les clients  :   2");
                System.out.println("consulter les comptes  :   3");
                System.out.println("ajouter un employe     :   4");
                System.out.println("supprimer un employe   :   5");
                System.out.println("ajouter un client      :   6");
                System.out.println("supprimer un client    :   7");
                System.out.println("ajouter un compte      :   8");
                System.out.println("supprimer un compte    :   9");
                choix = sc.nextInt();
                switch (choix) {
                    case 1:
                        crd.consulterEmployes();
                        break;
                    case 2:
                        crd.consulter();
                        break;
                    case 3:
                        crd.consulterComptes();
                        break;
                    case 4:
                        System.out.println("donnez le code :\t");
                        String code = sc.next();
                        System.out.println("donnez le nom :\t");
                        String nom = sc.next();
                        System.out.println("donnez le prenom :\t");
                        String prenom = sc.next();
                        System.out.println("donnez le ville :\t");
                        String ville = sc.next();
                        System.out.println("donnez le fonction :\t");
                        String fonction = sc.next();

                        employe emp = new employe(nom, prenom, ville, code, fonction);
                        crd.ajouterEmploye(emp);
                        System.out.println("\n"+emp.toString() + "\nemploye est  bien ajouté\n");

                        break;
                    case 5:
                        System.out.println("donnez le code de l'employe :\t");
                        String codeE = sc.next();
                        employe em = crd.consulterEmploye(codeE);
                        if (em != null) {
                            crd.supprimerEmploye(codeE);
                            System.out.println("\nemploye est  bien supprimé\n");
                        } else {
                            System.out.println("\nemploye n'existe pas\n");
                        }
                        break;
                    case 6:
                        System.out.println("entrez le nom :\t");
                        String nomC = sc.next();
                        System.out.println("entrez le prenom :\t");
                        String prenomC = sc.next();
                        System.out.println("entrez le code :\t");
                        String codeC = sc.next();
                        System.out.println("entrez le ville :\t");
                        String villeC = sc.next();

                        client newClient = new client(nomC, prenomC, villeC, codeC);
                        crd.ajouter(newClient);
                        System.out.println("client ajoutée! \t" + newClient.toString());
                        break;
                    case 7:
                        System.out.println("entrez le code du client");
                        String codeClient = sc.next();
                        crd.supprimer(codeClient);
                        System.out.println("suprimée!!");
                        break;
                    case 8:
                        System.out.println("entrez le code du client :\t");
                        String codeclient = sc.next();

                        String type ="";
                        do{
                        System.out.println("entrez le type :\t");
                        type = sc.next();
                        }while(!type.equals("courant")&&!type.equals("épargne"));

                        System.out.println("entrez le numero :\t");
                        String numero = sc.next();
                        System.out.println("entrez le solde :\t");
                        double solde = sc.nextDouble();

                        compte cmpt = new compte(type, numero, solde);
                        crd.ajouterCompte(codeclient, cmpt);
                        break;
                    case 9:
                        System.out.println("entrez le code du client");
                        String codeCl = sc.next();
                        System.out.println("entrez le numero du compte");
                        String num = sc.next();
                        crd.supprimerCompte(codeCl, num);
                        System.out.println("\nsuprimée!!\n");
                        break;
                }
            } while (choix < 10 && choix > 0);
            login = true;
        } else {
            System.out.println("nom ou code incorrect");
            return loginD();
        }
        return login;

    }

    public static boolean loginE() {
        System.out.println("donnez votre code :\t");
        String codeD = sc.next();

        boolean book = false;
        employe emp = crd.consulterEmploye(codeD);
        if (emp != null) {
            System.out.println("\nbienvenue monsieur " + emp.getNom()+"\n");
            book = true;
            int choix;

            do {
                System.out.println("ajouter un client :\t1");
                System.out.println("supprimer un client :\t2");
                System.out.println("ajouter un compte :\t3");
                System.out.println("supprimer un compte :\t4");
                System.out.println("afficher un client :\t5");
                System.out.println("afficher un compte :\t6");
                choix = sc.nextInt();
                if (choix == 5) {
                    System.out.println("entrez le code du client :\t");
                    String code = sc.next();
                    client clt = crd.consulter(code);
                    try {
                        System.out.println("\n" + clt.toString() + "\n");
                    } catch (Exception e) {
                        System.out.println("\n client n'existe pas \n");
                    }
                }
                if (choix == 6) {
                    System.out.println("entrez le numero du compte :\t");
                    String numero = sc.next();
                    compte com = crd.consulterCompte(numero);
                    try {
                        System.out.println("\n" + com.toString() + "\n");
                    } catch (Exception e) {
                        System.out.println("\n compte n'existe pas \n");
                    }

                }
                if (choix == 1) {
                    System.out.println("entrez le nom :\t");
                    String nom = sc.next();
                    System.out.println("entrez le prenom :\t");
                    String prenom = sc.next();
                    System.out.println("entrez le code :\t");
                    String codec = sc.next();
                    System.out.println("entrez le ville :\t");
                    String ville = sc.next();

                    client newClient = new client(nom, prenom, ville, codec);
                    crd.ajouter(newClient);
                    System.out.println("\nclient ajoutée! \t" + newClient.toString()+"\n");

                }
                if (choix == 3) {
                    System.out.println("entrez le code du client :\t");
                    String codeclient = sc.next();

                    String type ="";
                    do{
                    System.out.println("entrez le type :\t");
                    type = sc.next();
                    }while(!type.equals("courant")&&!type.equals("épargne"));
                    System.out.println("entrez le numero :\t");
                    String numero = sc.next();
                    System.out.println("entrez le solde :\t");
                    double solde = sc.nextDouble();

                    compte cmpt = new compte(type, numero, solde);
                    crd.ajouterCompte(codeclient, cmpt);
                }
                if (choix == 2) {
                    System.out.println("entrez le code du client");
                    String codeClient = sc.next();
                    crd.supprimer(codeClient);
                    System.out.println("suprimée!!");

                }
                if (choix == 4) {
                    System.out.println("entrez le code du client");
                    String codeClient = sc.next();
                    System.out.println("entrez le numero du compte");
                    String numero = sc.next();
                    crd.supprimerCompte(codeClient, numero);
                    System.out.println("suprimée!!");
                }

            } while (choix < 7 && choix > 0);
        }

        if (!book) {
            System.out.println("code incorrect");
            return loginE();
        }
        return false;
    }

    public static boolean loginC() {
        boolean login = false;
        int choix;
        System.out.print("donnez le code de votre compte : \n");

        String code = sc.next();
        client c = crd.consulter(code);

        if (c != null) {
            login = true;

            do {
                int compte = 0;
                int index = 0;

                for (compte com : c.getComptes()) {
                    System.out.println(com.toString());
                    System.out.println("pour choisir le compte " + com.getNumero() + ": " + ++index);
                }
                System.out.println();
                compte = sc.nextInt();
                System.out.println("si vous voulez verser  :  1");
                System.out.println("si vous voulez retirer :  2");
                choix = sc.nextInt();

                if (choix == 1) {
                    System.out.print("donnez le prix que vous voulez verser :\t");
                    double money = sc.nextDouble();
                    crd.verser(c, compte, money);
                } else if (choix == 2) {
                    System.out.print("donnez le prix que vous voulez retirer :\t");
                    double money = sc.nextDouble();
                    crd.retirer(c, compte, money);
                }

            } while (choix > 0 && choix < 3);

        }
        if (!login) {
            System.out.println("code incorrect");
            return loginC();
        }
        return login;
    }
}
