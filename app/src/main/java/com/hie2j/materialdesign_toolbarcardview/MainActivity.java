package com.hie2j.materialdesign_toolbarcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mMyTb;
    private CardView mCardView;
    private ImageView mImageView;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMyTb = findViewById(R.id.my_tb);

        setSupportActionBar(mMyTb);//不加这句无菜单!!!

        mCardView = findViewById(R.id.id_cv);
        mImageView = findViewById(R.id.id_img);

        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runAnima();
            }
        });
    }

    //菜单栏点击
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tab_add:
                ToastUtil.showAtOnce(MainActivity.this, "tab_add");
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_about:
                ToastUtil.showAtOnce(MainActivity.this, "about");
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_before:
                ToastUtil.showAtOnce(MainActivity.this, "defore");
                Toast.makeText(this, "Defore", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void runAnima() {
        mCardView.animate().translationX(100 + count).setDuration(1000).start();
        count += 10;
    }
}
