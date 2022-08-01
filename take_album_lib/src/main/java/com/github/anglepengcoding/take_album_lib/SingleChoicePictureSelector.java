package com.github.anglepengcoding.take_album_lib;

import android.app.Activity;
import android.content.Context;

import java.lang.ref.WeakReference;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * @author AngleCondingPeng
 * Created by on 2022/8/1 0001
 * @website https://github.com/AnglePengCoding
 * Start SingleChoicePictureSelector for class.
 */
public final class SingleChoicePictureSelector {

    private final WeakReference<Activity> mActivity;
    private final WeakReference<Fragment> mFragment;

    public SingleChoicePictureSelector(Activity activity) {
        this(activity, null);
    }

    private SingleChoicePictureSelector(Fragment fragment) {
        this(fragment.getActivity());
    }

    private SingleChoicePictureSelector(Activity activity, Fragment fragment) {
        mActivity = new WeakReference<>(activity);
        mFragment = new WeakReference<>(fragment);
    }

    /**
     * Start SingleChoicePictureSelector for context.
     *
     * @param context
     * @return SingleChoicePictureSelector instance.
     */
    public static SingleChoicePictureSelector create(Context context) {
        return new SingleChoicePictureSelector((Activity) context);
    }

    public static SingleChoicePictureSelector create(Fragment fragment) {
        return new SingleChoicePictureSelector(fragment);
    }

    public static SingleChoicePictureSelector create(Activity activity) {
        return new SingleChoicePictureSelector(activity);
    }

    /**
     * open camera
     */
    public PictureOpenCamera openCamera() {
        return new PictureOpenCamera(this);
    }


    @Nullable
    Activity getActivity() {
        return mActivity.get();
    }

    @Nullable
    Fragment getFragment() {
        return mFragment != null ? mFragment.get() : null;
    }
}
