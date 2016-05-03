package demo.com.getmyphonenumber;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/5/3.
 */
public class GetNumber extends AppCompatActivity {

    //将list设置为静态全局变量，在其他类可以直接通过GetNumber类名来调用它
    public static List<phoneInfo> list=new ArrayList<phoneInfo>();

    public static String getNumber(Context context){

        //获取电话本数据的地址并返回传入Cursor
        Cursor cursor=context.getContentResolver()
                .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);

        String phoneNumber,phoneName;

        //遍历获取电话本里的数据
        while(cursor.moveToNext()){
            phoneNumber=cursor.getString
                    (cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            phoneName=cursor.getString
                    (cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            phoneInfo phoneinfo=new phoneInfo(phoneName,phoneNumber);

            list.add(phoneinfo);//将数据放到列表里
        }
        return null;
    }

}
