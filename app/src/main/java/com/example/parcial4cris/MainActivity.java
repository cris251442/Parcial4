package com.example.parcial4cris;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNombre, editTextApellido, editTextDireccion, editTextCiudad, editTextMarcaCarro, editTextModelo;
    private Button buttonGuardar;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextDireccion = findViewById(R.id.editTextDireccion);
        editTextCiudad = findViewById(R.id.editTextCiudad);
        editTextMarcaCarro = findViewById(R.id.editTextMarcaCarro);
        editTextModelo = findViewById(R.id.editTextModelo);

        buttonGuardar = findViewById(R.id.buttonGuardar);
        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarFormulario();
            }
        });
    }
    
    private void guardarFormulario() {
        String nombre = editTextNombre.getText().toString().trim();
        String apellido = editTextApellido.getText().toString().trim();
        String direccion = editTextDireccion.getText().toString().trim();
        String ciudad = editTextCiudad.getText().toString().trim();
        String marcaCarro = editTextMarcaCarro.getText().toString().trim();
        String modelo = editTextModelo.getText().toString().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty() || ciudad.isEmpty()
                || marcaCarro.isEmpty() || modelo.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("apellido", apellido);
        values.put("direccion", direccion);
        values.put("ciudad", ciudad);
        values.put("marca_carro", marcaCarro);
        values.put("modelo", modelo);
        long resultado = db.insert("formulario", null, values);

        if (resultado == -1) {
            Toast.makeText(this, "Error al guardar el formulario", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Formulario guardado correctamente", Toast.LENGTH_SHORT).show();
            editTextNombre.setText("");
            editTextApellido.setText("");
            editTextDireccion.setText("");
            editTextCiudad.setText("");
            editTextMarcaCarro.setText("");
            editTextModelo.setText("");
        }
    }
}
