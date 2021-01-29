package io.gio.MAYSlotmachines777;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.gio.MAYSlotmachines777.Adapter.PrizesAdapter;
import io.gio.MAYSlotmachines777.Data.MachineData;
import io.gio.MAYSlotmachines777.Data.PrizesData;
import io.gio.MAYSlotmachines777.Model.PrizesViewModel;

public class Prizes extends Fragment {
PrizesAdapter prizesAdapter;
PrizesViewModel prizesViewModel;
public static RecyclerView recyclerView;
View root;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_prizes,container,false);
        initialize();

        return root;
    }

    private void initialize(){
        List<PrizesViewModel> awit = new ArrayList<>();
        for(int i = 0; i < MachineData.mname.length; i ++ ){
            awit.add(new PrizesViewModel(PrizesData.prizes[i],PrizesData.firstCoin[i],PrizesData.secondCoin[i],PrizesData.thirdCoin[i],PrizesData.images[i]));
        }

        recyclerView =root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
        prizesAdapter = new PrizesAdapter(getActivity(),awit);
        recyclerView.setAdapter(prizesAdapter);
    }
}