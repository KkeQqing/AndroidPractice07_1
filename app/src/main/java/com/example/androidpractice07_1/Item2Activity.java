package com.example.androidpractice07_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class Item2Activity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item2);

        tvResult = findViewById(R.id.tv_result);

        // 获取传递过来的数据
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");

        if ("array".equals(type)) {
            String[] array = intent.getStringArrayExtra("data_array");
            if (array != null) {
                String text = "数组值是：\n";
                for (int i = 0; i < array.length; i++) {
                    text += "数组项" + i + ":" + array[i] + "；";
                }
                tvResult.setText(text);
            }
        } else if ("list".equals(type)) {
            List<String> list = intent.getStringArrayListExtra("data_list");
            if (list != null) {
                String text = "集合值是：\n";
                for (int i = 0; i < list.size(); i++) {
                    text += "集合项" + i + ":" + list.get(i) + "；";
                }
                tvResult.setText(text);
            }
        }
    }
}
