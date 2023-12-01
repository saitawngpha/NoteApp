package com.saitawngpha.koinexample.di

import com.saitawngpha.koinexample.repository.DatabaseRepository
import com.saitawngpha.koinexample.viewmodel.DatabaseViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @Author: ၸၢႆးတွင်ႉၾႃႉ
 * @Date: 01/12/2023.
 */

val databaseModule = module {
    single { provideDatabase(androidContext()) }
    single { provideDao(get()) }
    factory { DatabaseRepository(get()) }
    viewModel() {DatabaseViewModel(get())}
}
