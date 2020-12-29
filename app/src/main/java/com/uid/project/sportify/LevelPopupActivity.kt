package com.uid.project.sportify

import android.app.Activity
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity


class LevelPopupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level_selection_popup)

        val seekBar = findViewById<SeekBar>(R.id.levelSeekBar)
        val button = findViewById<Button>(R.id.levelSubmitButton)
        val shape = GradientDrawable()
        shape.cornerRadius = 40f
        shape.setColor(getColor(R.color.purple_sportify))
        button.background = shape

        window.setBackgroundDrawable(ColorDrawable(getColor(R.color.dark_tone_sportify)))
        seekBar.progressDrawable.setColorFilter(
                getColor(R.color.pink_sportify),
                PorterDuff.Mode.SRC_IN
        )
        seekBar.thumb.setColorFilter(getColor(R.color.pink_sportify), PorterDuff.Mode.SRC_IN)

        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra(
                    "sportPosition", this.intent.getIntExtra
            ("sportPosition", -1)
            )
            intent.putExtra("selectedLevel", seekBar.progress)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

}