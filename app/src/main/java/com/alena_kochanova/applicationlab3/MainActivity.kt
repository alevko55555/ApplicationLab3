package com.alena_kochanova.applicationlab3


import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import kotlin.random.Random
import android.widget.ProgressBar


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var recyclerViewF: RecyclerView
    private lateinit var viewAdapterF: RecyclerView.Adapter<*>
    private lateinit var viewManagerF: RecyclerView.LayoutManager
    public var is_bool = 0

    data class CarCategory(val actor: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text2.text = "АВТО-ЛАБОРАТОРИЯ.РФ занимается регистрацией изменений в конструкции ТС." +
                " Предоставляем помощь, как при самостоятельной регистрации, так и при переоборудовании под ключ. Работаем по всей России."

        val list: List<CarCategory> = listOf(
            CarCategory("Замена ДВС"),
            CarCategory("Смена категории"),
            CarCategory("Установка фаркопа"),
            CarCategory("Тюнинг"),
            CarCategory("Увеличенные колеса"),
            CarCategory("Усиленный бампер"),
            CarCategory("Установка ГБО"),
            CarCategory("Регистрация учебного авто")
        )


        val list2: List<String> = listOf("Буханка", "Газель", "BMW E39",
            "IVECO", "RENAULT Logan", "Nissan",
            "Mitsubishi Pajero", "Соболь", "Ford Fiesta"
        )

        viewManager = LinearLayoutManager(this)
        viewAdapter = ListAdapter()
        (viewAdapter as ListAdapter).dataF = list

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view_car_vid).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        viewManagerF = LinearLayoutManager(this)
        viewAdapterF = ListAdapter2()
        (viewAdapterF as ListAdapter2).data = list2
        recyclerViewF = findViewById<RecyclerView>(R.id.recycler_view_cars).apply {
            setHasFixedSize(true)
            layoutManager = viewManagerF
            adapter = viewAdapterF
        }



        button.setOnClickListener {
            val cardView = CardView(this)

            // Initialize a new LayoutParams instance, CardView width and height
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, // CardView width
                LinearLayout.LayoutParams.WRAP_CONTENT // CardView height
            )

            // Set margins for card view
            layoutParams.setMargins(20, 20, 20, 20)
            // Set the card view layout params
            cardView.layoutParams = layoutParams
            // Set the card view corner radius
            cardView.radius = 16F
            // Set the card view content padding
            cardView.setContentPadding(25,25,25,25)
            // Set the card view background color
            cardView.setCardBackgroundColor(Color.LTGRAY)
            // Set card view elevation
            cardView.cardElevation = 8F
            // Set card view maximum elevation
            cardView.maxCardElevation = 12F

            // Set a click listener for card view
            cardView.setOnClickListener{
                Toast.makeText(
                    applicationContext,
                    "Наш клиент",
                    Toast.LENGTH_SHORT).show()
            }
            // Add an ImageView to the CardView
            cardView.addView(generateImageView())

            // Finally, add the CardView in root layout
            root_layout.addView(cardView)
        }
    }

    fun openMe(view: View) {
        val myToast = Toast.makeText(this, "Машины", Toast.LENGTH_SHORT)
        myToast.show()
        click(text_count)
    }

    fun click(view: View) {
        val countString = text_count.text.toString()

        var count: Int = Integer.parseInt(countString.toString())
        count++
        text_count.text = count.toString();
    }

    private fun generateImageView(): ImageView {
        val images: Array<Int> = arrayOf(R.drawable.bmw, R.drawable.buhanka, R.drawable.ford,
        R.drawable.gazel, R.drawable.iveco, R.drawable.logan, R.drawable.nissan, R.drawable.pajero, R.drawable.sobol)

        val imageView = ImageView(this)
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 300)
        imageView.layoutParams = params

        val random = Random(System.currentTimeMillis())
        imageView.setImageResource(images[random.nextInt(images.size - 1)])
        imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
        return imageView
    }

}