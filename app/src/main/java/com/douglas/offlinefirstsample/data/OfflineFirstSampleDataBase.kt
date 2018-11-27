package com.douglas.offlinefirstsample.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.douglas.offlinefirstsample.model.Comment
import com.douglas.offlinefirstsample.model.ModelConstants.Companion.DB_NAME

@Database(entities = [Comment::class], version = 1, exportSchema = false)
abstract class OfflineFirstSampleDataBase: RoomDatabase() {

    companion object {
        private var instance: OfflineFirstSampleDataBase? = null

        fun getInstance(context: Context) : OfflineFirstSampleDataBase {

            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                        OfflineFirstSampleDataBase::class.java,
                        DB_NAME)
                        .build()
            }

            return instance!!
        }
    }

    abstract fun commentDao() : CommentDao
}