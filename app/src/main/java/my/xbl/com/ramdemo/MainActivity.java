package my.xbl.com.ramdemo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 显示当前虚拟机当前还是用内存
 * 虚拟机可用内存
 * 本进程可获得的内存
 * 本进程可用的最大堆内存
 * 内存优化案例的跳转
 模拟字符串内存优化
 模拟内存抖动并优化
 模拟内存泄漏并优化
 */

public class MainActivity extends AppCompatActivity {
    private Button opti_btn;
    private Button churn_btn;
    private Button leak_btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opti_btn= (Button) findViewById(R.id.main_opti_btn);
        churn_btn= (Button) findViewById(R.id.main_churn_btn);
        leak_btn= (Button) findViewById(R.id.main_leak_btn);
        tv = (TextView) findViewById(R.id.main_tv);
        getRAMValue();
        opti_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OptiAc.class);
                startActivity(intent);

            }
        });
        leak_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MemLeaksAc.class);
                startActivity(intent);

            }
        });
        churn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MemChurnAc.class);
                startActivity(intent);

            }
        });
    }

    private void getRAMValue() {
        StringBuilder stringBuilder = new StringBuilder();
        //得到系统对象
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        //得到系统分配给本程序的最大内存
        int Ram = activityManager.getMemoryClass();//以M为单位
        //当设置manifest文件中的<application>标签中largeHeap属性的值为"true"
        // 获得应用可使用的最大内存
        int largeRam = activityManager.getLargeMemoryClass();//以M为单位
        stringBuilder.append("Ram:" + Ram + "\n");
        stringBuilder.append("largeRam:" + largeRam + "\n");
        //当前运行所有进程所占用的内存
        Float totalMemory = Runtime.getRuntime().totalMemory() * 1.0f / (1024 * 1024);
        //虚拟机当前空闲的内存
        Float freeMemory = Runtime.getRuntime().freeMemory() * 1.0f / (1024 * 1024);
        //返回运行时虚拟机给出的最大内存
        Float maxMemory = Runtime.getRuntime().maxMemory() * 1.0f / (1024 * 1024);
        stringBuilder.append("totalMemory:" + totalMemory + "\n");
        stringBuilder.append("freeMemory:" + freeMemory + "\n");
        stringBuilder.append("maxMemory:" + maxMemory + "\n");
        tv.setText(stringBuilder.toString());
    }


}
