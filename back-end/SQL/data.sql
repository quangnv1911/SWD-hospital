# Create database SWD_HospitalManagement;

use SWD_HospitalManagement;

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

INSERT INTO Patient (patientId, address, email, firstName, lastName, phoneNumber, dob, gender) VALUES
                                                                                           (1, '123 Main St', 'patient1@example.com', 'John', 'Doe', '555-1234', '1990-01-01', 'MALE'),
                                                                                           (2, '456 Elm St', 'patient2@example.com', 'Jane', 'Smith', '555-5678', '1985-05-15', 'MALE'),
                                                                                           (3, '789 Oak St', 'patient3@example.com', 'Alice', 'Johnson', '555-8765', '1970-10-10', 'MALE'),
                                                                                           (4, '101 Maple St', 'patient4@example.com', 'Bob', 'Brown', '555-4321', '2000-07-07', 'MALE'),
                                                                                           (5, '202 Pine St', 'patient5@example.com', 'Charlie', 'Davis', '555-6789', '1965-03-03', 'MALE'),
                                                                                           (6, '303 Birch St', 'patient6@example.com', 'David', 'Wilson', '555-3456', '1995-12-12', 'FEMALE'),
                                                                                           (7, '404 Cedar St', 'patient7@example.com', 'Eve', 'White', '555-6543', '1980-02-28', 'FEMALE'),
                                                                                           (8, '505 Spruce St', 'patient8@example.com', 'Frank', 'Moore', '555-7890', '1975-09-09', 'FEMALE'),
                                                                                           (9, '606 Fir St', 'patient9@example.com', 'Grace', 'Taylor', '555-0123', '1992-06-06', 'FEMALE'),
                                                                                           (10, '707 Redwood St', 'patient10@example.com', 'Hank', 'Anderson', '555-2345', '1988-11-11', 'FEMALE');

INSERT INTO Doctor (doctorId, lastName, firstName, email, speciality) VALUES
                                                                         (1, 'Williams', 'Emily', 'doctor1@example.com', 'Cardiology'),
                                                                         (2, 'Jones', 'Michael', 'doctor2@example.com', 'Neurology'),
                                                                         (3, 'Miller', 'Sarah', 'doctor3@example.com', 'Pediatrics'),
                                                                         (4, 'Davis', 'James', 'doctor4@example.com', 'Orthopedics'),
                                                                         (5, 'Garcia', 'David', 'doctor5@example.com', 'Dermatology'),
                                                                         (6, 'Rodriguez', 'Maria', 'doctor6@example.com', 'Ophthalmology'),
                                                                         (7, 'Martinez', 'Robert', 'doctor7@example.com', 'Psychiatry'),
                                                                         (8, 'Hernandez', 'Linda', 'doctor8@example.com', 'Gastroenterology'),
                                                                         (9, 'Lopez', 'William', 'doctor9@example.com', 'Endocrinology'),
                                                                         (10, 'Gonzalez', 'Elizabeth', 'doctor10@example.com', 'Rheumatology');

INSERT INTO Appointment (appointmentId, appointmentDate, appointmentStartTime, appointmentEndTime, doctorId, patientId, reason, status, receptionistId) VALUES
                                                                                                                                            (1, '2024-07-01', '10:00:00', '10:30:00', 1, 1, 'Regular Checkup', 'PENDING', 1),
                                                                                                                                            (2, '2024-07-02', '11:00:00', '11:30:00', 2, 2, 'Headache', 'CONFIRMED',2),
                                                                                                                                            (3, '2024-07-03', '09:00:00', '09:30:00', 3, 3, 'Fever', 'CANCELLED',3),
                                                                                                                                            (4, '2024-07-04', '14:00:00', '14:30:00', 4, 4, 'Knee Pain', 'PENDING',4),
                                                                                                                                            (5, '2024-07-05', '15:00:00', '15:30:00', 5, 5, 'Skin Rash', 'CONFIRMED',5),
                                                                                                                                            (6, '2024-07-06', '13:00:00', '13:30:00', 6, 6, 'Eye Checkup', 'CANCELLED',6),
                                                                                                                                            (7, '2024-07-07', '08:00:00', '08:30:00', 7, 7, 'Anxiety', 'PENDING',7),
                                                                                                                                            (8, '2024-07-08', '10:30:00', '11:00:00', 8, 8, 'Stomach Ache', 'CONFIRMED',8),
                                                                                                                                            (9, '2024-07-09', '12:00:00', '12:30:00', 9, 9, 'Diabetes Management', 'CANCELLED',9),
                                                                                                                                            (10, '2024-07-10', '14:30:00', '15:00:00', 10, 10, 'Arthritis', 'PENDING',10);

INSERT INTO PatientHistory (patientHistoryId, visitDate, doctorId, patientId, diagnosis, notes) VALUES
                                                                                                    (1, '2024-07-01', 1, 1, 'Good Health', 'No issues. Regular checkup.'),
                                                                                                    (2, '2024-07-02', 2, 2, 'Migraine', 'Prescribed medication.'),
                                                                                                    (3, '2024-07-03', 3, 3, 'Viral Fever', 'Advised rest and fluids.'),
                                                                                                    (4, '2024-07-04', 4, 4, 'Sprained Knee', 'Referred to physiotherapy.'),
                                                                                                    (5, '2024-07-05', 5, 5, 'Eczema', 'Prescribed topical ointment.'),
                                                                                                    (6, '2024-07-06', 6, 6, 'Normal Vision', 'Routine eye checkup.'),
                                                                                                    (7, '2024-07-07', 7, 7, 'Anxiety', 'Referred to counseling.'),
                                                                                                    (8, '2024-07-08', 8, 8, 'Gastritis', 'Prescribed antacids.'),
                                                                                                    (9, '2024-07-09', 9, 9, 'Type 2 Diabetes', 'Adjusting medication dosage.'),
                                                                                                    (10, '2024-07-10', 10, 10, 'Rheumatoid Arthritis', 'Prescribed anti-inflammatory drugs.');
