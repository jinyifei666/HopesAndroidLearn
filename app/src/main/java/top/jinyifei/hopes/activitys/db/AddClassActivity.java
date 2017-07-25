package top.jinyifei.hopes.activitys.db;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.sql.SQLException;

import top.jinyifei.hopes.R;
import top.jinyifei.hopes.dao.ClassDao;
import top.jinyifei.hopes.models.ClassModel;


public class AddClassActivity extends Activity {


    private EditText classIdEdit;
    private EditText classNameEdit;
    private Button classAddBtn;
    private ClassModel classModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        classIdEdit = (EditText)findViewById(R.id.class_id_edittext);
        classNameEdit = (EditText)findViewById(R.id.class_name_edittext);
        classAddBtn = (Button)findViewById(R.id.class_add_btn);

        classAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classModel = new ClassModel();
                classModel.setClassId(Integer.parseInt(classIdEdit.getText().toString()));
                classModel.setClassName(classNameEdit.getText().toString());
                try {
                    ClassDao.getInstance(AddClassActivity.this).save(classModel);
                    Toast.makeText(AddClassActivity.this,"成功",Toast.LENGTH_LONG).show();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
