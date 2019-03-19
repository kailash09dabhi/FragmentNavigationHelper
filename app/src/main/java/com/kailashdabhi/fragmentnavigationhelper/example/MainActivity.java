package com.kailashdabhi.fragmentnavigationhelper.example;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.kailashdabhi.fragmentnavigationhelper.FragmentXt;

/**
 * @author Kailash Dabhi
 * @email kailash09dabhi@gmail.com
 * @date 13/02/2019
 */
public final class MainActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity);
    int delay = 1000;
    Handler handler = new Handler();
    for (int i = 1; i <= 10; i++) {
      handler.postDelayed(
          () -> FragmentXt.navigate(new DummyFragment(), getSupportFragmentManager()), i * delay);
    }
    handler.postDelayed(() -> {
      int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
      for (int i = 0; i < backStackEntryCount; i++) {
        Log.e("fragment", getSupportFragmentManager().getBackStackEntryAt(i).getName());
      }
    }, 12000);
  }
}
