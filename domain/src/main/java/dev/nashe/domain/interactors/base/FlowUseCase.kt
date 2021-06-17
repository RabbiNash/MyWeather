package dev.nashe.domain.interactors.base

import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<T, in Params> {
    abstract suspend operator fun invoke(params: Params? = null): Flow<T>
}