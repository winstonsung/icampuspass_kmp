package com.itocc.icampuspass.di

import com.itocc.icampuspass.data.AppRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule: Module = module {
    single<AppRepository> {
        AppRepository().apply {
            init()
        }
    }

    single<HttpClient> {
        HttpClient {
            val json: Json = Json { ignoreUnknownKeys = true }

            install(plugin = ContentNegotiation) {
                json(json = json)
            }

            install(plugin = HttpCookies)
        }
    }
}

fun initKoin() = initKoin(extraModules = emptyList())

fun initKoin(extraModules: List<Module>) {
    startKoin {
        modules(
            dataModule,
            *extraModules.toTypedArray(),
        )
    }
}
