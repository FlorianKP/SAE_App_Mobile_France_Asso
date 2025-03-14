package iut.dam.sae_app_mobile_france_asso;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FirestoreAssoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void ajouterCategories(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Liste des associations
        String[][] categories = {
                {"1", "Maladies chroniques"},
                {"2", "Accidents et effets secondaires"},
                {"3", "Handicap et dépendance"},
                {"4", "Santé mentale et bien-être psychique"},
                {"5", "Droits des patients et accès aux soins"},
                {"6", "Soutien aux aidants et proches"},
                {"7", "Prévention et santé publique"}

        };

        // Ajout des catégories dans Firestore
        for (String[] categ : categories) {
            String id = categ[0];
            String name = categ[1];

            Map<String, Object> data = new HashMap<>();
            data.put("name", name);

            db.collection("categories").document(id)
                    .set(data)
                    .addOnSuccessListener(aVoid -> Log.d("Firestore", "Categorir ajoutée avec succès"))
                    .addOnFailureListener(e -> Log.w("Firestore", "Erreur lors de l'ajout de la categorie", e));
        }
    }
    public void ajouterAssociations() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Liste des associations
        String[][] associations = {
                {"1", "A.M.I","6" ,"https://ami-handicap.france-assos-sante.org/wp-content/uploads/sites/117/2019/01/customLogo.png"},
                {"2", "AAAVAM", "2" ,"https://aaavam.france-assos-sante.org/wp-content/uploads/sites/23/2023/06/logo-300x92.png"},
                {"3", "AAVL","7"  ,"https://www.vielibre.org/wp-content/themes/wp-bootstrap-starter/img/logo.jpg"},
                {"4", "ADEPA", "3" ,"https://www.adepa.fr/wp-content/uploads/2023/10/Logo-ADEPA-associoation-defense-entraide-personnes-amputees.png"},
                {"5", "ADMD","7"  ,"https://www.admd.net/themes/custom/admd/images/logo.png"},
                {"6", "Advocacy France","4" , "https://imgs.search.brave.com/F69AXs3sFuy6Yc7UGIiIBUyLzZMgJZeY5CbnjUlNc2c/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/ZmVkZXJhdGlvbnNv/bGlkYXJpdGUub3Jn/L3dwLWNvbnRlbnQv/dXBsb2Fkcy8yMDIw/LzA4LzEtQWR2b2Nh/Y3ktRnJhbmNlLTI0/OXgzMDAucG5n"},
                {"7", "AFA", "1" ,"https://www.afa.asso.fr/wp-content/uploads/2019/09/LOGO-AFA.png"},
                {"8", "AFDE", "2" ,"https://afde.net/wp-content/uploads/2022/10/logo-afde.jpg"},
                {"9", "AFDOC","2"  ,"https://afdoc.fr/local/cache-vignettes/L400xH120/afdoc-logo-05-38b2c.png?1710244315"},
                {"10", "AFGS","2"  ,"https://www.afgs-syndromes-secs.org/assets/logo/logo_afgs.png"},
                {"11", "AFH","2"  ,"https://app.assoconnect.com/services/storage?id=5111433&type=picture&secret=lD13fanUd1Wm20DvBoeXAme1FZtX0wKvwzeKRG0f&timestamp=1733500311&size=small"},
                {"12", "AFM", "1" ,"https://www.afm-telethon.fr/sites/default/files/styles/webp/public/logo/AFM_TELETHON_Q.png.webp?itok=CM1KrGfb"},
                {"13", "AFPric","1" ,"https://www.polyarthrite.org/wp-content/uploads/2023/07/logo_poly.png"},
                {"14", "AFS","1"  ,"https://www.spondy.fr/wp-content/uploads/2024/11/Logo-AFS-Et-Rics.png"},
                {"15", "AFSA","2"  ,"https://afsa.france-assos-sante.org/wp-content/uploads/sites/30/2019/01/afsa-logo-2018-300x211.png"},
                {"16", "AFSEP","1"  ,"https://afsep.fr/asso/wp-content/uploads/2023/10/logo_AFSEP_Octobre2020.webp"},
                {"17", "AFVD", "2" ,"https://www.association-afvd.com/images/afvd-logo-couleur-petit.png"},
                {"18", "AFVS", "2" ,"https://afvs.france-assos-sante.org/wp-content/uploads/sites/60/2019/01/logo-AFVS-web-200x120.jpg"},
                {"19", "AIDES","1"  ,"https://www.aides.org/themes/custom/aides/public/images/general/logo.png"},
                {"20", "AINP", "2" ,"https://app.assoconnect.com/services/storage?id=5348824&type=picture&secret=4duN7vCS7IZGlKLyk1rPmYXX4xyuyYv5YqAjLvoo&timestamp=1739992941"},
                {"21", "AEJS","7"  ,"https://www.alcoolecoute.com/images/logo_alcool_ecoute.png"},
                {"22", "AMR","1"  ,"https://alliance-maladies-rares.france-assos-sante.org/wp-content/uploads/sites/72/2019/01/logo-AMR-200x185.jpg"},
                {"23", "Amadys","1"  ,"https://amadys.fr/wp-content/themes/amadys/images/logo-amadys.png"},
                {"24", "AMALYSTE","1"  ,"https://www.amalyste.fr/wp-content/uploads/2023/11/2023-11-12-Banniere-site-web.jpg"},
                {"25", "ANDAR", "1" ,"https://www.polyarthrite-andar.org/images/imagecache/0x97/png/template_images_Logo_ANDAR.webp"},
                {"26", "APAJH", "3" ,"https://www.apajh.org/uploads/2023/02/logo-fede-apajh.jpg"},
                {"27", "APF France handicap","3"  ,"https://apf-france-handicap.france-assos-sante.org/wp-content/uploads/sites/78/2019/01/Logo-bloc-APF-France-handicap-bichromie-200x126.jpg"},
                {"28", "APODEC","2"  ,"https://app.assoconnect.com/services/storage?id=4320875&type=picture&secret=8cfjzkPPwfJmJ4sjEbmfnRkEgHnX12LPf0Oz9KDS&timestamp=1713532804&size=small"},
                {"29", "ARGOS 2001","4"  ,"https://argos2001.france-assos-sante.org/wp-content/uploads/sites/82/2019/01/argos2001-Logo-200x64-160x51.jpg"},
                {"30", "ARSLA", "2" ,"https://www.arsla.org/app/themes/arsla/images/logo.png"},
                {"31", "ASBH","3"  ,"https://www.spina-bifida.org/wp-content/uploads/2019/10/Logo-ASBH-website-2019.png"},
                {"32", "ASF", "1" ,"https://www.association-sclerodermie.fr/wp-content/uploads/2023/01/nouveau-logo-2023-reduit-334x350.jpg"},
                {"33", "ASFC", "1" ,"https://asfc.france-assos-sante.org/wp-content/uploads/sites/92/2019/01/Logo-ASFC-haute-def-2018-300x158.png"},
                {"34", "ABF","2"  ,"https://abf-association-brules-france.france-assos-sante.org/wp-content/uploads/sites/135/2022/10/logo.png"},
                {"35", "AFRH","7"  , "https://www.afrh.fr/files/drag-and-drop-img-436.png"},
                {"36", "AT","5"  ,"https://actions-traitements.org/images/AT_logo.png"},
                {"37", "Autisme France","1"  ,"https://www.autisme-france.fr/f/d8a9e3456da753f26b7d19471bd21cc854b01e50/logo-autisme-france.png"},
                {"38", "AVIAM","2"  ,"https://aviam.france-assos-sante.org/wp-content/uploads/sites/96/2019/01/logo-aviam-161x200.jpg"},
                {"39", "CADUS", "5 " ,"https://www.france-assos-sante.org/wp-content/uploads/2018/11/cadus-200x136.png"},
                {"40", "CLCV", "7" ,"https://clcv-isere.org/wp-content/uploads/2022/03/logo-clcv-isere.webp"},
                {"41", "CNAFAL","7" ,"https://www.cnafal.org/wp-content/themes/cnafal/images/familles_laiques.gif"},
                {"42", "CNAFC","7"  ,"https://www.afc-france.org/wp-content/uploads/2020/10/logo-AFC.png"},
                {"43", "CNAO","5"  ,"https://cnao.fr/wp-content/uploads/2021/02/cnao_logo.jpg"},
                {"44", "E3M","2"  ,"https://www.asso-e3m.fr/wp-content/uploads/2019/10/Logo-E3M-carre%CC%81-RVB-300x300.jpg"},
                {"45", "EFAPPE","7"  ,"https://www.efappe.epilepsies.fr/wp-content/uploads/2014/09/cropped-cropped-Banniere-bis.jpg"},
                {"46", "EndoFrance","1"  ,"https://endofrance.org/wp-content/uploads/2024/03/logo-2024-endo.png"},
                {"47", "ENDOmind","1"  ,"https://static.wixstatic.com/media/ebf679_8fc531e6bffb4f8688f8d28bbbdf9e54~mv2.jpg/v1/fill/w_203,h_80,al_c,q_80,usm_0.66_1.00_0.01,enc_avif,quality_auto/LOGO%20ENDOmind%20HD.jpg"},
                {"48", "Entraid'addict","7"  ,"https://app.assoconnect.com/services/storage?id=2514864&type=picture&secret=YuqLOHnl9CXqdXBWml8PfxNLhLLyysVIubCZ3i92&timestamp=1657644514&size=small"},
                {"49", "Épilepsie France","1"  ,"https://www.epilepsie-france.com/wp-content/uploads/2022/07/logo-epilepsie.png"},
                {"50", "Familles de France", "7" ,"https://www.familles-de-france.org/themes/custom/bootstrap_fdf/images/logo.png"},
                {"51", "Familles Rurales", "7" ,"https://www.famillesrurales.org/lefenouiller/lefenouiller/sites/multisite.famillesrurales.org._www/files/styles/logo/public/logo_institutionnel_blanc2.png?itok=ON3WOdcm"},
                {"52", "FFD","1"  ,"https://www.federationdesdiabetiques.org/public/styles/logo/public/logos/logo_ffd.png?itok=e_twXYuk"},
                {"53", "FFDSB","7"  ,"https://www.federationdesdiabetiques.org/public/styles/logo/public/logos/logo_ffd.png?itok=e_twXYuk"},
                {"54", "FFSA","7"  ,"https://sesameautisme.fr/wp-content/uploads/2017/03/logo.jpg"},
                {"55", "FNAS","7"  ,"https://www.lesamisdelasante.org/wp-content/themes/a3web/img/logo_menu.png"},
                {"56", "FFCM","7"  ,"https://static.wixstatic.com/media/cdd428_4eba4ddbe9f54adfbfbf59942a95a770.png/v1/fill/w_220,h_210,al_c,q_85,usm_0.66_1.00_0.01,enc_avif,quality_auto/cdd428_4eba4ddbe9f54adfbfbf59942a95a770.png"},
                {"57", "FGCP", "7" ,"https://fgcp.france-assos-sante.org/wp-content/uploads/sites/79/2019/01/logo-fgcp.jpg"},
                {"58", "FibromyalgieSOS", "1" ,"https://fibromyalgiesos.fr/rdv2/wp-content/uploads/2021/10/fibromyalgiesos-logo-mini.png"},
                {"59", "FNAPSY","4"  ,"https://fnapsy.france-assos-sante.org/wp-content/uploads/sites/88/2019/01/Fnapsy-logo-200x108.jpg"},
                {"60", "FNAR","7"  ,"https://fnar.info/wp-content/themes/fnar/img/logo.png"},
                {"61", "FNATH", "7" ,"https://fnath.france-assos-sante.org/wp-content/uploads/sites/86/2019/01/logo-fnath-200x201.jpg"},
                {"62", "France Alzheimer", "3" ,"https://www.francealzheimer.org/wp-content/themes/fa/menu/img/FALogoL.png"},
                {"63", "France Dépression","4"  ,"https://www.francedepression.fr/images/interface/accueil.png"},
                {"64", "France Lyme","1" ,"https://francelyme.fr/site/wp-content/uploads/2019/05/Logo-bandeau-new-site-FL.jpg"},
                {"65", "France Parkinson","1"  ,"https://france-parkinson.france-assos-sante.org/wp-content/uploads/sites/71/2019/01/logo-france-parkinson-300x113.png"},
                {"66", "France Rein", "1" ,"https://france-rein.france-assos-sante.org/wp-content/uploads/sites/69/2019/01/fnair-logo.png"},
                {"67", "HyperSupers","1"  ,"https://hypersupers-tdah-france.france-assos-sante.org/wp-content/uploads/sites/131/2022/04/logo-hypersupers-tdah.png"},
                {"68", "JALMALV","6"  ,"https://www.jalmalv-federation.fr/wp-content/uploads/2018/04/logo-jalmalv-quadri-1.png"},
                {"69", "La Croix Bleue", "7" ,"https://www.croixbleue.fr/local/cache-vignettes/L220xH96/siteon0-fa04f.jpg?1688112334"},
                {"70", "La CSF","7"  ,"https://www.la-csf.org/wp-content/uploads/2018/07/logo-csf.png"},
                {"71", "LCC", "7" ,"https://www.ligue-cancer.net/themes/lncc/logo_LNCC.png"},
                {"72", "Le Lien","2"  ,"https://www.france-assos-sante.org/wp-content/uploads/2019/01/association-le-lien-200x136.png"},
                {"73", "Le Planning familial", "7" ,"https://www.planning-familial.org/themes/custom/customer/images/logo.png"},
                {"74", "LPFP","6"  ,"https://petits-freres-des-pauvres.france-assos-sante.org/wp-content/uploads/sites/56/2019/07/Logo_PFP_Horizontal_signature_Posi_Rouge_RVB.png"},
                {"75", "Marfans", "1" ,"https://marfans.france-assos-sante.org/wp-content/uploads/sites/54/2019/01/logo-marfans.png"},
                {"76", "Priartem","7"  ,"https://www.priartem.org/squelettes/images/bandeau-haut2.jpg"},
                {"77", "Renaloo","1"  ,"https://renaloo.fr/wp-content/uploads/2020/04/LOGO1.png"},
                {"78", "Réseau D.E.S. France", "2" ,"https://www.des-france.org/wp-content/uploads/2021/10/Logo-DES-france-arbre.png"},
                {"79", "RES", "5" ,"https://www.reseau-environnement-sante.fr/wp-content/uploads/2018/04/logo.jpg"},
                {"80", "Schizo-oui", "4" ,"https://www.schizo-oui.com/wp-content/uploads/2024/02/logo_schizooui.png"},
                {"81", "SOS HF","1"  ,"https://soshepatites.org/wp-content/themes/soshepatitesV2/img/logo-federation-sos-hepatites.png"},
                {"82", "TRANSHÉPATE", "1" ,"https://www.transhepate.org/wp-content/uploads/2021/11/logo-transephate.jpg"},
                {"83", "UAFLMV","7"  ,"https://www.mutiles-voix.com/wp-content/uploads/2019/03/UN_logo-266x300.png"},
                {"84", "UFAL","7"  ,"https://www.ufal.org/wp-content/uploads/2022/04/logo-site.png"},
                {"85", "UFC-Que Choisir", "7" ,"https://ufc.france-assos-sante.org/wp-content/uploads/sites/39/2019/01/Logo_UFC_Que_Choisir-150x167.jpg"},
                {"86", "UNAF", "7" ,"https://unaf.france-assos-sante.org/wp-content/uploads/sites/38/2019/07/Logo_Unaf.png"},
                {"87", "UNAFAM","4"  ,"https://unafam.france-assos-sante.org/wp-content/uploads/sites/37/2019/01/logo-unafam-200x200.jpg"},
                {"88", "UNAFTC","3"  ,"https://www.cerebrolesion.org/plugins/ParvisPlugin/images/navigation/logo-unaftc.png"},
                {"89", "UNAPECLE","6"  ,"https://imgs.search.brave.com/-t9tZxC6KQPMXhcXEaaqiDnS422wki-tGzJzDum7LmU/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9wZWRp/YXRyaWUuZS1jYW5j/ZXIuZnIvdmFyL3Bl/ZGlhdHJpZS9zdG9y/YWdlL2ltYWdlcy85/LzIvMi82LzQ2MjI5/LTEtZnJlLUZSL3Vu/YXBlY2xlLnBuZw"},
                {"90","Unapei ",  "3", "https://www.unapei.org/wp-content/themes/wext/assets/img/logo_unapei.png"},
                {"91"," VLM" , "1", "https://www.vaincrelamuco.org/sites/all/themes/custom/vlm/images/vlm_logo.png"},
                {"92","Vivre comme avant "  ,"1", "https://vivre-comme-avant.france-assos-sante.org/wp-content/uploads/sites/138/2022/10/Octobre-Rose-Vivre-Comme-Avant-logo-e1665496802729.png"},
                {"93","VMEH"  ,"3", "https://imgs.search.brave.com/xiSKC1axZJNQygfgqVaR9pN5J5RRreCn0zvyiebaMDw/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly91cGxv/YWQud2lraW1lZGlh/Lm9yZy93aWtpcGVk/aWEvY29tbW9ucy9k/L2RjL1ZNRUhfUlZC/LnN2Zw"}
        };

        // Ajout des associations dans Firestore
        for (String[] assoc : associations) {
            String id = assoc[0];
            String name = assoc[1];
            String categorie = assoc[2];
            String logoUrl = assoc[3];

            Map<String, Object> data = new HashMap<>();
            data.put("name", name);
            data.put("categorie", categorie);
            data.put("logoUrl", logoUrl);

            db.collection("associations").document(id)
                    .set(data)
                    .addOnSuccessListener(aVoid -> Log.d("Firestore", "Asso ajoutée avec succès"))
                    .addOnFailureListener(e -> Log.w("Firestore", "Erreur lors de l'ajout de l'asso", e));
        }
    }
}