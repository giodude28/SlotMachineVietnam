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

import io.gio.MAYSlotmachines777.Adapter.MachineAdapter;
import io.gio.MAYSlotmachines777.Data.MachineData;
import io.gio.MAYSlotmachines777.Model.MachineViewModel;

public class Machine extends Fragment {
    public static RecyclerView recyclerView;
    MachineAdapter machineAdapter;
    MachineViewModel machineViewModel;
    View root;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_machine,container,false);
        initialize();
        return root;
    }

    private void initialize(){
        List<MachineViewModel> awit = new ArrayList<>();
        for(int i = 0; i < MachineData.mname.length; i ++ ){
            awit.add(new MachineViewModel(MachineData.mname[i],MachineData.desc[i],MachineData.image[i]));
        }

        recyclerView =root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
        machineAdapter = new MachineAdapter(getActivity(),awit);
        recyclerView.setAdapter(machineAdapter);
    }
}