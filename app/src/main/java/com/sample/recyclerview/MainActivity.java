package com.sample.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvStudents;
    private List<Student> studentList;
    private StudentAdapter studentAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvStudents = findViewById(R.id.rvStudents);

        studentList = new ArrayList<>();
        studentList.add(new Student("van", "0928922020"));
        studentList.add(new Student("van", "0928922020"));
        studentList.add(new Student("van", "0928922020"));
        studentList.add(new Student("van", "0928922020"));
        studentList.add(new Student("van", "0928922020"));
        studentList.add(new Student("van", "0928922020"));
        studentList.add(new Student("van", "0928922020"));
        studentList.add(new Student("van", "0928922020"));
        studentList.add(new Student("van", "0928922020"));
        studentList.add(new Student("van", "0928922020"));
        studentList.add(new Student("van", "0928922020"));
        studentList.add(new Student("van", "0928922020"));
        studentList.add(new Student("van", "0928922020"));


        rvStudents.setHasFixedSize(true);

        studentAdapter = new StudentAdapter(studentList);

        studentAdapter.setMyOnItemClickListener(new MyOnItemClickListener() {
            @Override
            public void onClick(Student student) {
                Toast.makeText(MainActivity.this, student.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        linearLayoutManager = new LinearLayoutManager(this); //MainActivity.this ; getApplicationContext()
        rvStudents.setLayoutManager(linearLayoutManager);
        rvStudents.setAdapter(studentAdapter);
    }
}
