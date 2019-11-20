package com.example.recyclerviewexample;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class EmptyActivity extends AppCompatActivity {
  String TAG = EmptyActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    Log.e(TAG, "onCreate: Secound Activity");
      Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
      PackageManager manager = getBaseContext().getPackageManager();
      List<ResolveInfo> infos = manager.queryIntentActivities(intent, 0);
      Log.e(TAG, ""+infos.size());
      if (infos.size() > 0) {
        //Then there is an Application(s) can handle your intent
      } else {
        //No Application can handle your intent
      }
    }
}
