package nyc.c4q.favouritefoodsharedper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_SHARED_PREF = "sharedPrefsFood";
    private EditText foodEditText;
    private Button addFoodButton;
    private Button searchFoodButton;
    private SharedPreferences foodSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodEditText =(EditText) findViewById(R.id.food_edittext);
        addFoodButton =(Button) findViewById(R.id.add_button);
        searchFoodButton =(Button) findViewById(R.id.search_food);

        foodSharedPref = getApplicationContext().getSharedPreferences(KEY_SHARED_PREF, MODE_PRIVATE);

        addFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = foodSharedPref.edit();
                if (foodEditText.getText() != null) {
                    String foodItem = foodEditText.getText().toString();
                    Toast.makeText(getApplicationContext(),  foodItem + " add to list.", Toast.LENGTH_LONG).show();
                    editor.putString("food01" + foodEditText.getText().toString(), foodEditText.getText().toString());
                    editor.commit();
                    foodItem = null;

                }
            }
        });

        searchFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("search", foodEditText.getText().toString());
                intent.putExtra("key", KEY_SHARED_PREF);
                startActivity(intent);
            }
        });
    }
}
