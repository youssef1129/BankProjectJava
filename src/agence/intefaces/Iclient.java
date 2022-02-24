package agence.intefaces;

import agence.models.*;

public interface Iclient<client> {
    void ajouter(client c);
    void supprimer(String code);
    void consulter();
    client consulter(String code);
}
