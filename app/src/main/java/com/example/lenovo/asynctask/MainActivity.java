package com.example.lenovo.asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btnprocess;
    ProgressBar progressBar,progressBar1;
    TextView txtpercentage,txtpercentage1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnprocess = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.pb);
        txtpercentage= (TextView) findViewById(R.id.tv2);
        progressBar1 = (ProgressBar) findViewById(R.id.progressBar6);
        txtpercentage1= (TextView) findViewById(R.id.textView3);

    }

    public void start(View view) {
        btnprocess.setEnabled(false);
       new Test().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }



int t=0;
    public void counter(View view) {

        TextView t222=(TextView)findViewById(R.id.textView2);
        t++;
        t222.setText(Integer.toString(t));


    }

    public void as(View view) {
        btnprocess.setEnabled(false);
        new Test1().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }



    private class Test extends AsyncTask<Void,Integer,Void>
    {

        int progress_status;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Invoke onPreExecute() Process", Toast.LENGTH_SHORT).show();
            progress_status = 0;
            txtpercentage.setText("Processing 0%");


        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            txtpercentage.setText("Processing " +values[0]+"%");
        }
@Override
protected Void doInBackground(Void... arg) {

    while(progress_status<100){
        progress_status += 5;
        publishProgress(progress_status);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
return null; }

        @Override
        protected void onPostExecute(Void result) {

                super.onPostExecute(result);
                Toast.makeText(MainActivity.this,"Invoke onPostExecute() Process", Toast.LENGTH_SHORT).show();
                txtpercentage.setText("Processing complete");
                btnprocess.setEnabled(true);

        }
    }

    private class Test1 extends AsyncTask<Void,Integer,Void>
    {

        int progress_status1;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Invoke onPreExecute() Process", Toast.LENGTH_SHORT).show();
            progress_status1 = 0;
            txtpercentage1.setText("Processing 0%");


        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar1.setProgress(values[0]);
            txtpercentage1.setText("Processing " +values[0]+"%");
        }
        @Override
        protected Void doInBackground(Void... arg) {

            while(progress_status1<100){
                progress_status1 += 5;
                publishProgress(progress_status1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }





            return null; }

        @Override
        protected void onPostExecute(Void result) {

            super.onPostExecute(result);
            Toast.makeText(MainActivity.this,"Invoke onPostExecute() Process", Toast.LENGTH_SHORT).show();
            txtpercentage1.setText("Processing complete");
            btnprocess.setEnabled(true);

        }
    }
        }
