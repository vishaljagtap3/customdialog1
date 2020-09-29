package in.bitcode.customdialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnLogin = findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SignInDialog signInDialog = new SignInDialog( MainActivity.this );
                signInDialog.setOnSignInListener( new MySignInDialogListener() );
                signInDialog.show();

            }
        });
    }

    private void mt(String text) {
        Toast.makeText( this, text, Toast.LENGTH_LONG).show();
    }

    private class MySignInDialogListener implements SignInDialog.OnSignInListener {

        @Override
        public void onSuccess(SignInDialog signInDialog) {
            mt("My Success code");
            signInDialog.dismiss();
        }

        @Override
        public void onFailure(SignInDialog signInDialog) {
            mt("My Failure Code");
        }
    }


}