# actions
Github Actions opprettet av jactor-rises

### Continuous integration
[![build actions](https://github.com/jactor-rises/actions/actions/workflows/ci.yaml/badge.svg)](https://github.com/jactor-rises/actions/actions/workflows/ci.yaml)

### Hovedregel for design:
Alt blir utført av bash-scripter slik at det enkelt kan testes på reell kodebase uten å måtte bygge med github. Javascript brukes dog til å hente
informasjon om den som forårsaker en workflow til å bli utført.

### Release log

#### build-node-action

Latest: `v1-build-node-action` -> `v1.0.1-build-node-action`

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.1 | Endret | `action-core`: `1.5.0` -> `1.6.0`
v1.0.0 | Opprettet | Bygger github action ved hjelp av node og ncc

#### commit

Latest: `v1-commit` -> `v1.0.1-commit`

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.1 | Endret | `action-core`: `1.5.0` -> `1.6.0`
v1.0.0 | Opprettet | Commit endring av files i et github repo og push til "origin"

#### setup-maven

Latest: `v1-setup-maven` -> `v1.0.0-setup-maven`

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.0 | Opprettet | Sets up repository settings for a maven build

#### tag

Latest: `v1-tag` -> `v1.0.1-tag`

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.1 | Endret | `action-core`: `1.5.0` -> `1.6.0`
v1.0.0 | Opprettet | "Tag" release versjon lages på bakgrunn av "tagged snapshot" versjon

#### tag-snapshot

Latest: `v1-tag-snapshot` -> `v1.0.0-tag-snapshot`

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.0 | Opprettet | "Bump" av "snapshot" versjon ved bruk av git tag

#### verify-maven-dependencies

Latest: `v1-verify-maven-dependencies` -> `v1.0.0-verify-maven-dependencies`

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.0 | Opprettet | Verifiserer at maven-bygg ikke inneholder SNAPSHOT avhengigheter
