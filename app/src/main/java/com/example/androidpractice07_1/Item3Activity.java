package com.example.androidpractice07_1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;

public class Item3Activity extends AppCompatActivity {

    private TextView tvObjResult;
    private ImageView ivBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item3);

        tvObjResult = findViewById(R.id.tv_obj_result);
        ivBitmap = findViewById(R.id.iv_bitmap);

        Intent intent = getIntent();

        // 1. 接收并解析对象
        String bookJson = intent.getStringExtra("book_json");
        if (bookJson != null) {
            Book book = new Gson().fromJson(bookJson, Book.class);
            tvObjResult.setText("Item3_Activity, Json解析值是：\n" +
                    "书名是：" + book.getName() + "，作者是：" + book.getAuthor());
        }

        // 2. 显示Bitmap
        boolean loadImage = intent.getBooleanExtra("load_image", false);
        if (loadImage) {



            // 传统方式 (如果图片很大，可能会卡顿)
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
            ivBitmap.setImageBitmap(bitmap);

        }
    }
}