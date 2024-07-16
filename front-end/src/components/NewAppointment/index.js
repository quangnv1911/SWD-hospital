import { useEffect, useState } from "react";
import PatientDetailPopup from "../AppointmentDetalPopup";

function NewAppointment() {
    const [appointments, setAppointments] = useState([]);

    useEffect(() => {
        fetch(`http://localhost:8080/appointment/status/PENDING`, {

        })
            .then((response) => {
                if (!response.ok) {

                }
                return response.json();
            })

            .then((dataJson) => {
              
                return dataJson;
            })

            .then((result) => {

                setAppointments(result);
            });
    }, []);

    const updateAppointmentStatus = (appointment) => {
        if (window.confirm("Bạn có chắc muốn hủy cuộc hẹn này")) {
           
            fetch(
                `http://localhost:8080/appointment/${appointment.id}`,
                {
                    method: "PUT",
                    headers: {
                        "Content-Type": "application/json",
                        
                      },
                    body: JSON.stringify(appointment),

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
                    alert("Cancell successfully");
                    window.location.reload();
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
                    <tr key={appointment.id}>
                        <td>{appointment.id}</td>
                        <td>{appointment.patientInfo.firstName} {appointment.patientInfo.lastName} </td>
                        <td>{appointment.patientInfo.phoneNumber}</td>
                        <td>{appointment.patientInfo.email}</td>
                        <td>{appointment.date}</td>
                        <td>
                            <div className="d-flex justify-content-around">
                                <button type="button" className="ml-3 btn btn-secondary" id="btn-cancel-patient" data-dismiss="modal"
                                    onClick={() => updateAppointmentStatus(appointment)}>Hủy</button>

                                <PatientDetailPopup
                                    statusValue={appointment.status}
                                    appointment={appointment} />
                            </div>
                        </td>
                    </tr>
                ))}

        </>
    );

}

export default NewAppointment;