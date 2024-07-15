import { useEffect, useState } from "react";
import PatientDetailPopup from "../PatientDetalPopup";

function NewAppointment() {
    const [appointments, setAppointments] = useState([]);

    useEffect(() => {
        fetch(`http://localhost:8080/appointment/new-appointment?status=pending`, {

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
                    status: item.status
                }));

                return data;
            })

            .then((result) => {

                setAppointments(result);
            });
    }, []);

    const updateAppointmentStatus = (appointmentId) => {
        if (window.confirm("Bạn có chắc muốn hủy cuộc hẹn này")) {
            fetch(
                `http://localhost:8080/appointment/${appointmentId}`,
                {
                    method: "PUT",

                    body: JSON.stringify({ status: "cancel" }),

                }
            )
                .then((response) => {
                    if (!response.ok) {
                        alert("Save fail!!");
                    }
                    return response.text();
                })
                .then((data) => {
                    console.log("Data saved successfully:", data);
                })
                .catch((error) => {
                    console.error("Error saving data:", error);
                });
        }

    };

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
                                <button type="button" className="ml-3 btn btn-secondary" id="btn-cancel-patient" data-dismiss="modal"
                                    onClick={() => updateAppointmentStatus(appointment.appointmentId)}>Hủy</button>

                                <PatientDetailPopup
                                    statusValue={appointment.status}
                                    appointmentId={appointment.appointmentId} />
                            </div>
                        </td>
                    </tr>
                ))}

        </>
    );

}

export default NewAppointment;