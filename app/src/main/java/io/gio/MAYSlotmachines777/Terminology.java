package io.gio.MAYSlotmachines777;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.gio.MAYSlotmachines777.Adapter.TerminologyAdapter;
import io.gio.MAYSlotmachines777.Data.TerminologyData;
import io.gio.MAYSlotmachines777.Model.TerminologyViewModel;

public class Terminology extends Fragment {
TerminologyAdapter terminologyAdapter;
TerminologyViewModel terminologyViewModel;
    public static RecyclerView recyclerView;
    View root;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_terminology,container,false);
        initialize();

        return root;
    }

    private void initialize(){
        List<TerminologyViewModel> awit = new ArrayList<>();
        for(int i = 0; i < TerminologyData.name.length; i ++ ){
            awit.add(new TerminologyViewModel(TerminologyData.name[i],TerminologyData.desc[i]));
        }

        recyclerView =root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2, RecyclerView.VERTICAL,false));
        terminologyAdapter = new TerminologyAdapter(getActivity(),awit);
        recyclerView.setAdapter(terminologyAdapter);
    }
}
