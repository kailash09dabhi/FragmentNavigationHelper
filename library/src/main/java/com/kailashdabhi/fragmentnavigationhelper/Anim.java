package com.kailashdabhi.fragmentnavigationhelper;

import androidx.annotation.IntDef;

import static com.kailashdabhi.fragmentnavigationhelper.Anim.NONE;
import static com.kailashdabhi.fragmentnavigationhelper.Anim.SLIDE_HORIZONTAL;
import static com.kailashdabhi.fragmentnavigationhelper.Anim.SLIDE_OVER_VERTICAL;

@IntDef({ NONE, SLIDE_HORIZONTAL, SLIDE_OVER_VERTICAL })
public @interface Anim {
  int NONE = 0;
  int SLIDE_HORIZONTAL = 1;
  int SLIDE_OVER_VERTICAL = 2;
}