package com.sandhu.blinknews.presentation.nvgraph

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.sandhu.blinknews.domain.model.Article
import com.sandhu.blinknews.presentation.details.DetailsScreen
import com.sandhu.blinknews.presentation.home.HomeScreen
import com.sandhu.blinknews.presentation.home.HomeViewModel
import com.sandhu.blinknews.presentation.onboarding.OnBoardingScreen
import com.sandhu.blinknews.presentation.onboarding.OnBoardingViewModel
import com.sandhu.blinknews.presentation.search.SearchScreen
import com.sandhu.blinknews.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination){

        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(
                route = Route.OnBoardingScreen.route
            ){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    onEvent = viewModel::onEvent,
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
            composable(
                route = Route.NewsNavigatorScreen.route
            ){
                val viewModel: HomeViewModel = hiltViewModel()
                val articles = viewModel.news.collectAsLazyPagingItems()
                // FIX: Pass actual navigation lambda instead of empty one
                HomeScreen(
                    articles = articles,
                    navigate = { route ->
                        navController.navigate(route)
                    }
                )
            }

            // FIX: Add SearchScreen composable
            composable(
                route = Route.SearchScreen.route
            ){
                val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen(
                    state = viewModel.state.value,
                    event = viewModel::onEvent,
                    navigate = { route ->
                        navController.navigate(route)
                    }
                )
            }

            composable(
                route = Route.DetailsScreen.route
            ) { backStackEntry ->
                // Retrieve the article from previous back stack entry
                val article = navController.previousBackStackEntry
                    ?.savedStateHandle
                    ?.get<Article>("article")

                if (article != null) {
                    //val viewModel: DetailsViewModel = hiltViewModel() // if you have one
                    DetailsScreen(
                        article = article,
                        event = { /* handle events */ },
                        navigateUp = { navController.navigateUp() }
                    )
                }
            }
        }

        /*navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
            composable(
                route = Route.NewsNavigatorScreen.route
            ){
                val viewModel: HomeViewModel = hiltViewModel()
                val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(articles = articles, navigate = { })
                *//*val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen(state = viewModel.state.value, event = viewModel::onEvent, navigate = { })*//*
            }
        }*/
    }
}