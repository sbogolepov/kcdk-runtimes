package com.kotlin.aws.js.runtime.tasks

import com.kotlin.aws.js.runtime.dsl.RuntimePluginExtension
import com.kotlin.aws.js.runtime.utils.Groups
import com.kotlin.aws.js.runtime.utils.runtime
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.File

open class BuildCustomRuntimeLambda : DefaultTask() {

    @get:Input
    val extension: RuntimePluginExtension = project.runtime

    init {
        group = Groups.aws
    }

    @TaskAction
    fun build() {
        val outputDirPath = extension.outputDir
        val dir = outputDirPath?.let { File(it) } ?: File(project.buildDir, "distributions")

        dir.mkdirs()
        with(File(dir, "bootstrap")) {
            writeText(
                """
                # just a placeholder, not tested yet
                node sample.js
            """.trimIndent()
            )
        }
    }

}