package com.example.um.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public int flag=0;
    public int flag2=0;
    public int fuhao=0;
    public float result=0;
    public String num1="";
    public String num2="";
    public String fh="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void reset(View view) {
        TextView textView=(TextView) findViewById(R.id.view);
        textView.setText("0");
        flag=0;
        flag2=0;
        num1="";
        num2="";
    }

    public void calcu(View view) {
        int mul=R.id.multiply;
        int min=R.id.minus;
        int add=R.id.add;
        int equ=R.id.equal;
        int div=R.id.division;
        int ID=view.getId();
        Button btn=(Button)findViewById(ID);
        String income= (String) btn.getText();
        TextView textView=(TextView) findViewById(R.id.view);
        Toast.makeText(getApplicationContext(),"flag:"+flag+",flag2:"+flag2,Toast.LENGTH_SHORT).show();
        if(flag==0)
        {
            if(flag2==0)
            {
                if(ID==mul||ID==min||ID==add||ID==equ||ID==div)
                {
                    Toast.makeText(getApplicationContext(),"您的输入有误",Toast.LENGTH_SHORT).show();
                    flag=0;
                    flag2=0;
                    num1="";
                    num2="";
                    fh="";
                    textView.setText("0");
                }
                else{
                    flag++;
                    num1+=income;
                    textView.setText(num1);
                }
            }
        }
        else if(flag==1){
            if(flag2==0){
                if(ID==mul||ID==min||ID==add||ID==div)
                {
                    flag++;
                    flag2++;
                    textView.setText(num1+income);
                    fh+=income;
                    Toast.makeText(getApplicationContext(),fh,Toast.LENGTH_SHORT).show();
                }
                else if(ID==equ)
                {
                    Toast.makeText(getApplicationContext(),"您的输入有误",Toast.LENGTH_SHORT).show();
                    flag=0;
                    flag2=0;
                    num1="";
                    fh="";
                    num2="";
                    textView.setText("0");
                }
                else{
                    num1+=income;
                    textView.setText(num1);
                }
            }

        }
        else if(flag==2)
        {
            if(flag2==1){
                if(ID==mul||ID==min||ID==add||ID==equ||ID==div)
                {
                    Toast.makeText(getApplicationContext(),"您的输入有误",Toast.LENGTH_SHORT).show();
                    flag=0;
                    flag2=0;
                    num1="";
                    fh="";
                    num2="";
                    textView.setText("0");
                }
                else{
                    flag++;
                    flag2=0;
                    num2+=income;
                    textView.setText(num1+fh+num2);
                }

            }
        }
        else if(flag==3)
        {
            if(flag2==0)
            {
                if(ID==mul||ID==min||ID==add||ID==div)
                {
                    Toast.makeText(getApplicationContext(),"您的输入有误",Toast.LENGTH_SHORT).show();
                    flag=0;
                    flag2=0;
                    num1="";
                    fh="";
                    num2="";
                    textView.setText("0");
                }
                else if(ID==equ)
                {
                    int number1=Integer.parseInt(num1);
                    int number2=Integer.parseInt(num2);
                    Toast.makeText(getApplicationContext(),"number1:"+number1+"number2:"+number2,Toast.LENGTH_SHORT).show();
                    if(fh.equals("*"))
                    {
                        result=number1*number2;
                        textView.setText(result+"");
                    }
                    else if(fh.equals("-"))
                    {
                        result=number1-number2;
                        textView.setText(result+"");
                    }
                    else if(fh.equals("+"))
                    {
                        result=number1+number2;
                        textView.setText(result+"");
                    }
                    else if(fh.equals("/"))
                    {
                        result=number1/number2;
                        textView.setText(result+"");
                    }
                    flag++;
                }

                else{
                    num2+=income;
                    textView.setText(num1+(String) fh+num2);
                }
            }
        }
        else if(flag==4)
        {
            flag=0;
            flag2=0;
            num1="";
            num2="";
            fh="";
            textView.setText("0");
        }






    }
}
