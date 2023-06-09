package com.example.zitchat;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.zitchat.dialogs.AddPerson;

public class Chats_Fragment extends Fragment {
    Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //MapKitFactory.setApiKey(MAPKIT_API_KEY);
        //MapKitFactory.initialize(this);


        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.chats, container, false);


        Button b = rootView.findViewById(R.id.button_add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddPerson myDialogFragment = new AddPerson();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                //myDialogFragment.show(manager, "dialog");

                FragmentTransaction transaction = manager.beginTransaction();
                myDialogFragment.show(transaction, "dialog");

            }
        });
        return rootView;
    }
}