Create database SWD_HospitalManagement;

use SWD_HospitalManagement;

-- Tạo dữ liệu mẫu cho bảng Doctor
INSERT INTO Doctor (doctorId, LastName, PhoneNumber, Specialty, email, firstName) VALUES
                                                                                      (1, 'Smith', '1234567890', 'Cardiology', 'smith@example.com', 'John'),
                                                                                      (2, 'Johnson', '2345678901', 'Neurology', 'johnson@example.com', 'Michael'),
                                                                                      (3, 'Williams', '3456789012', 'Orthopedics', 'williams@example.com', 'David'),
                                                                                      (4, 'Brown', '4567890123', 'Pediatrics', 'brown@example.com', 'James'),
                                                                                      (5, 'Jones', '5678901234', 'Dermatology', 'jones@example.com', 'Robert'),
                                                                                      (6, 'Garcia', '6789012345', 'Ophthalmology', 'garcia@example.com', 'Maria'),
                                                                                      (7, 'Martinez', '7890123456', 'Gastroenterology', 'martinez@example.com', 'Carlos'),
                                                                                      (8, 'Rodriguez', '8901234567', 'Pulmonology', 'rodriguez@example.com', 'Luis'),
                                                                                      (9, 'Lee', '9012345678', 'Urology', 'lee@example.com', 'Anna'),
                                                                                      (10, 'Walker', '0123456789', 'Endocrinology', 'walker@example.com', 'Nancy');

-- Tạo dữ liệu mẫu cho bảng Patient
INSERT INTO Patient (patientId, address, dob, email, firstName, lastName, phoneNumber) VALUES
                                                                                           (1, '123 Elm St', '1980-01-01', 'patient1@example.com', 'Alice', 'Smith', '1112223333'),
                                                                                           (2, '456 Oak St', '1985-02-02', 'patient2@example.com', 'Bob', 'Johnson', '2223334444'),
                                                                                           (3, '789 Pine St', '1990-03-03', 'patient3@example.com', 'Charlie', 'Williams', '3334445555'),
                                                                                           (4, '101 Maple St', '1975-04-04', 'patient4@example.com', 'David', 'Brown', '4445556666'),
                                                                                           (5, '202 Birch St', '1965-05-05', 'patient5@example.com', 'Emma', 'Jones', '5556667777'),
                                                                                           (6, '303 Cedar St', '1995-06-06', 'patient6@example.com', 'Fiona', 'Garcia', '6667778888'),
                                                                                           (7, '404 Walnut St', '2000-07-07', 'patient7@example.com', 'George', 'Martinez', '7778889999'),
                                                                                           (8, '505 Chestnut St', '1998-08-08', 'patient8@example.com', 'Hannah', 'Rodriguez', '8889990000'),
                                                                                           (9, '606 Ash St', '1992-09-09', 'patient9@example.com', 'Ian', 'Lee', '9990001111'),
                                                                                           (10, '707 Fir St', '1988-10-10', 'patient10@example.com', 'Jack', 'Walker', '0001112222');

-- Tạo dữ liệu mẫu cho bảng Receptionist
INSERT INTO Receptionist (receptionistId, PhoneNumber, email, firstName, lastName) VALUES
                                                                                       (1, '1234567890', 'receptionist1@example.com', 'Jane', 'Doe'),
                                                                                       (2, '2345678901', 'receptionist2@example.com', 'Emily', 'Smith'),
                                                                                       (3, '3456789012', 'receptionist3@example.com', 'Anna', 'Johnson'),
                                                                                       (4, '4567890123', 'receptionist4@example.com', 'Olivia', 'Brown'),
                                                                                       (5, '5678901234', 'receptionist5@example.com', 'Sophia', 'Williams'),
                                                                                       (6, '6789012345', 'receptionist6@example.com', 'Mia', 'Jones'),
                                                                                       (7, '7890123456', 'receptionist7@example.com', 'Amelia', 'Garcia'),
                                                                                       (8, '8901234567', 'receptionist8@example.com', 'Harper', 'Martinez'),
                                                                                       (9, '9012345678', 'receptionist9@example.com', 'Evelyn', 'Rodriguez'),
                                                                                       (10, '0123456789', 'receptionist10@example.com', 'Abigail', 'Lee');

