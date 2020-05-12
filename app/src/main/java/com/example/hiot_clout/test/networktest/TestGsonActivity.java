package com.example.hiot_clout.test.networktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hiot_clout.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class TestGsonActivity extends AppCompatActivity {

    private static final String TAG = "TestGsonActivity";
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_gson);

        //JSON转对象
        Button btnFromJson = findViewById(R.id.btn_from_json);
        btnFromJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = gson.fromJson("{\n" +
                        "\t\"id\": 20,\n" +
                        "\t\"graduation\": false,\n" +
                        "\t\"name\": \"张三\",\n" +
                        "\t\"height:\":175\n" +
                        "}", Student.class);
                if (student != null) {
                    String str = String.format("姓名：%s,id：%d，height：%d，是否毕业：%b",
                            student.getName(), student.getId(),student.getHight(), student.isGraduation());
                    Toast.makeText(TestGsonActivity.this, str, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //对象转JSON
        Button btnToJson = findViewById(R.id.btn_to_json);
        btnToJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student();
                student.setName("李四");
                student.setHight(175);
                student.setId(10);
                student.setGraduation(true);
                String json = gson.toJson(student);
                Log.d(TAG, "onClick: " + json);
            }
        });

        //JSON转列表
        Button btnGsonList = findViewById(R.id.btn_gson_list);
        btnGsonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json = "[\n" +
                        "\t{\n" +
                        "\t\t\"id\": 20,\n" +
                        "\t\"graduation\": false,\n" +
                        "\t\"name\": \"张三\",\n" +
                        "\t\"height:\":175\n" +
                        "\t},\n" +
                        "\t{\n" +
                        "\t\t\"id\": 20,\n" +
                        "\t\"graduation\": false,\n" +
                        "\t\"name\": \"李四\",\n" +
                        "\t\"height:\":175\n" +
                        "\t},\n" +
                        "\t{\n" +
                        "\t\t\"id\": 20,\n" +
                        "\t\"graduation\": false,\n" +
                        "\t\"name\": \"王五\",\n" +
                        "\t\"height:\":175\n" +
                        "\t}\n" +
                        "]";
                Type type = new TypeToken<List<Student>>() {
                }.getType();
                List<Student> studentList = gson.fromJson(json, type);
                String str = "";
                if (studentList != null || !studentList.isEmpty()) {
                    for (Student student : studentList) {
                        str = str + String.format("姓名：%s,id：%d，height：%d，是否毕业：%b",
                                student.getName(), student.getId(),student.getHight(), student.isGraduation());
                    }
                    Toast.makeText(TestGsonActivity.this, str, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //JSON转Map
        Button btnGsonMap = findViewById(R.id.btn_gson_map);
        btnGsonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json = "{\n" +
                        "\t\"1\":{\n" +
                        "\t\t\"id\": 20,\n" +
                        "\t\t\"graduation\": false,\n" +
                        "\t\t\"name\": \"张三\",\n" +
                        "\t\t\"height:\": 175\n" +
                        "\t},\n" +
                        "\t\"2\":{\n" +
                        "\t\t\"id\": 20,\n" +
                        "\t\t\"graduation\": false,\n" +
                        "\t\t\"name\": \"李四\",\n" +
                        "\t\t\"height:\": 175\n" +
                        "\t},\n" +
                        "\t\"3\":{\n" +
                        "\t\t\"id\": 20,\n" +
                        "\t\t\"graduation\": false,\n" +
                        "\t\t\"name\": \"王五\",\n" +
                        "\t\t\"height:\": 175\n" +
                        "\t}\n" +
                        "}";
                Type type=new TypeToken<Map<String, Student>>(){}.getType();
                Map<String,Student> map = gson.fromJson(json, type);
                String str="";
                if (map!=null){
                    for(String key: map.keySet()){
                        Student student = map.get(key);
                        str = str + String.format("姓名：%s,id：%d，height：%d，是否毕业：%b",
                                student.getName(), student.getId(),student.getHight(), student.isGraduation());
                    }
                    Toast.makeText(TestGsonActivity.this, str, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //JSON转嵌套对象
        Button btnGsonNest = findViewById(R.id.btn_gson_nest);
        btnGsonNest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json="{\n" +
                        "\t\"data\":\n" +
                        "\t{\n" +
                        "\t\t\"id\": 20,\n" +
                        "\t\"graduation\": false,\n" +
                        "\t\"name\": \"张三\",\n" +
                        "\t\"height:\":175\n" +
                        "\t},\n" +
                        "\t\"status\":1,\n" +
                        "\t\"msg\":\"正常\"\n" +
                        "}";
                Type type=new TypeToken<ResultBase<Student>>(){}.getType();
                ResultBase<Student> resultBase= gson.fromJson(json, type);
                String str=String.format("姓名：%s,id：%d，height：%d，是否毕业：%b",
                        resultBase.data.getName(), resultBase.data.getId(),resultBase.data.getHight(), resultBase.data.isGraduation());
                Toast.makeText(TestGsonActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
