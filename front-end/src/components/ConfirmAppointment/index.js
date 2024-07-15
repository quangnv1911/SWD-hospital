import { useEffect, useState } from "react";
import PatientDetailPopup from "../PatientDetalPopup";
import Button from 'react-bootstrap/Button';
function ConfirmAppointment() {
    const [appointments, setAppointments] = useState([]);
    
    useEffect(() => {
        fetch(`http://localhost:8080/appointment/new-appointment?status=confirm`, {

        })
            .then((response) => {
                if (!response.ok) {

                }
                return response.json();
            })

            .then((dataJson) => {
                const data = dataJson.map((item) => ({
                    appointmentId: item.appointmentId,
                    patientId: item.patientId,
                    patientName: item.patientName,
                    patientPhone: item.patientPhone,
                    patientEmail: item.patientEmail,
                    dateBooking: item.dateBooking,
                    status : item.status
                }));

                return data;
            })

            .then((result) => {

                setAppointments(result);
            });
    }, []);

    if (!appointments) {
        return <></>;
    }
    return (
        <>
            {appointments.map(
                (appointment) => (
                    <tr key={appointment.appointmentId}>
                        <td>{appointment.appointmentId}</td>
                        <td>{appointment.patientName}</td>
                        <td>{appointment.patientPhone}</td>
                        <td>{appointment.patientEmail}</td>
                        <td>{appointment.dateBooking}</td>
                        <td>
                            <div className="d-flex justify-content-around">

                                
                                <PatientDetailPopup appointmentId = {appointment.appointmentId}
                                                    statusValue={appointment.status}/>
            
                            </div>
                        </td>
                    </tr>
                ))}

        </>
    );

}

export default ConfirmAppointment;