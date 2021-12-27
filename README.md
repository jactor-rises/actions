# actions
Github Actions opprettet av jactor-rises

### Continuous integration
[![build actions](https://github.com/jactor-rises/actions/actions/workflows/ci.yaml/badge.svg)](https://github.com/jactor-rises/actions/actions/workflows/ci.yaml)

### Hovedregel for design:
Alt blir utført av bash-scripter slik at det enkelt kan testes på reell kodebase uten å måtte bygge med github. Javascript brukes dog til å hente
informasjon om den som forårsaker en workflow til å bli utført.

### Release log

#### build-node-action

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.0 | Opprettet | Bygger github action ved hjelp av node og ncc

#### commit

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.0 | Opprettet | Commit endring av files i et github repo og push til "origin"

#### setup-maven

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.0 | Opprettet | Sets up repository settings for a maven build

#### tag

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.0 | Opprettet | "Tag" release versjon lages på bakgrunn av "tagged snapshot" versjon

#### tag-snapshot

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.0 | Opprettet | "Bump" av "snapshot" versjon ved bruk av git tag

#### verify-maven-dependencies

Versjon | Endringstype | Beskrivelse
---|---|---
v1.0.0 | Opprettet | Verifiserer at maven-bygg ikke inneholder SNAPSHOT avhengigheter
