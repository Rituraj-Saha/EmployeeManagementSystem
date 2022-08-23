package com.technologiyagroup.tutnav.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.technologiyagroup.tutnav.MainActivity;
import com.technologiyagroup.tutnav.R;
import com.technologiyagroup.tutnav.databinding.FragmentManageEmployeeBinding;
import com.technologiyagroup.tutnav.databinding.ItemProfileBinding;
import com.technologiyagroup.tutnav.model.Employee;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ManageEmployeeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ManageEmployeeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentManageEmployeeBinding binding;
    public ManageEmployeeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ManageEmployeeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ManageEmployeeFragment newInstance(String param1, String param2) {
        ManageEmployeeFragment fragment = new ManageEmployeeFragment();
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
        binding = FragmentManageEmployeeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        MainActivity mainActivity = (MainActivity) this.getActivity();

        replaceFragment (new EmployeeDetailsFragment(),binding.mFrame);
        binding.loginCrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.imgSelectViewAll.setVisibility(View.VISIBLE);
                binding.imgSelectAddNew.setVisibility(View.GONE);
                replaceFragment (new EmployeeDetailsFragment(),binding.mFrame);
            }
        });
        binding.signupCrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.imgSelectViewAll.setVisibility(View.GONE);
                binding.imgSelectAddNew.setVisibility(View.VISIBLE);
                replaceFragment (new AddNewEmployeeFragment(),binding.mFrame);
            }
        });
        return view;
    }


    public void replaceFragment(Fragment fragment,View view) {
        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentManager.popBackStack();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(view.getId(), fragment);
        if(fragment instanceof Home)
        {

        }
        else
        {
            fragmentTransaction.addToBackStack(fragment.toString());
        }
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

}