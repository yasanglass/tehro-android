package dev.yasan.metro.tehran.ui.composable.screen.search

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.ui.composable.common.teh.TehScreen
import dev.yasan.metro.tehran.ui.composable.screen.line.modules.StationItem
import dev.yasan.metro.tehran.ui.composable.screen.line.modules.StationItemMode
import dev.yasan.metro.tehran.ui.composable.screen.search.modules.SearchField

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(viewModel: SearchViewModel, navController: NavController) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val queryState = rememberSaveable { mutableStateOf("") }

    val noQuery = queryState.value.isBlank()

    val results = viewModel.results.observeAsState()

    TehScreen(title = stringResource(id = R.string.search)) {

        item {

            SearchField(
                value = queryState.value,
                onValueChange = {
                    queryState.value = it
                    viewModel.search(query = it)
                },
                onDone = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }
            )

        }

        items(
            items = results.value?.data ?: emptyList(),
            key = { station -> station.id }) { station ->
            StationItem(
                station = station,
                navController = navController,
                mode = StationItemMode.SearchScreen
            )
        }

    }

}