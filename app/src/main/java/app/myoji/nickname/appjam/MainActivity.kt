package app.myoji.nickname.appjam

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//残り時間のセット
    var second = 10
//タイマーを設定する
    val timer : CountDownTimer = object : CountDownTimer(100000,1000) {
        //タイマーが終了するときに呼ばれる
        override fun onFinish() {
            //スタートボタンを表示する
            startButton.isVisible = true
            //残り時間をリセットする
            second = 10
            //時間の表示をもとに戻す
            secondText.text = second.toString()
        }

    override fun onTick(millisUntilFinished: Long) {
        //残り時間を1秒ずつ減らす
        second = second - 1
        //残り時間を表示する
        secondText.text = second.toString()
    }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //残り時間を表示
        secondText.text = second.toString()

        secondText.isVisible = false
        timeLabelText.isVisible = false

        //スタートボタンが押されたとき、スタートボタンを見えない状態にする
        startButton.setOnClickListener {

            startButton.isVisible = false

            secondText.isVisible = true
            timeLabelText.isVisible = true

            //タイマーを開始する
            timer.start()
        }



        }
    }

