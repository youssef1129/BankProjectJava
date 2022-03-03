package agence.intefaces;

import agence.models.*;

public interface Icompte<compte> {
    void ajouterCompte(String code,compte com);
    void supprimerCompte(String codeC,String numero);
    void consulterComptes();
    compte consulterCompte(String numero);
    void verser(client c,int num,double argent);
    void retirer(client c,int num,double argent);
}
