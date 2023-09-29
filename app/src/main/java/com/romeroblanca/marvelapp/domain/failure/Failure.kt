package com.romeroblanca.marvelapp.domain.failure

interface Failure {
    object UnknownFailure : Failure
    object NetworkConnectionFailure: Failure
}