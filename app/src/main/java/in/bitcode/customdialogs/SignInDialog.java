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

    public interface OnSignInListener {
        void onSuccess(SignInDialog signInDialog);

        void onFailure(SignInDialog signInDialog);
    }

    private OnSignInListener mOnSignInListener;

    public void setOnSignInListener(OnSignInListener onSignInListener) {
        this.mOnSignInListener = onSignInListener;
    }

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

        mBtnSignIn.setOnClickListener(new BtnSignInClickListener());
    }

    private class BtnSignInClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            if (mOnSignInListener == null) {
                return;
            }

            if (mEdtUsername.getText().toString().equals("bitcode")) {
                //delegate the success event to listener
                mOnSignInListener.onSuccess(SignInDialog.this);

            } else {
                //delegate the failure event to listener
                mOnSignInListener.onFailure(SignInDialog.this);
            }
        }
    }

}
