package test.com.glidedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImageView;
    private Button mButton;
    private final static String url_right = "http://img06.tooopen.com/images/20160921/tooopen_sy_179583447187.jpg";
    private final static String url_error = "http://imgs06.tooopen.com/images/20160921/tooopen_sy_179583447187.jpg";
    private final static String url_gif = "http://p1.pstatp.com/large/166200019850062839d3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initeView();
        initeData();
    }

    private void initeView() {
        mButton = findViewById(R.id.button);
        mImageView = findViewById(R.id.imageView);
        mButton.setOnClickListener(this);
    }

    private void initeData() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
//                loadImage(mImageView);
                loadGifImage(mImageView);
                break;
            default:
                break;
        }
    }

    /**
     * 加载普通照片
     * @param imageView
     */
    private void loadImage(ImageView imageView) {
        Glide.with(this)
                .load(url_right)
                .placeholder(R.mipmap.test_default)
                .error(R.mipmap.image_error)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .override(100, 100)
                .into(imageView);
    }

    /**
     * 加载gif照片
     * @param imageView
     */
    private void loadGifImage(ImageView imageView) {
        Glide.with(this)
                .load(url_gif)
                .asGif()
                .placeholder(R.mipmap.test_default)
                .error(R.mipmap.image_error)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }
    private void testGlide(){
        Glide.with(this).load(url_error).into(mImageView);
    }

}
