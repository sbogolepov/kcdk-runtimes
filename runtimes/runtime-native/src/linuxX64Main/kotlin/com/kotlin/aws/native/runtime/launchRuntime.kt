package com.kotlin.aws.native.runtime

import com.kotlin.aws.native.runtime.client.LambdaHTTPClient
import com.kotlin.aws.native.runtime.objects.LambdaContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Suppress("unused")
actual fun launchRuntime(handler: (context: LambdaContext, request: String) -> String) = runBlocking<Unit> {
    launch(Dispatchers.Default) {
        try {
            while (true) {
                val invocation = LambdaHTTPClient.init()
                try {
                    LambdaHTTPClient.invoke(
                            invocation.context.getAwsRequestId(),
                            handler(invocation.context, invocation.body)
                    )
                } catch (t: Throwable) {
                    LambdaHTTPClient.postInvokeError(
                            invocation.context.getAwsRequestId(),
                            t.message ?: "Unknown handler error"
                    )
                }
            }
        } catch (t: Throwable) {
            LambdaHTTPClient.postInitError(t.message ?: "Unknown invocation error")
        }
    }
}