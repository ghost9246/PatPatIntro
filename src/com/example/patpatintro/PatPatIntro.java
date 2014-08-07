package com.example.patpatintro;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PatPatIntro extends Activity implements View.OnClickListener {

	private int progress = 0;
	private TextView textV;
	private ImageView prof;
	private LinearLayout ll;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);
		
		textV = (TextView)findViewById(R.id.text);
		prof =  (ImageView)findViewById(R.id.imageView1);
		ll = (LinearLayout)findViewById(R.id.rootLayout);
		
		// activity 전체에 listener 처리
		ll.setOnClickListener(new OnClickListener() {
			@Override
	        public void onClick(View v) {
	            // TODO Auto-generated method stub
				progress++;

				switch(progress) {
				case 1:
					textV.setText("..............\r\n..............");
					break;

				case 2:
					textV.setText("이야~ 기다리게 했다!");
					break;

				case 3:
					// fade in
					for(int tmp=2; tmp<=100; tmp += 2) {
						 prof.setImageAlpha(tmp); 	// not working
					}

					textV.setText("내 이름은 지박사\r\n이 알을 발견한 사람이란다!");
					break;

				case 4:
					// add egg here


					textV.setText("이 알 속에는\r\n너의 휴대폰의 영혼이 담겨 있다");
					break;

				case 5:
					textV.setText("그리고 사랑, 꿈, 희망...\r\n이것들도 함께 들어 있지");
					break;

				case 6:
					textV.setText("자! 이 알을 너에게 주겠다");
					break;

				case 7:
					textV.setText("잘 해 보라구,\r\n후하하하하하하하...");
					break;
				}
	        }
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}