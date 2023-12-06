import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.utslabmdhafin.Goal
import com.example.utslabmdhafin.R

class GoalAdapter(private val goalList: ArrayList<Goal>) :
    RecyclerView.Adapter<GoalAdapter.GoalViewHolder>() {

    private var selectedPosition: Int = RecyclerView.NO_POSITION

    inner class GoalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val goalNameTv: TextView = itemView.findViewById(R.id.button_goal)

        init {
            goalNameTv.setOnClickListener {
                handleButtonClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_view_goal, parent, false)
        return GoalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return goalList.size
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        val category = goalList[position]
        holder.goalNameTv.text = category.goalName

        // Highlight the selected button
        if (position == selectedPosition) {
            holder.goalNameTv.setBackgroundResource(R.drawable.button_goalblack)
            val textColor = ContextCompat.getColor(holder.itemView.context, R.color.white)
            holder.goalNameTv.setTextColor(textColor)
        } else {
            // Reset the background and text color for non-selected buttons
            holder.goalNameTv.setBackgroundResource(R.drawable.button_goalgrey)
            val textColor = ContextCompat.getColor(holder.itemView.context, R.color.black)
            holder.goalNameTv.setTextColor(textColor)
        }
    }

    private fun handleButtonClick(position: Int) {
        if (selectedPosition != position) {
            // Deselect the previously selected button
            val previousSelectedPosition = selectedPosition
            selectedPosition = position

            // Notify item changes for the previously and newly selected positions
            notifyItemChanged(previousSelectedPosition)
            notifyItemChanged(position)

            // Handle button click actions here if needed
        }
    }
}
