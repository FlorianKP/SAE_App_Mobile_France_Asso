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

    public void ajouterAssociations() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Liste des associations
        String[][] associations = {
                {"1", "A.M.I"," " ,"https://ami-handicap.france-assos-sante.org/wp-content/uploads/sites/117/2019/01/customLogo.png"},
                {"2", "AAAVAM", " " ,"https://aaavam.france-assos-sante.org/wp-content/uploads/sites/23/2023/06/logo-300x92.png"},
                {"3", "AAVL"," "  ,"https://www.vielibre.org/wp-content/themes/wp-bootstrap-starter/img/logo.jpg"},
                {"4", "ADEPA", " " ,"https://www.adepa.fr/wp-content/uploads/2023/10/Logo-ADEPA-associoation-defense-entraide-personnes-amputees.png"},
                {"5", "ADMD"," "  ,"https://www.admd.net/themes/custom/admd/images/logo.png"},
                {"6", "Advocacy France"," " , "https://imgs.search.brave.com/F69AXs3sFuy6Yc7UGIiIBUyLzZMgJZeY5CbnjUlNc2c/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/ZmVkZXJhdGlvbnNv/bGlkYXJpdGUub3Jn/L3dwLWNvbnRlbnQv/dXBsb2Fkcy8yMDIw/LzA4LzEtQWR2b2Nh/Y3ktRnJhbmNlLTI0/OXgzMDAucG5n"},
                {"7", "AFA", " " ,"https://www.afa.asso.fr/wp-content/uploads/2019/09/LOGO-AFA.png"},
                {"8", "AFDE", " " ,"https://afde.net/wp-content/uploads/2022/10/logo-afde.jpg"},
                {"9", "AFDOC"," "  ,"https://afdoc.fr/local/cache-vignettes/L400xH120/afdoc-logo-05-38b2c.png?1710244315"},
                {"10", "AFGS"," "  ,"https://www.afgs-syndromes-secs.org/assets/logo/logo_afgs.png"},
                {"11", "AFH"," "  ,"https://app.assoconnect.com/services/storage?id=5111433&type=picture&secret=lD13fanUd1Wm20DvBoeXAme1FZtX0wKvwzeKRG0f&timestamp=1733500311&size=small"},
                {"12", "AFM", " " ,"https://www.afm-telethon.fr/sites/default/files/styles/webp/public/logo/AFM_TELETHON_Q.png.webp?itok=CM1KrGfb"},
                {"13", "AFPric", " " ,"https://www.polyarthrite.org/wp-content/uploads/2023/07/logo_poly.png"},
                {"14", "AFS"," "  ,"https://www.spondy.fr/wp-content/uploads/2024/11/Logo-AFS-Et-Rics.png"},
                {"15", "AFSA"," "  ,"https://afsa.france-assos-sante.org/wp-content/uploads/sites/30/2019/01/afsa-logo-2018-300x211.png"},
                {"16", "AFSEP"," "  ,"https://afsep.fr/asso/wp-content/uploads/2023/10/logo_AFSEP_Octobre2020.webp"},
                {"17", "AFVD", " " ,"https://www.association-afvd.com/images/afvd-logo-couleur-petit.png"},
                {"18", "AFVS", " " ,"https://afvs.france-assos-sante.org/wp-content/uploads/sites/60/2019/01/logo-AFVS-web-200x120.jpg"},
                {"19", "AIDES"," "  ,"https://www.aides.org/themes/custom/aides/public/images/general/logo.png"},
                {"20", "AINP", " " ,"https://app.assoconnect.com/services/storage?id=5348824&type=picture&secret=4duN7vCS7IZGlKLyk1rPmYXX4xyuyYv5YqAjLvoo&timestamp=1739992941"},
                {"21", "AEJS"," "  ,"https://www.alcoolecoute.com/images/logo_alcool_ecoute.png"},
                {"22", "AMR"," "  ,"https://alliance-maladies-rares.france-assos-sante.org/wp-content/uploads/sites/72/2019/01/logo-AMR-200x185.jpg"},
                {"23", "Amadys"," "  ,"https://amadys.fr/wp-content/themes/amadys/images/logo-amadys.png"},
                {"24", "AMALYSTE"," "  ,"https://www.amalyste.fr/wp-content/uploads/2023/11/2023-11-12-Banniere-site-web.jpg"},
                {"25", "ANDAR", " " ,"https://www.polyarthrite-andar.org/images/imagecache/0x97/png/template_images_Logo_ANDAR.webp"},
                {"26", "APAJH", " " ,"https://www.apajh.org/uploads/2023/02/logo-fede-apajh.jpg"},
                {"27", "APF France handicap"," "  ,"https://apf-france-handicap.france-assos-sante.org/wp-content/uploads/sites/78/2019/01/Logo-bloc-APF-France-handicap-bichromie-200x126.jpg"},
                {"28", "APODEC"," "  ,"https://app.assoconnect.com/services/storage?id=4320875&type=picture&secret=8cfjzkPPwfJmJ4sjEbmfnRkEgHnX12LPf0Oz9KDS&timestamp=1713532804&size=small"},
                {"29", "ARGOS 2001"," "  ,"https://argos2001.france-assos-sante.org/wp-content/uploads/sites/82/2019/01/argos2001-Logo-200x64-160x51.jpg"},
                {"30", "ARSLA", " " ,"https://www.arsla.org/app/themes/arsla/images/logo.png"},
                {"31", "ASBH"," "  ,"https://www.spina-bifida.org/wp-content/uploads/2019/10/Logo-ASBH-website-2019.png"},
                {"32", "ASF", " " ,"https://www.association-sclerodermie.fr/wp-content/uploads/2023/01/nouveau-logo-2023-reduit-334x350.jpg"},
                {"33", "ASFC", " " ,"https://asfc.france-assos-sante.org/wp-content/uploads/sites/92/2019/01/Logo-ASFC-haute-def-2018-300x158.png"},
                {"34", "ABF"," "  ,"https://abf-association-brules-france.france-assos-sante.org/wp-content/uploads/sites/135/2022/10/logo.png"},
                {"35", "AFRH"," "  , "https://www.afrh.fr/files/drag-and-drop-img-436.png"},
                {"36", "AT"," "  ,"https://actions-traitements.org/images/AT_logo.png"},
                {"37", "Autisme France"," "  ,"https://www.autisme-france.fr/f/d8a9e3456da753f26b7d19471bd21cc854b01e50/logo-autisme-france.png"},
                {"38", "AVIAM"," "  ,"https://aviam.france-assos-sante.org/wp-content/uploads/sites/96/2019/01/logo-aviam-161x200.jpg"},
                {"39", "CADUS", " " ,"https://www.france-assos-sante.org/wp-content/uploads/2018/11/cadus-200x136.png"},
                {"40", "CLCV", " " ,"https://clcv-isere.org/wp-content/uploads/2022/03/logo-clcv-isere.webp"},
                {"41", "CNAFAL"," " ,"https://www.cnafal.org/wp-content/themes/cnafal/images/familles_laiques.gif"},
                {"42", "CNAFC"," "  ,"https://www.afc-france.org/wp-content/uploads/2020/10/logo-AFC.png"},
                {"43", "CNAO"," "  ,"https://cnao.fr/wp-content/uploads/2021/02/cnao_logo.jpg"},
                {"44", "E3M"," "  ,"https://www.asso-e3m.fr/wp-content/uploads/2019/10/Logo-E3M-carre%CC%81-RVB-300x300.jpg"},
                {"45", "EFAPPE"," "  ,"https://www.efappe.epilepsies.fr/wp-content/uploads/2014/09/cropped-cropped-Banniere-bis.jpg"},
                {"46", "EndoFrance"," "  ,"https://endofrance.org/wp-content/uploads/2024/03/logo-2024-endo.png"},
                {"47", "ENDOmind"," "  ,"https://static.wixstatic.com/media/ebf679_8fc531e6bffb4f8688f8d28bbbdf9e54~mv2.jpg/v1/fill/w_203,h_80,al_c,q_80,usm_0.66_1.00_0.01,enc_avif,quality_auto/LOGO%20ENDOmind%20HD.jpg"},
                {"48", "Addiction France"," "  ,"https://app.assoconnect.com/services/storage?id=2514864&type=picture&secret=YuqLOHnl9CXqdXBWml8PfxNLhLLyysVIubCZ3i92&timestamp=1657644514&size=small"},
                {"49", "Épilepsie France"," "  ,"https://www.epilepsie-france.com/wp-content/uploads/2022/07/logo-epilepsie.png"},
                {"50", "Familles de France", " " ,"https://www.familles-de-france.org/themes/custom/bootstrap_fdf/images/logo.png"},
                {"51", "Familles Rurales", " " ,"https://www.famillesrurales.org/lefenouiller/lefenouiller/sites/multisite.famillesrurales.org._www/files/styles/logo/public/logo_institutionnel_blanc2.png?itok=ON3WOdcm"},
                {"52", "FFD"," "  ,"https://www.federationdesdiabetiques.org/public/styles/logo/public/logos/logo_ffd.png?itok=e_twXYuk"},
                {"53", "FFDSB"," "  ,"https://www.federationdesdiabetiques.org/public/styles/logo/public/logos/logo_ffd.png?itok=e_twXYuk"},
                {"54", "FFSA"," "  ,"https://sesameautisme.fr/wp-content/uploads/2017/03/logo.jpg"},
                {"55", "FNAS"," "  ,"https://www.lesamisdelasante.org/wp-content/themes/a3web/img/logo_menu.png"},
                {"56", "FFCM"," "  ,"https://static.wixstatic.com/media/cdd428_4eba4ddbe9f54adfbfbf59942a95a770.png/v1/fill/w_220,h_210,al_c,q_85,usm_0.66_1.00_0.01,enc_avif,quality_auto/cdd428_4eba4ddbe9f54adfbfbf59942a95a770.png"},
                {"57", "FGCP", " " ,"https://fgcp.france-assos-sante.org/wp-content/uploads/sites/79/2019/01/logo-fgcp.jpg"},
                {"58", "FibromyalgieSOS", " " ,"https://fibromyalgiesos.fr/rdv2/wp-content/uploads/2021/10/fibromyalgiesos-logo-mini.png"},
                {"59", "FNAPSY"," "  ,"https://fnapsy.france-assos-sante.org/wp-content/uploads/sites/88/2019/01/Fnapsy-logo-200x108.jpg"},
                {"60", "FNAR"," "  ,"https://fnar.info/wp-content/themes/fnar/img/logo.png"},
                {"61", "FNATH", " " ,"https://fnath.france-assos-sante.org/wp-content/uploads/sites/86/2019/01/logo-fnath-200x201.jpg"},
                {"62", "France Alzheimer", " " ,"https://www.francealzheimer.org/wp-content/themes/fa/menu/img/FALogoL.png"},
                {"63", "France Dépression"," "  ,"https://www.francedepression.fr/images/interface/accueil.png"},
                {"64", "France Lyme"," " ,"https://francelyme.fr/site/wp-content/uploads/2019/05/Logo-bandeau-new-site-FL.jpg"},
                {"65", "France Parkinson"," "  ,"https://france-parkinson.france-assos-sante.org/wp-content/uploads/sites/71/2019/01/logo-france-parkinson-300x113.png"},
                {"66", "France Rein", " " ,"https://france-rein.france-assos-sante.org/wp-content/uploads/sites/69/2019/01/fnair-logo.png"},
                {"67", "HyperSupers"," "  ,"https://hypersupers-tdah-france.france-assos-sante.org/wp-content/uploads/sites/131/2022/04/logo-hypersupers-tdah.png"},
                {"68", "JALMALV"," "  ,"https://www.jalmalv-federation.fr/wp-content/uploads/2018/04/logo-jalmalv-quadri-1.png"},
                {"69", "La Croix Bleue", " " ,"https://www.croixbleue.fr/local/cache-vignettes/L220xH96/siteon0-fa04f.jpg?1688112334"},
                {"70", "La CSF"," "  ,"https://www.la-csf.org/wp-content/uploads/2018/07/logo-csf.png"},
                {"71", "LCC", " " ,"https://www.ligue-cancer.net/themes/lncc/logo_LNCC.png"},
                {"72", "Le Lien"," "  ,"https://www.france-assos-sante.org/wp-content/uploads/2019/01/association-le-lien-200x136.png"},
                {"73", "Le Planning familial", " " ,"https://www.planning-familial.org/themes/custom/customer/images/logo.png"},
                {"74", "LPFP"," "  ,"https://petits-freres-des-pauvres.france-assos-sante.org/wp-content/uploads/sites/56/2019/07/Logo_PFP_Horizontal_signature_Posi_Rouge_RVB.png"},
                {"75", "Marfans", " " ,"https://marfans.france-assos-sante.org/wp-content/uploads/sites/54/2019/01/logo-marfans.png"},
                {"76", "Priartem"," "  ,"https://www.priartem.org/squelettes/images/bandeau-haut2.jpg"},
                {"77", "Renaloo"," "  ,"https://renaloo.fr/wp-content/uploads/2020/04/LOGO1.png"},
                {"78", "Réseau D.E.S. France", " " ,"https://www.des-france.org/wp-content/uploads/2021/10/Logo-DES-france-arbre.png"},
                {"79", "RES", " " ,"https://www.reseau-environnement-sante.fr/wp-content/uploads/2018/04/logo.jpg"},
                {"80", "Schizo-oui", " " ,"https://www.schizo-oui.com/wp-content/uploads/2024/02/logo_schizooui.png"},
                {"81", "SOS HF"," "  ,"https://soshepatites.org/wp-content/themes/soshepatitesV2/img/logo-federation-sos-hepatites.png"},
                {"82", "TRANSHÉPATE", " " ,"https://www.transhepate.org/wp-content/uploads/2021/11/logo-transephate.jpg"},
                {"83", "UAFLMV"," "  ,"https://www.mutiles-voix.com/wp-content/uploads/2019/03/UN_logo-266x300.png"},
                {"84", "UFAL"," "  ,"https://www.ufal.org/wp-content/uploads/2022/04/logo-site.png"},
                {"85", "UFC-Que Choisir", " " ,"https://ufc.france-assos-sante.org/wp-content/uploads/sites/39/2019/01/Logo_UFC_Que_Choisir-150x167.jpg"},
                {"86", "UNAF", " " ,"https://unaf.france-assos-sante.org/wp-content/uploads/sites/38/2019/07/Logo_Unaf.png"},
                {"87", "UNAFAM"," "  ,"https://unafam.france-assos-sante.org/wp-content/uploads/sites/37/2019/01/logo-unafam-200x200.jpg"},
                {"88", "UNAFTC"," "  ,"https://www.cerebrolesion.org/plugins/ParvisPlugin/images/navigation/logo-unaftc.png"},
                {"89", "UNAPECLE"," "  ,"https://imgs.search.brave.com/-t9tZxC6KQPMXhcXEaaqiDnS422wki-tGzJzDum7LmU/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9wZWRp/YXRyaWUuZS1jYW5j/ZXIuZnIvdmFyL3Bl/ZGlhdHJpZS9zdG9y/YWdlL2ltYWdlcy85/LzIvMi82LzQ2MjI5/LTEtZnJlLUZSL3Vu/YXBlY2xlLnBuZw"},
                {"90","Unapei ",  "", "https://www.unapei.org/wp-content/themes/wext/assets/img/logo_unapei.png"},
                {"91"," VLM" , "", "https://www.vaincrelamuco.org/sites/all/themes/custom/vlm/images/vlm_logo.png"},
                {"92","Vivre comme avant "  ,"", "https://vivre-comme-avant.france-assos-sante.org/wp-content/uploads/sites/138/2022/10/Octobre-Rose-Vivre-Comme-Avant-logo-e1665496802729.png"},
                {"93","VMEH"  ,"", "https://imgs.search.brave.com/xiSKC1axZJNQygfgqVaR9pN5J5RRreCn0zvyiebaMDw/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly91cGxv/YWQud2lraW1lZGlh/Lm9yZy93aWtpcGVk/aWEvY29tbW9ucy9k/L2RjL1ZNRUhfUlZC/LnN2Zw"}
        };

        // Ajout des associations dans Firestore
        for (String[] assoc : associations) {
            String id = assoc[0];
            String name = assoc[1];
            String logoUrl = assoc[3];

            Map<String, Object> data = new HashMap<>();
            data.put("name", name);
            data.put("logoUrl", logoUrl);

            db.collection("associations").document(id)
                    .set(data)
                    .addOnSuccessListener(aVoid -> Log.d("Firestore", "Asso ajoutée avec succès"))
                    .addOnFailureListener(e -> Log.w("Firestore", "Erreur lors de l'ajout de l'asso", e));
        }
    }
}