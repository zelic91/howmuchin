package com.thuongnh.howmuchin.util;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ResizeAnimation extends Animation {
	private View view;
	private float toHeight;
	private float fromHeight;
	private float toWidth;
	private float fromWidth;
	
	public ResizeAnimation(View v, float fromWidth, float fromHeight, float toWidth, float toHeight) {
		this.view 			= v;
		this.fromWidth		= fromWidth;
		this.fromHeight 	= fromHeight;
		this.toWidth		= toWidth;
		this.toHeight 		= toHeight;
	}
	
	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		float height 				= (toHeight-fromHeight)*interpolatedTime+fromHeight;
		float width 				= (toWidth-fromWidth)*interpolatedTime+fromWidth;
		LayoutParams layoutParams 	= view.getLayoutParams();
		layoutParams.width			= (int)width;
		layoutParams.height			= (int)height;
		view.requestLayout();
	}
}
