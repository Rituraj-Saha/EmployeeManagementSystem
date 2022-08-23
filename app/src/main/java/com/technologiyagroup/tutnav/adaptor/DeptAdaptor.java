package com.technologiyagroup.tutnav.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.technologiyagroup.tutnav.R;
import com.technologiyagroup.tutnav.model.Dept;
import com.technologiyagroup.tutnav.model.Employee;


import java.util.List;

public class DeptAdaptor extends RecyclerView.Adapter<DeptAdaptor.ViewHolder> {

    Context context;
    List<Dept> dataList;
    int selected = 0;
    public DeptAdaptor(Context context,List<Dept>dataList) {
        this.context = context;
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dept, parent, false);
        DeptAdaptor.ViewHolder vh= new DeptAdaptor.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dept data = dataList.get(position);
        holder.txt_dept.setText(data.getName());
        holder.txt_dept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.txt_dept.setBackground(context.getDrawable(R.drawable.dept_back_selected));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_dept;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
          this.txt_dept = view.findViewById(R.id.txt_dept);
        }
    }
}
