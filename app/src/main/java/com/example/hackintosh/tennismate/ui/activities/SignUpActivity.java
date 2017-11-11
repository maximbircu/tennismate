package com.example.hackintosh.tennismate.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.hackintosh.tennismate.R;
import com.example.hackintosh.tennismate.dto.DataKeys;
import com.example.hackintosh.tennismate.dto.LevelEnum;
import com.example.hackintosh.tennismate.dto.User;
import com.example.hackintosh.tennismate.ui.navigation.Navigator;
import com.example.hackintosh.tennismate.ui.presenters.SignUpPresenter;
import com.example.hackintosh.tennismate.ui.view.SingnUpView;
import com.google.firebase.auth.FirebaseAuth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by maxim on 11/11/17.
 */
public class SignUpActivity extends BaseActivity<SingnUpView, SignUpPresenter> implements SingnUpView {
    private List<String> levels = new ArrayList<>(Arrays.asList(LevelEnum.BEGINNER.getLevel(), LevelEnum.INTERMEDIATE.getLevel(), LevelEnum.ADVANCED.getLevel()));

    @BindView(R.id.level_spinner)
    public Spinner levelSpinner;

    @BindView(R.id.age_editText)
    public EditText ageEditText;

    @BindView(R.id.full_name_editText)
    public EditText fullNameEditText;

    @BindView(R.id.signup_button)
    public Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setPresenter();
        ButterKnife.bind(this);
        populateView();
    }

    public void setPresenter() {
        super.setPresenter(new SignUpPresenter(new Navigator(this)));
        presenter.bind(this);
    }

    private void populateView() {
        fullNameEditText.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, levels);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(dataAdapter);
    }

    private User populateUser() {
        User user = new User();
        user.setFullName(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        user.setEmail(FirebaseAuth.getInstance().getCurrentUser().getEmail());
        user.setAge(Short.parseShort(ageEditText.getText().toString()));
        user.setImageUrl(FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString());
        user.setLevel(LevelEnum.ADVANCED);
        return user;
    }

    @OnClick(R.id.signup_button)
    public void registerUser() {
        this.presenter.registerUser(populateUser());
    }

    @Override
    public void onPostSuccess() {
        super.presenter.navigator.openCourtInfoActivity();
    }
}
