package com.thuongnh.howmuchin.util;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ResizeAnimation extends Animation {
	private View view;
	private float toHeight;
	private float fromHeight;
	private float toWidth;
	private float fromWidth;
	
	public ResizeAnimation(View v, float fromWidth, float fromHeight, float toWidth, float toHeight) {
		
	}
	
	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		
	}

}
