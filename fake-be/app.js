const express = require('express');
const app = express();
const port = 8080;

app.get('/', function (req, res) {
    res.send("Hello World");
})


app.get('/appointment/new-appointment', function (req, res) {
    
    // api gọi tới
    // http://localhost:8080/appointment/new-appointment?status=pending
    const appointmentStatus = req.query.status;
    var appointments;

    switch (appointmentStatus) {
        case "pending":
            appointments = [
                {
                    appointmentId: 1,
                    patientId: 1,
                    patientName: "Nguyen Van A",
                    patientPhone: "80809",
                    patientEmail: "a@gmail.com",
                    dateBooking: "2030-3-2",
                    status: "pending",
                },
                {
                    appointmentId: 2,
                    patientId: 2,
                    patientName: "Nguyen Van A",
                    patientPhone: "80809",
                    patientEmail: "a@gmail.com",
                    dateBooking: "2023-20-2",
                    status: "pending",

                }
            ];
            res.json(appointments);
            break;
        case "confirm":
            appointments = [
                {
                    appointmentId: 1,
                    patientId: 1,
                    patientName: "Nguyen Van A",
                    patientPhone: "80809",
                    patientEmail: "a@gmail.com",
                    dateBooking: "2030-3-2",
                    status: "confirm",
                },
                {
                    appointmentId: 2,
                    patientId: 2,
                    patientName: "Nguyen Van A",
                    patientPhone: "80809",
                    patientEmail: "a@gmail.com",
                    dateBooking: "2023-20-2",
                    status: "confirm",
                }
            ];
            res.json(appointments);
            break;
        case "cancel":
            appointments = [
                {
                    appointmentId: 1,
                    patientId: 1,
                    patientName: "Nguyen Van A",
                    patientPhone: "80809",
                    patientEmail: "a@gmail.com",
                    dateBooking: "2030-3-2",
                    status: "cancel",
                },
                {
                    appointmentId: 2,
                    patientId: 2,
                    patientName: "Nguyen Van A",
                    patientPhone: "80809",
                    patientEmail: "a@gmail.com",
                    dateBooking: "2023-20-2",
                    status: "cancel",
                }
            ];
            res.json(appointments);
            break;
    }

})

app.get('/appointment', function (req, res) {
    const appointmentID = req.query.id;
    // lấy thông tin bệnh nhân theo appointment
    const patient =
    {
        patientId: 1,
        fullName: "Nguyen Van A",
        phone: "0542432",
        email: "a@gmail.com",
        dateBooking: "2023-20-2",
        timeBooking: "14:00 – 15:00",
        address: "Ha Noi",
        medicalHistory: "Đã từng khám vào ngày ...", // thông tin đã từng khám ở đây
        patientProfile: "tiền sử bệnh tim", // tiền sử bị bệnh
        InsuranceID: "3242343243", // mã số bảo hiểm
        note: "dsfdsf",
        reason: "đau bụng",
        doctorList:  [
            {
                doctorId: 1,
                doctorName: "Nguyen Van A",
               
            },
            {
                doctorId: 2,
                doctorName: "Nguyen Van B",
            }
        ],
        doctorId: 1 // nếu chưa có thì la
    }


    res.json(patient);
})

app.get('/doctor', function (req, res) {
    const appointmentID = req.query.id;
    // lấy thông tin bệnh nhân theo appointment
    const doctorList =
    [
        {
            doctorId: 1,
            doctorName: "Nguyen Van A",
           
        },
        {
            doctorId: 2,
            doctorName: "Nguyen Van B",
        }
    ];
    res.json(doctorList);
})


app.put('/appointment/:appointmentId', function (req, res) {

    // Request body
    // const requestBodyDTO = {
    // iD: int, status: string (pending/confirm/cancel)  , doctorId: 1
    //}
    const appointmentId = req.params.appointmentId;
    const requestBodyDTO = req.body;
    console.log(requestBodyDTO);
    // update status của appointment đó


    
    res.status(200).json({ message: 'Appointment save successfully', appointmentId});
})



app.listen(port, function () {
    console.log("Your app running on port " + port);
})
