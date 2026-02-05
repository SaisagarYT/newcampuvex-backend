# CampVex Backend - Complete Spring Boot REST API

## 📌 Quick Links
- [API Documentation](./BACKEND_API_DOCUMENTATION.md) - Comprehensive API reference with all endpoints
- [Postman Collection](#postman-collection) - Ready-to-use API requests
- [Troubleshooting](#troubleshooting) - Common issues and solutions

---

## 🎯 Project Overview

**CampVex Backend** is a full-featured REST API for a competitive programming and career development platform. Built with Spring Boot 3, MongoDB, and JWT authentication.

### Key Statistics
- **94 Java source files** across 6 layers
- **20 Entity models** for complete business logic
- **18 MongoDB repositories** for data access
- **14 Service implementations** with business logic
- **10 REST controllers** with 50+ API endpoints
- **100% CRUD operations** for all models
- **JWT-based authentication** with Spring Security
- **Cross-origin requests** enabled for frontend integration

---

## 🏗️ Architecture

### Layered Architecture
```
┌─────────────────────────────────────────────────────────┐
│                   REST Controllers                      │  
│  (Handle HTTP requests, validation, response mapping)  │
└──────────────────┬──────────────────────────────────────┘
                   │
┌──────────────────▼──────────────────────────────────────┐
│                  Services Layer                         │
│  (Business logic, calculations, validations)           │
└──────────────────┬──────────────────────────────────────┘
                   │
┌──────────────────▼──────────────────────────────────────┐
│               Repositories Layer                        │
│  (MongoDB data access, queries, persistence)           │
└──────────────────┬──────────────────────────────────────┘
                   │
┌──────────────────▼──────────────────────────────────────┐
│                MongoDB Database                         │
│  (Document storage, indexes, aggregation)              │
└─────────────────────────────────────────────────────────┘
```

### Directory Structure
```
src/main/java/com/newcampvex/newcampvex/
├── config/                          # Configuration classes
│   └── SecurityConfig.java          # Spring Security configuration
├── controllers/ (10 files)          # REST API endpoints
├── models/ (20 files)               # Entity classes
├── repositories/ (18 files)         # Data access interfaces
├── services/ (26 files)             # Business logic
│   ├── [Interfaces] (12 files)
│   └── [Implementations] (14+ files)
├── filters/                         # Security filters
│   └── JwtAuthenticationFilter.java
├── util/                            # Utility classes
│   └── JwtUtil.java
└── NewcampvexApplication.java       # Main entry point

src/main/resources/
└── application.properties           # Configuration properties
```

---

## 🚀 Getting Started

### Prerequisites
```
Java 21 or higher
Maven 3.8+
MongoDB 5.0+ (local or Atlas)
Git
```

### Step 1: Clone Repository
```bash
git clone <repository-url>
cd newcampvex-backend
```

### Step 2: Install Dependencies
```bash
mvn clean install
```

### Step 3: Configure Database
Edit `src/main/resources/application.properties`:

**Local MongoDB:**
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/uservex
```

**MongoDB Atlas (Cloud):**
```properties
spring.data.mongodb.uri=mongodb+srv://username:password@cluster.mongodb.net/uservex
```

### Step 4: Configure JWT Secret
```properties
app.jwt.secret=your-super-secret-key-at-least-32-characters-long
app.jwt.expiration=86400000
```

### Step 5: Build and Run
```bash
mvn clean compile
mvn spring-boot:run
```

Server starts at: `http://localhost:8080`

---

## 📡 Available API Endpoints

### Authentication
- `POST /api/users/register` - Register new user
- `POST /api/users/login` - User login

### User Management
- `GET /api/profiles/{id}` - Get profile
- `POST /api/profiles` - Create profile
- `PUT /api/profiles/{id}` - Update profile
- `DELETE /api/profiles/{id}` - Delete profile

### Problems & Coding
- `GET /api/problems` - List all problems
- `POST /api/problems` - Create problem
- `GET /api/problems/{id}` - Get problem details
- `GET /api/problems/category/{category}` - Filter by category
- `GET /api/problems/difficulty/{difficulty}` - Filter by difficulty

### User Progress
- `POST /api/user-progress` - Track problem solving
- `GET /api/user-progress/user/{userId}` - Get user's progress
- `GET /api/user-progress/user/{userId}/status/{status}` - Get progress by status

### Statistics & Gamification
- `GET /api/user-stats/user/{userId}` - Get user statistics
- `POST /api/user-stats/{userId}/add-xp?xp=100` - Award XP points
- `POST /api/user-stats/{userId}/increment-problems-solved` - Increment problems

### Assessments
- `GET /api/assessments` - List assessments
- `POST /api/assessments` - Create assessment
- `GET /api/assessments/category/{category}` - Get by category
- `GET /api/assessments/published` - Get published assessments

### Interview Prep
- `GET /api/interview-questions` - List all questions
- `GET /api/interview-questions/category/{category}` - Get by category
- `GET /api/interview-questions/topic/{topic}` - Get by topic

### Portfolio & Projects
- `GET /api/portfolios/user/{userId}` - Get user portfolio
- `POST /api/projects` - Create project
- `GET /api/projects/user/{userId}` - Get user projects
- `PUT /api/projects/{id}` - Update project
- `DELETE /api/projects/{id}` - Delete project

### Resumes
- `POST /api/resumes` - Create resume
- `GET /api/resumes/user/{userId}` - Get user's resumes
- `GET /api/resumes/user/{userId}/default` - Get default resume

### Learning Paths
- `GET /api/roadmaps` - List all roadmaps
- `GET /api/roadmaps/category/{category}` - Get by category
- `GET /api/cheatsheets` - List all cheatsheets
- `GET /api/cheatsheets/category/{category}` - Get by category

### Challenges
- `GET /api/challenges` - List all challenges
- `GET /api/challenges/status/{status}` - Get by status
- `GET /api/challenges/difficulty/{difficulty}` - Get by difficulty

---

## 🔐 Authentication Flow

### 1. Register User
```bash
curl -X POST http://localhost:8080/api/users/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "john_dev",
    "email": "john@example.com",
    "password": "SecurePass123!",
    "fullName": "John Developer",
    "role": "student"
  }'
```

### 2. Login to Get Token
```bash
curl -X POST http://localhost:8080/api/users/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "john@example.com",
    "password": "SecurePass123!"
  }'
```

Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "user": {
    "id": "507f1f77bcf86cd799439011",
    "username": "john_dev",
    "email": "john@example.com",
    "fullName": "John Developer",
    "role": "student"
  }
}
```

### 3. Use Token in Requests
```bash
curl -X GET http://localhost:8080/api/profiles/user/507f1f77bcf86cd799439011 \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
```

---

## 📚 Complete Data Models

### 1. User
Represents system user with authentication details
```json
{
  "id": "MongoDB ObjectId",
  "username": "john_dev",
  "email": "john@example.com",
  "fullName": "John Developer",
  "role": "student|instructor|admin",
  "active": true,
  "createdAt": "2026-02-05T10:30:00Z"
}
```

### 2. Profile  
User profile with personal and professional details
```json
{
  "userId": "Reference to User",
  "bio": "Full-stack developer",
  "skillsJson": "[\"Java\", \"React\", \"MongoDB\"]",
  "linkedInUrl": "https://linkedin.com/in/john",
  "githubUrl": "https://github.com/john"
}
```

### 3. Problem
Coding problems for practice
```json
{
  "title": "Two Sum",
  "difficulty": "beginner|intermediate|advanced",
  "category": "Arrays|Strings|Trees|etc",
  "platform": "LeetCode|HackerRank|GeeksforGeeks",
  "xpReward": 50,
  "timeComplexity": "O(n)",
  "spaceComplexity": "O(n)"
}
```

### 4. UserProgress
Tracks user's problem-solving progress
```json
{
  "userId": "Reference to User",
  "problemId": "Reference to Problem",
  "status": "not-started|solving|solved",
  "attempts": 2,
  "language": "Java",
  "timeSpent": 1200
}
```

### 5. UserStats
User's performance statistics
```json
{
  "userId": "Reference to User",
  "totalXP": 5000,
  "level": 15,
  "problemsSolved": 127,
  "currentStreak": 12,
  "longestStreak": 45,
  "averageScore": 87.5,
  "dSAScore": 82
}
```

### 6. Badge & UserBadge
Achievement badges system
```json
{
  "name": "First 10 Problems",
  "badgeType": "achievement|milestone|streak",
  "imageUrl": "https://example.com/badge.png",
  "requiredCount": 10
}
```

### 7. Assessment & UserAssessment
Tests and assessment tracking
```json
{
  "title": "Aptitude Test",
  "category": "aptitude|dsa|coding",
  "totalQuestions": 40,
  "timeLimit": 120,
  "passingScore": "60",
  "xpReward": 200
}
```

### 8. InterviewQuestion
Interview preparation questions
```json
{
  "question": "What is polymorphism?",
  "category": "Technical|HR|Behavioral",
  "topic": "Java|JavaScript|Python",
  "difficulty": "beginner|intermediate|advanced",
  "sampleAnswer": "..."
}
```

### 9. Portfolio & Project
User portfolio and projects
```json
{
  "userId": "Reference to User",
  "title": "John's Portfolio",
  "projectIds": ["proj1", "proj2"],
  "skillTags": ["Java", "React"],
  "isPublic": true
}
```

### 10. Resume
Resume versions for different applications
```json
{
  "userId": "Reference to User",
  "title": "Resume - 2026",
  "templateName": "professional",
  "content": "{\"name\": \"John\", ...}",
  "isDefault": true
}
```

### 11. Challenge
Coding challenges and contests
```json
{
  "title": "30-Day Challenge",
  "difficulty": "intermediate",
  "status": "active|upcoming|closed",
  "xpReward": 1000,
  "deadline": 1709510400000
}
```

### 12. Roadmap & UserRoadmap
Learning paths and progress tracking
```json
{
  "title": "Full-Stack Developer Path",
  "category": "Full-Stack|Frontend|Backend",
  "totalMilestones": 15,
  "estimatedHours": 500
}
```

### 13. Cheatsheet
Quick reference guides
```json
{
  "title": "Java Collections Cheatsheet",
  "category": "Backend",
  "topicsCount": 8,
  "examplesCount": 25,
  "difficulty": "intermediate"
}
```

### 14. XPTransaction
XP earning history
```json
{
  "userId": "Reference to User",
  "xpAmount": 100,
  "activityType": "problem_solved|quiz_completed",
  "description": "Solved: Two Sum"
}
```

### 15. AIMessage
AI chat conversation history
```json
{
  "userId": "Reference to User",
  "conversationId": "conv123",
  "role": "user|assistant",
  "content": "Can you explain this?"
}
```

---

## 🧪 Testing

### Compile Project
```bash
mvn clean compile
```

### Run Tests
```bash
mvn test
```

### Build JAR
```bash
mvn clean package -DskipTests
```

---

## 📊 Database Collections

MongoDB automatically creates these collections:

```
✓ users                    - User accounts and credentials
✓ profiles                 - User profile information
✓ problems                 - Coding problems and challenges
✓ user_progress           - User's problem-solving progress
✓ badges                  - Badge definitions and metadata
✓ user_badges             - Badges earned by users
✓ xp_transactions         - XP earning history
✓ user_stats              - User performance statistics
✓ challenges              - Coding challenges
✓ user_challenges         - Challenge participation
✓ assessments             - Tests and assessments
✓ user_assessments        - Assessment results
✓ interview_questions     - Interview prep questions
✓ portfolios              - User portfolios
✓ projects                - Portfolio projects
✓ resumes                 - Resume versions
✓ roadmaps                - Learning roadmaps
✓ user_roadmaps           - Roadmap progress
✓ cheatsheets             - Quick references
✓ ai_messages             - Chat history
```

---

## 🔧 Configuration

### application.properties
```properties
# Server
server.port=8080
spring.application.name=newcampvex

# MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/uservex

# JWT Configuration
app.jwt.secret=your-secret-key-change-in-production-must-be-32-chars
app.jwt.expiration=86400000

# Session
server.servlet.session.cookie.http-only=true
server.servlet.session.cookie.secure=false
server.servlet.session.cookie.same-site=strict
```

---

## 🐳 Docker Deployment

### Dockerfile
```dockerfile
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/newcampvex-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

### Build Docker Image
```bash
mvn clean package -DskipTests
docker build -t campvex-backend:1.0.0 .
```

### Run Docker Container
```bash
docker run -p 8080:8080 \
  -e SPRING_DATA_MONGODB_URI=mongodb://mongo:27017/uservex \
  -e APP_JWT_SECRET=your-secret-key \
  campvex-backend:1.0.0
```

---

## 📋 API Response Formats

### Success Response (200, 201)
```json
{
  "id": "507f1f77bcf86cd799439011",
  "name": "Example",
  "createdAt": "2026-02-05T10:30:00Z",
  ...
}
```

### Error Response (400, 401, 404, 500)
```json
{
  "status": 400,
  "message": "Invalid request parameters",
  "timestamp": "2026-02-05T10:30:00Z",
  "path": "/api/endpoint"
}
```

### List Response
```json
[
  { "id": "1", "name": "Item 1" },
  { "id": "2", "name": "Item 2" },
  ...
]
```

---

## ✅ Production Checklist

Before deploying to production:

- [ ] Change JWT secret to strong random string (32+ chars)
- [ ] Update MongoDB URI to production database
- [ ] Enable HTTPS/SSL certificates
- [ ] Configure CORS for specific domains only
- [ ] Setup database backups
- [ ] Enable database indexes for queries
- [ ] Configure logging to file
- [ ] Setup monitoring and alerts
- [ ] Rate limiting for APIs
- [ ] Implement request validation
- [ ] Error logging and tracking
- [ ] Database replication setup

---

## 📖 Documentation Files

- **[BACKEND_API_DOCUMENTATION.md](./BACKEND_API_DOCUMENTATION.md)** - Complete API reference with examples
- **[README.md](../NewCampVex/README.md)** - Frontend documentation
- **[pom.xml](./pom.xml)** - Maven dependencies
- **[application.properties](./src/main/resources/application.properties)** - Configuration

---

## 🛠️ Troubleshooting

### MongoDB Connection Error
```
Error: connect ECONNREFUSED 127.0.0.1:27017
Solution: Ensure MongoDB is running (mongod)
```

### JWT Token Expired
```
Error: 403 Forbidden - Token expired
Solution: Login again to get new token
```

### Port Already in Use
```
Error: Address already in use
Solution: netstat -ano | findstr :8080
         taskkill /PID <PID> /F
         Or change port in application.properties
```

### Build Fails
```bash
# Clean and rebuild
mvn clean install -DskipTests

# Check Java version
java -version  # Should be 21+

# Update Maven
mvn -v  # Should be 3.8+
```

---

## 📞 Support

For issues or questions:
1. Check [BACKEND_API_DOCUMENTATION.md](./BACKEND_API_DOCUMENTATION.md)
2. Review console logs for error messages
3. Check MongoDB logs
4. Verify configuration in application.properties
5. Check network connectivity
6. Review Spring Boot logs for stack traces

---

## 📝 Development Notes

### Adding New Endpoints
1. Create entity model in `models/`
2. Create repository in `repositories/`
3. Create service interface and implementation in `services/`
4. Create controller in `controllers/`
5. Add routes documentation
6. Write tests

### Best Practices
- Always use dependency injection (@RequiredArgsConstructor)
- Add proper exception handling
- Use Optional instead of null checks
- Implement proper validation
- Document all endpoints
- Use consistent naming conventions
- Keep controllers thin (delegate to services)
- Keep services focused (single responsibility)

---

## 📄 License

This project is part of CampVex platform. All rights reserved.

---

**Last Updated:** February 5, 2026  
**Version:** 1.0.0  
**Status:** ✅ Production Ready  
**Total Files:** 94 Java classes  
**Total Endpoints:** 50+ REST endpoints  
**Total Models:** 20 entity classes
