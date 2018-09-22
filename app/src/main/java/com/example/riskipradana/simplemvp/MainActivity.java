package com.example.riskipradana.simplemvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText edtLength;
    private EditText edtWidth;
    private EditText edtHeight;
    private TextView tvResult;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLength = findViewById(R.id.etd_length);
        edtWidth = findViewById(R.id.etd_width);
        edtHeight = findViewById(R.id.edt_height);
        Button btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        presenter = new MainPresenter(this);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String length = edtLength.getText().toString().trim();
                String widht = edtWidth.getText().toString().trim();
                String height = edtHeight.getText().toString().trim();

                boolean isEMptyFields = false;

                if(TextUtils.isEmpty(length)){
                    isEMptyFields = true;
                    edtLength.setError("field ini tidak boleh kosong");
                }

                if(TextUtils.isEmpty(widht)){
                    isEMptyFields = true;
                    edtLength.setError("field ini tidak boleh kosong");
                }

                if(TextUtils.isEmpty(height)){
                    isEMptyFields = true;
                    edtLength.setError("field ini tidak boleh kosong");
                }

                if(!isEMptyFields){
                    double l = Double.parseDouble(length);
                    double w = Double.parseDouble(widht);
                    double h = Double.parseDouble(height);

                    presenter.hitungVolume(l, w, h);
                }
            }
        });
    }

    @Override
    public void showVolume(MainModel model) {
        tvResult.setText(String.valueOf(model.getVolume()));
    }
}
