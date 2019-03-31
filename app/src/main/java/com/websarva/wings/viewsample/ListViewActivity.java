package com.websarva.wings.viewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // ListViewオブジェクトを取得
        ListView lvMenu = findViewById(R.id.lvMenu);

        // リストをタップするリスナを生成
        ListItemClickListener listener = new ListItemClickListener();

        // ListViewにリスナを設定
        lvMenu.setOnItemClickListener(listener);
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        /**
         * List項目の選択肢がタップされる時のイベントハンドラー
         * @param parent タップされたリスト全体
         * @param view タップされた１行分の画面部品そのもの
         * @param position タップされた行番号
         * @param id ID
         */
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // タップされた定食名を取得
            // String item = (String) parent.getItemAtPosition(position);

            TextView tvText = (TextView) view;

            String item = tvText.getText().toString();

            // トーストで表示する文字列を生成
            String show = "あなたが選んだ定食:" + item;

            Log.i("green", show);

            // トーストの表示
            /**
             * show : 表示する内容
             * Toast.LENGTH_LONG : 表示する時間
             */
            Toast.makeText(ListViewActivity.this, show, Toast.LENGTH_LONG).show();

            Log.d("blue", show);
        }
    }
}
