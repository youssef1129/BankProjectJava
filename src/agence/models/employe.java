package agence.models;

public class employe extends client{
    private String fonction;
    
    public employe(String nom, String prenom, String ville, String code,String fonction) {
        super(nom, prenom, ville, code);
        this.fonction = fonction;
    }

    public String getFonction() {
        return fonction;
    }
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    @Override
    public String toString() {
        return super.toString()+ " fonction : "+getFonction();
    }
}
