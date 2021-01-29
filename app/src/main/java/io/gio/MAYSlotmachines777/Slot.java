package io.gio.MAYSlotmachines777;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import io.gio.MAYSlotmachines777.Adapter.SlotAdapter;
import io.gio.MAYSlotmachines777.Data.SlotData;
import io.gio.MAYSlotmachines777.Model.SlotViewModel;

public class Slot extends Fragment {
SlotViewModel slotViewModel;
SlotAdapter slotAdapter;
    private CarouselView carousel;
    public List<Integer> llvpics = new ArrayList<>();
    public static RecyclerView recyclerView;
    View root;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_slot,container,false);
        carousel = root.findViewById(R.id.frontimg);
        initialize();
        showPics();
        return root;
    }


    private void initialize(){
        List<SlotViewModel> awit = new ArrayList<>();
        for(int i = 0; i < SlotData.title.length; i ++ ){
            awit.add(new SlotViewModel(SlotData.title[i],SlotData.desc[i],SlotData.image[i]));
        }

        recyclerView =root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1, RecyclerView.HORIZONTAL,false));
        slotAdapter = new SlotAdapter(getActivity(),awit);
        SnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(slotAdapter);
    }
    public void showPics() {
        llvpics.add(R.drawable.liberty_bell);
        llvpics.add(R.drawable.history);
        llvpics.add(R.drawable.single);
        llvpics.add(R.drawable.multipliers);
        llvpics.add(R.drawable.multiline);
        llvpics.add(R.drawable.wild_play_machine);
        llvpics.add(R.drawable.progressive);
        llvpics.add(R.drawable.reel_slot);
        llvpics.add(R.drawable.video_slot_machine);



        carousel.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {

                ArrayList<Integer> imageListTitle = new ArrayList<Integer>();

                for(int i = 0; i < llvpics.size(); i++ ){
                    imageListTitle.add(llvpics.get(i));
                }
                Picasso.get().load(imageListTitle.get(position)).into(imageView);

            }
        });
        carousel.setPageCount(llvpics.size());

    }

}