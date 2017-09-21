package com.example.jashaswee.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TestAdapter adapter;
    LinearLayoutManager layoutManager;
    ArrayList<String> xyz = (ArrayList<String>) Arrays.asList("123", "456");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new TestAdapter(xyz);
        recyclerView.setAdapter(adapter);


    }

    /**
     * Created by Jashaswee on 9/6/2017.
     */

    public static class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

        ArrayList<String> numbers;

        TestAdapter(ArrayList<String> num) {
            numbers = num;
        }

        @Override
        public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View itemview;
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            itemview = inflater.inflate(R.layout.textview, parent, false);
            TestViewHolder viewHolder = new TestViewHolder(itemview);
            return new TestViewHolder(itemview);
        }


        @Override
        public void onBindViewHolder(TestViewHolder holder, int position) {
            String a = numbers.get(position);
            holder.textView.setText(a);
        }


        @Override
        public int getItemCount() {
            return numbers.size();
        }

        public ArrayList<Integer> getArrayList() {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for (int i = 1; i <= 100; i++) {
                arrayList.add(i);
            }
            return arrayList;
        }

        public class TestViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;

            public TestViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.recyclerview_textview);
            }
        }
    }
}
