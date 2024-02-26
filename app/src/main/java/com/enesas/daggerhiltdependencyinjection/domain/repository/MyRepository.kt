package com.enesas.daggerhiltdependencyinjection.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()
}