package com.zhaoss.bottomslideline;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 自定义linearlayout
 * @author Administrator
 *
 */
public class MyLinearLayout extends LinearLayout {

	private float x = 0;
	private OnTouchListener touch;
	private boolean is_left;
	/** 滑动距离大于此数字才判断为滑动状态 */
	private int slideDistance = 80;
	
	public MyLinearLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyLinearLayout(Context context) {
		super(context);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		if(touch != null){
			touch.onTouch(is_left);
		}
		return true;
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			x = ev.getX();
			break;
		case MotionEvent.ACTION_MOVE:
			//判断当前是点击事件还是滑动事件
			float moveX = ev.getX();
			if(Math.abs(moveX-x) > slideDistance){
				//判断当前是向左滑动,还是向右
				if(moveX-x > 0){
					is_left = false;
				}else{
					is_left = true;
				}
				return true;
			}
			break;
		case MotionEvent.ACTION_UP:
			break;
		}
		return false;
	}
	
	public void setOnTouchListener(OnTouchListener touch){
		this.touch = touch;
	}
	
	public interface OnTouchListener{
		void onTouch(boolean is_left);
	}
}