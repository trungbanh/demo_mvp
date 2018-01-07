package trungbanh.com.demo_mvp.Push;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import trungbanh.com.demo_mvp.Main.MainActivity;
import trungbanh.com.demo_mvp.R;

public class PushStatusActivity extends AppCompatActivity implements MainContract {

    EditText editText;
    Button button;
    Presenter_Pushstatus presenterPushstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_status);

        editText = findViewById(R.id.edt_inputstatus);
        button = findViewById(R.id.btn_dang);
        presenterPushstatus = new Presenter_Pushstatus();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = editText.getText().toString();
                if (!presenterPushstatus.isStatusNull(status)) {
                    presenterPushstatus.Pusher(status);

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
