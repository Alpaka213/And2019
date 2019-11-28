package com.example.androidhw;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListVIewItem> listViewItemList =new ArrayList<ListVIewItem>();

    public ListViewAdapter(){}

    public ListViewAdapter(ArrayList<ListVIewItem> data){
        this.listViewItemList = data;

    }
    public int getCount(){
        return listViewItemList.size();
    }

    public View getView(int position, View convertView, ViewGroup parent){
        final  int pos =position;
        final Context context = parent.getContext();

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row, parent,false);
        }

        ImageView button = (ImageView) convertView.findViewById(R.id.imageView2);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(context, pos + 1 + "번째 선택", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder alertdialog = new AlertDialog.Builder(context);

                alertdialog.setMessage(listViewItemList.get(pos).getDescStr() + "으로 전화하시겠습니까?");

                alertdialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "확인 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+listViewItemList.get(pos).getDescStr()));
                        context.startActivity(intent);
                    }
                });
                alertdialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"취소 버튼을 눌렀습니다.",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alert = alertdialog.create();
                alert.setIcon(R.mipmap.ic_launcher);
                alert.setTitle("전화연결");
                alert.show();
            }
        });

        ImageView button2 = (ImageView) convertView.findViewById(R.id.imageView1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it= new Intent(context, ProfileActivity.class);
                it.putExtra("image",pos);
                it.putExtra("title",listViewItemList.get(pos).getTitle());
                it.putExtra("desc",listViewItemList.get(pos).getDescStr());
                it.putExtra("loc",listViewItemList.get(pos).getLocation());
                it.putExtra("email",listViewItemList.get(pos).getEmail());

                context.startActivity(it);
            }
        });

        ImageView IconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2);
        TextView emailView = (TextView) convertView.findViewById(R.id.textView3);
        TextView callView = (TextView) convertView.findViewById(R.id.textView4);

        ListVIewItem listVIewItem = listViewItemList.get(position);

        IconImageView.setImageDrawable(listVIewItem.getIcon());
        titleTextView.setText(listVIewItem.getTitle());
        descTextView.setText(listVIewItem.getDescStr());
        emailView.setText(listVIewItem.getEmail());
        callView.setText(listVIewItem.getLocation());

        return convertView;
    }

    public long getItemId(int position){
        return position;
    }
    public Object getItem(int position){
        return listViewItemList.get(position);
    }

    public void additem(Drawable icon,String title,String desc,String email,String scon){
        ListVIewItem item = new ListVIewItem();

        item.setIcon(icon);
        item.setTitleStr(title);
        item.setDescStr(desc);
        item.setEmail(email);
        item.setLocation(scon);
        listViewItemList.add(item);
    }

}
