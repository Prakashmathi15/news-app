# News Application 📰

This is a **Spring Boot + Thymeleaf** based web application to fetch and display news articles categorized as **All News**, **National News**, and **International News**.

---

## ✨ Features
- Fetches **live news** from **News API**.
- Stores news articles in **local database** (MySQL/PostgreSQL/H2) for faster loading.
- Divides news into:
  - All News
  - National News
  - International News
- Simple and clean **User Interface** with a **Navigation Bar**.
- Option to refresh news by fetching new articles from News API.

---

## 🏗️ Project Structure
| Folder/File | Purpose |
|:---|:---|
| `controller/` | Contains controllers to handle web requests |
| `service/` | Fetches news from API and saves to database |
| `model/News.java` | News entity/model representing each news article |
| `repository/NewsRepository.java` | Database operations using JPA |
| `templates/news.html` | Front-end HTML page using Thymeleaf |
| `application.properties` | Project configurations (DB, server, etc.) |

---

## ⚙️ Technologies Used
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Thymeleaf**
- **HTML + CSS**
- **NewsAPI.org** (for fetching news)
- **MySQL / H2 Database**

---

## 🔥 How it Works
1. **NewsApiService** calls the NewsAPI and fetches the latest articles.
2. Fetched news articles are **stored in the local database** (only required fields).
3. Frontend (HTML/Thymeleaf) loads data from the database and shows it to the user.
4. User can **navigate** through All News, National, and International categories.
5. New articles can be refreshed from NewsAPI when needed.

---

## 🛠️ Setup Instructions
1. Clone this repository:
   ```bash
   git clone https://github.com/Prakashmathi15/news-app.git
