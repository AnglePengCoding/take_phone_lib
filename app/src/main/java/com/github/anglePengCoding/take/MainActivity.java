package com.github.anglePengCoding.take;

import android.content.Intent;
import android.os.Bundle;


import com.github.anglepengcoding.take_album_lib.SingleChoicePictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    SingleChoicePictureSelector selector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.up).setOnClickListener(v -> {
            selector = SingleChoicePictureSelector.create(this);
            selector.openCamera().openMultipleActivityCamera(null, new
                    OnResultCallbackListener<LocalMedia>() {
                @Override
                public void onResult(ArrayList<LocalMedia> result) {
                    // TODO: 2022/8/1 0001
                    //Do what you should do

                }

                @Override
                public void onCancel() {

                }
            });
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}