package ackee.cz.codecamp03;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Jan Stanek[jan.stanek@ackee.cz] on {18.3.16}
 **/
public class SimpleDialogFragment extends DialogFragment {
    public static final String TAG = SimpleDialogFragment.class.getName();
    public static final int REQUEST_CODE = 123;


    public static SimpleDialogFragment createInstance(@NonNull Fragment target) {
        SimpleDialogFragment toReturn = new SimpleDialogFragment();
        toReturn.setTargetFragment(target, REQUEST_CODE);
        return toReturn;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SimpleDialogActionListener listener = (SimpleDialogActionListener) getTargetFragment();
                if (listener != null) {
                    listener.onOkClicked();
                } else {
                    throw new UnsupportedOperationException("Target fragment does not implement SimpleDialogActionListener");
                }
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SimpleDialogActionListener listener = (SimpleDialogActionListener) getTargetFragment();
                if (listener != null) {
                    listener.onCancelClicked();
                } else {
                    throw new UnsupportedOperationException("Target fragment does not implement SimpleDialogActionListener");
                }
            }
        });
        builder.setTitle(R.string.simple_dialog_title);
        return builder.create();
    }

    public interface SimpleDialogActionListener {
        void onOkClicked();

        void onCancelClicked();
    }
}
