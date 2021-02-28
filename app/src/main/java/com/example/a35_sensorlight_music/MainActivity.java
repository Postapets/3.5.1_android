package com.example.a35_sensorlight_music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Sensor sensorLight;
    TextView text;
    SensorManager sensorManager;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textID);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        intent=new Intent(this, musicService.class);
    }
    public void onClickSensLight(View v) {
        sensorManager.registerListener(listenerLight, sensorLight, SensorManager.SENSOR_DELAY_FASTEST);
    }

    SensorEventListener listenerLight = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            text.setText(String.valueOf(event.values[0]));
            if (event.values[0] < 10){

                startService(intent);
            } else {
                stopService(intent);
            }
        }
    };


}