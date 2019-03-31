package com.websarva.wings.viewsample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class OrderConfirmDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // ダイアログビルダーを生成。
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // ダイアログのタイトルを設定。
        builder.setTitle(R.string.dialog_title);

        // ダイアログのメッセージを設定。

        if (getArguments() != null){  // 引数が渡される場合
            String message = (String) getArguments().get("msg");
            builder.setMessage(message);
        }

        // ダイアログのバタンのリスナを生成。
        DialogButtonClickListener listener = new DialogButtonClickListener();

        // Positive Buttonを設定。
        builder.setPositiveButton(R.string.dialog_btn_ok, listener);

        // NegativeButtonを設定。
        builder.setNegativeButton(R.string.dialog_btn_ng, listener);

        // Neutral(中立的) Buttonを設定。
        builder.setNeutralButton(R.string.dialog_btn_nu, listener);

        // ダイアログオブジェクトを生成し、リターン。
        AlertDialog dialog = builder.create();
        return dialog;
    }

    /**
     * ダイアログのアクションボタンがタップされた時の処理が記述されたメンバクラス
     * Positive, Negative, Neutralボタンのリスナ
     */
    private class DialogButtonClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            // トーストメッセージ用文字列変数を用意。
            String msg = "";

            // タップされたアクションボタンで分岐。
            switch (which) {
                // Positiveボタンの場合
                case DialogInterface.BUTTON_POSITIVE :
                    msg = getString(R.string.dialog_ok_toast);
                    break;

                // Negativeボタンの場合
                case DialogInterface.BUTTON_NEGATIVE:
                    msg = getString(R.string.dialog_ng_toast);
                    break;

                // Neutralボタンの場合
                case DialogInterface.BUTTON_NEUTRAL:
                    msg = getString(R.string.dialog_nu_toast);
                    break;
            }

            // トーストの表示。
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }
    }
}
