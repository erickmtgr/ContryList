package montenegro.erick.contrylist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {

    private static final int CHOOSE_COUNTRY = 1;
    private TextView country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        country = (TextView) findViewById(R.id.country);
    }

    public void onChooseCountry(View view) {
        Intent intent = new Intent(this, CountryChooseActivity.class);
        startActivityForResult(intent, CHOOSE_COUNTRY); //REFERENCIAMOS a que intent nos referimos, y guardamos el entero que nos dice qúe devuelve. en este caso solo hay 1
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case CHOOSE_COUNTRY: //nomes tenim 1 case
                if (resultCode==RESULT_OK){
                    country.setText(data.getStringExtra("country"));
                }
        }
    }
}
