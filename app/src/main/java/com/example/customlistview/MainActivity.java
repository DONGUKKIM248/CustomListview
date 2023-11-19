package com.example.customlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String strTitle[] = {"한국","미국","일본","중국","영국"};
    String strDescription[] = {"한국의 수도는 서울","미국의 수도는 워싱턴","일본의 수도는 도쿄","중국의 수도는 베이징","영국의 수도는 런던"};
    int image[] = {R.drawable.korea, R.drawable.usa, R.drawable.japan,R.drawable.china,R.drawable.england};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this,strTitle, strDescription,image);
        listView.setAdapter(adapter);

        //리스트뷰 아이템 클릭시
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, Integer.toString(position),Toast.LENGTH_LONG).show();

                if(position == 0 ){
                    Toast.makeText(MainActivity.this, "한국의 수도는 서울",Toast.LENGTH_LONG).show();
                }
                else if(position == 1 ){
                    Toast.makeText(MainActivity.this, "미국의 수도는 워싱턴",Toast.LENGTH_LONG).show();
                }
                else if(position == 2 ){
                    Toast.makeText(MainActivity.this, "일본의 수도는 도쿄",Toast.LENGTH_LONG).show();
                }
                else if(position == 3 ){
                    Toast.makeText(MainActivity.this, "중국의 수도는 베이징",Toast.LENGTH_LONG).show();
                }
                else if(position == 4 ){
                    Toast.makeText(MainActivity.this, "영국의 수도는 런던",Toast.LENGTH_LONG).show();
                }


            }
        });


    }

    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String rTitle[];
        String rDescriptionp[];
        int rImgs[];

        MyAdapter(Context con, String sTitle[], String sDescription[], int imgs[]){
            super(con, R.layout.row, R.id.textview1, sTitle);
            this.context = con;
            this.rTitle = sTitle;
            this.rDescriptionp = sDescription;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.imageView);
            TextView myTitle = row.findViewById(R.id.textview1);
            TextView myDescription = row.findViewById(R.id.textview2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescriptionp[position]);


            return row;
        }
    }
}