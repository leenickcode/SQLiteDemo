package com.example.administrator.sqlitedemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2019/5/14 0014.
 *
 * @author Administrator
 *
 */
@Entity
public class Teach {
    @Id(autoincrement = true)
    Long id;
    @Unique
    int teachNo;//工号。
    @Generated(hash = 1101964655)
    public Teach(Long id, int teachNo) {
        this.id = id;
        this.teachNo = teachNo;
    }
    @Generated(hash = 858775668)
    public Teach() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getTeachNo() {
        return this.teachNo;
    }
    public void setTeachNo(int teachNo) {
        this.teachNo = teachNo;
    }
}
