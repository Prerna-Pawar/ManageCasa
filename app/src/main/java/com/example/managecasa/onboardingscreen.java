package com.example.managecasa;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class onboardingscreen extends AppCompatActivity {

    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutonboardingindicators;
    MaterialButton btnonboardingAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboardingscreen);
        Intent intent = getIntent();

        String nameUser = intent.getStringExtra("name");
        String contact=intent.getStringExtra("contactno");
        String flat=intent.getStringExtra("flatno");
        String emailUser = intent.getStringExtra("email");
        String usernameUser = intent.getStringExtra("username");
        String passwordUser = intent.getStringExtra("password");



        layoutonboardingindicators=findViewById(R.id.layoutOnboardingIndicators);
        btnonboardingAction=findViewById(R.id.buttonOnboardingAction);
        setupOnboardingItems();
        ViewPager2 onboardingViewPager=findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);
        setUpOnboardingIndicators();
        setCurrentOnboardingIndicator(0);
        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });
        btnonboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onboardingViewPager.getCurrentItem()+1 < onboardingAdapter.getItemCount())
                {
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem()+1);
                }
                else
                {
                    Intent intent1=new Intent(getApplicationContext(),AdminNavigation.class);
                    intent1.putExtra("name", nameUser);
                    intent1.putExtra("email", emailUser);
                    intent1.putExtra("username", usernameUser);
                    intent1.putExtra("password", passwordUser);
                    intent1.putExtra("contactno", contact);
                    intent1.putExtra("flatno", flat);
                    startActivity(intent1);

                }
            }
        });
    }
    private void setupOnboardingItems()
    {
        List<OnboardingItem> onboardingItems=new ArrayList<>();
        OnboardingItem itemPayOnline=new OnboardingItem();
        itemPayOnline.setImage(R.drawable.managecasaonboarding);

        OnboardingItem itemOntheWay =new OnboardingItem();
        itemOntheWay.setImage(R.drawable.meeting);

        OnboardingItem itemEatTogether=new OnboardingItem();
        itemEatTogether.setImage(R.drawable.requestscomplaints);

        OnboardingItem itemTogether=new OnboardingItem();
        itemTogether.setImage(R.drawable.noticeonboarding);

        OnboardingItem itempoll=new OnboardingItem();
        itempoll.setImage(R.drawable.conductpolls);

        onboardingItems.add(itemPayOnline);
        onboardingItems.add(itemOntheWay);
        onboardingItems.add(itemEatTogether);
        onboardingItems.add(itemTogether);
        onboardingItems.add(itempoll);

        onboardingAdapter=new OnboardingAdapter(onboardingItems);
    }
    private void setUpOnboardingIndicators(){
        ImageView[] indicators=new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);
        for(int i=0;i<indicators.length;i++)
        {
            indicators[i]=new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutonboardingindicators.addView(indicators[i]);
        }

    }
    private void setCurrentOnboardingIndicator(int index)
    {
        int childcount=layoutonboardingindicators.getChildCount();
        for(int i=0;i<childcount;i++)
        {
            ImageView imageView=(ImageView)layoutonboardingindicators.getChildAt(i);
            if(i==index)
            {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_active));
            }
            else
            {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_inactive));
            }
        }
        if(index==onboardingAdapter.getItemCount()-1)
        {
            btnonboardingAction.setText("Get Started");
        }
        else {
            btnonboardingAction.setText("Next");
        }
    }
}