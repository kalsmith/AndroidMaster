package settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kal.androidmaster.R
import com.kal.androidmaster.databinding.ActivitySettingsBinding
import com.kal.androidmaster.databinding.ActivitySuperHeroListBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}