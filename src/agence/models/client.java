package agence.models;


import java.util.ArrayList;
import java.util.List;

public class client {
    private String nom;
    private String prenom;
    private String ville;
    private String code;
    private List<compte> comptes = new ArrayList<compte>();

    public client(String nom,String prenom,String ville,String code){
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.ville= ville;
    }

    public List<compte> getComptes() {
        return comptes;
    }
    public void setComptes(List<compte> comptes) {
        this.comptes = comptes;
    } 
    public void addCompte(compte cmpt) {
        this.comptes.add(cmpt);
    }
    public void deleteCompte(compte cmpt) {
        this.comptes.remove(cmpt);
    }
    public String getCode() {
        return code;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getVille() {
        return ville;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "le code est : "+getCode()+" le nom est :"+getNom()+" le prenom est : "+getPrenom()+" la ville est : "+getVille();
    }

    public void compteInfo(){
        for (compte compte : comptes) {
            compte.toString();
        }
    }
}
