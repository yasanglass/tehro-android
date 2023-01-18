package dev.yasan.metro.tehran.presentation.compose.screen.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import dev.yasan.metro.tehran.R
import dev.yasan.metro.tehran.domain.entity.line.Line
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehFooter
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehProgress
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehScreen
import dev.yasan.metro.tehran.presentation.compose.common.teh.TehSwitchable
import dev.yasan.metro.tehran.presentation.compose.screen.line.modules.StationItem
import dev.yasan.metro.tehran.presentation.compose.screen.search.modules.SearchField
import dev.yasan.metro.tehran.presentation.util.entity.LaunchSource
import dev.yasan.metro.tehran.presentation.util.helper.LocaleHelper
import glass.yasan.kit.compose.foundation.grid
import glass.yasan.kit.core.Resource

@OptIn(
    ExperimentalComposeUiApi::class,
    androidx.compose.foundation.ExperimentalFoundationApi::class
)
@Composable
fun SearchScreen(viewModel: SearchViewModel, navController: NavController) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val queryState = rememberSaveable { mutableStateOf("") }
    val groupEnabled = rememberSaveable { mutableStateOf(true) }

    val results = viewModel.results.observeAsState(initial = Resource.Initial())
    val loading = viewModel.loading.observeAsState(initial = true)

    val resultsList = results.value.data ?: emptyList()

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
            TehSwitchable(
                title = stringResource(R.string.group_by_line),
                fontFamily = LocaleHelper.properFontFamily,
                getter = { groupEnabled.value },
                setter = { groupEnabled.value = it }
            )
        }

        item {
            AnimatedVisibility(
                visible = loading.value,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                TehProgress()
            }
        }

        item {
            AnimatedVisibility(
                visible = !groupEnabled.value,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Spacer(modifier = Modifier.requiredHeight(grid()))
            }
        }

        if (groupEnabled.value) {
            val groupedResults = resultsList.groupBy { it.line }
                .toSortedMap(compareBy<Line?> { it?.id ?: 0 }.thenBy { it?.name ?: "" })

            groupedResults.forEach { group ->

                item {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = grid(2))
                            .padding(top = grid(2), bottom = grid()),
                        text = (
                            group.key?.getFullName(context = context)
                                ?: stringResource(id = R.string.line)
                            ).uppercase(),
                        color = colorResource(id = R.color.text_title),
                        fontFamily = LocaleHelper.properFontFamily,
                        fontWeight = FontWeight.Bold
                    )
                }

                items(
                    items = group.value,
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
            }
        } else {
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
        }

        item {
            AnimatedVisibility(
                visible = queryState.value.isNotBlank() && resultsList.isEmpty(),
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                TehFooter(text = stringResource(R.string.no_stations_found))
            }
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
