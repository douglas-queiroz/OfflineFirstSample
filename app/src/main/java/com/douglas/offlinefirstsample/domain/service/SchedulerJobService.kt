package com.douglas.offlinefirstsample.domain.service

import com.birbit.android.jobqueue.JobManager
import com.birbit.android.jobqueue.scheduling.FrameworkJobSchedulerService

class SchedulerJobService: FrameworkJobSchedulerService() {

    override fun getJobManager(): JobManager {
        return JobManagerFactory.getJobManager()
    }
}