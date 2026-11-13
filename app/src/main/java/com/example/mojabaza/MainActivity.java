package com.example.mojabaza;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    BMWDataBase bmwDataBase;
    Button guzik;
    ListView lista;
    EditText wpisz;
    ArrayAdapter<BMW> arrayAdapter;
    List<BMW> modele;


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
        bmwDataBase = Room.databaseBuilder(
                getApplicationContext(),
                BMWDataBase.class,
                "salon_db"
        ).allowMainThreadQueries().build();
        bmwDataBase.zwrocAutaDAO().wstawDoBazy(
                new BMW(1, "e36", "coupe", 1994, 140)
        );
    }
}