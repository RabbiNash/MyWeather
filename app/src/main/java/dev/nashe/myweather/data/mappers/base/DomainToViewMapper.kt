package dev.nashe.myweather.data.mappers.base

interface DomainToViewMapper<in D, out V> {
        fun mapToView(domain : D): V

        fun mapToViewList(list: List<D>) : List<V> = list.mapTo(mutableListOf(), ::mapToView                              )
}