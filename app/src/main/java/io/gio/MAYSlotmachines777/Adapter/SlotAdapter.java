package io.gio.MAYSlotmachines777.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.gio.MAYSlotmachines777.Model.SlotViewModel;
import io.gio.MAYSlotmachines777.R;

public class SlotAdapter extends RecyclerView.Adapter<SlotAdapter.ViewHolder> {
    List<SlotViewModel> data;
    Context context;
    TextView name,desc;
    ImageView image;


    public SlotAdapter(Context context, List<SlotViewModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public SlotAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.slotitem, parent, false);
        SlotAdapter.ViewHolder viewHolder = new SlotAdapter.ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final SlotAdapter.ViewHolder holder, final int position) {
        holder.mname.setText(data.get(position).getTitle());
        holder.desc.setText(data.get(position).getDesc());
        holder.mimage.setImageResource(data.get(position).getImage());
//        holder.desc.setText(data.get(position).getDesc());
        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_slot_details);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        name = myDialog.findViewById(R.id.sname);
        desc = myDialog.findViewById(R.id.sdesc);
//        image = myDialog.findViewById(R.id.designimage);
        for (int i = 0; i<data.size(); i++) {
            if(holder.mname.getText()==data.get(position).getTitle()){
                name.setText(data.get(position).getTitle());
                desc.setText(data.get(position).getDesc());
//                Picasso.get().load(data.get(position).getImage()).into(image);
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();

            }
        });
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

        public TextView mname,desc;
       public ImageView mimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            desc = itemView.findViewById(R.id.slotdesc);
            mimage = itemView.findViewById(R.id.outimage);
            mname = itemView.findViewById(R.id.slotname);
        }
    }
}