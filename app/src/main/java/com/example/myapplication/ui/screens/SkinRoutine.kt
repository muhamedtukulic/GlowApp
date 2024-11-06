package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.myapplication.ui.screens.SkinType


@Composable
fun SkinRoutine(skinType: SkinType) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Your skin type is: ${skinType.name}")

        when (skinType) {
            SkinType.OILY -> {
                Text("Morning Routine:\n" +
                        "1. Cleanser: Gentle foaming or gel cleanser\n" +
                        "2. Toner: Alcohol-free toner\n" +
                        "3. Serum: Lightweight, oil-free serum (niacinamide, salicylic acid)\n" +
                        "4. Moisturizer: Non-comedogenic, oil-free moisturizer\n" +
                        "5. Sunscreen: Mattifying sunscreen (SPF 30+)\n\n" +
                        "Evening Routine:\n" +
                        "1. Cleanser: Double cleanse\n" +
                        "2. Exfoliant: Chemical exfoliant (salicylic acid) 2-3 times a week\n" +
                        "3. Toner: Alcohol-free toner\n" +
                        "4. Serum: Treatment serum (retinol, AHA/BHA)\n" +
                        "5. Moisturizer: Light, non-comedogenic moisturizer")
            }
            SkinType.COMBINED -> {
                Text("Morning Routine:\n" +
                        "1. Cleanser: Gentle, balancing cleanser\n" +
                        "2. Toner: Hydrating, alcohol-free toner\n" +
                        "3. Serum: Hyaluronic acid serum and niacinamide\n" +
                        "4. Moisturizer: Lightweight, gel-based moisturizer\n" +
                        "5. Sunscreen: Broad-spectrum sunscreen (SPF 30+)\n\n" +
                        "Evening Routine:\n" +
                        "1. Cleanser: Double cleanse\n" +
                        "2. Exfoliant: Gentle exfoliant (lactic acid) 2-3 times a week\n" +
                        "3. Toner: Hydrating toner\n" +
                        "4. Serum: Hydrating serum and treatment serum for oily areas\n" +
                        "5. Moisturizer: Lightweight, non-comedogenic moisturizer")
            }
            SkinType.DRY -> {
                Text("Morning Routine:\n" +
                        "1. Cleanser: Hydrating, non-foaming cleanser\n" +
                        "2. Toner: Hydrating toner (glycerin, hyaluronic acid)\n" +
                        "3. Serum: Hydrating serum (hyaluronic acid, vitamin C)\n" +
                        "4. Moisturizer: Rich, hydrating moisturizer\n" +
                        "5. Sunscreen: Hydrating sunscreen (SPF 30+)\n\n" +
                        "Evening Routine:\n" +
                        "1. Cleanser: Hydrating, non-foaming cleanser\n" +
                        "2. Exfoliant: Gentle exfoliant (lactic acid) 1-2 times a week\n" +
                        "3. Toner: Hydrating toner\n" +
                        "4. Serum: Hydrating serum (hyaluronic acid, peptides)\n" +
                        "5. Moisturizer: Rich, hydrating moisturizer\n" +
                        "6. Oil: Facial oil for extra hydration (if needed)")
            }
        }
    }
}
