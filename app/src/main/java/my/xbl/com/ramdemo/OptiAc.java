package my.xbl.com.ramdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by April on 2017/6/4.
 * 模拟用+号进行字符串拼接和StringBuilder进行字符拼接的所占时间
 */

public class OptiAc extends Activity {
    private int rowLength=20;
    private int length=100;
    private int [] [] intMatrix=new int[rowLength][length];
    private Random random=new Random();
    private Button add_btn;
    private Button sb_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optiac);
        add_btn= (Button) findViewById(R.id.optiac_add_btn);
        sb_btn= (Button) findViewById(R.id.optiac_sb_btn);
        initData();
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAdd();
            }
        });
        sb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSb();
            }
        });

    }

    private void initData() {
        for(int i=0;i<rowLength;i++){
            for (int j=0;j<length;j++){
                intMatrix[i][j]=random.nextInt();
            }
        }
    }

    private void doSb() {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<rowLength;i++){
            for (int j=0;j<length;j++){
                sb.append(intMatrix[i][j]);
                Log.d("TAG","APP");
            }
        }
        Log.d("TAG","length:"+sb.length());

    }

    private void doAdd() {
        String str="";
        for (int i=0;i<rowLength;i++){
            for (int j=0;j<length;j++){
                str=str+intMatrix[i][j];
                Log.d("TAG","ADD");
            }
        }
        Log.d("TAG","length:"+str.length());
    }
}
