package ackee.cz.codecamp03;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Jan Stanek[jan.stanek@ackee.cz] on {23.3.16}
 **/
public class SchoolProjectFragment extends Fragment {
    public static final String TAG = SchoolProjectFragment.class.getName();
    private EditText mEditAddress;
    private EditText mEditSubject;
    private EditText mEditContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_send_email, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEditAddress = (EditText) view.findViewById(R.id.edit_send_address);
        mEditSubject = (EditText) view.findViewById(R.id.edit_send_subject);
        mEditContent = (EditText) view.findViewById(R.id.edit_send_content);

        FloatingActionButton btnSend = (FloatingActionButton) view.findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("ConstantConditions")
            @Override
            public void onClick(View v) {
                if (areSetDataValid()) {
                    String address = mEditAddress.getText().toString();
                    String snack = getString(R.string.mail_sent_to_address, address);
                    clearEditFields();
                    Snackbar.make(getView(), snack, Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    private void clearEditFields() {
        mEditAddress.getText().clear();
        mEditSubject.getText().clear();
        mEditContent.getText().clear();
    }

    private boolean areSetDataValid() {
        boolean valid = true;
        String email = mEditAddress.getText().toString();
        if (email.isEmpty()) {
            mEditAddress.setError(getString(R.string.error_no_email_address));
            valid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEditAddress.setError(getString(R.string.error_invalid_email_address));
            valid = false;
        }
        return valid;
    }
}
