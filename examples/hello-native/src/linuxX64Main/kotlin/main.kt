import com.kotlin.aws.native.runtime.objects.LambdaContext

fun helloWorldHandler(context: LambdaContext, request: String) =
    "Hello World!"