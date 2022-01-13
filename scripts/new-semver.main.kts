#!/usr/bin/env kotlin

import New_patch_main.Argument.MAJOR_MINOR
import New_patch_main.Argument.SNAPSHOT
import New_patch_main.Argument.SNAPSHOT_TEXT

import java.io.File
import java.nio.file.Files

/***********************************************
 * DESCRIPTION:
 * -----------
 * Will find next patched version when given current snapshot-version and current major/minor-version (using semantic versioning)
 * -
 * Major and minor version will be determined by previous snapshot tag and the patch-version is bumped.
 * -
 * The new patched version (full semantic version, <major>.<minor>.<patch>) will be written to a new file named newSemVer
 * -
 * Note! If the major/minor version is less than current snapshot-version, the script will fail...
 */
object Argument {
    const val MAJOR_MINOR = "majorMinor"
    const val SNAPSHOT = "snapshot"
    const val SNAPSHOT_TEXT = "snapshotText"
}

object Constants {
    const val ENVIRONMENT_IS_DEBUG = "IS_DEBUG"
    const val FILE_NAME_NEW_SEM_VER = "newSemVer"
    const val SNAPSHOT_TAG_TEXT = "snapshot-"

    private const val SCRIPT_FILE_NAME = "new-semver.main.kts"

    val ERROR_MESSAGE = """
            >>> ERROR <<<
            {}
              Usage: $SCRIPT_FILE_NAME <mapped args, ie: $MAJOR_MINOR=? $SNAPSHOT=?> [optional argument: $SNAPSHOT_TEXT=?]
              - ex: ./$SCRIPT_FILE_NAME $MAJOR_MINOR=2.0 $SNAPSHOT=${SNAPSHOT_TAG_TEXT}2.0.15 $SNAPSHOT_TEXT=-SNAPSHOT
                when optional argument is not submitted, $SNAPSHOT_TEXT is equal to: $SNAPSHOT_TAG_TEXT
        """.trimIndent()
}

val isDebug = System.getenv(Constants.ENVIRONMENT_IS_DEBUG)?.toBoolean() ?: false
val allArgs = args.joinToString(" ")

debugMessage("all args: $allArgs")

if (args.size < 2) {
    throw IllegalArgumentException(errMsg("Two arguments are required!"))
}

val inputs = allArgs.split(Regex(" "))
val commands: MutableMap<String, String> = HashMap()

inputs.filter { it.contains('=') }.filter { !it.endsWith('=') }.forEach {
    val key = it.split("=")[0]
    val value = it.split("=")[1]
    commands[key] = value
}

debugMessage("map args: $commands")

// read arguments
val majorMinorVersion = commands[MAJOR_MINOR] ?: throw IllegalArgumentException("$MAJOR_MINOR argument is not supplied!")
val snapshotVersion = commands[SNAPSHOT] ?: throw IllegalArgumentException("$SNAPSHOT argument is not supplied!")
val snapshotText = commands[SNAPSHOT_TEXT] ?: Constants.SNAPSHOT_TAG_TEXT

val newSnapshotVersion = createNewSemanticVersion(snapshotVersion.replace(snapshotText, ""))
val semVerFile = File(Constants.FILE_NAME_NEW_SEM_VER)

Files.write(semVerFile.toPath(), newSnapshotVersion.toByteArray())

fun errMsg(message: String): String = Constants.ERROR_MESSAGE.replace("{}", message)
fun createNewSemanticVersion(snapshotVersion: String): String {
    debugMessage("creating new semantic version from $majorMinorVersion and current snapshot ($snapshotVersion)")

    if (!snapshotVersion.startsWith(majorMinorVersion)) {
        return createNewSemanticVersion(
            majorMinorVersion.split(".")[0].toInt(),
            majorMinorVersion.split(".")[1].toInt(),
            snapshotVersion.split(".")[0].toInt(),
            snapshotVersion.split(".")[1].toInt()
        )
    }

    val currentPatch = snapshotVersion.substring(snapshotVersion.lastIndexOf('.') + 1).toInt()

    return "$majorMinorVersion.${currentPatch + 1}"
}

fun createNewSemanticVersion(majorVersion: Int, minorVersion: Int, snapshotMajorVersion: Int, snapshotMinorVersion: Int): String {
    debugMessage(
        """
        supplied major version: $majorVersion
        supplied minor version: $minorVersion
        snapshot major version: $snapshotMajorVersion
        snapshot minor version: $snapshotMinorVersion
    """.trimIndent()
    )

    if (majorVersion < snapshotMajorVersion) {
        throw IllegalStateException("Supplied major/minor version ($majorMinorVersion) is less than current snapshot major version!")
    }

    if (majorVersion == snapshotMajorVersion && minorVersion < snapshotMinorVersion) {
        throw IllegalStateException("Supplied major/minor version ($majorMinorVersion) is less than current snapshot major/minor version")
    }

    return "$majorMinorVersion.0"
}

fun debugMessage(message: String) {
    if (isDebug) println(message)
}
