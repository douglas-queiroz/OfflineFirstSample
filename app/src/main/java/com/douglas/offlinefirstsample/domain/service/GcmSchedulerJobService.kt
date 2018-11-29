package com.douglas.offlinefirstsample.domain.service

import com.birbit.android.jobqueue.JobManager
import com.birbit.android.jobqueue.scheduling.GcmJobSchedulerService

class GcmSchedulerJobService: GcmJobSchedulerService() {

    override fun getJobManager(): JobManager {
        return JobManagerFactory.getJobManager()
    }
}