package agence.intefaces;

import agence.models.*;

public interface Iemploye<employe> {
    void ajouterEmploye(employe e);
    void supprimerEmploye(String code);
    void consulterEmployes();
    employe consulterEmploye(String code);
}
