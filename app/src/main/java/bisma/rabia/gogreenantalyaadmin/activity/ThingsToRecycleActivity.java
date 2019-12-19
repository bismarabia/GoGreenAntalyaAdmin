package bisma.rabia.gogreenantalyaadmin.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import bisma.rabia.gogreenantalyaadmin.R;
import bisma.rabia.gogreenantalyaadmin.databinding.ActivityThingsToRecycleBinding;
import bisma.rabia.gogreenantalyaadmin.utils.TransactionTask;

public class ThingsToRecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThingsToRecycleBinding activityThingsToRecycleBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_things_to_recycle, null, false);
        setContentView(activityThingsToRecycleBinding.getRoot());

        activityThingsToRecycleBinding.lyoRecycleOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQrScanActivity("10");
            }
        });
        activityThingsToRecycleBinding.lyoRecycleOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQrScanActivity("5");
            }
        });
        activityThingsToRecycleBinding.lyoRecycleOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQrScanActivity("2");
            }
        });
        activityThingsToRecycleBinding.lyoRecycleOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQrScanActivity("1");
            }
        });

        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(ThingsToRecycleActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(ThingsToRecycleActivity.this, new String[]{Manifest.permission.CAMERA}, 8528);
        }
    }

    private void startQrScanActivity(String point) {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(ThingsToRecycleActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(ThingsToRecycleActivity.this, new String[]{Manifest.permission.CAMERA}, 8528);
        } else {
            startActivityForResult(new Intent(ThingsToRecycleActivity.this, ScanQrActivity.class).putExtra("point", point), 9874);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 9874) {
            Bundle extras = data.getExtras();
            Log.d("TAG", "onActivityResult: point " + extras.getString("point"));
            Log.d("TAG", "onActivityResult: username " + extras.getString("username"));

            sendPointsToUser(extras.getString("point"), extras.getString("username"));
        }
    }

    private void sendPointsToUser(final String point, final String username) {
        String nodeUrl = this.getString(R.string.node_url);
        String privateKey = this.getString(R.string.from_account_private_key);
        String fromAccount = this.getString(R.string.from_account);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Processing...Please stand by!");
        progressDialog.show();

        String formattedPoint = point + ".0000 EOS";

        new TransactionTask(new TransactionTask.TransactionTaskCallback() {
            @Override
            public void update(String updateContent) {
            }

            @Override
            public void finish(boolean success, String updateContent) {
                progressDialog.dismiss();
                if (success) {
                    new AlertDialog.Builder(ThingsToRecycleActivity.this)
                            .setTitle("Congrats")
                            .setMessage("Dear " + username + ", \nYou have received " + point + " points, thank you for recycling!!")
                            .setPositiveButton("Ok", null)
                            .show();
                } else {
                    new AlertDialog.Builder(ThingsToRecycleActivity.this)
                            .setTitle("Oops")
                            .setMessage("Transaction not completed! can you try again.")
                            .setPositiveButton("Ok", null)
                            .show();
                }
            }
        }).execute(nodeUrl, fromAccount, username, privateKey, formattedPoint, point + " points sent");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 8528) {

        }
    }
}
