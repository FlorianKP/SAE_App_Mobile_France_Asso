package iut.dam.sae_app_mobile_france_asso;

import androidx.appcompat.app.AppCompatActivity;

public class Association extends AppCompatActivity {

    private String id;
    private String name;
    private String category;
    private String description;
    private String logoUrl;

    public Association() {
    }
    public Association(String id, String category, String description, String logoUrl, String name) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.logoUrl = logoUrl;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getLogoUrl(){
        return logoUrl;
    }

    public String getCategory(){
        return category;
    }
}