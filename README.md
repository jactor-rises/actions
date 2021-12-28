# actions
Github Actions opprettet av jactor-rises

### Continuous integration
[![build actions](https://github.com/jactor-rises/actions/actions/workflows/ci.yaml/badge.svg)](https://github.com/jactor-rises/actions/actions/workflows/ci.yaml)

### Hovedregel for design:
Alt blir utført av bash-scripter slik at det enkelt kan testes på reell kodebase uten å måtte bygge med github. Javascript brukes dog til å hente
informasjon om den som forårsaker en workflow til å bli utført.

### Release log

#### git-commit

Latest: `v2-git-commit` -> `v2.0.0-git-commit`

Versjon | Endringstype | Beskrivelse
---|---|---
v2.0.0 | Endret | `commit` -> `git-commit`
v1.0.1 | Endret | `action-core`: `1.5.0` -> `1.6.0`
v1.0.0 | Opprettet | Commit endring av files i et github repo og push til "origin"

#### git-commit-n-tag

Latest: `v1-git-commit-n-tag` -> `v1.0.0-git-commit-n-tag`

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.0 | Opprettet | Gjør en `git commit` av ny snapshot versjon og kjører `git tag` på siste commit

#### git-tag

Latest: `v2-git-tag` -> `v2.0.0-git-tag`

Versjon | Endringstype | Beskrivelse
---|---|---
v2.0.0 | Endret | `tag` -> `git-tag`
v1.0.0 | Opprettet | "Tag" release versjon lages på bakgrunn av "tagged snapshot" versjon

#### git-tag-snapshot

Latest: `v2-git-tag-snapshot` -> `v2.0.0-git-tag-snapshot`

Versjon | Endringstype | Beskrivelse
---|---|---
v2.0.0 | Endret | `tag-snapshot` -> `git-tag-snapshot`
v1.0.0 | Opprettet | "Bump" av "snapshot" versjon ved bruk av git tag

#### maven-deploy

Latest: `v1-maven-deploy` -> `v1.0.0-maven-deploy`

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.0 | Opprettet | gjør en maven deploy når pakken skal releases

#### maven-prepare-deploy

Latest: `v1-maven-prepare-deploy` -> `v1.0.0-maven-prepare-deploy`

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.0 | Opprettet | Forbereder en deploy ved å finne gjeldende og ny snapshot versjon for å sette deploy versjon i pom.xml

#### maven-setup

Latest: `v2-maven-setup` -> `v2.0.0-maven-setup`

Versjon | Endringstype | Beskrivelse
---|---|---
v2.0.0 | Endret | `setup-maven` -> `maven-setup`
v1.0.1 | Endret | `action-core`: `1.5.0` -> `1.6.0`
v1.0.0 | Opprettet | Sets up repository settings for a maven build

#### maven-verify-dependencies

Latest: `v1-maven-verify-dependencies` -> `v2.0.0-maven-verify-dependencies`

Versjon | Endringstype | Beskrivelse
---|---|---
v2.0.0 | Endret | `verify-maven-dependencies` -> `maven-verify-dependencies`
v1.0.0 | Opprettet | Verifiserer at maven-bygg ikke inneholder SNAPSHOT avhengigheter

#### maven-verify-deploy

Latest: `v1-maven-verify-deploy` -> `v1.0.0-maven-verify-deploy`

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.0 | Opprettet | Sjekker om gitt versjon finnes i README.md. Når denne finnes, så skal dette være en ny deploy

#### node-build-action

Latest: `v2-node-build-action` -> `v2.0.0-node-build-action`

Versjon | Endringstype | Beskrivelse
---|---|---
v2.0.0 | Endret | `build-node-action` -> `node-build-action`
v1.0.1 | Endret | `action-core`: `1.5.0` -> `1.6.0`
v1.0.0 | Opprettet | Bygger github action ved hjelp av node og ncc
