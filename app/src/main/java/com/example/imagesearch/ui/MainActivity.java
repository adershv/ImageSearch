package com.example.imagesearch.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imagesearch.R;
import com.example.imagesearch.viewmodels.MainAtivityViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    MainAtivityViewModel viewModel;

    Button searchBtn;
    EditText searchBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainAtivityViewModel.class);
        searchBox = findViewById(R.id.searchBox);
        searchBtn = findViewById(R.id.searchBtn);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchBox.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Enter search keyword",Toast.LENGTH_LONG).show();
                }else {
                    passIntent();
                }

            }
        });


    }

private void passIntent(){
    Intent intent = new Intent(this, ImageListActivity.class);
    String searchQuery = searchBox.getText().toString();
    intent.putExtra("SearchQuery", searchQuery);
    startActivity(intent);
}

}
