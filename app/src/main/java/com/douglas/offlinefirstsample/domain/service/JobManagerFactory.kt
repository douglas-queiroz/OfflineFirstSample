package com.douglas.offlinefirstsample.domain.service

import android.content.Context
import android.os.Build
import com.birbit.android.jobqueue.JobManager
import com.birbit.android.jobqueue.config.Configuration
import com.birbit.android.jobqueue.scheduling.FrameworkJobSchedulerService
import com.birbit.android.jobqueue.scheduling.GcmJobSchedulerService
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability

class JobManagerFactory {

    companion object {

        private var jobManager: JobManager? = null

        fun getJobManager() : JobManager{
            return jobManager!!
        }

        fun getJobManager(context: Context) : JobManager {

            if (jobManager == null) {
                jobManager = configureJobManager(context)
            }

            return jobManager!!
        }

        private fun configureJobManager(context: Context) : JobManager {
            val builder = Configuration.Builder(context)
                    .minConsumerCount(1)
                    .maxConsumerCount(3)
                    .loadFactor(3)
                    .consumerKeepAlive(120)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                builder.scheduler(FrameworkJobSchedulerService
                        .createSchedulerFor(context, SchedulerJobService::class.java), true)
            } else {

                val enableGcm = GoogleApiAvailability.getInstance()
                        .isGooglePlayServicesAvailable(context)
                if (enableGcm == ConnectionResult.SUCCESS) {
                    builder.scheduler(GcmJobSchedulerService.
                            createSchedulerFor(context, GcmSchedulerJobService::class.java), true)
                }
            }

            return JobManager(builder.build())
        }
    }
}