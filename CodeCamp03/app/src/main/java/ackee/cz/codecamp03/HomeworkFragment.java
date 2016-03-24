package ackee.cz.codecamp03;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jan Stanek[jan.stanek@ackee.cz] on {18.3.16}
 **/
public class HomeworkFragment extends Fragment implements SimpleDialogFragment.SimpleDialogActionListener {
    public static final String TAG = HomeworkFragment.class.getName();
    private static final String RESULT_TEXT_KEY = "result_key";

    private TextView mTextResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTextResult = (TextView) view.findViewById(R.id.text_dialog_result);
        Button btnShowDialog = (Button) view.findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDialogFragment.createInstance(HomeworkFragment.this)
                        .show(getFragmentManager(), SimpleDialogFragment.TAG);
            }
        });

        if (savedInstanceState != null) {
            mTextResult.setText(savedInstanceState.getString(RESULT_TEXT_KEY));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(RESULT_TEXT_KEY, mTextResult.getText().toString());
    }

    @Override
    public void onOkClicked() {
        mTextResult.setText(getString(R.string.ok));
    }

    @Override
    public void onCancelClicked() {
        mTextResult.setText(getString(R.string.cancel));
    }
}
