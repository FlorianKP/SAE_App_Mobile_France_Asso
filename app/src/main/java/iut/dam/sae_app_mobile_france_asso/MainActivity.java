package iut.dam.sae_app_mobile_france_asso;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements CategoryFragment.CategoryListener {

    private AssociationListFragment associationListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirestoreAssoActivity firestoreAssoActivity = new FirestoreAssoActivity();
        firestoreAssoActivity.ajouterAssociations();
        CategoryFragment categoryFragment = new CategoryFragment();
        categoryFragment.setCategoryListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.category_container, categoryFragment)
                .commit();

        associationListFragment = new AssociationListFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, associationListFragment)
                .commit();
    }

    @Override
    public void onCategorySelected(String category) {
        if (associationListFragment != null) {
            associationListFragment.filterByCategory(category);
        }
    }
}
