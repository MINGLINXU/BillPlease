package sg.edu.rp.c346.billplease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText amountNum;
    EditText paxNum;
    ToggleButton gstBtn;
    ToggleButton scBtn;
    TextView avgNum;
    Button subBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        amountNum = findViewById(R.id.amount);
        paxNum=findViewById(R.id.pax);
        gstBtn=findViewById(R.id.gstButton);
        scBtn=findViewById(R.id.scButton);
        avgNum=findViewById(R.id.avgPrice);
        subBtn=findViewById(R.id.submitBtn);



        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = amountNum.getText().toString();
                double amt = Double.parseDouble(data);
                int pax = Integer.parseInt(paxNum.getText().toString());

                if (scBtn.isChecked() == true) {
                    amt = amt * 1.10;
                }
                if(gstBtn.isChecked()==true){
                    amt=amt*1.07;
                }
                double ave = amt/pax;
                String display=String.format("Each pax pays %.2f",ave);
                avgNum.setText(display);

            }
        });
    }
}
