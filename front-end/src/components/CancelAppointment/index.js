import { useEffect, useState } from "react";
import PatientDetailPopup from "../AppointmentDetalPopup";

function CancelAppointment() {
    const [appointments, setAppointments] = useState([]);
    useEffect(() => {
        fetch(`http://localhost:8080/appointment/status/CANCELLED`, {
            
        })
            .then((response) => {
                if (!response.ok) {
                    
                }
                return response.json();
            })

            .then((dataJson) => {
                const data = dataJson;

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
                    <tr key={appointment.id}>
                        <td>{appointment.id}</td>
                        <td>{appointment.patientInfo.firstName} {appointment.patientInfo.lastName} </td>
                        <td>{appointment.patientInfo.phoneNumber}</td>
                        <td>{appointment.patientInfo.email}</td>
                        <td>{appointment.date}</td>
                        <td>
                            <div className="d-flex justify-content-around">
                                <PatientDetailPopup appointment={appointment}
                                statusValue={appointment.status}/>
                            
                            </div>
                        </td>
                    </tr>
                ))}

        </>
    );

}

export default CancelAppointment;