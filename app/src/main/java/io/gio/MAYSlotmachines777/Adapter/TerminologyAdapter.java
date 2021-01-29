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

import io.gio.MAYSlotmachines777.Model.TerminologyViewModel;
import io.gio.MAYSlotmachines777.R;

public class TerminologyAdapter extends RecyclerView.Adapter<TerminologyAdapter.ViewHolder> {
    List<TerminologyViewModel> data;
    Context context;
    TextView name,desc;
    ImageView image;


    public TerminologyAdapter(Context context, List<TerminologyViewModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public TerminologyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.terminologyitem, parent, false);
        TerminologyAdapter.ViewHolder viewHolder = new TerminologyAdapter.ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final TerminologyAdapter.ViewHolder holder, final int position) {
        holder.mname.setText(data.get(position).getName());
        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_terminology_details);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        name = myDialog.findViewById(R.id.tername);
        desc = myDialog.findViewById(R.id.terdesc);
        for (int i = 0; i<data.size(); i++) {
            if(holder.mname.getText()==data.get(position).getName()){
                name.setText(data.get(position).getName());
                desc.setText(data.get(position).getDesc());
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mname;
//     public ImageView mimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            mimage = itemView.findViewById(R.id.outimage);
            mname = itemView.findViewById(R.id.tername);
        }
    }
}