package iut.dam.sae_app_mobile_france_asso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity implements CategoryFragment.CategoryListener {

    private AssociationListFragment associationListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialisation de la base de données avec les assos et les catégories

        /*
        FirestoreAsso firestoreAssoActivity = new FirestoreAsso();
        firestoreAssoActivity.ajouterAssociations();
        firestoreAssoActivity.ajouterCategories();*/
        CategoryFragment categoryFragment = new CategoryFragment();
        categoryFragment.setCategoryListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.category_container, categoryFragment)
                .commit();

        associationListFragment = new AssociationListFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, associationListFragment)
                .commit();

        getSupportFragmentManager().addOnBackStackChangedListener(() -> {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                findViewById(R.id.category_container).setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onCategorySelected(String category) {
        if (associationListFragment != null) {
            associationListFragment.setSelectedCategory(category);
        }
    }

    public void clickAccount(View view) {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        Intent intent;
        if (currentUser != null) {
            intent = new Intent(this, ProfileActivity.class);
        } else {
            intent = new Intent(this, ConnexionActivity.class);
        }
        startActivity(intent);
    }
}
