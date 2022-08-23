package com.technologiyagroup.tutnav.Fragments;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technologiyagroup.tutnav.R;
import com.technologiyagroup.tutnav.databinding.FragmentAddNewEmployeeBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddNewEmployeeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddNewEmployeeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private FragmentAddNewEmployeeBinding binding;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int REQUEST_GALLERY = 1000;
    private int REQUEST_CAMERA = 1001;
    private int REQUEST_PERMISSION = 1002;
    private int requestCode = 0;
    public AddNewEmployeeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddNewEmployeeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddNewEmployeeFragment newInstance(String param1, String param2) {
        AddNewEmployeeFragment fragment = new AddNewEmployeeFragment();
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
        binding =  FragmentAddNewEmployeeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();


        return view;
    }
    void changeProfilePicture() {

        checkAndRequestPermissions(this.requireActivity());

    }
    private Boolean checkAndRequestPermissions(Activity context) {
        int storage = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        );
        ArrayList<String> permissions = new ArrayList<String>();
        if (storage != PackageManager.PERMISSION_GRANTED) {
            permissions
                    .add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissions.isEmpty()) {
            ActivityCompat.requestPermissions(
                    context, (String[]) permissions.toArray(),
                    this.REQUEST_PERMISSION
            );
            return false;
        }
//        chooseImage(this.requireActivity(), someActivityResultLauncher);
        return true;

    }






    void chooseImage(
            Activity activity,
            ActivityResultLauncher<Intent> launcher
    ) {
        try {
            //requestCode = REQUEST_GALLERY
            //galleryIntent()

            new AlertDialog.Builder(activity)
                    .setMessage("Where to attach image from?")
                    .setCancelable(true)
                    .setPositiveButton("Gallery", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            requestCode = REQUEST_GALLERY;
//                            galleryIntent();
                        }
                    })
                .setNegativeButton("Camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        requestCode = REQUEST_CAMERA;
//                        cameraIntent();
                    }
                })
                .show();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}