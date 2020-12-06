package com.example.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
TextView textViewLanguage1,textViewLanguage2,textViewReverse;
SearchView searchView;
Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewLanguage1 = findViewById(R.id.text_view_language_1);
        textViewLanguage2 = findViewById(R.id.text_view_language_2);
        textViewReverse = findViewById(R.id.text_view_reverse);

        textViewReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((textViewLanguage1.getText()).equals("English")) {
                    textViewLanguage1.setText("Arabic");
                    textViewLanguage2.setText("English");
                }//end if
              else{
                textViewLanguage1.setText("English");
                textViewLanguage2.setText("Arabic" );
              }//end else
            }//end onClick

        });//end setOnClickListener

        ArrayList<list_Item> Items = new ArrayList<list_Item>();
        Items.add(new list_Item("Chicken","دجاجة"));
        Items.add(new list_Item("Sheep ","خروف"));
        Items.add(new list_Item("Rabbit","أرنب"));
        Items.add(new list_Item("Monkey","قرد"));
        Items.add(new list_Item("Giraffe","زرافة"));
        Items.add(new list_Item("Bear","دب"));
        Items.add(new list_Item("Elephant","فيل"));
        Items.add(new list_Item("Cow","بقرة"));
        Items.add(new list_Item("Horse","حصان"));

        myAdapter myAdapter = new myAdapter(Items);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(myAdapter);


    }//end onCreate

  class myAdapter extends BaseAdapter{
        ArrayList<list_Item> Items = new ArrayList<list_Item>();

   myAdapter( ArrayList<list_Item> Items ){
            this.Items=Items;
        }

        @Override
        public int getCount() {
            return Items.size();
        }//end getCount

        @Override
        public String getItem(int position) {
            return Items.get(position).nameEng;
        }//end getItem


        @Override
        public long getItemId(int position) {
            return position;
        }//end getItemId

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater lInflater = getLayoutInflater();
            View view1 = lInflater.inflate(R.layout.row_view,null);

            TextView textName = view1.findViewById(R.id.name_eng);
            textName.setText(Items.get(i).nameEng);

            TextView textJob = view1.findViewById(R.id.name_ar);
            textJob.setText(Items.get(i).nameAr);

            return view1;
        }//end getView
    }//end myAdapter

}//end Class