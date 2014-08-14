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

		// activity ��ü�� listener ó��
		ll.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				progress++;

				switch(progress) {
				case 1:
					textV.setText(".....��翩.....");
					break;

				case 2:
					textV.setText("(��? ����??)");
					break;

				case 3:
					textV.setText("�������, ��翩...");
					break;

				case 4:
					textV.setText("(?????)");
					break;

				case 5:
					textV.setText("����������!\r\n�������� �Ͼ���!");
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

					// Ŭ�� ���ϰ� �ڵ����� �Ѿ�� �Ҷ� �պ��� ��F�Ե� �ɱ�?
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
					textV.setText("�̾�~ ��ٸ��� �ߴ�!");
					break;

				case 8:
					textV.setText("�� �̸��� ���ڻ�");
					break;

				case 9:
					egg = BitmapFactory.decodeResource(context.getResources(), R.drawable.egg);
					Bitmap bit = Bitmap.createBitmap(egg.getWidth(), egg.getHeight(), Config.ARGB_8888);
							
					textV.setText("�� �̻��� ����\r\n�߰��� �������");
					break;

				case 10:
					textV.setText("�� �� �ӿ��� ���� �޴�����\r\n��ȥ�� ��� ����");
					break;

				case 11:
					textV.setText("�׸��� ���, ��, ���...\r\n�� ���� �Բ� ��� ����");
					break;

				case 12:
					textV.setText("������ ���� �ʹ� Ÿ���ؼ�\r\n�� ���� Ű�� ���� ����");
					break;

				case 13:
					textV.setText("�׷���... �ڳװ� �� ����\r\n�þ� �־����� �ϴµ�");
					break;

				case 14:
					textV.setText("�� ��, �þ� �ְڳ�?");
					break;

				case 15:
					AlertDialog.Builder builder = new AlertDialog.Builder(context);
					builder.setMessage("���� �ðڽ��ϱ�?").setPositiveButton("Yes", dialogClickListener)
					.setNegativeButton("No", dialogClickListener).show();

					break;

				// Select Yes
				case 21:
					textV.setText("����! ����.\r\n�ڳ׶�� �þ��� �� �˾���.");
					break;

				case 22:
					textV.setText("�׷� ��Ź�ϰڳ�.");
					break;

				case 23:
					textV.setText("�� ��, �� Ű���ְԳ�...");
					break;

				case 24:
					textV.setText("����������������...");
					break;

					// Select No
				case 31:
					textV.setText("��? �̾��ϳ�.\r\n���� ���±Ͱ� �Ծ...");
					break;

				case 32:
					textV.setText("��� ����� �ߴ���\r\n�ٽ� �������� �ʰڳ�?");
					progress = 14;
					break;

				// Select No 5 times
				case 41:
					textV.setText("�׷�... �׷���...");
					break;

				case 42:
					textV.setText("�׷��ٸ� �ڳ״�\r\n�� �̻� ���� ���ڱ�");
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