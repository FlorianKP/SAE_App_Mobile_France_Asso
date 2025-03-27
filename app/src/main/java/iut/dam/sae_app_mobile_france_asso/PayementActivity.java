package iut.dam.sae_app_mobile_france_asso;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PayementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payement);
        int montant = getIntent().getIntExtra("montant",-1);
        Association association = (Association) getIntent().getSerializableExtra("association");
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });

        ImageView imgCB = findViewById(R.id.carte_bancaire_logo);
        TextView textCB = findViewById(R.id.carte_bancaire_TextView);
        imgCB.setOnClickListener(v -> {
            Intent intent = new Intent(this, PayementCBActivity.class);
            intent.putExtra("montant", montant);
            intent.putExtra("association",association);
            intent.putExtra("TYPE_DON",getIntent().getStringExtra("TYPE_DON"));
            intent.putExtra("periodicite", getIntent().getStringExtra("periodicite"));
            startActivity(intent);
        });
        textCB.setOnClickListener(v -> {
            Intent intent = new Intent(this, PayementCBActivity.class);
            intent.putExtra("montant", montant);
            intent.putExtra("association",association);
            intent.putExtra("TYPE_DON",getIntent().getStringExtra("TYPE_DON"));
            intent.putExtra("periodicite", getIntent().getStringExtra("periodicite"));
            startActivity(intent);
        });
    }
}