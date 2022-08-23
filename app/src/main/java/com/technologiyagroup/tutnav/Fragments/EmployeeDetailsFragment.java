package com.technologiyagroup.tutnav.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.technologiyagroup.tutnav.R;
import com.technologiyagroup.tutnav.adaptor.DeptAdaptor;
import com.technologiyagroup.tutnav.adaptor.homeRecyclAdaptor;
import com.technologiyagroup.tutnav.databinding.FragmentEmployeeDetailsBinding;
import com.technologiyagroup.tutnav.databinding.ItemProfileBinding;
import com.technologiyagroup.tutnav.model.Dept;
import com.technologiyagroup.tutnav.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmployeeDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

   private FragmentEmployeeDetailsBinding binding;
    public EmployeeDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmployeeDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmployeeDetailsFragment newInstance(String param1, String param2) {
        EmployeeDetailsFragment fragment = new EmployeeDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEmployeeDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        binding.recyclEmpDept.setLayoutManager(
                new GridLayoutManager(getActivity(),
                        2,
                        GridLayoutManager.HORIZONTAL,
                        false));
        List<Dept> dataList = new ArrayList<>();
        dataList.add(new Dept("IT"));
        dataList.add(new Dept("CSE"));
        dataList.add(new Dept("ECE"));
        dataList.add(new Dept("HR"));
        dataList.add(new Dept("SD"));
        DeptAdaptor adaptor = new DeptAdaptor(this.requireContext(),dataList);
        binding.recyclEmpDept.setAdapter(adaptor);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1","RTR","It","18-08-2022"));
        employees.add(new Employee("2","Megha","It","18-08-2022"));
        employees.add(new Employee("3","Suvo","It","18-08-2022"));
        employees.add(new Employee("4","Shiladitya","It","18-08-2022"));
        employees.add(new Employee("5","Bholanath","It","18-08-2022"));

        addLayout(binding.linDetailsParent,employees);

        return view;
    }
    private void addLayout(LinearLayout my_linear_layout, List<Employee>employees) {
        ItemProfileBinding pbinding;
        my_linear_layout.removeAllViews();
        for (Employee e:employees) {
            pbinding = ItemProfileBinding.inflate(getLayoutInflater());
            View view =pbinding.getRoot();
            pbinding.empDept.setText(e.getDept());
            pbinding.empId.setText(e.getEmpId());
            pbinding.empName.setText(e.geteName());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            layoutParams.setMargins(30, 20, 30, 0);
            my_linear_layout.addView(view,layoutParams);
        }
    }
}