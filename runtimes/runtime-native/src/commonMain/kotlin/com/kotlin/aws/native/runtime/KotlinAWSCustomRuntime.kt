package com.kotlin.aws.native.runtime

import com.kotlin.aws.native.runtime.objects.LambdaContext

@Suppress("unused")
expect fun launchRuntime(handler: (context: LambdaContext, request: String) -> String)