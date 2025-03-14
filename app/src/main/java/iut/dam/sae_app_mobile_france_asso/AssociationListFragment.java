package iut.dam.sae_app_mobile_france_asso;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import android.widget.GridView;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssociationListFragment extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<Association> associations;
    private List<Association> filteredAssociations;
    private Map<String, String> categories;
    private AssociationAdapter adapter;

    public AssociationListFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_association_list, container, false);

        GridView gridView = view.findViewById(R.id.gridView);

        SearchView searchView = getActivity().findViewById(R.id.searchView);

        associations = new ArrayList<>();
        filteredAssociations = new ArrayList<>();
        categories = new HashMap<>();
        fetchAllAssociationsASync();
        fetchAllCategoriesASync();
        filteredAssociations = new ArrayList<>(associations);

        adapter = new AssociationAdapter(requireContext(), filteredAssociations);
        gridView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterByCategory(newText);
                return true;
            }
        });

        return view;
    }

    public void fetchAllAssociationsASync(){
        db.collection("associations")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                String id = document.getId();
                                String name = (String) document.getData().get("name");
                                String categorie = (String) document.getData().get("categorie");
                                String logoUrl = (String) document.getData().get("logoUrl");
                                String description = (String) document.getData().get("description");
                                Association a = new Association(id, categorie, "", logoUrl, name);
                                associations.add(a);
                            }

                            filteredAssociations.clear();
                            filteredAssociations.addAll(associations);
                            adapter.notifyDataSetChanged();
                        }
                        else {
                            Log.d(this.getClass().getName(), "error");
                        }
                    }
                });
    }

    public void fetchAllCategoriesASync(){
        db.collection("categories")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                String id = document.getId();
                                String name = (String) document.getData().get("name");

                                categories.put(name, id);
                            }
                        }
                        else {
                            Log.d(this.getClass().getName(), "error");
                        }
                    }
                });
    }

    public void filterByCategory(String category) {
        filteredAssociations.clear();
        if (category.isEmpty() || category.equals("Toutes")) {
            filteredAssociations.addAll(associations);
        } else {
            for (Association association : associations) {
                if (categories.containsKey(category) && categories.get(category).equals(association.getCategory())) {
                    filteredAssociations.add(association);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }
}