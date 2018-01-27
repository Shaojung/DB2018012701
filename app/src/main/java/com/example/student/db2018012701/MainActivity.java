package com.example.student.db2018012701;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv, tv2, tv3;
    int ch1, tmp1;
    boolean chks[] = new boolean[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
    }
    public void click1(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("這是對話框");
        builder.setMessage("這是內容訊息");
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下確定", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("幫助?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下幫助", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void click2(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("這是對話框");
        final EditText ed = new EditText(this);
        builder.setView(ed);
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下確定", Toast.LENGTH_SHORT).show();
                tv.setText(ed.getText().toString());
            }
        });
        builder.show();
    }
    public void click3(View v)
    {
        final String data[] = {"蘋果", "香蕉", "柳丁", "鳳梨"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("選擇");
        builder.setCancelable(false);
        builder.setItems(data, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, data[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
    public void click4(View v)
    {
        final String data[] = {"蘋果", "香蕉", "柳丁", "鳳梨"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("單選");
        tmp1 = ch1;
        builder.setSingleChoiceItems(data, tmp1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tmp1 = which;
            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ch1 = tmp1;
                Toast.makeText(MainActivity.this, "按下確定:" + ch1, Toast.LENGTH_SHORT).show();
                tv2.setText(data[ch1]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "按下取消:" + ch1, Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    public void click5(View v)
    {
        final String data[] = {"蘋果", "香蕉", "柳丁", "鳳梨"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("多選");
        final StringBuilder sb = new StringBuilder();
        builder.setMultiChoiceItems(data, chks, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                for (int i=0;i<=3;i++)
                {
                    if (chks[i])
                    {
                        sb.append(data[i]);
                    }
                }
            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv3.setText(sb.toString());
            }
        });

        builder.show();
    }
}
