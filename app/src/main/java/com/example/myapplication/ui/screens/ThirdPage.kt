package com.example.myapplication.ui.screens



import PostViewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.viewmodel.AppViewModelProvider

data class ThirdPage(
    val postId: Int,
    val Title: String,
    val Description: String,
    val Image: Int?
)

val ThirPages = listOf(
    ThirdPage(
        postId =1,
        Title = "Unveiling the Mysteries of Skincare Ingredients",
        Description = "Ever wondered why your favorite skincare products contain ingredients like hyaluronic acid, ceramides, and more? These ingredients have a special connection to your skin, particularly the outer-most layer: the skin barrier. This layer acts as the fortress walls of your skin, scientifically known as the stratum corneum. It's the first line of defense against anything that tries to mess with your glow - irritants, allergens, infections, you name it!",
        Image = R.drawable.b1
    ),
    ThirdPage(
        postId = 2,
        Title = "Effective Skincare Routine Tips",
        Description = buildString {
            append(" Use gentle cleansers to remove dirt, oil, and impurities without stripping the skin's natural oils.")
            append(" Consider double cleansing with an oil-based cleanser followed by a water-based cleanser for thorough cleansing.")
            append(" Incorporate chemical exfoliants like AHAs (alpha hydroxy acids) or BHAs (beta hydroxy acids) to remove dead skin cells and promote cell turnover.")
            append(" Limit physical exfoliation to 1-2 times per week to avoid over-exfoliating and irritating the skin.")
            append(" Choose a moisturizer suitable for your skin type (dry, oily, combination) to maintain skin hydration.")
        },
        Image = null
    ),
    ThirdPage(
        postId = 3,
        Title = "Understanding Serums",
        Description = buildString {
            append(" Serums are lightweight skincare products with a high concentration of active ingredients designed to target specific skin concerns such as hydration, brightening, or anti-aging.")
            append(" They are formulated with smaller molecules that allow deeper penetration into the skin, delivering potent ingredients like vitamins, antioxidants, and peptides directly to the target area.")
            append(" Serums are typically applied after cleansing and toning but before moisturizing, allowing them to penetrate the skin effectively and work their magic.")
            append(" Different serums cater to different skin types and concerns, so it's essential to choose one that suits your skin type (dry, oily, combination) and addresses your specific needs (anti-aging, acne-prone, hyperpigmentation).")
        },
        Image = R.drawable.b1
    )
)


@Preview(showBackground = true)
@Composable
fun ThirdPagerScreen(
    viewModel: PostViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    PagerScreenThird(viewModel = viewModel)
}
