package com.websarva.wings.viewsample;

/**
 * HelloActivityのクラス
 *
 * @author LI
 * @version 1.0.0
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

    /**
     * 挨拶する言葉の定数
     */
    private static final String GREET = "さん、こんにちは。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        // リスナクラスのインスタンスを生成
        HelloListener listener = new HelloListener();

        // 表示ボタンであるButtonオブジェクトを取得
        Button btClick = findViewById(R.id.btClick);

        // 表示ボタンにリスナを設定
        btClick.setOnClickListener(listener);

        // クリアボタンであるButtonオブジェクトを取得
        Button btClear = findViewById(R.id.btClear);

        // クリアボタンにリスナを設定
        btClear.setOnClickListener(listener);

    }

    /**
     * ボタンをクリックしたときのリスなクラス
     */
    private class HelloListener implements View.OnClickListener {

        @Override
        public void onClick (View view) {

            switch (view.getId()) {  // 押下されたボタンのIDを判断する

                case R.id.btClick :  // 表示ボタンである場合
                    this.setContent();
                    break;

                case R.id.btClear :  // クリアボタンである場合
                    this.clearContent();
                    break;
            }
        }

        /**
         * テキストの内容を設定する
         */
        private void setContent () {

            // 名前入力欄であるEditTextオブジェクトを取得
            EditText input = findViewById(R.id.etName);

            // メッセージを表示するTextViewオブジェクトを取得する
            TextView output = findViewById(R.id.tvOutput);

            // 入力された名前文字列を取得
            String inputStr = input.getText().toString();

            // メッセージを表示する
            output.setText(inputStr + GREET);
        }

        /**
         * テキストの内容をクリアする
         */
        private void clearContent () {

            // 入力欄のオブジェクトを取得する
            EditText input = findViewById(R.id.etName);

            // メッセージを表示するTextViewオブジェクトを取得する
            TextView output = findViewById(R.id.tvOutput);

            // 入力欄をクリアする
            input.setText(null);

            // メッセージをクリアする
            output.setText(null);
        }
    }
}
