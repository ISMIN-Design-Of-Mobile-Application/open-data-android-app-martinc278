package com.ismin.opendataapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StarbucksDAO {
    @Insert
    fun insert(vararg starbucks: Starbucks)

    @Delete
    fun delete(book: Starbucks)

    @Query("SELECT * FROM starbucks")
    fun getAll(): List<Starbucks>

    /*@Query("SELECT * FROM starbucks WHERE name LIKE :queryName")
    fun findByName(queryName: String): Starbucks*/
}