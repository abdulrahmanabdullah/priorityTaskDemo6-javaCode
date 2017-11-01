package abdulrahmanjavanrd.com.prioritytaskdemo7_java.services;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOError;
import java.io.IOException;

import abdulrahmanjavanrd.com.prioritytaskdemo7_java.constant.ConstantValue;

/**
 * Created by nfs05 on 31/10/2017.
 */

public class TaskService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int timer = intent.getIntExtra(ConstantValue.SEND_VALUE,10);

       new  AsyncTaskInner().execute(timer);
        Log.d("service","onStartCommand :  "+ Thread.currentThread().getName() +"Timer  = " + timer );
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    // aysnc task inner class ..
    class AsyncTaskInner extends AsyncTask<Integer,String,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Log.i("service","update = " + values[0]);
        }

        // this method take a long running process .
        @Override
        protected String doInBackground(Integer... voids) {
            int ctr = voids[0];
            while(ctr >= 0){
                publishProgress("Ctr = " + ctr );
                try{
                    Thread.sleep(1000);
                    ctr--;
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return "Done Task";
        }


        @Override
        protected void onPostExecute(String str) {
            super.onPostExecute(str);
            stopSelf();
            Intent mIntent = new Intent(ConstantValue.MY_ACTION_SERVICE);
            mIntent.putExtra(ConstantValue.START_SERVICE_RESULT,str);
            sendBroadcast(mIntent);

        }
    }

}
