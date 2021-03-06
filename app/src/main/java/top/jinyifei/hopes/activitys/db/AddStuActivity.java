package top.jinyifei.hopes.activitys.db;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



import java.sql.SQLException;

import top.jinyifei.hopes.R;
import top.jinyifei.hopes.dao.StudentDao;
import top.jinyifei.hopes.models.ClassModel;
import top.jinyifei.hopes.models.Student;



public class AddStuActivity extends Activity {

    private EditText studentIdEdit;
    private EditText studentNameEdit;
    private EditText classIdEdit;
    private EditText classNameEdit;
    private Button studentAddBtn;
    private Student studentModel;
    private ClassModel classModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


        studentIdEdit = (EditText)findViewById(R.id.student_id_edittext);
        studentNameEdit = (EditText)findViewById(R.id.student_name_edittext);
        classIdEdit = (EditText)findViewById(R.id.stu_class_id_edittext);
        classNameEdit = (EditText)findViewById(R.id.stu_class_name_edittext);
        studentAddBtn = (Button)findViewById(R.id.student_add_btn);

        studentAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentModel = new Student();
                classModel = new ClassModel();
                studentModel.setStudetId(Integer.parseInt(studentIdEdit.getText().toString()));
                studentModel.setName(studentNameEdit.getText().toString());
                classModel.setClassId(Integer.parseInt(classIdEdit.getText().toString()));
                classModel.setClassName(classNameEdit.getText().toString());
                studentModel.setClassModel(classModel);
                try {
                    StudentDao.getInstance(AddStuActivity.this).save(studentModel);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
