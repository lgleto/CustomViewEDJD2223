package ipca.example.customcontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewWarning = findViewById<TextView>(R.id.textViewWarning)
        textViewWarning.text = "hello"

        val verticalSliderLeft = findViewById<VerticalSlider>(R.id.verticalSliderLeft)
        val verticalSliderRight = findViewById<VerticalSlider>(R.id.verticalSliderRight)

        val switchLock = findViewById<Switch>(R.id.switchLock)

        switchLock.setOnCheckedChangeListener { compoundButton, b ->
            if (switchLock.isChecked) {
                verticalSliderLeft.percent = verticalSliderRight.percent
            }
        }

        verticalSliderLeft.setOnValueChangeListener {
            if (it > 80F ||
                verticalSliderRight.percent > 80F
            ) {
                textViewWarning.text = "The volume is too loud!"
            }else {
                textViewWarning.text = ""
            }

            if (switchLock.isChecked) {
                verticalSliderRight.percent = verticalSliderLeft.percent
            }

        }

        verticalSliderRight.setOnValueChangeListener {
            if (it > 80F ||
                verticalSliderLeft.percent > 80F
            ){
                textViewWarning.text = "The volume is too loud!"
            }else {
                textViewWarning.text = ""
            }

            if (switchLock.isChecked) {
                verticalSliderLeft.percent = verticalSliderRight.percent
            }
        }




    }

}