package com.example.user.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText name;
    TextView textView;
    RadioButton RB;
    RadioButton RB1;
    RadioButton RB2;
    RadioGroup radioGroup2;
    Button but1;
    TextView txv6;
    TextView txv7;
    TextView txv8;
    TextView txv9;

    int mora_gamer = -1;
    String[] MoraString ={"剪刀","石頭","布"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        textView = (TextView) findViewById(R.id.textView);
        but1 = (Button) findViewById(R.id.but1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        RB = (RadioButton) findViewById(R.id.RB);
        RB1 = (RadioButton) findViewById(R.id.RB1);
        RB2 = (RadioButton) findViewById(R.id.RB2);
        txv6 = (TextView) findViewById(R.id.txv6);
        txv7 = (TextView) findViewById(R.id.txv7);
        txv8 = (TextView) findViewById(R.id.txv8);
        txv9 = (TextView) findViewById(R.id.txv9);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            public void onCheckedChanged(RadioGroup radioGroup2,int i){
                switch (radioGroup2.getCheckedRadioButtonId()){

                    case R.id.RB:
                        mora_gamer = 0;
                        break;
                    case R.id.RB1:
                        mora_gamer = 1;
                        break;
                    case R.id.RB2:
                        mora_gamer = 2;
                        break;

                }

            }
        });
        but1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                if (name.getText().toString().equals(""))
                    textView.setText("請填寫玩家名稱");
                else if (mora_gamer == -1)
                    textView.setText("請選擇出拳");
                else{
                    txv6.setText(name.getText());
                    txv8.setText(MoraString[mora_gamer]);
                    int mora_computer = (int) (Math.random() * 3);
                    txv9.setText(MoraString[mora_computer]);
                    if ((mora_gamer == 0 && mora_computer == 1) || (mora_gamer == 1 && mora_computer == 2) || (mora_gamer == 2 && mora_computer == 0)){
                        txv7.setText("美女");
                        textView.setText("可惜，你要脫衣服了");
                    } else if (mora_gamer == mora_computer){
                        txv7.setText("平局");
                        textView.setText("平局!Agal!");
                    } else  {
                        txv7.setText(name.getText());
                        textView.setText("美女脫一件");
                    }

                }
            }

        });

    }
}
