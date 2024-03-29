// Generated by view binder compiler. Do not edit!
package com.example.managecasa.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.managecasa.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityForgotPasswordBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText conPass;

  @NonNull
  public final EditText newpassword;

  @NonNull
  public final Button submit;

  @NonNull
  public final EditText username;

  private ActivityForgotPasswordBinding(@NonNull LinearLayout rootView, @NonNull EditText conPass,
      @NonNull EditText newpassword, @NonNull Button submit, @NonNull EditText username) {
    this.rootView = rootView;
    this.conPass = conPass;
    this.newpassword = newpassword;
    this.submit = submit;
    this.username = username;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityForgotPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityForgotPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_forgot_password, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityForgotPasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.conPass;
      EditText conPass = ViewBindings.findChildViewById(rootView, id);
      if (conPass == null) {
        break missingId;
      }

      id = R.id.newpassword;
      EditText newpassword = ViewBindings.findChildViewById(rootView, id);
      if (newpassword == null) {
        break missingId;
      }

      id = R.id.submit;
      Button submit = ViewBindings.findChildViewById(rootView, id);
      if (submit == null) {
        break missingId;
      }

      id = R.id.username;
      EditText username = ViewBindings.findChildViewById(rootView, id);
      if (username == null) {
        break missingId;
      }

      return new ActivityForgotPasswordBinding((LinearLayout) rootView, conPass, newpassword,
          submit, username);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
