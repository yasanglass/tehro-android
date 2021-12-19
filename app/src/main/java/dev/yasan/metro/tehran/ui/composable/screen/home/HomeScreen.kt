package dev.yasan.metro.tehran.ui.composable.screen.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.composable.common.TehTitle
import dev.yasan.metro.tehran.util.Resource

@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    val lines = viewModel.lines.observeAsState()

    if (lines.value is Resource.Initial) {
        viewModel.loadLines()
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        item {
            TehTitle(title = stringResource(id = R.string.app_name))
        }

        when (lines.value) {
            is Resource.Loading -> {
                item {
                    Text(text = "Loading")
                }
            }
            is Resource.Error -> {
                item {
                    Text(text = "Error")
                }
            }
            is Resource.Success -> {

                item {
                    Text(text = "Success")
                }

                items(lines.value!!.data!!) {
                    Text(text = it.nameEn)
                }

            }
        }

    }

}

@Preview(name = "Home Screen")
@Composable
fun HomeScreenPreview() {
    val viewModel: HomeViewModel = hiltViewModel()
    HomeScreen(viewModel = viewModel)
}