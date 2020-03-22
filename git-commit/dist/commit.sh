#!/bin/bash
set -e

############################################
#
# Følgende skjer i dette skriptet:
# 1) Konfigurerer git for remote repository
#    - USER_EMAIL og USER_NAME settes av javascriptet
# 2) Når det er en endring i repository:
#    - Sett commit message og pattern (fra javascript)
#    - legg til endringer ihht. pattern og commit med melding
#    - push kode til remote repository
#
############################################

git remote set-url origin https://${GITHUB_ACTOR}:${GITHUB_TOKEN}@github.com/${GITHUB_REPOSITORY}.git
git config --global user.email "$AUTHOR_EMAIL"
git config --global user.name "$AUTHOR_NAME"

if ! git diff --quiet
then
  git status

  COMMIT_MESSAGE=$1
  INPUT_PATTERN=$2

  echo "Committing changes (pattern: $INPUT_PATTERN) with message: $COMMIT_MESSAGE"

  git add "$INPUT_PATTERN"
  git commit -m "$COMMIT_MESSAGE"
  git push
else
  echo "No difference detected."
fi
