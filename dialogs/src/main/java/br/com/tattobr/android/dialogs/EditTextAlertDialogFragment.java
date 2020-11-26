package br.com.tattobr.android.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;
import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

public class EditTextAlertDialogFragment extends DialogFragment {
    private static final String TAG = "tag";
    private static final String TITLE = "title";
    private static final String MESSAGE = "message";
    private static final String TEXT = "text";
    private static final String INPUT_TYPE = "input_type";
    private static final String PARAMS = "params";

    public interface EditTextAlertDialogFragmentListener {
        void onEditTextDialogPositiveButton(int tag, String text, Bundle params);

        void onEditTextDialogNegativeButton(int tag, Bundle params);
    }

    public static EditTextAlertDialogFragment newInstance(int tag, int title, int message, String text) {
        return newInstance(tag, title, message, text, -1, null);
    }

    public static EditTextAlertDialogFragment newInstance(int tag, int title, int message, String text, int inputType, Bundle params) {
        EditTextAlertDialogFragment frag = new EditTextAlertDialogFragment();

        Bundle args = new Bundle();
        args.putInt(TAG, tag);
        args.putInt(TITLE, title);
        args.putInt(MESSAGE, message);
        args.putString(TEXT, text);
        args.putInt(INPUT_TYPE, inputType);
        args.putBundle(PARAMS, params);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final Bundle args = getArguments();
        final View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_edit_text, null);
        final EditText editText = (EditText) view.findViewById(android.R.id.text1);
        final TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.hint);
        final int tag = args.getInt(TAG);
        final Bundle params = args.getBundle(PARAMS);

        textInputLayout.setHint(getString(args.getInt(MESSAGE)));
        editText.setText(args.getString(TEXT));
        final int inputType = args.getInt(INPUT_TYPE);
        if (inputType >= 0) {
            editText.setRawInputType(inputType);
        }

        int title = args.getInt(TITLE);
        if (title != 0) {
            builder.setTitle(title);
        }
        builder.setView(view);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (getActivity() instanceof EditTextAlertDialogFragmentListener) {
                    ((EditTextAlertDialogFragmentListener) getActivity()).onEditTextDialogPositiveButton(tag, editText.getText().toString(), params);
                }
            }
        });

        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (getActivity() instanceof EditTextAlertDialogFragmentListener) {
                    ((EditTextAlertDialogFragmentListener) getActivity()).onEditTextDialogNegativeButton(tag, params);
                }
            }
        });

        return builder.create();
    }
}
