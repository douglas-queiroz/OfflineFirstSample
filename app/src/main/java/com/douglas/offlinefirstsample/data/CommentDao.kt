package com.douglas.offlinefirstsample.data

import android.arch.persistence.room.*
import com.douglas.offlinefirstsample.model.Comment
import io.reactivex.Flowable

@Dao
interface CommentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(comment: Comment) : Long

    @Update
    fun update(comment: Comment)

    @Delete
    fun delete(comment: Comment)

    @Query("SELECT * FROM comment WHERE photo_id = :photoId ORDER BY timestamp DESC")
    fun getComment(photoId: Long) : Flowable<List<Comment>>
}