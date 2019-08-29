package com.sample.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {

    private List<Student> studentList;
    private MyOnItemClickListener myOnItemClickListener;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setMyOnItemClickListener(MyOnItemClickListener myOnItemClickListener) {
        this.myOnItemClickListener = myOnItemClickListener;
    }

    //khai bao cac doi tuong co trong hang do
    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_row, viewGroup, false);
        return new StudentHolder(view);
    }

    //dua du lieu tu danh sach sinh vien bo vao cac hang tuong ung
    @Override
    public void onBindViewHolder(@NonNull StudentHolder studentHolder, final int i) {
        studentHolder.tvStudent.setText(studentList.get(i).getName() + studentList.get(i).getPhone());
        studentHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myOnItemClickListener.onClick(studentList.get(i));
            }
        });
    }

    //tra ve so hang ma recycler hien thi
    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentHolder extends RecyclerView.ViewHolder {

        public TextView tvStudent;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            tvStudent = itemView.findViewById(R.id.tvStudent);
        }
    }
}
