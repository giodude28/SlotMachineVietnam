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

import io.gio.MAYSlotmachines777.Adapter.TipsAdapter;
import io.gio.MAYSlotmachines777.Data.TipsData;
import io.gio.MAYSlotmachines777.Model.TipsViewModel;

public class Tips extends Fragment {
TipsAdapter tipsAdapter;
TipsViewModel tipsViewModel;
public static RecyclerView recyclerView;
View root;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_tips,container,false);
        initialize();

        return root;
    }

    private void initialize(){
        List<TipsViewModel> awit = new ArrayList<>();
        for(int i = 0; i < TipsData.titles.length; i ++ ){
            awit.add(new TipsViewModel(TipsData.titles[i],TipsData.subtitle[i],TipsData.img[i]));
        }

        recyclerView =root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2, RecyclerView.VERTICAL,false));
        tipsAdapter = new TipsAdapter(getActivity(),awit);
        recyclerView.setAdapter(tipsAdapter);
    }
}