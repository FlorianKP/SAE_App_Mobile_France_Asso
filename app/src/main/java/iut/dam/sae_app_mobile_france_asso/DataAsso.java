package iut.dam.sae_app_mobile_france_asso;
import java.util.Arrays;
import java.util.List;

public class DataAsso {
    public static List<Association> getAssociations() {
        return Arrays.asList(
                new Association(1, "A.M.I", "Aide aux personnes", "https://ami-handicap.france-assos-sante.org/wp-content/uploads/sites/117/2019/01/customLogo.png"),
                new Association(2, "AAAVAM", "Soutien aux enfants", "https://aaavam.france-assos-sante.org/wp-content/uploads/sites/23/2023/06/logo-300x92.png"),
                new Association(3, "AAVL", "Protection de l'environnement", "https://addictions-alcool-vie-libre.france-assos-sante.org/wp-content/uploads/sites/32/2019/01/logo-300x136.jpg"),
                new Association(4, "ADEPA", "Aide aux personnes", "https://adepa.france-assos-sante.org/wp-content/uploads/sites/134/2022/11/Fichier-32@300x-100-300x246.jpeg"),
                new Association(5, "ADMD", "Soutien aux enfants", "https://admd.france-assos-sante.org/wp-content/uploads/sites/22/2019/01/Meeting18_V2.png"),
                new Association(6, "ADVOCACY", "Protection de l'environnement", "https://imgs.search.brave.com/F69AXs3sFuy6Yc7UGIiIBUyLzZMgJZeY5CbnjUlNc2c/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/ZmVkZXJhdGlvbnNv/bGlkYXJpdGUub3Jn/L3dwLWNvbnRlbnQv/dXBsb2Fkcy8yMDIw/LzA4LzEtQWR2b2Nh/Y3ktRnJhbmNlLTI0/OXgzMDAucG5n")
        );
    }
}
