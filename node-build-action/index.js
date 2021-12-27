const core = require("@actions/core");
const exec = require("@actions/exec");

async function run() {
  try {
    const artifactFolder = core.getInput('artifact_folder');

    // Execute tag bash script
    await exec.exec(`${__dirname}/build.sh`, [artifactFolder]);

  } catch (error) {
    core.setFailed(error.message);
  }
}

// noinspection JSIgnoredPromiseFromCall
run();
