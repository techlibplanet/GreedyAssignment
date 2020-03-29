package com.mpokket.koindi

import com.greedyassignment.viewmodels.RedditImageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule =
    module(override = true) {

        viewModel {
            RedditImageViewModel(redditRepositoryService = get())
        }
    }
