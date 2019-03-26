package com.kailashdabhi.fragmentnavigationhelper;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * @author Kailash Dabhi
 * @date 17/05/2018
 */

public final class FragmentTx {
  private final FragmentManager manager;
  private final Fragment fragment;
  private final boolean addToBackStack;
  private final @Anim int animation;
  private final @Type int type;

  private FragmentTx(Builder builder) {
    this.manager = builder.manager;
    this.fragment = builder.fragment;
    this.addToBackStack = builder.addToBackStack;
    this.animation = builder.animation;
    this.type = builder.type;
  }

  void execute() {
    FragmentTransaction transaction = manager.beginTransaction();
    int count = FragmentXt.backStackEntryCountOf(fragment.getClass().getName(), manager);
    String tag =
        count == 0 ? fragment.getClass().getName() : fragment.getClass().getName() + ++count;
    addToBackStack(transaction, tag);
    setAnimation(transaction);
    setTransaction(transaction, tag);
    transaction.commit();
  }

  private void addToBackStack(FragmentTransaction transaction, String tag) {
    if (addToBackStack) {
      transaction.addToBackStack(tag);
    }
  }

  private void setTransaction(FragmentTransaction transaction, String tag) {
    if (type == Type.REPLACE) {
      transaction.replace(R.id.fragment_container, fragment, tag);
    } else if (type == Type.ADD) {
      transaction.add(R.id.fragment_container, fragment, tag);
    }
  }

  private void setAnimation(FragmentTransaction transaction) {
    if (animation == Anim.SLIDE_HORIZONTAL) {
      transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_right,
          R.anim.slide_in_left, R.anim.slide_out_left);
    } else if (animation == Anim.SLIDE_OVER_VERTICAL) {
      transaction.setCustomAnimations(R.anim.slide_in_up,
          R.anim.still, 0, R.anim.slide_out_up);
    }
  }

  public static class Builder {
    private final FragmentManager manager;
    private final Fragment fragment;
    private boolean addToBackStack = false;
    private @Anim int animation = Anim.NONE;
    private @Type int type = Type.REPLACE;

    public Builder(FragmentManager manager, Fragment fragment) {
      this.manager = manager;
      this.fragment = fragment;
    }

    public Builder addToBackStack() {
      this.addToBackStack = true;
      return this;
    }

    public Builder animation(@Anim int anim) {
      this.animation = anim;
      return this;
    }

    public Builder type(@Type int type) {
      this.type = type;
      return this;
    }

    public FragmentTx build() {
      return new FragmentTx(this);
    }
  }
}
