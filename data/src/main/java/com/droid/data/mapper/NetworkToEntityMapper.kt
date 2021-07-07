package com.droid.data.mapper

/**
 * @author adityakhullar on 21/06/21.
 */
interface NetworkToEntityMapper<in S : Any, out D : Any> {

    fun convert(source: S): D

}