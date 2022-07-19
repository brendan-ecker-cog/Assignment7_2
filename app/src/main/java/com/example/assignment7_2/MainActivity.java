package com.example.assignment7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView mURL;
    TextView mSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mURL = findViewById(R.id.et_URL);
        mSource = findViewById(R.id.page_source);
    }


    public void getSource(View view) {
        new FetchSource(mURL, mSource).execute(mURL.getText().toString());
//        URL google = null;
//        try {
//            google = new URL("http://www.google.com/");
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(google.openStream()));
//        String input;
//        StringBuffer stringBuffer = new StringBuffer();
//        while ((input = in.readLine()) != null)
//        {
//            stringBuffer.append(input);
//        }
//            in.close();
//            String htmlData = stringBuffer.toString();
//            mSource.setText(htmlData);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}