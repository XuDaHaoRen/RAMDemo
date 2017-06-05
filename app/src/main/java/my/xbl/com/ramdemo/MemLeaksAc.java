package my.xbl.com.ramdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by April on 2017/6/5.
 * 模拟内存泄漏和改善方法
 */

public class MemLeaksAc extends Activity {
    private Button leak_btn;
    private Button option_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        leak_btn= (Button) findViewById(R.id.leak_leak_btn);
        option_btn= (Button) findViewById(R.id.leak_opti_btn);
        leak_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new LeakThread()).start();
            }
        });
        option_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new OptiThread()).start();

            }
        });

    }
    private class LeakThread implements Runnable{
        @Override
        public void run() {
            Log.d("TAG","LeakThread start");
            while(true){
                try {
                    Thread.sleep(1000*60*5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private class OptiThread implements Runnable{
        @Override
        public void run() {
            Log.d("TAG","LeakThread start");
            while(true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
