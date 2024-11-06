package com.example.myapplication.ui.screens


import PostViewModel
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.viewmodel.AppViewModelProvider


data class Page(
    val Title :String,
    val Description: String,
    @DrawableRes val Image:Int?
)
val Pages= listOf(
Page(
    Title= "Hey there skincare enthusiasts! Ever\n" +
            "wondered why your fav skincare products\n" +
            "consist of ingredients like hyaluronic acid,\n" +
            "ceramides, and more? Well, I can tell you,\n" +
            "they're not just your average ingredients.\n" +
            "These ingredients have a special connection\n" +
            "to your own skin, more specifically the\n" +
            "outer-most layer: the skin barrier.\n" +
            "Now, for those, who are wondering what the\n" +
            "skin barrier is - it acts as the fortress walls of\n" +
            "your skin, scientifically known as the stratum\n" +
            "corneum. This layer isn't just hanging out;\n" +
            "it's on a mission! It's the first line of defense\n" +
            "against anything that tries to mess with your\n" +
            "glow - irritants, allergens, infections, you\n" +
            "name it!",
    Description = "",
    Image = R.drawable.b2
),
    Page(
        Title="Digging deeper into the skin's most outer layer" ,
        Description = buildString {

            append("\u2022 Use gentle cleansers to remove dirt, oil, and impurities without stripping the skin's natural oils.\n")
            append("\u2022 Consider double cleansing with an oil-based cleanser followed by a water-based cleanser for thorough cleansing.\n")
            append("\u2022 ncorporate chemical exfoliants like AHAs (alpha hydroxy acids) or BHAs (beta hydroxy acids) to remove dead skin cells and promote cell turnover.\n")
            append("\u2022 Limit physical exfoliation to 1-2 times per week to avoid over-exfoliating and irritating the skin.\n")
            append("\u2022 Choose a moisturizer suitable for your skin type (dry, oily, combination) to maintain skin hydration.\n")
        },
        Image =null
    ), Page(
        Title= "Into the Skin-verse serums",
        Description = buildString {

            append("\u2022 Serums are lightweight skincare products with a high concentration of active ingredients designed to target specific skin concerns such as hydration, brightening, or anti-aging.\n")
            append("\u2022 They are formulated with smaller molecules that allow deeper penetration into the skin, delivering potent ingredients like vitamins, antioxidants, and peptides directly to the target area.\n")
            append("\u2022 Serums are typically applied after cleansing and toning but before moisturizing, allowing them to penetrate the skin effectively and work their magic.\n")
            append("\u2022 Different serums cater to different skin types and concerns, so it's essential to choose one that suits your skin type (dry, oily, combination) and addresses your specific needs (anti-aging, acne-prone, hyperpigmentation).\n")

        },
        Image = R.drawable.b11
    )
)

@Preview(showBackground = true)
@Composable
fun PagerScreenpreview(
    viewModel: PostViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    PagerScreen(viewModel = viewModel)
}
