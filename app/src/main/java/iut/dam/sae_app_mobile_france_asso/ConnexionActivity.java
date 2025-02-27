package iut.dam.sae_app_mobile_france_asso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_connexion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void clickLogin(View view){
        if (validEmail()) {
            if(validPassword()){
                Toast.makeText(this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                Intent intentMain = new Intent(ConnexionActivity.this, Association.class);
                startActivity(intentMain);
            }
            else{
                Toast.makeText(this, "Mot de passe incorrecte", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Email invalide", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validEmail() {
        EditText etMail = findViewById(R.id.etEmail);
        String email = etMail.getText().toString().trim();
        DatabaseOpenHelper db = new DatabaseOpenHelper(this);
        return db.isEmailExisting(email);
    }

    private boolean validPassword(){
        EditText etMail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        String email = etMail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        DatabaseOpenHelper db = new DatabaseOpenHelper(this);
        String rightPassword = db.getPassword(email);
        return (password.equals(rightPassword));
    }

    public void clickRegister(View view) {
        Intent intent = new Intent(this, InscriptionActivity.class);
        startActivity(intent);
    }
}