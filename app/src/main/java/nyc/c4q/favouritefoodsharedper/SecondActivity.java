package nyc.c4q.favouritefoodsharedper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private SharedPreferences savedPrefs;
    private EditText savedFoodEditText;
    private Button checkFoodButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        savedFoodEditText = (EditText) findViewById(R.id.food_edittext);
        checkFoodButton = (Button) findViewById(R.id.check_food);

        Intent intent = getIntent();
        String user = intent.getStringExtra("search");
        savedPrefs = getApplicationContext().getSharedPreferences(intent.getStringExtra("key"), MODE_PRIVATE);
        savedFoodEditText.setText(user);


        checkFoodButton.setOnClickListener(new View.OnClickListener() {

            String name = savedFoodEditText.getText().toString();
            @Override
            public void onClick(View v) {
                String checkFoodEditText = "food01" + savedFoodEditText.getText().toString();
                if (savedFoodEditText.getText().toString().equalsIgnoreCase(savedPrefs.getString(checkFoodEditText, null))) {
                    String item = savedFoodEditText.getText().toString();
                    Toast.makeText(getApplicationContext(),  item + " is on the list.", Toast.LENGTH_LONG).show();
                    savedFoodEditText.setText(null);

                } else {
                    Toast.makeText(getApplicationContext(), name + " is not on the list.", Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}
