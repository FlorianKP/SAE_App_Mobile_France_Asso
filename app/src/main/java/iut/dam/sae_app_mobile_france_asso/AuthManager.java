package iut.dam.sae_app_mobile_france_asso;
/*
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class AuthManager {
    private FirebaseAuth auth;
    private FirebaseDatabase db;

    public AuthManager() {
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
    }

    public void registerUser(String email, String password, String name, String firstname,boolean isAdmin) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Récupérer l'ID utilisateur généré par Firebase
                        String userId = auth.getCurrentUser().getUid();

                        // Créer un objet utilisateur à stocker dans Firestore
                        Map<String, Object> user = new HashMap<>();
                        user.put("name", name);
                        user.put("firstname", firstname);
                        user.put("email", email);
                        user.put("isAdmin", isAdmin);

                        // Ajouter dans Firestore (Collection "users")
                        db.collection("users").document(userId).set(user)
                                .addOnSuccessListener(aVoid -> Log.d("Firestore", "Utilisateur ajouté !"))
                                .addOnFailureListener(e -> Log.e("Firestore", "Erreur Firestore: " + e.getMessage()));

                    } else {
                        Log.e("FirebaseAuth", "Erreur inscription : " + task.getException().getMessage());
                    }
                });
    }

    public boolean isEmailExists(String email) {
        final boolean[] emailExists = {false};  // Variable pour stocker le résultat

        db.collection("users")
                .whereEqualTo("email", email)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        QuerySnapshot querySnapshot = task.getResult();
                        if (querySnapshot != null && !querySnapshot.isEmpty()) {
                            // Email déjà utilisé
                            emailExists[0] = true;
                        } else {
                            // Email libre
                            emailExists[0] = false;
                        }
                    } else {
                        // Si la requête échoue, on considère que l'email existe
                        emailExists[0] = false;
                    }
                });

        // On renvoie le résultat de la vérification
        return emailExists[0];
    }

    public void loginUser(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        String userId = auth.getCurrentUser().getUid();

                        // Récupérer les infos utilisateur depuis Firestore
                        db.collection("users").document(userId).get()
                                .addOnSuccessListener(document -> {
                                    if (document.exists()) {
                                        String name = document.getString("name");
                                        boolean isAdmin = document.getBoolean("isAdmin");

                                        Log.d("Firestore", "Connexion réussie ! Nom: " + name + ", Admin: " + isAdmin);
                                    } else {
                                        Log.e("Firestore", "Utilisateur introuvable dans Firestore.");
                                    }
                                })
                                .addOnFailureListener(e -> Log.e("Firestore", "Erreur Firestore: " + e.getMessage()));

                    } else {
                        Log.e("FirebaseAuth", "Erreur connexion : " + task.getException().getMessage());
                    }
                });
    }

    public boolean isUserLoggedIn() {
        return auth.getCurrentUser() != null;
    }

    public void logoutUser() {
        auth.signOut();
        Log.d("FirebaseAuth", "Utilisateur déconnecté !");
    }


}*/

