package bisma.rabia.gogreenantalyaadmin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import bisma.rabia.gogreenantalyaadmin.R;
import bisma.rabia.gogreenantalyaadmin.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding activityMainBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_main, null, false);
        setContentView(activityMainBinding.getRoot());

        activityMainBinding.imvTapToRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ThingsToRecycleActivity.class));
            }
        });
        activityMainBinding.txvTapToRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityMainBinding.imvTapToRecycle.callOnClick();
            }
        });
    }
}
