package in.bitcode.customdialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInDialog extends Dialog {

    private EditText mEdtUsername, mEdtPassword;
    private Button mBtnSignIn;
    private Context mContext;

    public SignInDialog(Context context) {
        super(context);
        mContext = context;

        init();
    }

    private void init() {
        this.setContentView(R.layout.sign_in_dialog);

        mBtnSignIn = findViewById(R.id.btnSignIn);
        mEdtUsername = findViewById(R.id.edtUsername);
        mEdtPassword = findViewById(R.id.edtPassword);

        mBtnSignIn.setOnClickListener( new BtnSignInClickListener() );
    }

    private class BtnSignInClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            if( mEdtUsername.getText().toString().equals("bitcode")) {
                //action x
                Toast.makeText( mContext, "Success!", Toast.LENGTH_LONG).show();
                dismiss();
            }
            else {
                //action y
                Toast.makeText( mContext, "Failed!", Toast.LENGTH_LONG).show();
            }
        }
    }

}
