package com.wangshiqi.bestgift.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.wangshiqi.bestgift.R;
import com.wangshiqi.bestgift.ui.fragment.gift.GiftFragment;
import com.wangshiqi.bestgift.ui.fragment.category.CategoryFragment;
import com.wangshiqi.bestgift.ui.fragment.homepage.HomepageFragment;
import com.wangshiqi.bestgift.ui.fragment.profile.ProfileFragment;

public class MainActivity extends AbsBaseActivity {

    private RadioGroup radioGroup;
    private HomepageFragment fragmentHomepage;
    private GiftFragment fragmentGift;
    private CategoryFragment fragmentCategory;
    private ProfileFragment fragmentProfile;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        radioGroup = byView(R.id.main_radio_group);

    }

    @Override
    protected void initDatas() {

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId) {
                    case R.id.homepage_rb:
                        transaction.replace(R.id.replace_view, fragmentHomepage.newInstance());
                        break;
                    case R.id.gift_rb:
                        transaction.replace(R.id.replace_view, fragmentGift.newInstance());
                        break;
                    case R.id.category_rb:
                        transaction.replace(R.id.replace_view, fragmentCategory.newInstance());
                        break;
                    case R.id.profile_rb:
                        transaction.replace(R.id.replace_view, fragmentProfile.newInstance());
                        break;
                }
                transaction.commit();
            }
        });
        radioGroup.check(R.id.homepage_rb);
    }
}