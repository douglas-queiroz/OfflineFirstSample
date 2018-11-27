package com.douglas.offlinefirstsample

import com.douglas.offlinefirstsample.model.Comment
import org.junit.Test

import org.junit.Assert.*

class CommentUnitTest {
    @Test
    fun fullConstructor_isFillInObject() {

        val id: Long = 1
        val photoId: Long = 1
        val commentText = "Comment text"
        val timestamp: Long = 1
        val syncPending = false

        val comment = Comment(id, photoId, commentText, timestamp, syncPending)

        assertEquals("Id is different", id, comment.id)
        assertEquals("Photo id is different", photoId, comment.photoId)
        assertEquals("Comment Text id is different", commentText, comment.commentText)
        assertEquals("Timestamp id is different", timestamp, comment.timestamp)
        assertEquals("Sync Pending id is different", syncPending, comment.syncPending)
    }

    @Test
    fun constructor_isFillInObject() {

        val photoId: Long = 1
        val commentText = "Comment text"

        val comment = Comment(photoId, commentText)

        assertNull("Id is not null", comment.id)
        assertEquals("Photo id is different", photoId, comment.photoId)
        assertEquals("Comment Text id is different", commentText, comment.commentText)
        assertNull("Timestamp is not null", comment.timestamp)
        assertNull("Sync Pending is not null", comment.syncPending)
    }
}
