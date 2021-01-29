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

import io.gio.MAYSlotmachines777.Model.TipsViewModel;
import io.gio.MAYSlotmachines777.R;

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.ViewHolder> {
    List<TipsViewModel> data;
    Context context;
    TextView name,desc;


    public TipsAdapter(Context context, List<TipsViewModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public TipsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.tipsitem, parent, false);
        TipsAdapter.ViewHolder viewHolder = new TipsAdapter.ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final TipsAdapter.ViewHolder holder, final int position) {
        holder.mname.setText(data.get(position).getTitle());
        holder.mimage.setImageResource(data.get(position).getImg());
        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_tips_details);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        name = myDialog.findViewById(R.id.tname);
        desc = myDialog.findViewById(R.id.tdesc);
        for (int i = 0; i<data.size(); i++) {
            if(holder.mname.getText()==data.get(position).getTitle()){
                name.setText(data.get(position).getTitle());
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
        public ImageView mimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mimage = itemView.findViewById(R.id.cardImg);
            mname = itemView.findViewById(R.id.tiptitle);
        }
    }
}