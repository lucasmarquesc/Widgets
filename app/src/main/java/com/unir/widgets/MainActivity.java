package com.unir.widgets;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Handler handler; // Handler da UI Thread
    private int progresso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Componente TextView e Button
        TextView textView = findViewById(R.id.txt_exemplo1);
        Button btn_textView = findViewById(R.id.btn_textView);
        btn_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Texto Alterado");
            }
        });
        //Manipulação do componente EditText
        EditText editText = findViewById(R.id.editText1);
        Button btn_editText = findViewById(R.id.btn_editText);
        btn_editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensagem = "Texto informado: ";
                if (!editText.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, mensagem + editText.getText().toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        //Manipulação do componente RadioGroup (Usando Button)
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int checkedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(checkedId);
        Button btn_radioButton = findViewById(R.id.btn_RadioButton);
        btn_radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Opção selecionada: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        //Manipulação do componente RadioGroup (Usando Listener)
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(@NonNull RadioGroup radioGroup, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(MainActivity.this, "Opção selecionada: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        //Manipulação do componentes CheckBox;
        CheckBox checkBox1 = findViewById(R.id.checkBox1);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);
        Button btn_checkBox = findViewById(R.id.btn_checkBox);
        btn_checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder resultado = new StringBuilder("Selecionados: ");

                if (checkBox1.isChecked()) {
                    resultado.append("Opção 1 ");
                }
                if (checkBox2.isChecked()) {
                    resultado.append("Opção 2 ");
                }
                if (checkBox3.isChecked()) {
                    resultado.append("Opção 3 ");
                }

                if (resultado.toString().equals("Selecionados: ")) {
                    resultado = new StringBuilder("Nenhum selecionado!");
                }
                // Mostra resultado no Toast
                Toast.makeText(MainActivity.this, resultado.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        //Manipulação do componente CheckBox1 (Usando Listener)
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "Opção 1 selecionada", Toast.LENGTH_SHORT).show();
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        //Manipulação do componentes Spinner (Usando Listener)
        String opcoes [] = {"Opção 01", "Opção 02", "Opção 03", "Opção 04"};
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(android.R.array.phoneTypes));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String opcaoSelecionada = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Opção selecionada: " + opcaoSelecionada, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Nenhuma opção selecionada", Toast.LENGTH_SHORT).show();
            }
        });
        //Manipulação do componente ProgressBar (simulando progresso com Thread)
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(10);
        handler = new Handler(Looper.getMainLooper());
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progresso < 100){
                    progresso+=1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progresso);
                        }
                    });
                    try{
                        Thread.sleep(50);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        //Manipulação do componente ProgressBar (simulando progresso indeterminado)
        ProgressBar progressBar2 = findViewById(R.id.progressBar2);
        int tempoDeEspera = 3000;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar2.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Progresso concluído!", Toast.LENGTH_SHORT).show();
            }
        }, tempoDeEspera);
        //Manipulação do componente AutoCompleteTextView
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        String sugestoes [] = {"Brasil", "Argentina", "Chile", "Uruguai", "Paraguai"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, sugestoes
        );
        autoCompleteTextView.setAdapter(adapter1);
        //Manipulação do componente RatingBar
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setNumStars(5);
        ratingBar.setMax(10);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, "Nota selecionada: " + rating, Toast.LENGTH_SHORT).show();
            }
        });
        //Manipulação do componente ImageView
        ImageView imageView = findViewById(R.id.imageView);
        Button btn_imageView = findViewById(R.id.btn_imageView);
        btn_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.widget2);
            }
        });
        TextInputEditText textInputEditText = findViewById(R.id.textInputEditText);
        Button btn_textInputEditText = findViewById(R.id.btn_textInputEditText);
        btn_textInputEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Texto informado: " + textInputEditText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}