package com.wolf.first.ui;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.wolf.first.R;
import com.wolf.first.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @Bind(R.id.name_edit)
    EditText nameEdit;
    @Bind(R.id.name_input)
    TextInputLayout nameInput;
    @Bind(R.id.pwd_edit)
    EditText pwdEdit;
    @Bind(R.id.pwd_input)
    TextInputLayout pwdInput;
    @Bind(R.id.login_text)
    TextView loginText;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @OnClick(R.id.login_text)
    public void onViewClicked() {
        if (TextUtils.isEmpty(nameEdit.getText().toString())) {
            nameInput.setError("请输入用户名");
            return;
        } else {
            nameInput.setError("");
        }
        if (TextUtils.isEmpty(pwdEdit.getText().toString())) {
            pwdInput.setError("请输入密码");
            return;
        } else {
            pwdInput.setError("");
        }
//        MenuActivity.startTest(LoginActivity.this);
    }
}
