package com.example.androidpractice07_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        List<String> items = getItems();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(myListener);
    }

    private List<String> getItems() {
        List<String> items = new ArrayList<>();
        items.add("Intent传递数组");
        items.add("Intent传递集合");
        items.add("Intent传递对象");
        items.add("Intent传递Bitmap");
        return items;
    }

    private final AdapterView.OnItemClickListener myListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String text = (String) parent.getItemAtPosition(position);
            Toast.makeText(MainActivity.this, "点击：" + text, Toast.LENGTH_SHORT).show();

            Intent intent = null;
            switch (position) {
                case 0:
                    // 传递数组
                    intent = new Intent(MainActivity.this, Item2Activity.class);
                    intent.putExtra("type", "array");
                    intent.putExtra("data_array", new String[]{"呵呵", "哈哈", "喝喝"});
                    break;
                case 1:
                    // 传递集合
                    intent = new Intent(MainActivity.this, Item2Activity.class);
                    intent.putExtra("type", "list");
                    List<String> list = new ArrayList<>();
                    list.add("集合项1");
                    list.add("集合项2");
                    list.add("集合项3");
                    intent.putStringArrayListExtra("data_list", (ArrayList<String>) list);
                    break;
                case 2:
                    // 传递对象 (使用Gson转成Json字符串)
                    intent = new Intent(MainActivity.this, Item3Activity.class);
                    Book book = new Book("Java编程思想", "Bruce Eckel");
                    intent.putExtra("book_json", new Gson().toJson(book));
                    break;
                case 3:
                    // 传递Bitmap (这里我们传递一个资源ID，或者在Item3中生成Bitmap)
                    // 为了简化，我们在Item3中加载一个本地图片
                    intent = new Intent(MainActivity.this, Item3Activity.class);
                    intent.putExtra("load_image", true);
                    break;
            }
            if (intent != null) {
                startActivity(intent);
            }
        }
    };
}