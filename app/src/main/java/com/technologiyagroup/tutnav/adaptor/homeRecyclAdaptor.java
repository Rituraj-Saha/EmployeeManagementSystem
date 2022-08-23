package com.technologiyagroup.tutnav.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.technologiyagroup.tutnav.R;
import com.technologiyagroup.tutnav.model.Employee;

import java.util.List;

public class homeRecyclAdaptor extends RecyclerView.Adapter<homeRecyclAdaptor.ViewHolder> {

    Context context;
    List<Employee> dataList;
    public homeRecyclAdaptor(Context context,List<Employee>dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_profile, parent, false);
        ViewHolder vh= new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee data = dataList.get(position);
        holder.emp_id.setText(data.getEmpId());
        holder.emp_name.setText(data.geteName());
        holder.emp_dept.setText(data.getDept());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView img_profile;
        TextView emp_id;
        TextView emp_name;
        TextView emp_dept;
        RadioGroup radio_grp;
        RadioButton radio_btn_present;
        RadioButton radio_btn_absent;
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            this.emp_id = view.findViewById(R.id.emp_id);
            this.emp_name = view.findViewById(R.id.emp_name);
            this.img_profile = view.findViewById(R.id.img_profile);
            this.emp_dept = view.findViewById(R.id.emp_dept);
            this.radio_grp = view.findViewById(R.id.radio_grp);
            this.radio_btn_present = view.findViewById(R.id.radio_btn_present);
            this.radio_btn_absent = view.findViewById(R.id.radio_btn_absent);
        }
    }

    public void setDataList(List<Employee> dataList) {
        this.dataList = dataList;
    }
}
