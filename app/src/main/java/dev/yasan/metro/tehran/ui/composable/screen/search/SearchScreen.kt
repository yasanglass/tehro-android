package dev.yasan.metro.tehran.ui.composable.screen.search

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import dev.yasan.kit.compose.foundation.grid
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.model.misc.LaunchSource
import dev.yasan.metro.tehran.ui.composable.common.teh.TehFooter
import dev.yasan.metro.tehran.ui.composable.common.teh.TehScreen
import dev.yasan.metro.tehran.ui.composable.screen.line.modules.StationItem
import dev.yasan.metro.tehran.ui.composable.screen.search.modules.SearchField

@OptIn(
    ExperimentalComposeUiApi::class,
    androidx.compose.foundation.ExperimentalFoundationApi::class
)
@Composable
fun SearchScreen(viewModel: SearchViewModel, navController: NavController) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val queryState = rememberSaveable { mutableStateOf("") }
    val results = viewModel.results.observeAsState()
    val resultsList = results.value?.data ?: emptyList()

    TehScreen(title = stringResource(id = R.string.search)) {

        stickyHeader {

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

        item {
            Spacer(modifier = Modifier.requiredHeight(grid()))
        }

        items(
            items = resultsList,
            key = { station -> station.id }
        ) { station ->
            StationItem(
                modifier = Modifier.animateItemPlacement(),
                station = station,
                navController = navController,
                launchSource = LaunchSource.SEARCH,
                onClickExtra = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }
            )
        }

        item {
            AnimatedVisibility(
                visible = resultsList.isNotEmpty(),
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                TehFooter(text = stringResource(R.string.n_stations, resultsList.size))
            }
        }

    }

}