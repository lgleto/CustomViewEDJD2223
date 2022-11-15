package ipca.example.customcontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewWarning = findViewById<TextView>(R.id.textViewWarning)
        textViewWarning.text = "hello"

        val verticalSliderLeft = findViewById<VerticalSlider>(R.id.verticalSliderLeft)
        val verticalSliderRight = findViewById<VerticalSlider>(R.id.verticalSliderRight)


        textViewWarning.text = "hello${verticalSliderLeft.percent}"


    }

}