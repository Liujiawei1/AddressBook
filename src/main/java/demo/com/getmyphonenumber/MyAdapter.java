package demo.com.getmyphonenumber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell on 2016/5/3.
 */
public class MyAdapter extends BaseAdapter {

    private List<phoneInfo> list;
    private Context context;
    private View layout;

    public MyAdapter(Context context,List<phoneInfo> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();//返回的是list的数量
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);//返回当前数据
    }

    @Override
    public long getItemId(int position) {
        return position;//返回当前id
    }

    @Override
    public View getView(int position,
                        View convertView, ViewGroup parent) {
       // LayoutInflater inflater=LayoutInflater.from(context);
        //layout=inflater.inflate(R.layout.cell,null);//加载子项布局
        //TextView nametv= (TextView) layout.findViewById(R.id.name);
        //TextView numbertv= (TextView) layout.findViewById(R.id.number);
        //nametv.setText(list.get(position).getName());//获取子项的姓名数据
        //numbertv.setText(list.get(position).getNumber());//获取电话数据

        ViewHolder viewHolder;
        if (convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.cell,null);
            viewHolder=new ViewHolder();
            viewHolder.nametv=(TextView)convertView.findViewById(R.id.name);
            viewHolder.numbertv= (TextView) convertView.findViewById(R.id.number);

            convertView.setTag(viewHolder);
            //将viewholder存储在view中，以后就不用再重新加载子项内容，而可以直接获取，性能得以优化
        }else {
            viewHolder= (ViewHolder) convertView.getTag();//获取
        }

        viewHolder.nametv.setText(list.get(position).getName());
        viewHolder.numbertv.setText(list.get(position).getNumber());

        return convertView;
    }

    static class ViewHolder{
        TextView nametv;
        TextView numbertv;
    }

}
