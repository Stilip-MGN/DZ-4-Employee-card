package studio.stilip.employeecard

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import studio.stilip.employeecard.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private val adapter =
        RewardAdapter { name -> Toast.makeText(this, name, Toast.LENGTH_SHORT).show() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        adapter.addList(
            listOf(
                Reward(R.drawable.reward_cup, "Победитель"),
                Reward(R.drawable.reward_cup, "Победитель"),
                Reward(R.drawable.reward_cup, "Победитель"),
                Reward(R.drawable.reward_cup, "Победитель"),
                Reward(R.drawable.reward_cup, "Победитель"),
                Reward(R.drawable.reward_cup, "Победитель")
            )
        )
        binding.btnCall.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:${binding.content.phoneNumberField.text}")
            )
            startActivity(intent)
        }

        with(binding.content) {
            photo.setImageResource(R.drawable.avatar)
            fullName.text = "Кратчук Полина Максимовна"
            locationField.text = "Екатеринбург"
            timeWorking.text = "4 года 7 месяцев"
            btnPosition.text = "Ведущий инженер-программист (3 категории, моб.)"
            birthdayField.text = getString(R.string.date_birthday)
            description.text = getString(R.string.info)
            phoneNumberField.text = getString(R.string.tel)
            emailField.text = getString(R.string.mail)
            recyclerReward.layoutManager =
                LinearLayoutManager(this@ProfileActivity, LinearLayoutManager.HORIZONTAL, false)
            recyclerReward.adapter = adapter

            btnPosition.setOnClickListener {
                AlertDialog.Builder(this@ProfileActivity)
                    .setNegativeButton("Cancel") { d, _ ->
                        d.dismiss()
                    }
                    .setMessage(getString(R.string.alert_info))
                    .create()
                    .show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> this.finish()
        }

        return super.onOptionsItemSelected(item)
    }
}