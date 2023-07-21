package ddwucom.mobile.week05.outputtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SoundPool soundPool;
    int sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        sound = soundPool.load(this,R.raw.dingdong,1);
    }

    public void onClick(View v){
        //로딩이끝나야 플레이 가능한데 로딩끝나기전에 재생돼서 안됨
        //soundPool, sound는 전역변수 선언하고 onCreate로 올린다.
        //soundPool.play(sound, 1,1,0,0,1);
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        vibrator.vibrate(500); //permisssion 추가하면 에러안남!
        vibrator.vibrate(new long[] {100, 50, 200, 50},0);

        vibrator.cancel();
    }
}