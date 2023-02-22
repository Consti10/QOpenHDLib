package com.example.qopenhdlib;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import org.freedesktop.gstreamer.tutorials.tutorial_3.GstLivePlayer;

public class MainActivity extends Activity implements SurfaceHolder.Callback {

    private final GstLivePlayer m_live_player=new GstLivePlayer();

    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        SurfaceView sv = (SurfaceView) this.findViewById(R.id.surface_video);
        SurfaceHolder sh = sv.getHolder();
        sh.addCallback(this);

        //m_live_player.xx_init(this);
    }


    protected void onDestroy() {
        //m_live_player.xx_finalize();;
        super.onDestroy();
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        Log.d("GStreamer", "Surface changed to format " + format + " width "
                + width + " height " + height);
        //m_live_player.xx_set_surface_out(holder.getSurface());
    }

    public void surfaceCreated(SurfaceHolder holder) {
        Log.d("GStreamer", "Surface created: " + holder.getSurface());
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d("GStreamer", "Surface destroyed");
        //m_live_player.xx_remove_surface_out();;
    }

}
