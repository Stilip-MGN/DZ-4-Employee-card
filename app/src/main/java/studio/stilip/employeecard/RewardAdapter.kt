package studio.stilip.employeecard

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import studio.stilip.employeecard.databinding.CardRewardBinding

class RewardAdapter(private val clickListener: (String) -> Unit) :
    RecyclerView.Adapter<RewardAdapter.RewardHolder>() {

    private var rewards: List<Reward> = emptyList()

    class RewardHolder(val viewBinding: CardRewardBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardHolder {
        val binding = CardRewardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RewardHolder(binding)
    }

    override fun onBindViewHolder(holder: RewardHolder, position: Int) {
        with(holder.viewBinding) {
            val item = rewards[position]
            name.text = item.name
            logo.setImageResource(item.imageSrc)
        }

        holder.itemView.setOnClickListener {
            clickListener.invoke(rewards[position].name)
        }
    }

    override fun getItemCount(): Int {
        return rewards.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<Reward>) {
        rewards = list
        notifyDataSetChanged()
    }
}