package com.example.zitchat.dialogs;

import static android.app.Activity.RESULT_OK;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


import com.example.zitchat.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPerson extends DialogFragment {
    Context mContext;
    private int last_index;

    private static final int SELECT_PICTURE = 1;
    private ImageView imageView;
    private static final int PICK_IMAGE_REQUEST_CODE = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private Uri selectedImageUri;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);




        if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.getData();
            if (null != selectedImageUri) {
                imageView.setImageURI(selectedImageUri);

            }
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        View view = getLayoutInflater().inflate(R.layout.addperson, null);
        Button add = view.findViewById(R.id.button3);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = view.findViewById(R.id.editTextDesc);

            }
        });


        //builder.setTitle("Создать заказ")
        //
        //        .setPositiveButton("Отменить", new DialogInterface.OnClickListener() {
        //            public void onClick(DialogInterface dialog, int id) {
        //                // Закрываем диалоговое окно
        //                dialog.cancel();
        //            }
        //        });
        builder.setView(view);
        return builder.create();
    }
}