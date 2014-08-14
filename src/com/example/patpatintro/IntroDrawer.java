package com.example.patpatintro;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class IntroDrawer extends View {
	private Bitmap mViewBitmap;
	private Bitmap mBitmap;
	
	private Paint mPaint;
	
	private int[] mColors;
	private int mWidth = 0;
	private int mHeight = 0;
	private int mST = 0;

	public IntroDrawer(Context context, Bitmap bmp) {
		
		super(context);
		setFocusable(true);
		
		mBitmap = bmp;
		mColors = createColors();
		Log.v("TAG", "B");
		int[] colors = mColors;
		Log.v("TAG", "C");
		
		
		Log.v("TAG", "D");
		mViewBitmap = Bitmap.createBitmap(colors, 0, mST, mWidth, mHeight, Bitmap.Config.ARGB_8888);
		Log.v("TAG", "E");
		mPaint = new Paint();
		Log.v("TAG", "F");
		mPaint.setDither(true);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// 이미지 그리기
		canvas.drawBitmap(mViewBitmap, mWidth, mHeight, null);
		canvas.translate(0, mViewBitmap.getHeight());

		super.onDraw(canvas);
	}

	private int[] createColors(){
		int[] colors = null;
		mWidth = mBitmap.getWidth();
		mHeight = mBitmap.getHeight();
		mST = mWidth + 10; // 넓이보다 10을 크게 설정
		
		colors = new int[mST * mHeight];
		Log.v("TAG", "4");
		for (int y = 0; y < mHeight; y++) {
			for (int x = 0; x < mWidth; x++) {
				colors[y * mST + x] = mBitmap.getPixel(x, y);
			}
		}

		return colors;
	}
}