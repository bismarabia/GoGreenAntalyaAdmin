package bisma.rabia.gogreenantalyaadmin;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import java.security.Permission;
import java.security.Permissions;

import bisma.rabia.gogreenantalyaadmin.databinding.ActivityThingsToRecycleBinding;

public class ThingsToRecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThingsToRecycleBinding activityThingsToRecycleBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_things_to_recycle, null, false);
        setContentView(activityThingsToRecycleBinding.getRoot());

        activityThingsToRecycleBinding.lyoRecycleOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Checking if permission is not granted
                if (ContextCompat.checkSelfPermission(ThingsToRecycleActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(
                            ThingsToRecycleActivity.this,
                            new String[]{Manifest.permission.CAMERA},
                            8528);
                } else {
                    startActivity(new Intent(ThingsToRecycleActivity.this, ScanQrActivity.class).putExtra("point", "10"));
                }
            }
        });
        activityThingsToRecycleBinding.lyoRecycleOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Checking if permission is not granted
                if (ContextCompat.checkSelfPermission(ThingsToRecycleActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(
                            ThingsToRecycleActivity.this,
                            new String[]{Manifest.permission.CAMERA},
                            8528);
                } else {
                    startActivity(new Intent(ThingsToRecycleActivity.this, ScanQrActivity.class).putExtra("point", "5"));
                }
            }
        });
        activityThingsToRecycleBinding.lyoRecycleOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Checking if permission is not granted
                if (ContextCompat.checkSelfPermission(ThingsToRecycleActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(
                            ThingsToRecycleActivity.this,
                            new String[]{Manifest.permission.CAMERA},
                            8528);
                } else {
                    startActivity(new Intent(ThingsToRecycleActivity.this, ScanQrActivity.class).putExtra("point", "2"));
                }
            }
        });
        activityThingsToRecycleBinding.lyoRecycleOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Checking if permission is not granted
                if (ContextCompat.checkSelfPermission(ThingsToRecycleActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(
                            ThingsToRecycleActivity.this,
                            new String[]{Manifest.permission.CAMERA},
                            8528);
                } else {
                    startActivity(new Intent(ThingsToRecycleActivity.this, ScanQrActivity.class).putExtra("point", "1"));
                }
            }
        });

        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(ThingsToRecycleActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(
                    ThingsToRecycleActivity.this,
                    new String[]{Manifest.permission.CAMERA},
                    8528);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 8528) {

        }
    }
}
