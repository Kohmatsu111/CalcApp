package jp.techacademy.masahiro.kohmatsu.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.widget.EditText

// リスナクラスの設定：
// MainActivity クラスに View.OnClickListener インターフェースを実装
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //button1～4にリスナを設定する：クリックに対するリスナー
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    // イベントハンドラ：リスナが検知した時に実行する処理
    override fun onClick(v: View){
        //数字入力欄　EditText1 からオブジェクト input1 を取得
        val input1 =  findViewById<EditText>(R.id.editText1)
        //数字入力欄　EditText2 からオブジェクト input2 取得
        val input2 =  findViewById<EditText>(R.id.editText2)

        //Editable 型のinput1とinput2をそれぞれ、String型の input3,4 として取得
        val input3 = input1.toString()
        val input4 = input2.toString()

        //直下の四則演算に使用する 変数ver を定義
        var total: Float? = null

        // button1 をクリックすると、editText1 と editText2 に入力した
        // 2つの値をwhen文で各四則演算毎に条件を与え、それぞれの値に対応できるよう、定数ではなく、
        // 変数 var totalで取得
        when{
            (v.id == R.id.button1)
                -> var total = input3.toFloat() + input4.toFloat()
            (v.id == R.id.button2)
                -> var total = input3.toFloat() - input4.toFloat()
            (v.id == R.id.button3)
                -> var total = input3.toFloat() * input4.toFloat()
            (v.id == R.id.button4)
                -> var total = input3.toFloat() / input4.toFloat()
        }
        // Intent のインスタンスを作成
        val intent = Intent(this, SecondActivity::class.java)
        // 第2画面に送るデータを格納
        intent.putExtra("total",total)
        // 第2画面の起動
        startActivity(intent)
    }
}
