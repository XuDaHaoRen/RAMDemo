package my.xbl.com.ramdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by April on 2017/6/4.
 * 模拟内存抖动和改善
 */

public class MemChurnAc extends Activity {
    private Button churn_btn;
    private Button opti_btn;
    private int num=10;
    private int length =420000;
    private Random random=new Random();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_churn);
        churn_btn= (Button) findViewById(R.id.churn_churn_btn);
        opti_btn= (Button) findViewById(R.id.churn_opti_btn);
        churn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doChurn();
            }

        });
        opti_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optiChurn();
            }
        });
    }
    private void optiChurn(){
        String [] strMatrix=new String[length];
        for(int i=0;i<num;i++){
            for(int j=0;j<length;j++){
                strMatrix[j]=String.valueOf(random.nextInt());
            }
            Log.d("TAG","opti churn:"+i);
        }
        Log.d("TAG","opti churn end");
    }


    private void doChurn(){
        //每一次都生成占用大量内存的数组对象
        for(int i=0;i<num;i++){
            String [] strMatrix=new String[length];
            for(int j=0;j<length;j++){
                strMatrix[j]=String.valueOf(random.nextDouble());
            }
            Log.d("TAG","churn:"+i);
        }
        Log.d("TAG","churn end");
    }
    }

