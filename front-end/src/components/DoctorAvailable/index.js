import { useEffect, useState } from "react";
import PatientDetailPopup from "../AppointmentDetalPopup";
import Button from 'react-bootstrap/Button';
function DoctorAvailable({ appointment }) {
    const [doctors, setDoctors] = useState([]);



    useEffect(() => {
        console.log(appointment)
        fetch(`http://localhost:8080/doctor/all/available/${appointment.date}/${appointment.startTime}/${appointment.endTime}`, {
         

        })
            .then((response) => {
                if (!response.ok) {

                }
                return response.json();
            })

            .then((dataJson) => {
                const data = dataJson.map((item) => ({
                    doctorId: item.doctorId,
                    name: item.firstName + item.lastName,
                    speciality: item.speciality,
                    phoneNumber: item.phoneNumber,
                    email: item.email
                }));

                return data;
            })

            .then((result) => {

                setDoctors(result);
            });
    }, [appointment]);

    if (!appointment) {
        return <></>;
    }
    return (
        <>

            {doctors.map(
                (doctor) => (
                    <option key={doctor.doctorId} value={doctor.doctorId}>{doctor.name}({doctor.speciality})</option>
                ))}

        </>
    );

}

export default DoctorAvailable;