# CampVex Backend API Documentation

## 📋 Table of Contents
1. [Overview](#overview)
2. [Project Structure](#project-structure)
3. [Setup Instructions](#setup-instructions)
4. [Database Configuration](#database-configuration)
5. [Authentication](#authentication)
6. [API Endpoints](#api-endpoints)
7. [Data Models](#data-models)
8. [Error Handling](#error-handling)
9. [Testing](#testing)

---

## 🎯 Overview

**CampVex Backend** is a comprehensive REST API built with **Spring Boot 3**, **MongoDB**, and **JWT Authentication**. It supports all features of the CampVex platform including problem solving, challenges, assessments, portfolios, resumes, and gamification.

### Key Features
- ✅ JWT-based Authentication & Authorization
- ✅ 15+ Data Models for complete platform functionality
- ✅ RESTful API endpoints with CRUD operations
- ✅ MongoDB integration for scalability
- ✅ Spring Security for API protection
- ✅ CORS support for frontend integration

---

## 📁 Project Structure

```
newcampvex-backend/
├── src/main/java/com/newcampvex/newcampvex/
│   ├── config/
│   │   └── SecurityConfig.java              # Security configuration
│   ├── controllers/                         # REST API endpoints
│   │   ├── UserController.java              # User authentication
│   │   ├── ProfileController.java           # User profiles
│   │   ├── ProblemController.java           # Coding problems
│   │   ├── UserProgressController.java      # Problem solving progress
│   │   ├── UserStatsController.java         # User statistics & XP
│   │   ├── AssessmentController.java        # Assessments & tests
│   │   ├── InterviewQuestionController.java # Interview prep
│   │   ├── PortfolioController.java         # Portfolio management
│   │   ├── ProjectController.java           # User projects
│   │   ├── ResumeController.java            # Resume builder
│   │   ├── ChallengeController.java         # Coding challenges
│   │   ├── RoadmapController.java           # Learning roadmaps
│   │   └── CheatsheetController.java        # Quick references
│   ├── models/                              # Entity classes
│   │   ├── User.java
│   │   ├── Profile.java
│   │   ├── Problem.java
│   │   ├── UserProgress.java
│   │   ├── Badge.java
│   │   ├── UserBadge.java
│   │   ├── XPTransaction.java
│   │   ├── UserStats.java
│   │   ├── Challenge.java
│   │   ├── UserChallenge.java
│   │   ├── Assessment.java
│   │   ├── UserAssessment.java
│   │   ├── InterviewQuestion.java
│   │   ├── Portfolio.java
│   │   ├── Project.java
│   │   ├── Resume.java
│   │   ├── Roadmap.java
│   │   ├── UserRoadmap.java
│   │   ├── Cheatsheet.java
│   │   └── AIMessage.java
│   ├── repositories/                        # Data access layer
│   │   └── [All Repository interfaces]
│   ├── services/                            # Business logic layer
│   │   ├── [Service interfaces]
│   │   └── [Service implementations]
│   ├── filters/
│   │   └── JwtAuthenticationFilter.java     # JWT token validation
│   ├── util/
│   │   └── JwtUtil.java                     # JWT utilities
│   └── NewcampvexApplication.java           # Main entry point
├── src/main/resources/
│   └── application.properties               # Configuration
└── pom.xml                                  # Maven dependencies
```

---

## 🚀 Setup Instructions

### Prerequisites
- Java 21 or higher
- Maven 3.8+
- MongoDB 5.0+ (local or Atlas)
- Git

### Installation Steps

1. **Clone the Repository**
```bash
cd d:\GithubProjects\OnlineCodingProject\newcampvex-backend
```

2. **Configure Application Properties**
```properties
# application.properties
spring.data.mongodb.uri=mongodb://localhost:27017/uservex
app.jwt.secret=your-secret-key-change-this-in-production-must-be-at-least-32-chars-long
app.jwt.expiration=86400000
server.port=8080
```

3. **Build the Project**
```bash
mvn clean install
```

4. **Run the Application**
```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

---

## 🗄️ Database Configuration

### MongoDB Setup

**Local Installation:**
```bash
# Windows
choco install mongodb-community

# After installation, start MongoDB
mongod

# Or run as service
net start MongoDB
```

**Atlas Cloud Database:**
1. Create account at [MongoDB Atlas](https://www.mongodb.com/cloud/atlas)
2. Create a cluster
3. Get connection string
4. Update `application.properties`:
```properties
spring.data.mongodb.uri=mongodb+srv://username:password@cluster.mongodb.net/database
```

### Collections
MongoDB automatically creates these collections:
- `users` - User accounts
- `profiles` - User profiles
- `problems` - Coding problems
- `user_progress` - Problem solving progress
- `badges` - Achievement badges
- `user_badges` - User earned badges
- `xp_transactions` - XP history
- `user_stats` - User statistics
- `challenges` - Coding challenges
- `user_challenges` - Challenge participation
- `assessments` - Tests and assessments
- `user_assessments` - Assessment results
- `interview_questions` - Interview prep questions
- `portfolios` - User portfolios
- `projects` - Portfolio projects
- `resumes` - Resume versions
- `roadmaps` - Learning roadmaps
- `user_roadmaps` - Roadmap progress
- `cheatsheets` - Quick reference guides
- `ai_messages` - AI chat history

---

## 🔐 Authentication

### JWT Token Flow

1. **User Login**
```
POST /api/users/login
Body: { "email": "user@example.com", "password": "password123" }
Response: { "token": "eyJhbGciOiJIUzI1NiIs...", "user": {...} }
```

2. **Request with Token**
```
Headers: Authorization: Bearer eyJhbGciOiJIUzI1NiIs...
```

3. **Token Validation**
- Tokens are validated by `JwtAuthenticationFilter`
- Invalid tokens return 401 Unauthorized
- Expired tokens return 403 Forbidden

### Security Configuration
- CORS enabled for frontend integration
- CSRF disabled for REST APIs
- Session management disabled (stateless)
- Password encoding with BCrypt

---

## 📡 API Endpoints

### 🔑 Authentication Endpoints

#### User Registration
```
POST /api/users/register
Content-Type: application/json

{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "SecurePassword123",
  "fullName": "John Doe",
  "role": "student"
}

Response (201 Created):
{
  "id": "507f1f77bcf86cd799439011",
  "username": "john_doe",
  "email": "john@example.com",
  "fullName": "John Doe",
  "role": "student",
  "active": true,
  "createdAt": "2026-02-05T10:30:00Z"
}
```

#### User Login
```
POST /api/users/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "SecurePassword123"
}

Response (200 OK):
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "user": {
    "id": "507f1f77bcf86cd799439011",
    "username": "john_doe",
    "email": "john@example.com",
    "fullName": "John Doe",
    "role": "student"
  }
}
```

---

### 👤 Profile Management

#### Create Profile
```
POST /api/profiles
Authorization: Bearer <token>
Content-Type: application/json

{
  "userId": "507f1f77bcf86cd799439011",
  "bio": "Full-stack developer passionate about learning",
  "profilePictureUrl": "https://example.com/pic.jpg",
  "skillsJson": "[\"Java\", \"React\", \"MongoDB\"]",
  "location": "San Francisco, CA",
  "phoneNumber": "+1-555-0123",
  "linkedInUrl": "https://linkedin.com/in/johndoe",
  "githubUrl": "https://github.com/johndoe"
}

Response (201 Created):
{
  "id": "507f1f77bcf86cd799439012",
  "userId": "507f1f77bcf86cd799439011",
  "bio": "Full-stack developer passionate about learning",
  "profilePictureUrl": "https://example.com/pic.jpg",
  "skillsJson": "[\"Java\", \"React\", \"MongoDB\"]",
  "location": "San Francisco, CA",
  "createdAt": "2026-02-05T10:30:00Z",
  "updatedAt": "2026-02-05T10:30:00Z"
}
```

#### Get Profile
```
GET /api/profiles/{profileId}
Authorization: Bearer <token>

Response (200 OK):
{
  "id": "507f1f77bcf86cd799439012",
  "userId": "507f1f77bcf86cd799439011",
  "bio": "Full-stack developer passionate about learning",
  ...
}
```

#### Get Profile by User ID
```
GET /api/profiles/user/{userId}
Authorization: Bearer <token>

Response (200 OK):
[Profile object]
```

#### Update Profile
```
PUT /api/profiles/{profileId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "bio": "Senior full-stack developer",
  ...
}

Response (200 OK):
[Updated profile object]
```

#### Delete Profile
```
DELETE /api/profiles/{profileId}
Authorization: Bearer <token>

Response (204 No Content)
```

---

### 📝 Problem Management

#### Create Problem
```
POST /api/problems
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Two Sum",
  "description": "Given an array of integers nums and an integer target...",
  "difficulty": "beginner",
  "category": "Arrays",
  "platform": "LeetCode",
  "externalLink": "https://leetcode.com/problems/two-sum/",
  "xpReward": 50,
  "tags": ["array", "hash-table", "two-pointers"],
  "sampleInput": "[2,7,11,15], target = 9",
  "sampleOutput": "[0,1]",
  "timeComplexity": "O(n)",
  "spaceComplexity": "O(n)"
}

Response (201 Created):
{
  "id": "507f1f77bcf86cd799439013",
  "title": "Two Sum",
  "difficulty": "beginner",
  "category": "Arrays",
  "platform": "LeetCode",
  "xpReward": 50,
  ...
}
```

#### Get Problem
```
GET /api/problems/{problemId}
Authorization: Bearer <token>

Response (200 OK):
[Problem object]
```

#### Get All Problems
```
GET /api/problems
Authorization: Bearer <token>

Response (200 OK):
[
  [Problem 1],
  [Problem 2],
  ...
]
```

#### Get Problems by Category
```
GET /api/problems/category/{category}
Authorization: Bearer <token>

Response (200 OK):
[
  [Problem 1],
  [Problem 2],
  ...
]
```

Example categories: `Arrays`, `Strings`, `Trees`, `Graphs`, `LinkedLists`, `DynamicProgramming`, `Sorting`, `Searching`

#### Get Problems by Difficulty
```
GET /api/problems/difficulty/{difficulty}
Authorization: Bearer <token>

Response (200 OK):
[Problems of that difficulty]
```

Valid difficulties: `beginner`, `intermediate`, `advanced`

#### Get Problems by Platform
```
GET /api/problems/platform/{platform}
Authorization: Bearer <token>

Response (200 OK):
[Problems from that platform]
```

Valid platforms: `LeetCode`, `HackerRank`, `GeeksforGeeks`, `CodeSignal`, `HackerEarth`

#### Search Problems
```
GET /api/problems/search?category=Arrays&difficulty=beginner
Authorization: Bearer <token>

Response (200 OK):
[Filtered problems]
```

#### Update Problem
```
PUT /api/problems/{problemId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Two Sum (Updated)",
  ...
}

Response (200 OK):
[Updated problem]
```

#### Delete Problem
```
DELETE /api/problems/{problemId}
Authorization: Bearer <token>

Response (204 No Content)
```

---

### 📊 User Progress Tracking

#### Create Progress Entry
```
POST /api/user-progress
Authorization: Bearer <token>
Content-Type: application/json

{
  "userId": "507f1f77bcf86cd799439011",
  "problemId": "507f1f77bcf86cd799439013",
  "status": "solving",
  "attempts": 1,
  "language": "Java",
  "solution": "public int[] twoSum(int[] nums, int target) { ... }",
  "timeSpent": 1200,
  "isOptimal": false
}

Response (201 Created):
{
  "id": "507f1f77bcf86cd799439014",
  "userId": "507f1f77bcf86cd799439011",
  "problemId": "507f1f77bcf86cd799439013",
  "status": "solving",
  "attempts": 1,
  ...
}
```

#### Get User Progress
```
GET /api/user-progress/user/{userId}
Authorization: Bearer <token>

Response (200 OK):
[
  [Progress 1],
  [Progress 2],
  ...
]
```

#### Get Progress by Status
```
GET /api/user-progress/user/{userId}/status/{status}
Authorization: Bearer <token>

Response (200 OK):
[Progress entries with that status]
```

Valid statuses: `not-started`, `solving`, `solved`

#### Get Specific Problem Progress
```
GET /api/user-progress/user/{userId}/problem/{problemId}
Authorization: Bearer <token>

Response (200 OK):
[Progress for that problem]
```

#### Update Progress
```
PUT /api/user-progress/{progressId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "status": "solved",
  "attempts": 2,
  "isOptimal": true
}

Response (200 OK):
[Updated progress]
```

#### Delete Progress
```
DELETE /api/user-progress/{progressId}
Authorization: Bearer <token>

Response (204 No Content)
```

---

### 🏆 User Statistics & Gamification

#### Create User Stats
```
POST /api/user-stats
Authorization: Bearer <token>
Content-Type: application/json

{
  "userId": "507f1f77bcf86cd799439011",
  "totalXP": 0,
  "level": 1,
  "problemsSolved": 0,
  "questionsAttempted": 0,
  "quizzesCompleted": 0,
  "currentStreak": 0,
  "longestStreak": 0,
  "averageScore": 0,
  "totalMinutesCoded": 0
}

Response (201 Created):
[User stats object]
```

#### Get User Stats
```
GET /api/user-stats/user/{userId}
Authorization: Bearer <token>

Response (200 OK):
{
  "id": "507f1f77bcf86cd799439015",
  "userId": "507f1f77bcf86cd799439011",
  "totalXP": 250,
  "level": 2,
  "problemsSolved": 5,
  "questionsAttempted": 15,
  "quizzesCompleted": 2,
  "currentStreak": 3,
  "longestStreak": 10,
  "averageScore": 85.5,
  "totalMinutesCoded": 4320,
  "aptitudeScore": 78,
  "dSAScore": 82,
  "codingScore": 88
}
```

#### Add XP Points
```
POST /api/user-stats/{userId}/add-xp?xp=100
Authorization: Bearer <token>

Response (200 OK):
[Updated stats with new XP and level]
```

#### Increment Problems Solved
```
POST /api/user-stats/{userId}/increment-problems-solved
Authorization: Bearer <token>

Response (200 OK):
[Updated stats with incremented problem count]
```

#### Update Streak
```
POST /api/user-stats/{userId}/update-streak
Authorization: Bearer <token>

Response (200 OK):
[Updated stats with new streak]
```

---

### 📋 Assessments & Tests

#### Create Assessment
```
POST /api/assessments
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Aptitude Test - Month 1",
  "description": "Comprehensive aptitude assessment",
  "category": "aptitude",
  "difficulty": "intermediate",
  "totalQuestions": 40,
  "timeLimit": 120,
  "questionIds": ["q1", "q2", "q3", ...],
  "passingScore": "60",
  "xpReward": 200,
  "isPublished": true
}

Response (201 Created):
[Assessment object]
```

#### Get Assessment
```
GET /api/assessments/{assessmentId}
Authorization: Bearer <token>

Response (200 OK):
[Assessment object]
```

#### Get All Assessments
```
GET /api/assessments
Authorization: Bearer <token>

Response (200 OK):
[Array of assessments]
```

#### Get Published Assessments
```
GET /api/assessments/published
Authorization: Bearer <token>

Response (200 OK):
[Published assessments]
```

#### Get Assessments by Category
```
GET /api/assessments/category/{category}
Authorization: Bearer <token>

Response (200 OK):
[Assessments in category]
```

Valid categories: `aptitude`, `dsa`, `coding`, `interview`, `general`

#### Update Assessment
```
PUT /api/assessments/{assessmentId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Updated Assessment Title",
  ...
}

Response (200 OK):
[Updated assessment]
```

#### Delete Assessment
```
DELETE /api/assessments/{assessmentId}
Authorization: Bearer <token>

Response (204 No Content)
```

---

### 💼 Interview Preparation

#### Create Interview Question
```
POST /api/interview-questions
Authorization: Bearer <token>
Content-Type: application/json

{
  "question": "What is polymorphism in Java?",
  "category": "Technical",
  "difficulty": "beginner",
  "topic": "Java",
  "sampleAnswer": "Polymorphism allows objects to take multiple forms...",
  "keyPoints": "Method overloading, Method overriding, Runtime polymorphism",
  "tips": ["Remember compile-time vs runtime polymorphism", "Provide code examples"],
  "rating": 4.5
}

Response (201 Created):
[Interview question object]
```

#### Get Interview Question
```
GET /api/interview-questions/{questionId}
Authorization: Bearer <token>

Response (200 OK):
[Question object]
```

#### Get All Questions
```
GET /api/interview-questions
Authorization: Bearer <token>

Response (200 OK):
[Array of questions]
```

#### Get Questions by Category
```
GET /api/interview-questions/category/{category}
Authorization: Bearer <token>

Response (200 OK):
[Questions in category]
```

Valid categories: `HR`, `Technical`, `Behavioral`, `General`

#### Get Questions by Topic
```
GET /api/interview-questions/topic/{topic}
Authorization: Bearer <token>

Response (200 OK):
[Questions on topic]
```

Valid topics: `Java`, `JavaScript`, `Python`, `SystemDesign`, `DataStructures`, `Algorithms`, `Leadership`

#### Update Question
```
PUT /api/interview-questions/{questionId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "sampleAnswer": "Updated answer...",
  ...
}

Response (200 OK):
[Updated question]
```

#### Delete Question
```
DELETE /api/interview-questions/{questionId}
Authorization: Bearer <token>

Response (204 No Content)
```

---

### 🎨 Portfolio Management

#### Create Portfolio
```
POST /api/portfolios
Authorization: Bearer <token>
Content-Type: application/json

{
  "userId": "507f1f77bcf86cd799439011",
  "title": "John's Portfolio",
  "description": "Full-stack development portfolio",
  "projectIds": ["proj1", "proj2", "proj3"],
  "skillTags": ["Java", "React", "MongoDB", "Spring Boot"],
  "portfolioUrl": "https://johndoe-portfolio.com",
  "theme": "dark",
  "isPublic": true,
  "views": 0
}

Response (201 Created):
[Portfolio object]
```

#### Get Portfolio
```
GET /api/portfolios/{portfolioId}
Authorization: Bearer <token>

Response (200 OK):
[Portfolio object]
```

#### Get Portfolio by User ID
```
GET /api/portfolios/user/{userId}
Authorization: Bearer <token>

Response (200 OK):
[User's portfolio]
```

#### Update Portfolio
```
PUT /api/portfolios/{portfolioId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Updated Portfolio",
  ...
}

Response (200 OK):
[Updated portfolio]
```

#### Delete Portfolio
```
DELETE /api/portfolios/{portfolioId}
Authorization: Bearer <token>

Response (204 No Content)
```

---

### 📦 Projects

#### Create Project
```
POST /api/projects
Authorization: Bearer <token>
Content-Type: application/json

{
  "userId": "507f1f77bcf86cd799439011",
  "title": "E-commerce Platform",
  "description": "Full-stack e-commerce application with payment integration",
  "imageUrl": "https://example.com/project.jpg",
  "repositoryUrl": "https://github.com/johndoe/ecommerce",
  "deployedUrl": "https://my-ecommerce.herokuapp.com",
  "technologies": ["Java", "Spring Boot", "React", "MongoDB"],
  "startDate": "2025-09-01",
  "endDate": "2025-12-31",
  "status": "completed",
  "likes": 0
}

Response (201 Created):
[Project object]
```

#### Get Project
```
GET /api/projects/{projectId}
Authorization: Bearer <token>

Response (200 OK):
[Project object]
```

#### Get User Projects
```
GET /api/projects/user/{userId}
Authorization: Bearer <token>

Response (200 OK):
[Array of user's projects]
```

#### Get Projects by Status
```
GET /api/projects/user/{userId}/status/{status}
Authorization: Bearer <token>

Response (200 OK):
[Projects with that status]
```

Valid statuses: `completed`, `in-progress`, `planned`

#### Update Project
```
PUT /api/projects/{projectId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Updated Title",
  ...
}

Response (200 OK):
[Updated project]
```

#### Delete Project
```
DELETE /api/projects/{projectId}
Authorization: Bearer <token>

Response (204 No Content)
```

---

### 📄 Resume Builder

#### Create Resume
```
POST /api/resumes
Authorization: Bearer <token>
Content-Type: application/json

{
  "userId": "507f1f77bcf86cd799439011",
  "title": "John's Resume - 2026",
  "templateName": "professional",
  "content": "{\"name\": \"John Doe\", \"email\": \"john@example.com\", ...}",
  "fileUrl": "https://example.com/resume.pdf",
  "isDefault": true,
  "downloads": 0
}

Response (201 Created):
[Resume object]
```

#### Get Resume
```
GET /api/resumes/{resumeId}
Authorization: Bearer <token>

Response (200 OK):
[Resume object]
```

#### Get User Resumes
```
GET /api/resumes/user/{userId}
Authorization: Bearer <token>

Response (200 OK):
[Array of user's resumes]
```

#### Get Default Resume
```
GET /api/resumes/user/{userId}/default
Authorization: Bearer <token>

Response (200 OK):
[Default resume]
```

#### Update Resume
```
PUT /api/resumes/{resumeId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Updated Resume",
  ...
}

Response (200 OK):
[Updated resume]
```

#### Delete Resume
```
DELETE /api/resumes/{resumeId}
Authorization: Bearer <token>

Response (204 No Content)
```

---

### 🏅 Challenges

#### Create Challenge
```
POST /api/challenges
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "30-Day Coding Challenge",
  "description": "Solve 30 problems in 30 days to earn special badge",
  "difficulty": "intermediate",
  "xpReward": 1000,
  "deadline": 1709510400000,
  "status": "active",
  "problemIds": ["p1", "p2", "p3", ...],
  "rules": "Must complete one problem per day"
}

Response (201 Created):
[Challenge object]
```

#### Get Challenge
```
GET /api/challenges/{challengeId}
Authorization: Bearer <token>

Response (200 OK):
[Challenge object]
```

#### Get All Challenges
```
GET /api/challenges
Authorization: Bearer <token>

Response (200 OK):
[Array of challenges]
```

#### Get Challenges by Status
```
GET /api/challenges/status/{status}
Authorization: Bearer <token>

Response (200 OK):
[Active/upcoming/closed challenges]
```

#### Update Challenge
```
PUT /api/challenges/{challengeId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "status": "closed",
  ...
}

Response (200 OK):
[Updated challenge]
```

#### Delete Challenge
```
DELETE /api/challenges/{challengeId}
Authorization: Bearer <token>

Response (204 No Content)
```

---

### 🗺️ Learning Roadmaps

#### Create Roadmap
```
POST /api/roadmaps
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Full-Stack Developer Path",
  "description": "Complete guide to become a full-stack developer",
  "category": "Full-Stack",
  "difficulty": "advanced",
  "milestoneJson": "[{\"title\": \"HTML/CSS\", \"duration\": 2}, ...]",
  "totalMilestones": 15,
  "estimatedHours": 500,
  "followersCount": 0
}

Response (201 Created):
[Roadmap object]
```

#### Get Roadmap
```
GET /api/roadmaps/{roadmapId}
Authorization: Bearer <token>

Response (200 OK):
[Roadmap object]
```

#### Get All Roadmaps
```
GET /api/roadmaps
Authorization: Bearer <token>

Response (200 OK):
[Array of roadmaps]
```

#### Get Roadmaps by Category
```
GET /api/roadmaps/category/{category}
Authorization: Bearer <token>

Response (200 OK):
[Roadmaps in category]
```

Valid categories: `Frontend`, `Backend`, `Full-Stack`, `Mobile`, `DSA`, `DevOps`, `CloudComputing`

#### Update Roadmap
```
PUT /api/roadmaps/{roadmapId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Updated Title",
  ...
}

Response (200 OK):
[Updated roadmap]
```

#### Delete Roadmap
```
DELETE /api/roadmaps/{roadmapId}
Authorization: Bearer <token>

Response (204 No Content)
```

---

### 📚 Cheatsheets

#### Create Cheatsheet
```
POST /api/cheatsheets
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Java Collections Cheatsheet",
  "category": "Backend",
  "topicsCount": 8,
  "examplesCount": 25,
  "difficulty": "intermediate",
  "description": "Quick reference for Java collections framework",
  "contentJson": "{\"topics\": [...]}",
  "tags": ["Java", "Collections", "Data Structures"],
  "downloads": 0
}

Response (201 Created):
[Cheatsheet object]
```

#### Get Cheatsheet
```
GET /api/cheatsheets/{cheatsheetId}
Authorization: Bearer <token>

Response (200 OK):
[Cheatsheet object]
```

#### Get All Cheatsheets
```
GET /api/cheatsheets
Authorization: Bearer <token>

Response (200 OK):
[Array of cheatsheets]
```

#### Get Cheatsheets by Category
```
GET /api/cheatsheets/category/{category}
Authorization: Bearer <token>

Response (200 OK):
[Cheatsheets in category]
```

#### Update Cheatsheet
```
PUT /api/cheatsheets/{cheatsheetId}
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Updated Title",
  ...
}

Response (200 OK):
[Updated cheatsheet]
```

#### Delete Cheatsheet
```
DELETE /api/cheatsheets/{cheatsheetId}
Authorization: Bearer <token>

Response (204 No Content)
```

---

## 📚 Data Models

### User Model
```json
{
  "id": "MongoDB ObjectId",
  "username": "Unique username",
  "email": "Unique email address",
  "passwordHash": "BCrypt hashed password",
  "fullName": "User's full name",
  "role": "student | instructor | admin",
  "bio": "Optional bio",
  "active": "Boolean status",
  "createdAt": "ISO 8601 timestamp",
  "updatedAt": "ISO 8601 timestamp",
  "lastLoginAt": "ISO 8601 timestamp"
}
```

### Profile Model
```json
{
  "id": "MongoDB ObjectId",
  "userId": "Foreign key to User",
  "bio": "User biography",
  "profilePictureUrl": "Profile picture URL",
  "skillsJson": "JSON array of skills",
  "experienceJson": "JSON array of experiences",
  "educationJson": "JSON array of education",
  "portfolioUrl": "Portfolio website URL",
  "resumeUrl": "Resume URL",
  "linkedInUrl": "LinkedIn profile",
  "githubUrl": "GitHub profile",
  "location": "User location",
  "phone": "Contact phone",
  "createdAt": "ISO 8601 timestamp",
  "updatedAt": "ISO 8601 timestamp"
}
```

### Problem Model
```json
{
  "id": "MongoDB ObjectId",
  "title": "Problem title",
  "description": "Full problem description",
  "difficulty": "beginner | intermediate | advanced",
  "category": "Problem category",
  "platform": "LeetCode | HackerRank | GeeksforGeeks",
  "externalLink": "Link to problem",
  "xpReward": "Points for solving",
  "tags": "Array of tags",
  "sampleInput": "Example input",
  "sampleOutput": "Example output",
  "testCases": "Array of test cases",
  "solutionsCount": "Number of solutions",
  "successRate": "Success percentage",
  "timeComplexity": "Time complexity",
  "spaceComplexity": "Space complexity",
  "createdAt": "ISO 8601 timestamp",
  "updatedAt": "ISO 8601 timestamp"
}
```

### UserStats Model
```json
{
  "id": "MongoDB ObjectId",
  "userId": "Foreign key to User",
  "totalXP": "Total experience points",
  "level": "Current level",
  "problemsSolved": "Count of problems solved",
  "questionsAttempted": "Count of questions",
  "quizzesCompleted": "Count of quizzes",
  "assessmentsPassed": "Count of assessments",
  "currentStreak": "Consecutive days",
  "longestStreak": "All-time longest",
  "averageScore": "Average test score",
  "totalMinutesCoded": "Total coding time",
  "aptitudeScore": "Aptitude test score",
  "dSAScore": "DSA test score",
  "codingScore": "Coding test score",
  "createdAt": "ISO 8601 timestamp",
  "updatedAt": "ISO 8601 timestamp"
}
```

### Other Models
See [Model Reference](#data-models) for complete documentation of all 20+ data models

---

## ❌ Error Handling

### Error Response Format
```json
{
  "status": 400,
  "message": "Error description",
  "timestamp": "ISO 8601 timestamp",
  "path": "Request path"
}
```

### Common HTTP Status Codes
| Code | Meaning | Scenario |
|------|---------|----------|
| 200 | OK | Successful GET/PUT request |
| 201 | Created | Successful POST request |
| 204 | No Content | Successful DELETE request |
| 400 | Bad Request | Invalid request parameters |
| 401 | Unauthorized | Missing or invalid authentication |
| 403 | Forbidden | Insufficient permissions |
| 404 | Not Found | Resource doesn't exist |
| 409 | Conflict | Duplicate entry (e.g., email) |
| 500 | Server Error | Unexpected server error |

### Common Error Scenarios

**Missing Authentication Token**
```
401 Unauthorized
{ "message": "Missing or invalid authentication token" }
```

**Invalid Credentials**
```
401 Unauthorized
{ "message": "Invalid email or password" }
```

**Resource Not Found**
```
404 Not Found
{ "message": "Problem with ID 'xyz' not found" }
```

**Duplicate Email**
```
409 Conflict
{ "message": "Email already registered" }
```

**Validation Error**
```
400 Bad Request
{ "message": "Invalid input: title cannot be empty" }
```

---

## 🧪 Testing

### Unit Tests
```bash
mvn test
```

### Integration Tests
```bash
mvn test -Dgroups=integration
```

### Test API Locally
Use Postman or cURL:

```bash
# Register user
curl -X POST http://localhost:8080/api/users/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "email": "test@example.com",
    "password": "Test@123",
    "fullName": "Test User",
    "role": "student"
  }'

# Login
curl -X POST http://localhost:8080/api/users/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "test@example.com",
    "password": "Test@123"
  }'

# Get profile (with token)
curl -X GET http://localhost:8080/api/profiles/user/{userId} \
  -H "Authorization: Bearer <your-token>"
```

---

## 🚀 Deployment

### Docker
```dockerfile
FROM openjdk:21-jdk
COPY target/newcampvex-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

### Production Checklist
- [ ] Change JWT secret to strong random string (32+ chars)
- [ ] Update MongoDB connection to production database
- [ ] Enable HTTPS/SSL
- [ ] Set up proper error logging
- [ ] Configure CORS for production domain only
- [ ] Setup database backups
- [ ] Enable rate limiting
- [ ] Configure API versioning
- [ ] Setup monitoring and alerts

---

## 📞 Support & Documentation

For questions or issues:
1. Check existing documentation
2. Review error messages in logs
3. Contact development team
4. Open GitHub issue

---

**Last Updated:** February 5, 2026  
**Version:** 1.0.0  
**Java Version:** 21  
**Spring Boot:** 3.5.10  
**MongoDB:** 5.0+
