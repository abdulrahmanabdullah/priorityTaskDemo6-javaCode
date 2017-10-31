package abdulrahmanjavanrd.com.prioritytaskdemo7_java.Fragments;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import abdulrahmanjavanrd.com.prioritytaskdemo7_java.R;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.constant.ConstantValue;
import abdulrahmanjavanrd.com.prioritytaskdemo7_java.services.TaskService;

/**
 * Created by nfs05 on 20/10/2017.
 */

public class FragA extends Fragment {
    private Spinner spinner1 , spinner2 ;
    private ArrayAdapter<String> dataAdapter ;
    private Button start_button ;
   private List<String> spinner1List = new ArrayList<>();
   private List<String> spinner2List = new ArrayList<>();
   private TextView taskType ;
    // sum of numbers and converted hours or day or month .
    public  int totalSum ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_a_layout,container,false);
        Bundle bundle = getArguments();
        String task = bundle.getString("task");
        taskType = v.findViewById(R.id.task_type);
        taskType.setText(task);
        Toast.makeText(getActivity(),"This value from FragA:"+task,Toast.LENGTH_LONG).show();
        spinner1 = v.findViewById(R.id.sp_numbers);
        spinner2 = v.findViewById(R.id.sp_date);
        start_button = v.findViewById(R.id.start_button);
        // call spinner spinner2List .
        addItemsDynamic();
        start_button.setOnClickListener(view->{
            totalSum = convertData(String.valueOf(spinner1.getSelectedItem()),String.valueOf(spinner2.getSelectedItem()));
            Toast.makeText(getActivity(),"btn clicked :  "+totalSum ,Toast.LENGTH_LONG).show();
            Intent sendService = new Intent(getActivity(), TaskService.class);
            sendService.putExtra(ConstantValue.SEND_VALUE,20);
            getActivity().startService(sendService);
        });
        return v ;
    }

    // dynamic spinner2List
    public void addItemsDynamic(){
        spinner2List.add("");
        spinner2List.add("hours");
        spinner2List.add("Day");
        spinner2List.add("Month");
        // arrayAdapter ..
         dataAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item, spinner2List);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
        spinner1List.add("0");
        spinner1List.add("1");
        spinner1List.add("2");
        spinner1List.add("3");
        spinner1List.add("4");
        spinner1List.add("5");
        spinner1List.add("6");
        spinner1List.add("7");
        spinner1List.add("8");
        spinner1List.add("9");
        dataAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item, spinner1List);
        spinner1.setAdapter(dataAdapter);


    }
    // convert data
    private int convertData(String numberStr, String dataStr ){
       int resultNumbers = 0  ;
        int resultData = 0  ;
        int totalResult;
       if (numberStr != null && !numberStr.equals("") && (dataStr !=null && !dataStr.equals(""))){
         // check numbers ..
           for (int i =0 ; i < spinner1List.size() ; i++){
               if (numberStr == spinner1List.get(i)){
                   resultNumbers += i ;
               }
           }
           if (dataStr.equals("Day") ){
               resultData += 1000 ;
           }
           else if (dataStr.equalsIgnoreCase("hours")){
               resultData += 600 ;
           }
           else if (dataStr.equalsIgnoreCase("month")){
               resultData += 5000;
           }
           totalSum = resultData * resultNumbers;
       }else {
          totalResult = -1 ;
          totalSum = totalResult ;
       }
        return totalSum ;
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };
    @Override
    public void onResume() {
        IntentFilter fliter = new IntentFilter("my.action.to.receiver");
        getActivity().registerReceiver(receiver,fliter);
        super.onResume();
    }

    @Override
    public void onPause() {
        getActivity().unregisterReceiver(receiver);
        super.onPause();
    }
}
