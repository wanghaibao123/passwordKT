package com.whb.dbmodule.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * Created by whb on 2019/1/24.
 * Email:18720982457@163.com
 */
@Entity(nameInDb = "password")
public class PasswordBean implements Serializable{
    //主键自增
    @Id(autoincrement = true)
    private Long id;
    private String userside;
    private String name;
    private String passsord;
    private long time;
    private String desc;
    private boolean flag;
    @Generated(hash = 1047724216)
    public PasswordBean(Long id, String userside, String name, String passsord,
            long time, String desc, boolean flag) {
        this.id = id;
        this.userside = userside;
        this.name = name;
        this.passsord = passsord;
        this.time = time;
        this.desc = desc;
        this.flag = flag;
    }
    @Generated(hash = 1542250000)
    public PasswordBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserside() {
        return this.userside;
    }
    public void setUserside(String userside) {
        this.userside = userside;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPasssord() {
        return this.passsord;
    }
    public void setPasssord(String passsord) {
        this.passsord = passsord;
    }
    public long getTime() {
        return this.time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public boolean getFlag() {
        return this.flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}
