package com.example.zitchat;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zitchat.domain.Order;
import com.example.zitchat.domain.UserInfo;
import com.example.zitchat.rest.LoginApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile_fragment extends Fragment {
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
        View rootView = inflater.inflate(R.layout.profile, container, false);


        return rootView;
    }
}