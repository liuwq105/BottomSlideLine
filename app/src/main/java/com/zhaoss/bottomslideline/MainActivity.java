package com.zhaoss.bottomslideline;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView iv_mode1;
    private ImageView iv_mode2;
    private ImageView iv_mode3;
    private ImageView iv_mode4;
    private ImageView iv_mode5;
    private ImageView iv_mode6;
    private ImageView iv_mode7;
    private TextView tv_mode1;
    private TextView tv_mode2;
    private TextView tv_mode3;
    private TextView tv_mode4;
    private TextView tv_mode5;
    private TextView tv_mode6;
    private TextView tv_mode7;
    private LinearLayout ll_mode1;
    private LinearLayout ll_mode2;
    private LinearLayout ll_mode3;
    private LinearLayout ll_mode4;
    private LinearLayout ll_mode5;
    private LinearLayout ll_mode6;
    private LinearLayout ll_mode7;
    private TextView currentTextVuew;
    private ImageView currentImageView;
    private LinearLayout currentLinearLayout;
    /** 当前屏幕的宽度 */
    private int width;
    private MyLinearLayout ll_all;
    private List<LinearLayout> llList;
    private List<TextView> tvList;
    private List<ImageView> ivList;
    /** 记录当前显示位置坐标 */
    private int currentPosttion;
    /** 记录当前是否在执行动画中 */
    private boolean animaing;
    /** 滑动动画执行时间 */
    long animaTime = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initList();
        initData();
    }

    /**
     * 将滚动条所有的控件都添加到集合中
     */
    private void initList() {

        llList = new ArrayList();
        tvList = new ArrayList();
        ivList = new ArrayList();

        llList.add(ll_mode1);
        llList.add(ll_mode2);
        llList.add(ll_mode3);
        llList.add(ll_mode4);
        llList.add(ll_mode5);
        llList.add(ll_mode6);
        llList.add(ll_mode7);

        tvList.add(tv_mode1);
        tvList.add(tv_mode2);
        tvList.add(tv_mode3);
        tvList.add(tv_mode4);
        tvList.add(tv_mode5);
        tvList.add(tv_mode6);
        tvList.add(tv_mode7);

        ivList.add(iv_mode1);
        ivList.add(iv_mode2);
        ivList.add(iv_mode3);
        ivList.add(iv_mode4);
        ivList.add(iv_mode5);
        ivList.add(iv_mode6);
        ivList.add(iv_mode7);
    }

    private void initData() {

        //初始化第一次显示的位置
        currentTextVuew = tv_mode4;
        currentImageView = iv_mode4;
        currentLinearLayout = ll_mode4;
        currentPosttion = 3;
        changeView(ll_mode4, tv_mode4, iv_mode4);
        iv_mode4.setImageResource(R.mipmap.chuxing);

        //得到屏幕的宽度
        WindowManager wm = getWindowManager();
        width = wm.getDefaultDisplay().getWidth();

        ll_all.setOnTouchListener(new MyLinearLayout.OnTouchListener() {
            @Override
            public void onTouch(boolean is_left) {

                if(!animaing){//如果没有滑动动画在执行中
                    if(is_left){
                        if(currentPosttion < 6){//角标最大判断
                            animaing = true;
                            currentPosttion++;
                            changeView(llList.get(currentPosttion),
                                    tvList.get(currentPosttion), ivList.get(currentPosttion));
                            changeImage(currentPosttion);
                        }
                    }else{
                        if(currentPosttion > 0){//角标最小判断
                            animaing = true;
                            currentPosttion--;
                            changeView(llList.get(currentPosttion),
                                    tvList.get(currentPosttion), ivList.get(currentPosttion));
                            changeImage(currentPosttion);
                        }
                    }
                }
            }
        });
    }

    public void changeImage(int position){

        switch (position) {
            case 0:
                iv_mode1.setImageResource(R.mipmap.fenxiang);
                break;
            case 1:
                iv_mode2.setImageResource(R.mipmap.zhuisui);
                break;
            case 2:
                iv_mode3.setImageResource(R.mipmap.anquan);
                break;
            case 3:
                iv_mode4.setImageResource(R.mipmap.putong);
                break;
            case 4:
                iv_mode5.setImageResource(R.mipmap.chuxing);
                break;
            case 5:
                iv_mode6.setImageResource(R.mipmap.zhaoji);
                break;
            case 6:
                iv_mode7.setImageResource(R.mipmap.guyong);
                break;
        }
    }

    private void initUI() {

        iv_mode1 = (ImageView) findViewById(R.id.iv_mode1);
        iv_mode2 = (ImageView) findViewById(R.id.iv_mode2);
        iv_mode3 = (ImageView) findViewById(R.id.iv_mode3);
        iv_mode4 = (ImageView) findViewById(R.id.iv_mode4);
        iv_mode5 = (ImageView) findViewById(R.id.iv_mode5);
        iv_mode6 = (ImageView) findViewById(R.id.iv_mode6);
        iv_mode7 = (ImageView) findViewById(R.id.iv_mode7);

        tv_mode1 = (TextView) findViewById(R.id.tv_mode1);
        tv_mode2 = (TextView) findViewById(R.id.tv_mode2);
        tv_mode3 = (TextView) findViewById(R.id.tv_mode3);
        tv_mode4 = (TextView) findViewById(R.id.tv_mode4);
        tv_mode5 = (TextView) findViewById(R.id.tv_mode5);
        tv_mode6 = (TextView) findViewById(R.id.tv_mode6);
        tv_mode7 = (TextView) findViewById(R.id.tv_mode7);

        ll_mode1 = (LinearLayout) findViewById(R.id.ll_mode1);
        ll_mode2 = (LinearLayout) findViewById(R.id.ll_mode2);
        ll_mode3 = (LinearLayout) findViewById(R.id.ll_mode3);
        ll_mode4 = (LinearLayout) findViewById(R.id.ll_mode4);
        ll_mode5 = (LinearLayout) findViewById(R.id.ll_mode5);
        ll_mode6 = (LinearLayout) findViewById(R.id.ll_mode6);
        ll_mode7 = (LinearLayout) findViewById(R.id.ll_mode7);
        ll_all = (MyLinearLayout) findViewById(R.id.ll_all);

        ll_mode1.setOnClickListener(this);
        ll_mode2.setOnClickListener(this);
        ll_mode3.setOnClickListener(this);
        ll_mode4.setOnClickListener(this);
        ll_mode5.setOnClickListener(this);
        ll_mode6.setOnClickListener(this);
        ll_mode7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ll_mode1:
                if(currentLinearLayout != ll_mode1){
                    currentPosttion = 0;
                    changeView(ll_mode1, tv_mode1, iv_mode1);
                    changeImage(0);
                }
                break;
            case R.id.ll_mode2:
                if(currentLinearLayout != ll_mode2){
                    currentPosttion = 1;
                    changeView(ll_mode2, tv_mode2, iv_mode2);
                    changeImage(1);
                }
                break;
            case R.id.ll_mode3:
                if(currentLinearLayout != ll_mode3){
                    currentPosttion = 2;
                    changeView(ll_mode3, tv_mode3, iv_mode3);
                    changeImage(2);
                }
                break;
            case R.id.ll_mode4:
                if(currentLinearLayout != ll_mode4){
                    currentPosttion = 3;
                    changeView(ll_mode4, tv_mode4, iv_mode4);
                    changeImage(3);
                }
                break;
            case R.id.ll_mode5:
                if(currentLinearLayout != ll_mode5){
                    currentPosttion = 4;
                    changeView(ll_mode5, tv_mode5, iv_mode5);
                    changeImage(4);
                }
                break;
            case R.id.ll_mode6:
                if(currentLinearLayout != ll_mode6){
                    currentPosttion = 5;
                    changeView(ll_mode6, tv_mode6, iv_mode6);
                    changeImage(5);
                }
                break;
            case R.id.ll_mode7:
                if(currentLinearLayout != ll_mode7){
                    currentPosttion = 6;
                    changeView(ll_mode7, tv_mode7, iv_mode7);
                    changeImage(6);
                }
                break;
        }
    }

    /**
     * 跳转到指定的角标位
     * @param ll_mode
     * @param tv_mode
     * @param iv_mode
     */
    private void changeView(LinearLayout ll_mode, TextView tv_mode, ImageView iv_mode) {

        currentTextVuew.setTextSize(14);
        currentTextVuew.setTextColor(Color.GRAY);
        currentImageView.setImageResource(R.mipmap.dian);

        currentImageView = iv_mode;
        currentTextVuew = tv_mode;
        currentLinearLayout = ll_mode;
        currentTextVuew.setTextSize(16);
        currentTextVuew.setTextColor(Color.BLACK);
        //执行滑动动画,原滴滴打车好像没有滑动动画,他是直接跳过去了
        startAnima(ll_mode);
    }

    /**
     * 滑动动画实际逻辑
     * @param ll_mode
     */
    private void startAnima(LinearLayout ll_mode) {

        int left = ll_mode.getLeft();
        int w = ll_mode.getWidth();
        //计算每次滑动的距离
        float moveX = width/2-left-(w/2);
        ObjectAnimator oa = ObjectAnimator.ofFloat(ll_all, "translationX", ll_all.getX(), moveX).setDuration(animaTime);
        oa.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }
            @Override
            public void onAnimationRepeat(Animator animation) {

            }
            @Override
            public void onAnimationEnd(Animator animation) {
                animaing = false;
            }
            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });
        oa.start();
    }
}
