package agence;

import java.util.Scanner;
import agence.models.*;

public class App {
    public static Scanner sc = new Scanner(System.in);
    public static crud crd = new crud();

    public static void main(String[] args) throws Exception {


        System.out.println("---------------------------------------");
        System.out.println("Chaabi bank\n");
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
            do {
                System.out.println("\nbienvenue monsieur " + crd.d.getNom()+"\n");
                System.out.println("consulter les employes :   1");
                System.out.println("consulter les clients  :   2");
                System.out.println("consulter les comptes  :   3");
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
                }
            } while (choix < 4 && choix > 0);
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
            System.out.println("bienvenue monsieur " + emp.getNom());
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
                    int numero = sc.nextInt();
                    compte com = crd.consulterCompte(numero);
                    try {
                        System.out.println("\n" + com.toString() + "\n");
                    } catch (Exception e) {
                        System.out.println("\n compte n'existe pas \n");
                    }

                }
                if (choix == 1) {
                    String nom = sc.next();
                    System.out.println("entrez le nom :\t");
                    nom = sc.next();
                    System.out.println("entrez le prenom :\t");
                    String prenom = sc.next();
                    System.out.println("entrez le code :\t");
                    String codec = sc.next();
                    System.out.println("entrez le ville :\t");
                    String ville = sc.next();

                    client newClient = new client(nom, prenom, ville, codec);
                    crd.ajouter(newClient);
                    System.out.println("client ajoutée! \t" + newClient.toString());

                }
                if (choix == 3) {
                    System.out.println("entrez le code du client :\t");
                    String codeclient = sc.next();

                    System.out.println("entrez le type :\t");
                    String type = sc.next();
                    System.out.println("entrez le numero :\t");
                    int numero = sc.nextInt();
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
                    int numero = sc.nextInt();
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

            if (c!=null){
                login = true;
                

                do{
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
                    crd.verser(c,compte, money);
                } else if (choix == 2) {
                    System.out.print("donnez le prix que vous voulez retirer :\t");
                    double money = sc.nextDouble();
                    crd.retirer(c,compte, money);
                }

            }while(choix>0&&choix<3);

            }
        if (!login) {
            System.out.println("code incorrect");
            return loginC();
        }
        return login;
    }
}
