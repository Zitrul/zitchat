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
import androidx.recyclerview.widget.RecyclerView;

import com.example.zitchat.adapter.ChatsAdapter;
import com.example.zitchat.dialogs.AddPerson;
import com.example.zitchat.domain.Contact;

import java.util.ArrayList;

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
        RecyclerView recViewJobs = rootView.findViewById(R.id.rvJobs);
        //example
        Contact mycontact = new Contact(1,"Egor","Hi");

        ArrayList<Contact> basearray = new ArrayList<Contact>();
        basearray.add(mycontact);
        Contact mycontact1 = new Contact(1,"Igor","Hi");

        basearray.add(mycontact1);

        ChatsAdapter chatsadapter = new ChatsAdapter(getContext(),basearray);
        recViewJobs.setAdapter(chatsadapter);


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