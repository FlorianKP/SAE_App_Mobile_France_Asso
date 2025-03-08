package iut.dam.sae_app_mobile_france_asso;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import android.widget.GridView;
import iut.dam.sae_app_mobile_france_asso.R;
import iut.dam.sae_app_mobile_france_asso.DataAsso;
import iut.dam.sae_app_mobile_france_asso.Association;
import java.util.ArrayList;
import java.util.List;

public class AssociationListFragment extends Fragment {

    private List<Association> associationList;
    private List<Association> filteredList;
    private AssociationAdapter adapter;

    public AssociationListFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_association_list, container, false);

        GridView gridView = view.findViewById(R.id.gridView);

        SearchView searchView = getActivity().findViewById(R.id.searchView);
        associationList = DataAsso.getAssociations();
        filteredList = new ArrayList<>(associationList);

        adapter = new AssociationAdapter(requireContext(), filteredList);
        gridView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        return view;
    }
    private void filterList(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(associationList);
        } else {
            for (Association association : associationList) {
                if (association.getName().toLowerCase().startsWith(query.toLowerCase())) {
                    filteredList.add(association);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void filterByCategory(String category) {
        filteredList.clear();
        if (category.equals("Toutes")) {
            filteredList.addAll(associationList);
        } else {
            for (Association association : associationList) {
                if (association.getCategorie().equals(category)) {
                    filteredList.add(association);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }
}