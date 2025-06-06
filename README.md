# Sample Spring Boot Kotlin Microservice

[![Build Status](https://dev.azure.com/piomin/sample-spring-kotlin-microservice/_apis/build/status%2Fpiomin.sample-spring-kotlin-microservice?branchName=master)](https://dev.azure.com/piomin/sample-spring-kotlin-microservice/_build/latest?definitionId=1&branchName=master)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=piomin_sample-spring-kotlin-microservice&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=piomin_sample-spring-kotlin-microservice)

A demonstration microservice built with **Spring Boot** and **Kotlin** showcasing modern microservice patterns, cloud-native development, and DevOps practices.

## 🚀 Features

- **RESTful API** for Person entity management (CRUD operations)
- **In-memory data store** with 1000 auto-generated fake records using DataFaker
- **Spring Boot Actuator** integration with health checks and metrics
- **Prometheus metrics** exposure for monitoring
- **OpenAPI/Swagger** documentation
- **Multiple web server support** (Tomcat, Jetty, Undertow)
- **Cloud-native** deployment configurations (Kubernetes, OpenShift)
- **Containerization** with Jib Maven plugin
- **CI/CD** pipeline with Azure DevOps
- **Development tools** integration (Skaffold, DevFile)

## 🛠 Technology Stack

| Technology            | Version | Purpose               |
|-----------------------|---------|-----------------------|
| **Spring Boot**       | 3.5.0   | Application framework |
| **Kotlin**            | 2.1.21  | Programming language  |
| **Java**              | 17      | Runtime platform      |
| **Maven**             | 3.6+    | Build tool            |
| **SpringDoc OpenAPI** | 2.8.8   | API documentation     |
| **Micrometer**        | 1.11.4  | Metrics collection    |
| **DataFaker**         | 2.4.3   | Test data generation  |
| **Instancio**         | 5.4.1   | Test object creation  |

## 🏃‍♂️ Quick Start

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- (Optional) Docker for containerization
- (Optional) Kubernetes/OpenShift for deployment

### Running the Application

1. Clone the repository

   ```bash
   git clone https://github.com/piomin/sample-spring-kotlin-microservice.git
   cd sample-spring-kotlin-microservice
   ```

2. Run with Maven

   ```bash
   mvn spring-boot:run
   ```

3. Access the application

   - Application: http://localhost:8080
   - Swagger UI: http://localhost:8080/swagger-ui.html
   - Health Check: http://localhost:8080/actuator/health
   - Metrics: http://localhost:8080/actuator/prometheus

## 📋 API Documentation

### Person Management Endpoints

| Method | Endpoint                | Description                         | Response         |
|--------|-------------------------|-------------------------------------|------------------|
| GET    | /persons                | Retrieve all persons                | List<Person>     |
| GET    | /persons/{id}           | Get person by ID                    | Person           |
| GET    | /persons/ages/{age}     | Find persons by age                 | List<Person>     |
| GET    | /persons/delayed        | Get all persons with random delay   | List<Person>     |
| POST   | /persons                | Create new person                   | Person           |
| PUT    | /persons                | Update existing person              | Person           |
| DELETE | /persons/{id}           | Delete person by ID                 | Boolean          |

### Environment Endpoint

| Method | Endpoint | Description                          |
|--------|----------|--------------------------------------|
| GET    | /envs    | Get environment password variable    |

## 🔧 Build & Package

### Maven Commands

```bash
# Compile and run tests
mvn clean compile test

# Package application
mvn clean package

# Skip tests during build
mvn clean package -DskipTests

# Run with a specific profile (jetty, undertow)
mvn spring-boot:run -Pjetty
```

### Docker Build

```bash
# Build with Jib (preferred)
mvn clean compile jib:dockerBuild -Pjib

# Build with Dockerfile
docker build -t sample-spring-kotlin-microservice .
```

## ☸️ Deployment

### Kubernetes

```bash
kubectl apply -f k8s/
kubectl get pods -l app=sample-spring-kotlin-microservice
kubectl port-forward svc/sample-spring-kotlin-microservice 8080:8080
```

### OpenShift

```bash
oc process -f openshift/app.yaml \
  -p namespace=my-project \
  -p version=latest | oc apply -f -
```

## 🧪 Testing

```bash
# Run all tests
mvn test

# Run a specific test class
mvn test -Dtest=PersonControllerTests

# Generate coverage report
mvn clean test jacoco:report
```

## 📊 Monitoring & Observability

```bash
curl http://localhost:8080/actuator/health
curl http://localhost:8080/actuator/metrics
curl http://localhost:8080/actuator/prometheus
```

## ⚙️ Configuration

### application.yml highlights

```yaml
spring:
  application.name: sample-spring-kotlin-microservice
management:
  endpoints.web.exposure.include: '*'
  endpoint.health:
    show-details: always
    probes.enabled: true
app:
  delay: 20
```

## 🔨 Development Setup

### IntelliJ IDEA

1. Import as Maven project  
2. Install Kotlin plugin  
3. Set Project SDK to Java 17  
4. Enable annotation processing  

### VS Code

- Install Extension Pack for Java  
- Kotlin Language Support  
- Spring Boot Extension Pack  

## 🚦 CI/CD Pipeline

- **Azure DevOps** pipeline for build, test, and container image creation  
- **SonarCloud** integration for quality gate  
- Automatic triggers on master and PR validation  

## 📁 Project Structure

```text
sample-spring-kotlin-microservice/
├── src/
│   ├── main/kotlin/pl/piomin/services/
│   ├── main/resources/application.yml
│   └── test/kotlin/pl/piomin/services/
├── k8s/
├── openshift/
├── azure-pipelines.yml
├── skaffold.yaml
├── devfile.yaml
├── Dockerfile
└── pom.xml
```

## 🤝 Contributing

1. Fork the repo  
2. Create a feature branch (`git checkout -b feature/awesome`)  
3. Commit changes (`git commit -m 'feat: awesome feature'`)  
4. Push and open a PR  

## 📝 License

This project is provided as a sample/demo for educational purposes.

## 📞 Support

For questions, open an issue or refer to:  
- Spring Boot Docs: https://spring.io/projects/spring-boot  
- Kotlin Docs: https://kotlinlang.org/docs/