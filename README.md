![Logo](https://github.com/user-attachments/assets/183a3d07-731c-4009-8432-33424ae85cf5)

# Tashkelah ⚽

Tashkelah is a community-driven sports booking platform built as a final project for the Tuwaiq Academy Java Bootcamp. It enables players to join matches solo or with friends, and allows organizers to manage sports fields, create matches, and coordinate bookings — all through a structured, role-based system.

---

## 🚀 Features

- Player registration and team creation (solo or with friends)
- Organizer registration and field management (after admin approval)
- Private match flow for friends
- Public match flow for solo players
- Match filtering by sport and location
- Booking system with price split per player
- Payment integration via Moyasar
- Email and WhatsApp notifications
- Admin management and monitoring capabilities

---

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring Security
- JPA & Hibernate
- MySQL
- RESTful APIs
- Lombok
- Maven
- Moyasar API (payment gateway)
- JavaMailSender (email)
- WhatsApp API (Twilio or custom)

## 📊 Architecture Diagrams

### 🔷 Class Diagram
> ![Class Diagram](https://github.com/user-attachments/assets/34b72330-2fcf-44b2-9601-23ca824e6516)


### 🔶 Use Case Diagram
> ![Use Case Diagram](https://github.com/user-attachments/assets/28508414-0733-4256-9e8c-9f1bf774dceb)


---

## 📬 API Documentation

- 🔗 [Postman Documentation](https://documenter.getpostman.com/view/42844638/2sB2qUmPwG)
- Base URL: `http://tuwaiq-app-env.eba-9nhuvpa3.eu-central-1.elasticbeanstalk.com`

---

## 🎨 Figma Design

- 🔗 [View UI on Figma](https://www.figma.com/design/3wzDvkE6kbXGBVgeGu4lnF/%D8%AA%D8%B4%D9%83%D9%8A%D9%84%D8%A9?node-id=9-2&p=f&t=T7G5n1vvnv9yWZfH-0)

---

## 🧰 Endpoints Table

| #  | Endpoint Description                                        | Creator |
|----|-------------------------------------------------------------|---------|
| 1  | Register organizer                                          | Taha    |
| 2  | Admin approve organizer                                     | Taha    |
| 3  | Reject organizer                                            | Taha    |
| 4  | Block organizer                                             | Taha    |
| 5  | Send approve notification With a logg to organizer          | Taha    |
| 6  | Send reject notification to organizer                       | Taha    |
| 7  | Send block notification to organizer                        | Taha    |
| 10 | Add field                                                   | Taha    |
| 11 | Save uploaded field image                                   | Taha    |
| 12 | Update field information                                    | Taha    |
| 13 | Delete field image                                          | Taha    |
| 14 | Get fields for an organizer                                 | Taha    |
| 15 | Get booked time slots for a field                           | Taha    |
| 16 | Get available time slots for a field                        | Taha    |
| 19 | Create public match                                         | Taha    |
| 20 | Show matches for a field (public + private)                 | Taha    |
| 21 | Add teams for a public match                                | Taha    |

![image](https://github.com/user-attachments/assets/de548e43-92d5-4027-9a52-ba22f225348a)
![image](https://github.com/user-attachments/assets/2266e82f-4578-4e21-9cab-ef7780f7a679)
![image](https://github.com/user-attachments/assets/9fe21e66-76e8-4935-b13f-b596f1de2457)
https://documenter.getpostman.com/view/42844638/2sB2qUmPwG
https://www.figma.com/design/3wzDvkE6kbXGBVgeGu4lnF/%D8%AA%D8%B4%D9%83%D9%8A%D9%84%D8%A9?t=NHs8mJQeVTiIq1LU-0


