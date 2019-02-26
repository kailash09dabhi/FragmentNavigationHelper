package com.kailashdabhi.fragmentnavigationhelper;//@IntDef({ SLIDE, SLIDE_ON_TOP })

import androidx.annotation.IntDef;

import static com.kailashdabhi.fragmentnavigationhelper.Type.ADD;
import static com.kailashdabhi.fragmentnavigationhelper.Type.REPLACE;

@IntDef({ ADD, REPLACE })
public @interface Type {
  int ADD = 1;
  int REPLACE = 2;
}
