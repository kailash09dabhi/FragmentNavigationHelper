package com.kailashdabhi.fragmentnavigationhelper.example;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.kailashdabhi.fragmentnavigationhelper.FragmentXt;

public class DummyFragment extends Fragment {
  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    FrameLayout frameLayout = new FrameLayout(getContext());
    frameLayout.setBackgroundColor(
        Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255),
            (int) (Math.random() * 255)));
    frameLayout.setOnClickListener(
        v -> FragmentXt.navigate(new DummyFragment(), getFragmentManager()));
    return frameLayout;
  }
}