package io.gio.MAYSlotmachines777.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.gio.MAYSlotmachines777.Model.PrizesViewModel;
import io.gio.MAYSlotmachines777.R;

public class PrizesAdapter extends RecyclerView.Adapter<PrizesAdapter.ViewHolder> {
    List<PrizesViewModel> data;
    Context context;
    TextView name,desc;
    ImageView image;


    public PrizesAdapter(Context context, List<PrizesViewModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public PrizesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.prizesitem, parent, false);
        PrizesAdapter.ViewHolder viewHolder = new PrizesAdapter.ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final PrizesAdapter.ViewHolder holder, final int position) {
        holder.prizeName.setText(data.get(position).getPrizesName());
        holder.first.setText(data.get(position).getFirstCoin());
        holder.second.setText(data.get(position).getSecondCoin());
        holder.third.setText(data.get(position).getThirdCoin());
        holder.prizeIMG.setImageResource(data.get(position).getImages());
//        holder.desc.setText(data.get(position).getDesc());
//        final Dialog myDialog;
//        myDialog = new Dialog(context);
//        myDialog.setContentView(R.layout.activity_design_detail);
//        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        name = myDialog.findViewById(R.id.designname);
//        desc = myDialog.findViewById(R.id.designdesc);
////        image = myDialog.findViewById(R.id.designimage);
//        for (int i = 0; i<data.size(); i++) {
//            if(holder.mname.getText()==data.get(position).getName()){
//                name.setText(data.get(position).getName());
//                desc.setText(data.get(position).getDesc());
////                Picasso.get().load(data.get(position).getImage()).into(image);
//            }
//        }
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myDialog.show();
//
//            }
//        });
//        holder.mimage.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Toast toast = Toast.makeText(context,"Expand the image to Zoom In",Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView prizeName,first,second,third;
        ImageView prizeIMG;
//        public ImageView mimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            desc = itemView.findViewById(R.id.slotdesc);
            prizeIMG = itemView.findViewById(R.id.prizeImage);
            prizeName = itemView.findViewById(R.id.prizeName);
            first = itemView.findViewById(R.id.first);
            second = itemView.findViewById(R.id.second);
            third  = itemView.findViewById(R.id.third);
        }
    }
}