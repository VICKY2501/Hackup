package com.example.lineup_contests
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lineup_contests.databinding.RecyclerdataBinding

class LuAdapter(val listener:Rvlisten) :
    ListAdapter<ContestsItem, LuAdapter.FoodPhotosViewHolder>(DiffCallback) {

    /**
     * The MarsPhotosViewHolder constructor takes the binding variable from the associated
     * GridViewItem, which nicely gives it access to the full [MarsPhoto] information.
     */
    inner class FoodPhotosViewHolder(
        private var binding: RecyclerdataBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(foodPhoto: ContestsItem) {
            binding.codes= foodPhoto
            binding.executePendingBindings()
            itemView.setOnClickListener{
                listener.onclicked(foodPhoto)
            }
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of
     * [MarsPhoto] has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<ContestsItem>() {
        override fun areItemsTheSame(oldItem: ContestsItem, newItem: ContestsItem): Boolean {
            return oldItem.duration == newItem.duration
        }

        override fun areContentsTheSame(oldItem: ContestsItem, newItem: ContestsItem): Boolean {
            return oldItem.end_time== newItem.end_time
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodPhotosViewHolder {
        return FoodPhotosViewHolder(
            RecyclerdataBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: FoodPhotosViewHolder, position: Int) {
        val foodPhoto = getItem(position)
        holder.bind(foodPhoto)
    }
}
interface Rvlisten
{
    fun onclicked(hit:ContestsItem)
}
//class LuAdapter (val listener : RVListener) : RecyclerView.Adapter<LuAdapter.RecipeViewHolder>() {
//
//    var allContests : ArrayList<contestsItem> = ArrayList()
//
//
//    inner class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view){
//        val site_name: TextView = view.findViewById(R.id.site_name)
//        val title : TextView = view.findViewById(R.id.contest_name)
//        val start_date: TextView = view.findViewById(R.id.start_date)
//        val before: TextView = view.findViewById(R.id.before)
//        fun  bind(curr : contestsItem){
//            this.site_name.text = curr.site
//            this.title.text = curr.name
//            this.start_date.text = curr.start_time.subSequence(0,10)
//            this.before.text = curr.in_24_hours
//            itemView.setOnClickListener {
//                listener.onClicked(curr)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_view, parent, false)
//        return RecipeViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
//        val currContest = allContests[position]
//        holder.bind(currContest)
//    }
//
//    override fun getItemCount(): Int = allContests.size
//
//    fun updateList(arr: contests){
//        allContests.clear()
//        allContests = arr
//        notifyDataSetChanged()
//    }
//}
//
//interface RVListener {
//    fun onClicked(curr_cont: contestsItem)
//}