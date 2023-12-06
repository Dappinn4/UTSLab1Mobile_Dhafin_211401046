package com.example.utslabmdhafin

import GoalAdapter
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryList:ArrayList<Category>
    private lateinit var categoryAdapter: CategoryAdapter

    private lateinit var recyclerViewPo: RecyclerView
    private lateinit var popularList:ArrayList<Popular>
    private lateinit var popularAdapter: PopularAdapter

    private lateinit var recyclerViewMe: RecyclerView
    private lateinit var mealPlansList:ArrayList<MealPlans>
    private lateinit var mealPlansAdapter: MealPlansAdapter

    private lateinit var recyclerViewGo: RecyclerView
    private lateinit var goalList:ArrayList<Goal>
    private lateinit var goalAdapter: GoalAdapter

    private lateinit var recyclerViewAd: RecyclerView
    private lateinit var additionalList:ArrayList<Additional>
    private lateinit var additioalAdapter: AdditionalAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

    private fun init(){
        recyclerView = findViewById(R.id.recylerView_Category)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this , RecyclerView.HORIZONTAL , false)
        val snapHelper :  SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        categoryList = ArrayList()

        recyclerViewPo = findViewById(R.id.recylerView_Popular)
        recyclerViewPo.setHasFixedSize(true)
        recyclerViewPo.layoutManager = LinearLayoutManager(this , RecyclerView.VERTICAL , false)
        snapHelper.attachToRecyclerView(recyclerViewPo)
        popularList = ArrayList()

        recyclerViewMe = findViewById(R.id.recylerView_MealPlans)
        recyclerViewMe.setHasFixedSize(true)
        recyclerViewMe.layoutManager = LinearLayoutManager(this , RecyclerView.VERTICAL , false)
        snapHelper.attachToRecyclerView(recyclerViewMe)
        mealPlansList = ArrayList()

        recyclerViewGo = findViewById(R.id.recylerView_Goal)
        recyclerViewGo.setHasFixedSize(true)
        recyclerViewGo.layoutManager = LinearLayoutManager(this , RecyclerView.HORIZONTAL , false)
        snapHelper.attachToRecyclerView(recyclerViewGo)
        goalList = ArrayList()

        recyclerViewAd = findViewById(R.id.recylerView_AdditionalExercise)
        recyclerViewAd.setHasFixedSize(true)
        recyclerViewAd.layoutManager = LinearLayoutManager(this , RecyclerView.VERTICAL , false)
        snapHelper.attachToRecyclerView(recyclerViewAd)
        additionalList = ArrayList()

        addDataToList()

        categoryAdapter = CategoryAdapter(categoryList)
        recyclerView.adapter = categoryAdapter

        popularAdapter = PopularAdapter(popularList)
        recyclerViewPo.adapter = popularAdapter

        mealPlansAdapter = MealPlansAdapter(mealPlansList)
        recyclerViewMe.adapter = mealPlansAdapter

        goalAdapter = GoalAdapter(goalList)
        recyclerViewGo.adapter = goalAdapter

        additioalAdapter = AdditionalAdapter(additionalList)
        recyclerViewAd.adapter = additioalAdapter
    }

    private fun addDataToList() {
        categoryList.add(Category(R.drawable.yoga, "Yoga"))
        categoryList.add(Category(R.drawable.gym, "Gym"))
        categoryList.add(Category(R.drawable.cardio, "Cardio"))
        categoryList.add(Category(R.drawable.stretch, "Stretch"))
        categoryList.add(Category(R.drawable.croppedfullbody, "Full Body"))

        popularList.add(Popular(R.drawable.womanstretching, "Full Shot Woman Stretching Arm", "30 Min"))
        popularList.add(Popular(R.drawable.looking_shocked, "Athlete Practicing Monochrome", "50 Min"))

        mealPlansList.add(MealPlans(R.drawable.greeksalad, "Greek salad with lettuce, green onion, ", "150 kcal"))
        mealPlansList.add(MealPlans(R.drawable.salad_of_fresh_vegetables, "Salad of fresh vegetables", "270 kcal"))

        goalList.add(Goal("Loose Weight"))
        goalList.add(Goal("Gain Weight"))
        goalList.add(Goal("Body Building"))
        goalList.add(Goal("Healthy"))

        additionalList.add(Additional(R.drawable.jumping_bg, R.drawable.jumping_rope, "Exercises with Jumping Rope","10 min"))
        additionalList.add(Additional(R.drawable.holdingjumping_bg, R.drawable.holding_jumping_rope, "Exercises with Holding Jumping Rope","8 min"))
        additionalList.add(Additional(R.drawable.dumbbells_bg, R.drawable.sitting_dumbbells, "Exercises with Sitting Dumbbells","5 min"))
    }
}