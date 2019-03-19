package com.kailashdabhi.fragmentnavigationhelper;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * @author Kailash Dabhi
 * @date 30/07/2018
 */
public final class FragmentXt {
  private FragmentXt() {
  }

  public static boolean hasBackStackEntry(Fragment fragment) {
    FragmentManager manager = fragment.getFragmentManager();
    int backStackCount = manager != null ? manager.getBackStackEntryCount() : 0;
    for (int i = 0; i < backStackCount; i++) {
      if (manager.getBackStackEntryAt(i).getName().equals(fragment.getClass().getName())) {
        return true;
      }
    }
    return false;
  }

  static int backStackEntryCountOf(String fragment, FragmentManager manager) {
    int backStackCount = manager.getBackStackEntryCount();
    int count = 0;
    for (int i = 0; i < backStackCount; i++) {
      if (manager.getBackStackEntryAt(i).getName().contains(fragment)) {
        count++;
      }
    }
    return count;
  }

  public static void navigate(Fragment fragment, FragmentManager manager,
      Block<FragmentTx.Builder> block) {
    FragmentTx.Builder builder = new FragmentTx.Builder(manager, fragment)
        .animation(Anim.SLIDE_HORIZONTAL)
        .type(Type.REPLACE)
        .addToBackStack();
    block.take(builder);
    builder.build().execute();
  }

  public static void navigate(Fragment fragment, FragmentManager manager) {
    navigate(fragment, manager, b -> {
    });
  }
}
