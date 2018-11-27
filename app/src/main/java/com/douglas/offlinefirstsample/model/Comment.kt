package com.douglas.offlinefirstsample.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
class Comment: Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    @ColumnInfo(name = "photo_id")
    var photoId: Long? = null

    @ColumnInfo(name = "comment_text")
    var commentText: String? = null

    @ColumnInfo(name = "timestamp")
    var timestamp: Long? = null

    @ColumnInfo(name = "sync_pending")
    var syncPending: Boolean? = null

    @Ignore
    constructor(photoId: Long, commentText: String) {
        this.photoId = photoId
        this.commentText = commentText
    }

    constructor(id: Long, photoId: Long, commentText: String, timestamp: Long, syncPending: Boolean) {
        this.id = id
        this.photoId = photoId
        this.commentText = commentText
        this.timestamp = timestamp
        this.syncPending = syncPending
    }

    override fun toString(): String {
        return "Comment id: $id, photo Id; $photoId text: $commentText, syncPending: $syncPending"
    }
}