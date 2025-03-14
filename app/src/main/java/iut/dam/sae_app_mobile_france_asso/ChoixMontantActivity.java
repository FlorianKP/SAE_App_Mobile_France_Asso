package iut.dam.sae_app_mobile_france_asso;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChoixMontantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choix_montant);

        String typeDon = getIntent().getStringExtra("TYPE_DON");
        TextView typeTitre = findViewById(R.id.titre);
        typeTitre.setText("Faire un don " + typeDon + " à");
    }
}