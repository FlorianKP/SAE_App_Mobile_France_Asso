package iut.dam.sae_app_mobile_france_asso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChoixDonation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choix_donation);

        Button bUnique = findViewById(R.id.btn_unique);
        Button bRecurrent = findViewById(R.id.btn_recurrent);

        bUnique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ouvrirChoixMontant("unique");
            }
        });

        bRecurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ouvrirChoixMontant("recurrent");
            }
        });
    }

    private void ouvrirChoixMontant(String type) {
        Intent intent = new Intent(ChoixDonation.this, ChoixMontantActivity.class);
        intent.putExtra("TYPE_DON", type);
        startActivity(intent);
    }
}