package top.jinyifei.hopes.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * author: jinyifei
 * time:  Created on 2017/7/25.
 * email：jyf@whu.edu.cn
 * function：
 */


@DatabaseTable(tableName = "people_tb")
public class People {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "people_name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
