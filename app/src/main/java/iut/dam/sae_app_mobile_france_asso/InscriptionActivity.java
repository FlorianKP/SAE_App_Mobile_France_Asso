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

public class InscriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inscription);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void clickRegister(View view) {
        EditText etNom = findViewById(R.id.etNom);
        String name = etNom.getText().toString().trim();
        EditText etPrenom = findViewById(R.id.etPrenom);
        String firstname = etPrenom.getText().toString().trim();
        EditText etEmail = findViewById(R.id.etEmail);
        String email = etEmail.getText().toString().trim();
        EditText etPassword = findViewById(R.id.etPassword);
        String password = etPassword.getText().toString().trim();
        if(isValid(name)){
            if(isValid(firstname)){
                if(isValidEmail(email)){
                    if(passwordValid(password)){
                        Intent intent = new Intent(this, ConnexionActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("name", name);
                        bundle.putString("firstname", firstname);
                        bundle.putString("email", email);
                        bundle.putString("password", password);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        Toast t = Toast.makeText(this, "Inscription réussie", Toast.LENGTH_SHORT);
                        t.show();
                    }
                    else{
                        Toast t = Toast.makeText(this, "Mot de passe invalide", Toast.LENGTH_SHORT);
                        t.show();
                    }
                }
                else{
                    Toast t = Toast.makeText(this, "Email invalide", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
            else{
                Toast t = Toast.makeText(this, "Prénom invalide", Toast.LENGTH_SHORT);
                t.show();
            }
        }
        else{
            Toast t = Toast.makeText(this, "Nom invalide", Toast.LENGTH_SHORT);
            t.show();
        }
    }
    public boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailPattern);
    }

    private boolean passwordValid(String password) {
        String passwordPattern = "^(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        return password.matches(passwordPattern);
    }

    private boolean isValid(String text) {
        return text.length()>=2 && text.length()<26 && text.matches("[\\p{L}\\s]+");
    }

    public void clickLogin(View view) {
        Intent intent = new Intent(this, ConnexionActivity.class);
        startActivity(intent);
    }
}