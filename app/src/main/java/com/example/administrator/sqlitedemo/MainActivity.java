package com.example.administrator.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import greendao.datebase.StudentDao;
import greendao.datebase.TeachDao;

public class MainActivity extends AppCompatActivity {
    Button btnInsert,btnQuery,btnDelete;
    private static final String TAG = "MainActivity";
    StudentDao mSutudentDao;
    TeachDao teachDao;
    Random random=new Random();
    RecyclerView rv_data;
    MyAdapter adapter;
    List<Student> students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert=findViewById(R.id.btn_insert);
        btnQuery=findViewById(R.id.btn_query);
        btnDelete=findViewById(R.id.btn_delete);
        rv_data=findViewById(R.id.rv_data);
        rv_data.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter=new MyAdapter(this,R.layout.item_student);
        rv_data.setAdapter(adapter);
        mSutudentDao=MyApplication.getDaoSession().getStudentDao();
        teachDao=MyApplication.getDaoSession().getTeachDao();
        students=new ArrayList<>();
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAll();
            }
        });
    }
    //length用户要求产生字符串的长度
    public  String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(52);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    /**
     * 插入数据
     */
    private void  insert(){
        for (int i = 0; i <100 ; i++) {
            int age=random.nextInt(5)+20;
            String sex;
            if (i%2==0){
                sex="男";
            }else {
                sex="女";
            }
            String name=getRandomString(random.nextInt(6)+1);
            String adress=getRandomString(random.nextInt(1)+1);
            String gradle=String.valueOf(random.nextInt(3)+1)+"年级";

            Student student=new Student(null,20140000+i,age,
                    "13788888888",sex,name,
                    adress,"科大",gradle);

//

            mSutudentDao.insert(student);
        }

    }

    private void insertTeach(){
        for (int i = 0; i <10 ; i++) {
           Teach teach=new Teach((long) i,i);
            teachDao.insert(teach);
        }
    }
    private void save(){
        //key为空 插入
        Student student=new Student(null,20140000,21,"13788888888","男","nock","关东","科大"
                ,"aa");
        //key不为null,在数据库中有该key执行更新，在数据无无该key,不插入不更新
        Student student1=new Student((long) 123,20140000,21,"13788888888","男","nock","关东","科大"
                ,"aa");
    }

    /**
     * 查询数据
     */
    private void query(){
        //查询全部数据
            students=mSutudentDao.loadAll();
        Log.d(TAG, "query: "+students.size());
      adapter.setData(students);
    }

    private void deleteAll(){
        mSutudentDao.deleteAll();
    }

    /**
     * 删除指定的记录
     * @param student
     */
    private void delete(Student student){
        mSutudentDao.delete(student);
    }

    /**
     * 删除指定ID的记录
     * @param id  主键
     */
    protected void deleteById(Long id){
        mSutudentDao.deleteByKey(id);
    }
}
