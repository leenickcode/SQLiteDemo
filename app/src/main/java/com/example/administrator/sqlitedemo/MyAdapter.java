package com.example.administrator.sqlitedemo;

import android.content.Context;

import com.lee.mylibrary.BaseRecyclerViewAdapter;
import com.lee.mylibrary.UniversalViewHolder;

/**
 * Created by Administrator on 2019/5/14 0014.
 *
 * @author Administrator
 */
public class MyAdapter extends BaseRecyclerViewAdapter<Student> {
    public MyAdapter(Context mContext, int mDefaultItemLayoutId) {
        super(mContext, mDefaultItemLayoutId);
    }

    @Override
    protected void bindData(UniversalViewHolder holder, int position, Student bean) {
            if (bean instanceof Student){
                holder.getTextView(R.id.tv_name).setText(((Student) bean).getName());
                holder.getTextView(R.id.tv_age).setText(((Student) bean).getAge()+"");
                holder.getTextView(R.id.tv_adress).setText(((Student) bean).getAddress());
                holder.getTextView(R.id.tv_gradle).setText(((Student) bean).getGrade());
                holder.getTextView(R.id.tv_sex).setText(((Student) bean).getSex());
                holder.getTextView(R.id.tv_school).setText(((Student) bean).getSchoolName());

            }
    }
}
