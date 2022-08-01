package com.github.anglepengcoding.take_album_lib.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.github.anglepengcoding.take_album_lib.SingleChoicePictureSelector;
import com.github.anglepengcoding.take_album_lib.listener.SingleMultipleCameraData;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;

import androidx.annotation.Nullable;

/**
 * @author AngleCondingPeng
 * Created by on 2022/8/1 0001
 * @website https://github.com/AnglePengCoding
 * single choice photo- upload pictures of specified type
 */
public class TypeSelectionActivity extends Activity implements SingleMultipleCameraData {

    SingleChoicePictureSelector selector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        selector = SingleChoicePictureSelector.create(this);

//        findViewById(R.id.positive).setOnClickListener(v -> {
//            selector.openCamera().openSingleCamera("身份证");
//        });

//        findViewById(R.id.reverse).setOnClickListener(v -> {
//            selector.openCamera().openSingleCamera("反面证");
//        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        selector.openCamera().getIntentMultipleResult(resultCode, requestCode, data, this);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void getMultipleCameraData(String type, ArrayList<LocalMedia> localMedia, int requestCode) {
        switch (type) {
            case "身份证":
//                ImageView positive = findViewById(R.id.positive);
//                positive.setImageBitmap(BitmapFactory.decodeFile(localMedia.get(0).getPath()));
                break;
            case "反面证":
//                ImageView reverse = findViewById(R.id.reverse);
//                reverse.setImageBitmap(BitmapFactory.decodeFile(localMedia.get(0).getPath()));
                break;
        }
    }
}
