package com.uniquindio.electiva_android.campusuq.dialogos;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uniquindio.electiva_android.campusuq.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Sugerencia extends DialogFragment {


    public Sugerencia() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sugerencia, container, false);
    }

}
