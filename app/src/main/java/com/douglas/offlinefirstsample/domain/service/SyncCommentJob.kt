package com.douglas.offlinefirstsample.domain.service

import com.birbit.android.jobqueue.Job
import com.birbit.android.jobqueue.Params
import com.birbit.android.jobqueue.RetryConstraint
import com.douglas.offlinefirstsample.model.Comment

class SyncCommentJob: Job {

    companion object {
        private val TAG: String = SyncCommentJob::class.java.name
    }

    private lateinit var comment: Comment

    constructor(comment: Comment): super(Params(JobPriority.MID)
            .requireNetwork()
            .groupBy(TAG)
            .persist()) {

        this.comment = comment
    }

    override fun onRun() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun shouldReRunOnThrowable(throwable: Throwable, runCount: Int, maxRunCount: Int): RetryConstraint {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAdded() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCancel(cancelReason: Int, throwable: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}