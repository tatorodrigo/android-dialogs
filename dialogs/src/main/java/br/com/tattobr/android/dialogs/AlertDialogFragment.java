package br.com.tattobr.android.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class AlertDialogFragment extends DialogFragment {
    public interface IAlertDialogFragment {
        void onAlertDialogNegativeButton(int tag, boolean checked, Bundle params);

        void onAlertDialogPositiveButton(int tag, boolean checked, Bundle params);
    }

    public static final String TAG = "tag";
    private static final String TITLE = "title";
    private static final String MESSAGE = "message";
    private static final String CHECKBOX = "checkbox";
    private static final String SHOW_CHECKBOX = "showCheckbox";
    private static final String CHECKBOX_CHECKED = "checkboxChecked";
    private static final String POSITIVE_BUTTON = "positive_label";
    private static final String NEGATIVE_BUTTON = "negative_label";
    private static final String SHOW_NEGATIVE_BUTTON = "showNegativeButton";
    private static final String TITLE_MESSAGE_AS_STRING = "titleMessageAsString";
    private static final String CANCELABLE = "cancelable";
    private static final String CANCEL_ON_TOUCH_OUTSIDE = "cancelOnTouchOutside";
    private static final String PARAMS = "params";

    public static AlertDialogFragment newInstance(int tag, int title, int message, boolean showNegativeButton) {
        return newInstance(tag, title, message, showNegativeButton, true, true, null);
    }

    public static AlertDialogFragment newInstance(int tag, int title, int message, boolean showNegativeButton, boolean cancelable, boolean cancelOnTouchOutside, Bundle params) {
        AlertDialogFragment frag = new AlertDialogFragment();

        Bundle args = new Bundle();
        args.putInt(TAG, tag);
        args.putInt(TITLE, title);
        args.putInt(MESSAGE, message);
        args.putString(POSITIVE_BUTTON, null);
        args.putString(NEGATIVE_BUTTON, null);
        args.putBoolean(SHOW_CHECKBOX, true);
        args.putBoolean(SHOW_NEGATIVE_BUTTON, showNegativeButton);
        args.putBoolean(TITLE_MESSAGE_AS_STRING, false);
        args.putBoolean(CANCELABLE, cancelable);
        args.putBoolean(CANCEL_ON_TOUCH_OUTSIDE, cancelOnTouchOutside);
        args.putBundle(PARAMS, params);

        frag.setArguments(args);

        return frag;
    }

    public static AlertDialogFragment newInstance(int tag, int title, int message, int checkbox) {
        return newInstance(tag, title, message, checkbox, false, true, true, true, null);
    }

    public static AlertDialogFragment newInstance(int tag, int title, int message, int checkbox, boolean checked) {
        return newInstance(tag, title, message, checkbox, checked, true, true, true, null);
    }

    public static AlertDialogFragment newInstance(int tag, int title, int message, int checkbox, boolean checkboxChecked, boolean showNegativeButton, boolean cancelable, boolean cancelOnTouchOutside, Bundle params) {
        AlertDialogFragment frag = new AlertDialogFragment();

        Bundle args = new Bundle();
        args.putInt(TAG, tag);
        args.putInt(TITLE, title);
        args.putInt(MESSAGE, message);
        args.putInt(CHECKBOX, checkbox);
        args.putBoolean(SHOW_CHECKBOX, true);
        args.putBoolean(CHECKBOX_CHECKED, checkboxChecked);
        args.putBoolean(SHOW_NEGATIVE_BUTTON, showNegativeButton);
        args.putBoolean(TITLE_MESSAGE_AS_STRING, false);
        args.putBoolean(CANCELABLE, cancelable);
        args.putBoolean(CANCEL_ON_TOUCH_OUTSIDE, cancelOnTouchOutside);
        args.putString(POSITIVE_BUTTON, null);
        args.putString(NEGATIVE_BUTTON, null);
        args.putBundle(PARAMS, params);

        frag.setArguments(args);

        return frag;
    }

    public static AlertDialogFragment newInstance(int tag, String title, String message, boolean showNegativeButton) {
        return newInstance(tag, title, message, showNegativeButton, true, true, null);
    }

    public static AlertDialogFragment newInstance(int tag, String title, String message, boolean showNegativeButton, boolean cancelable, boolean cancelOnTouchOutside, Bundle params) {
        AlertDialogFragment frag = new AlertDialogFragment();

        Bundle args = new Bundle();
        args.putInt(TAG, tag);
        args.putString(TITLE, title);
        args.putString(MESSAGE, message);
        args.putBoolean(SHOW_CHECKBOX, false);
        args.putBoolean(SHOW_NEGATIVE_BUTTON, showNegativeButton);
        args.putBoolean(TITLE_MESSAGE_AS_STRING, true);
        args.putBoolean(CANCELABLE, cancelable);
        args.putBoolean(CANCEL_ON_TOUCH_OUTSIDE, cancelOnTouchOutside);
        args.putString(POSITIVE_BUTTON, null);
        args.putString(NEGATIVE_BUTTON, null);
        args.putBundle(PARAMS, params);

        frag.setArguments(args);

        return frag;
    }

    public static AlertDialogFragment newInstance(int tag, String title, String message, String positiveLabel, String negativeLabel) {
        return newInstance(tag, title, message, positiveLabel, negativeLabel, null);
    }

    public static AlertDialogFragment newInstance(int tag, String title, String message, String positiveLabel, String negativeLabel, Bundle params) {
        AlertDialogFragment frag = new AlertDialogFragment();

        Bundle args = new Bundle();
        args.putInt(TAG, tag);
        args.putString(TITLE, title);
        args.putString(MESSAGE, message);
        args.putString(POSITIVE_BUTTON, positiveLabel);
        args.putString(NEGATIVE_BUTTON, negativeLabel);
        args.putBoolean(SHOW_NEGATIVE_BUTTON, true);
        args.putBoolean(SHOW_CHECKBOX, false);
        args.putBoolean(TITLE_MESSAGE_AS_STRING, true);
        args.putBundle(PARAMS, params);

        frag.setArguments(args);

        return frag;
    }


    public static AlertDialogFragment newInstance(int tag, String title, String message, int checkbox) {
        return newInstance(tag, title, message, checkbox, true, true, true, null);
    }

    public static AlertDialogFragment newInstance(int tag, String title, String message, int checkbox, boolean showNegativeButton, boolean cancelable, boolean cancelOnTouchOutside, Bundle params) {
        AlertDialogFragment frag = new AlertDialogFragment();

        Bundle args = new Bundle();
        args.putInt(TAG, tag);
        args.putString(TITLE, title);
        args.putString(MESSAGE, message);
        args.putInt(CHECKBOX, checkbox);
        args.putBoolean(SHOW_CHECKBOX, true);
        args.putBoolean(SHOW_NEGATIVE_BUTTON, showNegativeButton);
        args.putBoolean(TITLE_MESSAGE_AS_STRING, true);
        args.putBoolean(CANCELABLE, cancelable);
        args.putBoolean(CANCEL_ON_TOUCH_OUTSIDE, cancelOnTouchOutside);
        args.putString(POSITIVE_BUTTON, null);
        args.putString(NEGATIVE_BUTTON, null);
        args.putBundle(PARAMS, params);

        frag.setArguments(args);

        return frag;
    }

    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final Bundle args = getArguments();
        String message;
        String title;
        String positiveButton = null;
        String negativeButton = null;

        if (!args.getBoolean(TITLE_MESSAGE_AS_STRING)) {
            int messageId = args.getInt(MESSAGE);
            int titleId = args.getInt(TITLE);
            int positiveButtonId = args.getInt(POSITIVE_BUTTON);
            int negativeButtonId = args.getInt(NEGATIVE_BUTTON);
            message = getString(messageId);
            title = getString(titleId);
            positiveButton = getString(positiveButtonId);
            negativeButton = getString(negativeButtonId);
        } else {
            message = args.getString(MESSAGE);
            title = args.getString(TITLE);
            positiveButton = args.getString(POSITIVE_BUTTON);
            negativeButton = args.getString(NEGATIVE_BUTTON);
        }

        builder.setTitle(title);

        final View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_alert_checkbox, null);
        final TextView textView = (TextView) view.findViewById(android.R.id.text1);
        final CheckBox checkBoxView = (CheckBox) view.findViewById(android.R.id.checkbox);

        textView.setText(message);

        if (args.getBoolean(SHOW_CHECKBOX, false)) {
            int checkbox = args.getInt(CHECKBOX);
            checkBoxView.setText(checkbox);
            checkBoxView.setVisibility(View.VISIBLE);
            checkBoxView.setChecked(args.getBoolean(CHECKBOX_CHECKED, false));
        } else {
            checkBoxView.setVisibility(View.GONE);
        }

        builder.setView(view);

        builder.setPositiveButton(positiveButton == null ? getString(android.R.string.yes) : positiveButton, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (getActivity() instanceof IAlertDialogFragment) {
                    ((IAlertDialogFragment) getActivity()).onAlertDialogPositiveButton(args.getInt(TAG), checkBoxView.isChecked(), args.getBundle(PARAMS));
                }
            }
        });

        if (args.getBoolean(SHOW_NEGATIVE_BUTTON, false)) {
            builder.setNegativeButton(negativeButton == null ? getString(android.R.string.no) : negativeButton, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    if (getActivity() instanceof IAlertDialogFragment) {
                        ((IAlertDialogFragment) getActivity()).onAlertDialogNegativeButton(args.getInt(TAG), checkBoxView.isChecked(), args.getBundle(PARAMS));
                    }
                }
            });
        }
        setCancelable(args.getBoolean(CANCELABLE));

        AlertDialog d = builder.create();
        d.setCanceledOnTouchOutside(args.getBoolean(CANCEL_ON_TOUCH_OUTSIDE));
        return d;
    }
}