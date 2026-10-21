<p align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="docs/assets/nozzle-logo-dark.svg">
    <img src="docs/assets/nozzle-logo-light.svg" alt="Nozzle" width="360">
  </picture>
</p>

# Nozzle

A platform that connects people who need something 3D-printed with people who own 3D printers. A client uploads a model, picks material and colour, and places an order; the platform offers it to a suitable printer owner nearby, taxi-style, and holds the payment until the print is delivered.

> **Status:** learning project in early development. I'm building it to learn Spring Boot, so the design is documented in more detail than the code is written.

## What works now

- `POST /api/orders` — create an order (material is one of `PLA`, `PETG`, `ABS`, `TPU`), with request validation
- Orders are stored in PostgreSQL

Everything else described in the docs is planned, not implemented yet.

## Tech stack

- Java, Spring Boot (Web, Data JPA, Validation)
- PostgreSQL
- Maven
- Docker Compose for the local database

## Running locally

Requirements: JDK, Docker.

```sh
git clone git@github.com:kzbj/nozzle-print.git
cd nozzle-print
docker compose up -d        # starts PostgreSQL
./mvnw spring-boot:run      # starts the app
```

Example requests are in [`requests.http`](requests.http).

## Documentation

- [Requirements](docs/requirements.md) — how the system should work: order lifecycle, dispatch, payment, delivery, moderation, and ideas deliberately left for later
- Design decisions (`docs/decisions/`) — coming soon: why each rule was chosen and what alternatives were considered
