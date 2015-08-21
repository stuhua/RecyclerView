package com.mt178.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private NormalRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//显示成listview
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
        String[] mTitles = this.getResources().getStringArray(R.array.titles);
        adapter = new NormalRecyclerViewAdapter(this, mTitles);
        adapter.setOnItemClick(new NormalRecyclerViewAdapter.NomalTextViewHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, int positon) {
                Toast.makeText(MainActivity.this, "您选中了--->" + positon, Toast.LENGTH_SHORT).show();
            }
        });


        mRecyclerView.setAdapter(adapter);
    }

    public <T extends View> T getViewById(int viewId) {
        return (T) findViewById(viewId);
    }
}
