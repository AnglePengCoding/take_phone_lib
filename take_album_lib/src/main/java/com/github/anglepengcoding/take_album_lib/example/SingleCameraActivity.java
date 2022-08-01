package com.github.anglepengcoding.take_album_lib.example;

import android.content.Intent;
import android.os.Bundle;

import com.github.anglepengcoding.take_album_lib.SingleChoicePictureSelector;
import com.github.anglepengcoding.take_album_lib.listener.SingleCameraData;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author AngleCondingPeng
 * Created by on 2022/8/1 0001
 * @website https://github.com/AnglePengCoding
 * single choice photo
 */
public class SingleCameraActivity extends AppCompatActivity implements SingleCameraData {

    SingleChoicePictureSelector selector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        selector = SingleChoicePictureSelector.create(this);

//        findViewById(R.id.positive).setOnClickListener(v -> {
//            selector.openCamera().openSingleCamera();
//        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        selector.openCamera().getIntentResult(resultCode, requestCode, data, this);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void getCameraData(ArrayList<LocalMedia> localMedia, int requestCode) {

//        ImageView positive = findViewById(R.id.positive);
//        positive.setImageBitmap(BitmapFactory.decodeFile(localMedia.get(0).getPath()));
    }
}
