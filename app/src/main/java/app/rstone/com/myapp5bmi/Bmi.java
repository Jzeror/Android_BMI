package app.rstone.com.myapp5bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
        final EditText height = findViewById(R.id.height);
        final EditText weight = findViewById(R.id.weight);
        class Calc{
            double height, weight,f;
            String result;
            public void exe(){
                f = weight / (height * height/10000);
                result = "3단계 비만";
                if (f < 18.5) {
                    result = "저체중";
                } else if (f < 23) {
                    result = "정상";
                } else if (f < 25) {
                    result = "비만 전단계";
                } else if (f < 30) {
                    result = "1단계 비만";
                } else if (f < 35) {
                    result = "2단계 비만";
                }
            }
           /* public double getHeight(){return  height;}
            public void setHeight(double height){this.height=height;}
            public double getWeight(){return  weight;}
            public void setWeight(double weight){this.weight=weight;}
            public String getResult(){return  result;}
            public void setResult(String result){this.result=result;}*/ //겟터셋터는 필요가 없어진다. 원페이지 소스이기 때문에.
        }

        findViewById(R.id.send_btn).setOnClickListener(
                (View v)->{
                    Calc c = new Calc();
                    c.height=Integer.parseInt(height.getText().toString());
                    c.weight=Integer.parseInt(weight.getText().toString());
                    c.exe();
                   TextView result= findViewById(R.id.result);
                   result.setText(c.result);
                   c.result="";
                }
        );
    }
}
