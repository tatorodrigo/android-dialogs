package br.com.tattobr.android.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

public class EditTextAlertDialogFragment extends DialogFragment {
    private static final String TAG = "tag";
    private static final String TITLE = "title";
    private static final String MESSAGE = "message";
    private static final String TEXT = "text";

    public interface EditTextAlertDialogFragmentListener {
        void onEditTextDialogPositiveButton(int tag, String text);

        void onEditTextDialogNegativeButton(int tag);
    }

    public static EditTextAlertDialogFragment newInstance(int tag, int title, int message, String text) {
        EditTextAlertDialogFragment frag = new EditTextAlertDialogFragment();

        Bundle args = new Bundle();
        args.putInt(TAG, tag);
        args.putInt(TITLE, title);
        args.putInt(MESSAGE, message);
        args.putString(TEXT, text);
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

        textInputLayout.setHint(getString(args.getInt(MESSAGE)));
        editText.setText(args.getString(TEXT));

        int title = args.getInt(TITLE);
        if (title != 0) {
            builder.setTitle(title);
        }
        builder.setView(view);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (getActivity() instanceof EditTextAlertDialogFragmentListener) {
                    ((EditTextAlertDialogFragmentListener) getActivity()).onEditTextDialogPositiveButton(args.getInt(TAG), editText.getText().toString());
                }
            }
        });

        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (getActivity() instanceof EditTextAlertDialogFragmentListener) {
                    ((EditTextAlertDialogFragmentListener) getActivity()).onEditTextDialogNegativeButton(args.getInt(TAG));
                }
            }
        });

        return builder.create();
    }
}
