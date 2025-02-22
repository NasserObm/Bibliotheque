# 📚 Bibliothèque Numérique

Une API REST pour gérer une bibliothèque numérique avec authentification JWT, gestion des utilisateurs, des livres et des emprunts. Déployée avec Docker et sécurisée avec Spring Security.

## 🚀 Fonctionnalités
- 🔐 Authentification avec JWT (utilisateurs et administrateurs)
- 📚 Gestion des livres (CRUD)
- 🏷️ Gestion des emprunts avec dates de retour
- 🛠️ Documentation API avec Swagger
- 🗄️ Persistance des données avec MySQL
- 🐳 Conteneurisation avec Docker



## 📦 Installation
### 1️⃣ Prérequis
- Docker & Docker Compose
- JDK 17+
- Maven

### 2️⃣ Cloner le projet
```sh
git clone https://github.com/ton-repo/bibliotheque-numerique.git
cd bibliotheque-numerique
```

### 3️⃣ Construire l'application
```sh
mvn clean package
```

### 4️⃣ Lancer avec Docker
```sh
docker-compose up -d
```

### 5️⃣ Accéder à l'API
- Swagger UI : `http://localhost:8080/swagger-ui.html`
- Base de données MySQL : `localhost:3307`

## 🛠️ Configuration
Fichier `application.properties` :
```properties
spring.datasource.url=jdbc:mysql://mysql_db:3306/bibliotheque_db
spring.datasource.username=root
spring.datasource.password=root
```

## 🏗️ Structure du projet
```
📂 src
 ┣ 📂 main
 ┃ ┣ 📂 java
 ┃ ┃ ┣ 📂 com.bibliotheque
 ┃ ┃ ┃ ┣ 📂 controllers
 ┃ ┃ ┃ ┣ 📂 services
 ┃ ┃ ┃ ┣ 📂 repositories
 ┃ ┃ ┃ ┣ 📂 models
 ┃ ┃ ┃ ┣ 📂 security
 ┃ ┃ ┃ ┗ 📂 config
 ┃ ┣ 📂 resources
 ┃ ┃ ┣ 📜 application.properties
 ┃ ┃ ┗ 📜 data.sql
```

## 🐳 Déploiement Docker
### 1️⃣ Construire l'image Docker
```sh
docker build -t bibliotheque-app .
```

### 2️⃣ Lancer les conteneurs
```sh
docker-compose up -d
```

## 🔗 Liens utiles
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Docker](https://www.docker.com/)
- [Swagger](https://swagger.io/)

---
✍️ **Auteur** : Nasser - 📅 2025

