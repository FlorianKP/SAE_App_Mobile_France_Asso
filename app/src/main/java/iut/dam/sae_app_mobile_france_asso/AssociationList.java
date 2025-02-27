package iut.dam.sae_app_mobile_france_asso;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import iut.dam.sae_app_mobile_france_asso.R;
import iut.dam.sae_app_mobile_france_asso.DataAsso;
import iut.dam.sae_app_mobile_france_asso.Association;
import java.util.List;

public class AssociationList extends Fragment {

    public AssociationList() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_association_list, container, false);

        GridView gridView = view.findViewById(R.id.gridView);
        List<Association> associations = DataAsso.getAssociations();

        AssociationAdapter adapter = new AssociationAdapter(requireContext(), associations);
        gridView.setAdapter(adapter);

        return view;
    }
}