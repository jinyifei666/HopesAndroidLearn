package top.jinyifei.hopes.ui;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import top.jinyifei.hopes.R;
import android.provider.ContactsContract.CommonDataKinds.Phone;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContentProviderActivity extends AppCompatActivity {

    private EditText et_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        et_result = (EditText) findViewById(R.id.contacts_result);
        String duanxin=getSmsInPhone();
        et_result.setText(duanxin);
//        // 1、获得解析器
//        ContentResolver resolver = this.getContentResolver();
//        // 2、将查询的结构返回为游标类型数据
//        Cursor cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] {
//                Phone.DISPLAY_NAME, Phone.NUMBER }, null, null, null);
//        if (cursor != null) {
//            while (cursor.moveToNext()) {
//                String name = cursor.getString(cursor
//                        .getColumnIndex(Phone.DISPLAY_NAME));
//                String number = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
//                et_result.setText("姓名:" + name + ":" + "\n号码:" + number);
//            }
//
//        }
        /**
         * 使用ContentValues为数据库增加数据
         */
//		ContentValues values = new ContentValues();
//		values.put(Phone.DISPLAY_NAME, "张三");
//		values.put(Phone.NUMBER, "13574651834");
//		resolver.insert(uri, values);


    }

    public String getSmsInPhone()
    {
        final String SMS_URI_ALL   = "content://sms/";
        final String SMS_URI_INBOX = "content://sms/inbox";
        final String SMS_URI_SEND  = "content://sms/sent";
        final String SMS_URI_DRAFT = "content://sms/draft";

        StringBuilder smsBuilder = new StringBuilder();

        try{
            ContentResolver cr = getContentResolver();
            String[] projection = new String[]{"_id", "address", "person",
                    "body", "date", "type"};
            Uri uri = Uri.parse(SMS_URI_ALL);
            Cursor cur = cr.query(uri, projection, null, null, "date desc");

            if (cur.moveToFirst()) {
                String name;
                String phoneNumber;
                String smsbody;
                String date;
                String type;

                int nameColumn = cur.getColumnIndex("person");
                int phoneNumberColumn = cur.getColumnIndex("address");
                int smsbodyColumn = cur.getColumnIndex("body");
                int dateColumn = cur.getColumnIndex("date");
                int typeColumn = cur.getColumnIndex("type");

                do{
                    name = cur.getString(nameColumn);
                    phoneNumber = cur.getString(phoneNumberColumn);
                    smsbody = cur.getString(smsbodyColumn);

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date d = new Date(Long.parseLong(cur.getString(dateColumn)));
                    date = dateFormat.format(d);

                    int typeId = cur.getInt(typeColumn);
                    if(typeId == 1){
                        type = "接收";
                    } else if(typeId == 2){
                        type = "发送";
                    } else {
                        type = "";
                    }

                    smsBuilder.append("[");
                    smsBuilder.append(name+",");
                    smsBuilder.append(phoneNumber+",");
                    smsBuilder.append(smsbody+",");
                    smsBuilder.append(date+",");
                    smsBuilder.append(type);
                    smsBuilder.append("] ");
                    smsBuilder.append("\n");
                    if(smsbody == null) smsbody = "";
                }while(cur.moveToNext());
            } else {
                smsBuilder.append("no result!");
            }
        } catch(SQLiteException ex) {
            Log.d("SQLiteException", ex.getMessage());
        }
        return smsBuilder.toString();
    }
}
