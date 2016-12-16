/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.apis.view;

// Need the following import to get access to the app resources, since this
// class is in a sub-package.
import com.example.android.apis.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.zip.Inflater;


public class Animation2 extends Activity implements
        AdapterView.OnItemSelectedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_2);

        mFlipper = ((ViewFlipper) this.findViewById(R.id.flipper));
        mFlipper.startFlipping();

        initViewFlipper2();

        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mStrings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(this);
    }

    private void initViewFlipper2() {
        mFlipper2 = (ViewFlipper) this.findViewById(R.id.flipper2);
        String[] titles = {"可以传输MP3、视频、文档等文件",
                "可让传输DCIM和Pictures文件夹下的照片", "可以与手机共享移动数据上网", "通过USB为手机充电"};
        for(int i=0;i<titles.length;i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.animation_2_item, null);
            ((TextView)view.findViewById(R.id.title)).setText(titles[i]);
            mFlipper2.addView(view);
        }
        mFlipper2.setInAnimation(AnimationUtils.loadAnimation(this,
                R.anim.push_up_in));
        mFlipper2.setOutAnimation(AnimationUtils.loadAnimation(this,
                R.anim.push_up_out));
        mFlipper2.startFlipping();
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        switch (position) {

        case 0:
            mFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.push_up_in));
            mFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.push_up_out));
            break;
        case 1:
            mFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.push_left_in));
            mFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.push_left_out));
            break;
        case 2:
            mFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                    android.R.anim.fade_in));
            mFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                    android.R.anim.fade_out));
            break;
        default:
            mFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.hyperspace_in));
            mFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.hyperspace_out));
            break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    private String[] mStrings = {
            "Push up", "Push left", "Cross fade", "Hyperspace"};

    private ViewFlipper mFlipper;
    private ViewFlipper mFlipper2;

}
