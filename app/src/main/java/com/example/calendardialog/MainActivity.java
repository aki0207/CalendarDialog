package com.example.calendardialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity{

    DatePickerDialog datePickerDialog;

    // 日付設定時のリスナ作成
    DatePickerDialog.OnDateSetListener DateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(android.widget.DatePicker datePicker, int year,
                              int monthOfYear, int dayOfMonth) {

            // トーストとログ出力
            Toast.makeText(
                    MainActivity.this,
                    "year:" + year + " monthOfYear:" + monthOfYear
                            + " dayOfMonth:" + dayOfMonth, Toast.LENGTH_LONG)
                    .show();
            Log.d("DatePicker", "year:" + year + " monthOfYear:" + monthOfYear
                    + " dayOfMonth:" + dayOfMonth);
        }
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 日付情報の初期設定
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR); // 年
        int monthOfYear = calendar.get(Calendar.MONTH); // 月
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // 日

        // 日付設定ダイアログの作成・リスナの登録
        datePickerDialog = new DatePickerDialog(this,
                android.R.style.Theme_Black_NoTitleBar, DateSetListener, year,
                monthOfYear, dayOfMonth);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 日付設定ダイアログの表示
                datePickerDialog.show();

            }
        });


    }
}