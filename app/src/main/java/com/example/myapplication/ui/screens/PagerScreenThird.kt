package com.example.myapplication.ui.screens




import PostViewModel
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.viewmodel.AppViewModelProvider

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerScreenThird(
    viewModel: PostViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val uiState by viewModel.homeUiState.collectAsState()
    val pagerState = rememberPagerState(initialPage = 0) { uiState.postsList.size }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState,
            pageSpacing = 0.dp,
            userScrollEnabled = true,
            reverseLayout = false,
            beyondBoundsPageCount = 0,
            key = null,
        ) { pageIndex ->
            val adjustedIndex = pageIndex + 6
            if (adjustedIndex < uiState.postsList.size) {
                SingleThirdPage(
                    page = uiState.postsList[adjustedIndex]
                )
            }
        }
    }
}