-- Tạo dữ liệu mẫu cho bảng Appointment
INSERT INTO Appointment (appointmentId, appointmentDate, appointmentTime, reason, receptionistId, status, doctorId, patientId, appointmentEndTime, appointmentStartTime) VALUES
                                                                                                                                                                             (1, '2023-07-15', '2023-07-15 10:00:00', 'Routine Checkup', 1, 'Scheduled', 1, 1, '2023-07-15 11:00:00', '2023-07-15 10:00:00'),
                                                                                                                                                                             (2, '2023-07-16', '2023-07-16 11:00:00', 'Flu Symptoms', 2, 'Scheduled', 2, 2, '2023-07-16 12:00:00', '2023-07-16 11:00:00'),
                                                                                                                                                                             (3, '2023-07-17', '2023-07-17 12:00:00', 'Back Pain', 3, 'Scheduled', 3, 3, '2023-07-17 13:00:00', '2023-07-17 12:00:00'),
                                                                                                                                                                             (4, '2023-07-18', '2023-07-18 13:00:00', 'Skin Rash', 4, 'Scheduled', 4, 4, '2023-07-18 14:00:00', '2023-07-18 13:00:00'),
                                                                                                                                                                             (5, '2023-07-19', '2023-07-19 14:00:00', 'Headache', 5, 'Scheduled', 5, 5, '2023-07-19 15:00:00', '2023-07-19 14:00:00'),
                                                                                                                                                                             (6, '2023-07-20', '2023-07-20 15:00:00', 'Eye Checkup', 6, 'Scheduled', 6, 6, '2023-07-20 16:00:00', '2023-07-20 15:00:00'),
                                                                                                                                                                             (7, '2023-07-21', '2023-07-21 16:00:00', 'Stomach Pain', 7, 'Scheduled', 7, 7, '2023-07-21 17:00:00', '2023-07-21 16:00:00'),
                                                                                                                                                                             (8, '2023-07-22', '2023-07-22 17:00:00', 'Cough', 8, 'Scheduled', 8, 8, '2023-07-22 18:00:00', '2023-07-22 17:00:00'),
                                                                                                                                                                             (9, '2023-07-23', '2023-07-23 18:00:00', 'Kidney Pain', 9, 'Scheduled', 9, 9, '2023-07-23 19:00:00', '2023-07-23 18:00:00'),
                                                                                                                                                                             (10, '2023-07-24', '2023-07-24 19:00:00', 'Diabetes Checkup', 10, 'Scheduled', 10, 10, '2023-07-24 20:00:00', '2023-07-24 19:00:00');

-- Tạo dữ liệu mẫu cho bảng PatientHistory
INSERT INTO PatientHistory (historyId, description, diagnosis, notes, prescription, visitDate, doctorId, patientId) VALUES
                                                                                                                        (1, 'Checkup for flu symptoms', 'Flu', 'Rest and hydration recommended', 'Paracetamol', '2023-07-15', 1, 1),
                                                                                                                        (2, 'Routine checkup', 'Healthy', 'No issues found', 'None', '2023-07-16', 2, 2),
                                                                                                                        (3, 'Back pain examination', 'Muscle strain', 'Physical therapy recommended', 'Ibuprofen', '2023-07-17', 3, 3),
                                                                                                                        (4, 'Skin rash', 'Dermatitis', 'Avoid allergens', 'Hydrocortisone cream', '2023-07-18', 4, 4),
                                                                                                                        (5, 'Headache', 'Tension headache', 'Stress management techniques', 'Acetaminophen', '2023-07-19', 5, 5),
                                                                                                                        (6, 'Eye checkup', 'Healthy', 'No issues found', 'None', '2023-07-20', 6, 6),
                                                                                                                        (7, 'Stomach pain', 'Gastritis', 'Avoid spicy food', 'Antacids', '2023-07-21', 7, 7),
                                                                                                                        (8, 'Cough', 'Bronchitis', 'Rest and fluids', 'Cough syrup', '2023-07-22', 8, 8),
                                                                                                                        (9, 'Kidney pain', 'Kidney stones', 'Increase water intake', 'Pain relievers', '2023-07-23', 9, 9),
                                                                                                                        (10, 'Diabetes checkup', 'Type 2 diabetes', 'Monitor blood sugar levels', 'Metformin', '2023-07-24', 10, 10);