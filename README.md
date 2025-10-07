# Eventify – Event Management Platform

Eventify is a full-stack event management platform that allows users to browse and book events, while organizers can manage their events and track registrations. The platform includes an **Admin Dashboard** to monitor platform statistics and manage users, events, and bookings.

---

## 🚀 Features

### For Users:
- Sign up and log in.
- Browse events.
- Book events and track bookings.
- Receive notifications for confirmed bookings.

### For Organizers:
- Create, manage, and update events.
- View registrations and attendee details.
- Manage their profile and event dashboard.

### Admin Dashboard:
- Monitor total users, organizers, events, bookings, and revenue.
- View details for users, organizers, events, and bookings.
- Manage platform data efficiently.
- Logout functionality.

---

## 🛠 Technologies Used
- **Frontend:** React.js  
- **Backend:** Spring Boot   
- **Database:** MySQL  
- **APIs:** RESTful APIs for CRUD operations  

---

## ⚙️ Setup & Installation

1. **Clone the repository:**
```bash
git clone https://github.com/yourusername/Event_Management.git
```
2. **Start backend:**
-> replace 'your_password' in application.properties with your actual MySQL Database Server password and username if needed
```bash
cd backend
# Start server
mvn spring-boot:run
```
3. **Start frontend:**
```bash
cd frontend
# Install dependencies
npm install
# Start React app
npm start
```
4. **Database setup:**
-> for creating admin credintials, follow the below steps (optional)
```bash
USE eventdb
INSERT INTO roles (id, name) VALUES (1, 'ROLE_USER'),(2, 'ROLE_ADMIN'),(3, 'ROLE_ORGANIZER');
INSERT INTO users (id, email, password, username, name, role_id) VALUES (1, 'admin1@gmail.com', 'admin1', 'admin1', 'admin1', 2);
```
