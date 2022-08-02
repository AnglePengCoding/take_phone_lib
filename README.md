# take_phone_lib
<h2>介绍</h2>
<h3>相册上传，支持单传，多传，指定类型传/resultCode的小lib  </h3>

[![](https://jitpack.io/v/AnglePengCoding/take_phone_lib.svg)](https://jitpack.io/#AnglePengCoding/take_phone_lib)

<h3> Step 2. Add the dependency 以最新版本为准 </h3>

```java
  implementation 'com.github.AnglePengCoding:take_phone_lib:Tag'
```


<h4> 单传图片 </h4>

```java 
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
    
```
<h4> 单传且指定类型图片 </h4>

```java 
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

```

<h4> 多传图片 </h4>

```java 

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

```


