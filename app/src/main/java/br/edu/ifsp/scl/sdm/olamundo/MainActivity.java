package br.edu.ifsp.scl.sdm.olamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText textoEt;
    private Button cliqueAquiBt;
    private Spinner opcoesSp;
    private CheckBox selecionadoCb;
    private RadioButton radio1Rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoEt = findViewById(R.id.textoEt);
        textoEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        cliqueAquiBt = findViewById(R.id.cliqueAquiBt);
        cliqueAquiBt.setOnClickListener(this);
        opcoesSp = findViewById(R.id.opcoesSp);
        opcoesSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        selecionadoCb = findViewById(R.id.selecionadoCb);
        radio1Rb = findViewById(R.id.radio1Rb);
    }

    @Override
    public void onClick(View view) {
        StringBuilder sb = new StringBuilder();

        // EditText
        sb.append(textoEt.getText().toString());
        sb.append('\n');

        // Spinner
        sb.append(((TextView) opcoesSp.getSelectedView()).getText());
        sb.append('\n');

        // CheckBox
        sb.append(selecionadoCb.isChecked() ? "selecionado" : "não selecionado");
        sb.append('\n');

        // RadioButton
        sb.append(radio1Rb.isChecked() ? "Radio 1" : "Radio 2");
        sb.append('\n');

        Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
    }
}