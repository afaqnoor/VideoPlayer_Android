package com.example.firstapp_timervideo
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var myButton: Button
    private lateinit var countdownTextView: TextView
    private lateinit var countDownTimer: CountDownTimer
    private var timerIsRunning = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



               myButton = findViewById(R.id.timerButton)
                countdownTextView = findViewById(R.id.timerTextVier)
                // Initialize the countdown timer
                countDownTimer = object : CountDownTimer(10000, 1000) { // 10 seconds with a 1-second interval
            override fun onTick(millisUntilFinished: Long) {
                // This method is called on each tick (every second in this case)
                val secondsRemaining = millisUntilFinished / 1000
                countdownTextView.text = "$secondsRemaining"
            }
            override fun onFinish() {
                // This method is called when the countdown timer finishes
                countdownTextView.text = "00:00"
                var intent = Intent(this@MainActivity, VideoPlayerActivity ::class.java)
                startActivity(intent)
//                myButton.isEnabled = true
                timerIsRunning = false
            }
        }
                myButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (!timerIsRunning) {
                    // Start the countdown timer
                    countDownTimer.start()
                    myButton.isEnabled = false
                    timerIsRunning = true
                }
            }
        })



    }
}