package com.example.patpatintro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PatPatIntro extends Activity implements View.OnClickListener {

	private Context context;
	private TextView textV;
	private ImageView prof;
	private LinearLayout ll;

	private boolean isProfShowed = false;
	private int popupNoCnt = 0;
	private int progress = 0;
	
	private LinearLayout linear;
	private Bitmap egg;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		// set up bottom layout
		Window win = getWindow();
		win.setContentView(R.layout.intro);

		// set up top layout
		LayoutInflater inflater = (LayoutInflater)getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
		linear = (LinearLayout)inflater.inflate(R.layout.intro_black, null);

		LinearLayout.LayoutParams paramlinear = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT);
		win.addContentView(linear, paramlinear);

		// prepare variables
		context = this;
		textV = (TextView)findViewById(R.id.text);
		prof =  (ImageView)findViewById(R.id.imageView1);
		ll = (LinearLayout)findViewById(R.id.rootLayout);
		final Animation fadeOut = AnimationUtils.loadAnimation(PatPatIntro.this, R.anim.fade_out);

		// activity 전체에 listener 처리
		ll.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				progress++;

				switch(progress) {
				case 1:
					textV.setText(".....용사여.....");
					break;

				case 2:
					textV.setText("(음? 뭐지??)");
					break;

				case 3:
					textV.setText("깨어나세요, 용사여...");
					break;

				case 4:
					textV.setText("(?????)");
					break;

				case 5:
					textV.setText("간나새끼래!\r\n날래날래 일어나라우!");
					break;

				case 6:
					textV.setTextColor(Color.parseColor("#000000"));
					textV.setText("!!!!!!");
					
					linear.startAnimation(fadeOut);

					/*
					try {
						for(int tmp=0; tmp<=255; tmp++) {
							//ll.setBackgroundColor(Color.rgb(tmp, tmp, tmp));
//							Log.v("TAG","aa");
							//Thread.sleep(25);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// 클릭 안하고 자동으로 넘어가게 할때 손보면 어덯게든 될까?
					try {
						ll.setBackgroundColor(Color.rgb(50, 50, 50));
						Thread.sleep(100);
						ll.setBackgroundColor(Color.rgb(100, 100, 100));
						Thread.sleep(100);
						ll.setBackgroundColor(Color.rgb(150, 150, 150));
						Thread.sleep(100);
						ll.setBackgroundColor(Color.rgb(200, 200, 200));
						Thread.sleep(100);
						ll.setBackgroundColor(Color.rgb(255, 255, 255));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					*/
					break;

				case 7:
					textV.setText("이야~ 기다리게 했다!");
					break;

				case 8:
					textV.setText("내 이름은 지박사");
					break;

				case 9:
					egg = BitmapFactory.decodeResource(context.getResources(), R.drawable.egg);
					Bitmap bit = Bitmap.createBitmap(egg.getWidth(), egg.getHeight(), Config.ARGB_8888);
							
					textV.setText("이 이상한 알을\r\n발견한 사람이지");
					break;

				case 10:
					textV.setText("이 알 속에는 너의 휴대폰의\r\n영혼이 들어 있지");
					break;

				case 11:
					textV.setText("그리고 사랑, 꿈, 희망...\r\n이 또한 함께 들어 있지");
					break;

				case 12:
					textV.setText("하지만 나는 너무 타락해서\r\n이 알을 키울 수가 없어");
					break;

				case 13:
					textV.setText("그래서... 자네가 이 알을\r\n맡아 주었으면 하는데");
					break;

				case 14:
					textV.setText("이 알, 맡아 주겠나?");
					break;

				case 15:
					AlertDialog.Builder builder = new AlertDialog.Builder(context);
					builder.setMessage("알을 맡겠습니까?").setPositiveButton("Yes", dialogClickListener)
					.setNegativeButton("No", dialogClickListener).show();

					break;

				// Select Yes
				case 21:
					textV.setText("오오! 고맙네.\r\n자네라면 맡아줄 줄 알았지.");
					break;

				case 22:
					textV.setText("그럼 부탁하겠네.");
					break;

				case 23:
					textV.setText("이 알, 잘 키워주게나...");
					break;

				case 24:
					textV.setText("후하하하하하하하...");
					break;

					// Select No
				case 31:
					textV.setText("음? 미안하네.\r\n내가 가는귀가 먹어서...");
					break;

				case 32:
					textV.setText("방금 뭐라고 했는지\r\n다시 말해주지 않겠나?");
					progress = 14;
					break;

				// Select No 5 times
				case 41:
					textV.setText("그래... 그런가...");
					break;

				case 42:
					textV.setText("그렇다면 자네는\r\n더 이상 쓸모가 없겠군");
					break;

				case 43:
					textV.setText("");
					break;
					
				case 44:
					System.exit(1);
				}
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	// popup	
	DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which){
			case DialogInterface.BUTTON_POSITIVE:
				//Yes button clicked
				progress = 20;
				break;

			case DialogInterface.BUTTON_NEGATIVE:
				//No button clicked
				popupNoCnt++;

				if(popupNoCnt >= 5)
					progress = 40;
				else
					progress = 30;

				break;
			}
		}
	};
}