package io.gio.MAYSlotmachines777.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.gio.MAYSlotmachines777.Model.MachineViewModel;
import io.gio.MAYSlotmachines777.R;

public class MachineAdapter extends RecyclerView.Adapter<MachineAdapter.ViewHolder> {
    List<MachineViewModel> data;
    Context context;
    TextView name,desc;
    ImageView image;


    public MachineAdapter(Context context, List<MachineViewModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MachineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.machineitem, parent, false);
        MachineAdapter.ViewHolder viewHolder = new MachineAdapter.ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final MachineAdapter.ViewHolder holder, final int position) {
        holder.mname.setText(data.get(position).getMname());
        holder.mimage.setImageResource(data.get(position).getImg());
//        holder.desc.setText(data.get(position).getDesc());
        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_machine_details);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        name = myDialog.findViewById(R.id.macname);
        desc = myDialog.findViewById(R.id.macdesc);
//        image = myDialog.findViewById(R.id.designimage);
        for (int i = 0; i<data.size(); i++) {
            if(holder.mname.getText()==data.get(position).getMname()){
                name.setText(data.get(position).getMname());
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
        holder.mimage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast toast = Toast.makeText(context,"Expand the image to Zoom In",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mname;
        public ImageView mimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mimage = itemView.findViewById(R.id.outimage);
            mname = itemView.findViewById(R.id.mname);
        }
    }
}