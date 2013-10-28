package sound.generator.soundgenerator;


import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class View_Main extends Activity implements OnClickListener{
	private Button button;
	
	// originally from http://marblemice.blogspot.com/2010/04/generate-and-play-tone-in-android.html
    // and modified by Steve Pomeroy <steve@staticfree.info>
    private final int duration = 1; // seconds
    private final int sampleRate = 44100;
    private final int numSamples = duration * sampleRate;
    private final double sample[] = new double[numSamples];
    private final double freqOfTone = 20000; // hz
    private boolean state = false;
    private final byte generatedSnd[] = new byte[2 * numSamples];
    private AudioTrack audioTrack;
    Handler handler = new Handler();
    TextView tv1;
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_main);
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);
		handler = new Handler() {
			public void handleMessage(Message msg){
				super.handleMessage(msg);
				button.setText(msg.obj.toString());
			}
		};
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view__main, menu);
		return true;
	}
	
	
	@Override
	public void onClick(View v) {
		// Tworzymy now¹ wiadomoœæ
       
		genTone();
		if(state == false){
			state = true;
			new Thread(new Runnable() {
		        public void run() {
		        	 Message wiadomosc = new Message();
			        	playSound();
			        	wiadomosc.obj = "Sound playing";
						handler.sendMessage(wiadomosc);
		        	}
		    }).start();
		}else{
			Message wiadomosc = new Message();
			pauseSound();
			wiadomosc.obj = "Sound paused";
			handler.sendMessage(wiadomosc);
			state = false;
		}

	}
	
	void genTone(){
        // fill out the array
        for (int i = 0; i < numSamples; ++i) {
            sample[i] = Math.sin(freqOfTone * 2 * Math.PI * i / sampleRate);
        }
        // convert to 16 bit pcm sound array
        // assumes the sample buffer is normalised.
        int idx = 0;
        for (final double dVal : sample) {
            // scale to maximum amplitude
            final short val = (short) ((dVal * 32767));
            // in 16 bit wav PCM, first byte is the low order byte
            generatedSnd[idx++] = (byte) (val & 0x00ff);
            generatedSnd[idx++] = (byte) ((val & 0xff00) >>> 8);

        }
    }
	
	
	void pauseSound(){
		this.audioTrack.pause();
	}
	
	void playSound(){
        this.audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
                sampleRate, AudioFormat.CHANNEL_OUT_STEREO,
                AudioFormat.ENCODING_PCM_16BIT, numSamples,
                AudioTrack.MODE_STATIC);
        
        audioTrack.write(generatedSnd, 0, numSamples);
        audioTrack.setLoopPoints(0, generatedSnd.length/8 , -1);
        audioTrack.play();
    }
	
	
}
