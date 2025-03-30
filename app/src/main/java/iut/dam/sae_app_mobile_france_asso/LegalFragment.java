package iut.dam.sae_app_mobile_france_asso;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LegalFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_legal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView txtLegal = view.findViewById(R.id.txt_legal);
        txtLegal.setText("Cette application est un projet pédagogique.\n\nToutes les données affichées sont fictives.\nAucune transaction réelle n'est effectuée.\n\nDroits d'auteur : © 2025 France Asso Santé (simulation)");
    }
}
