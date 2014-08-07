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
		
		// activity ��ü�� listener ó��
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
					textV.setText("�̾�~ ��ٸ��� �ߴ�!");
					break;

				case 3:
					// fade in
					for(int tmp=2; tmp<=100; tmp += 2) {
						 prof.setImageAlpha(tmp); 	// not working
					}

					textV.setText("�� �̸��� ���ڻ�\r\n�� ���� �߰��� ����̶���!");
					break;

				case 4:
					// add egg here


					textV.setText("�� �� �ӿ���\r\n���� �޴����� ��ȥ�� ��� �ִ�");
					break;

				case 5:
					textV.setText("�׸��� ���, ��, ���...\r\n�̰͵鵵 �Բ� ��� ����");
					break;

				case 6:
					textV.setText("��! �� ���� �ʿ��� �ְڴ�");
					break;

				case 7:
					textV.setText("�� �� ����,\r\n����������������...");
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