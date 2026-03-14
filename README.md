<p align="left">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,spring,maven,postgres,docker" />
  </a>
</p>

# Craft Library API

[![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)](https://openjdk.org/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![Clean Architecture](https://img.shields.io/badge/Architecture-Hexagonal-blue?style=for-the-badge)](https://en.wikipedia.org/wiki/Hexagonal_architecture_(software))

Cette API de gestion de bibliothèque est un projet de démonstration conçu selon les principes du **Software Craftsmanship**. L'objectif est de démontrer une maîtrise technique avancée sur l'écosystème Java/Spring tout en garantissant une isolation totale de la logique métier.

## Vision Technique

Pour ce projet, j'ai privilégié la **qualité et la maintenabilité** sur la rapidité d'exécution :

- **Architecture Hexagonale (Ports & Adapters) :** Le coeur métier (Domain) est pur et ne dépend d'aucun framework (pas de Spring, pas de JPA dans le domaine).
- **TDD (Test Driven Development) :** Développement piloté par les tests pour assurer une couverture fonctionnelle robuste.
- **Java 21 Modern Features :** Utilisation intensive des `records` pour l'immuabilité et la concision.
- **DDD (Domain Driven Design) :** Utilisation de langages ubiquitaires et d'objets métiers riches.



## Stack Technique

- **Backend :** Java 21, Spring Boot 3.x
- **Persistence :** Spring Data JPA, H2 Database (Runtime) / PostgreSQL ready.
- **Mapping :** MapStruct (pour une séparation stricte entre Entities et DTOs).
- **Boilerplate :** Lombok.
- **Tests :** JUnit 5, Mockito, AssertJ.

## Structure du Projet

```text
src/main/java/com/bidzana/library
├── domain          # Le Coeur : Logique métier pure (POJO/Records)
│   ├── model       # Entités métier
│   ├── ports       # Interfaces d'entrée/sortie
│   ├── service     # Orchestration métier (sans annotations Spring)
│   └── exception   # Exceptions métier spécifiques
├── infrastructure  # Les Détails : Frameworks et outils
│   ├── adapters    # Implémentations (REST Controllers, JPA Repositories)
│   ├── config      # Configuration des Beans Spring
│   └── mapper      # Mappers MapStruct
└── LibraryApplication.java

```

## Installation et Lancement

### Prérequis

* JDK 21
* Maven 3.6+

### Lancer l'application

```bash
./mvnw spring-boot:run

```

### Exécuter les tests

```bash
./mvnw test

```

## Choix de Conception (Design Decisions)

1. **Isolation du Domaine :** Le service métier est instancié via une classe `DomainConfig` à l'aide de l'annotation `@Bean`. Cela permet de garder le domaine indépendant de l'annotation `@Service` de Spring.
2. **Gestion d'erreurs centralisée :** Utilisation d'un `GlobalExceptionHandler` avec `@RestControllerAdvice` pour transformer les exceptions métier en codes HTTP sémantiques.
3. **Validation :** Utilisation de `Bean Validation` pour garantir l'intégrité des données dès l'entrée de l'API.

## Auteur

**Marvin Bidzana** - Développeur Fullstack (Java/Angular)
