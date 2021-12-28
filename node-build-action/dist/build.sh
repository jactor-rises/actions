#!/bin/bash
set -e

INPUT_ARTIFACT_FOLDER=$1

echo "Building node artifact: $INPUT_ARTIFACT_FOLDER"

cd "$RUNNER_WORKSPACE/$INPUT_ARTIFACT_FOLDER"

npm install
ncc build index.js
