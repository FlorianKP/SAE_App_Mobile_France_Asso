package iut.dam.sae_app_mobile_france_asso;

import androidx.appcompat.app.AppCompatActivity;

public class Association extends AppCompatActivity {

    private int id;
    private String name;
    private String categorie;
    private String logoUrl;

    public Association(int id, String name, String description, String logoUrl) {
        this.id = id;
        this.name = name;
        this.categorie = description;
        this.logoUrl = logoUrl;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCategorie() {
        return categorie;
    }
    public String getLogoUrl() {
        return logoUrl;
    }
}